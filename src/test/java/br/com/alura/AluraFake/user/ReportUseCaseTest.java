package br.com.alura.AluraFake.user;

import br.com.alura.AluraFake.course.FindCourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportUseCaseTest {

    @Mock
    private FindUserService findUserService;
    @Mock
    private FindCourseService findCourseService;

    @InjectMocks
    private ReportUseCase reportUseCase;

    @Test
    @DisplayName("Deve lançar UserNotFoundException quando não encontrar o usuário")
    void shouldThrowExceptionWhenUserNotFound() {
        final var userId = 1L;
        doThrow(UserNotFoundException.class).when(findUserService).findById(userId);

        assertThrows(UserNotFoundException.class, () -> reportUseCase.execute(userId));

        verify(findCourseService, never()).findAllByInstructor(any());
    }

    @Test
    @DisplayName("Deve lançar NotInstructorException quando o usuário não for um instrutor")
    void shouldThrowExceptionWhenUserIsNotInstructor() {
        final var userId = 1L;
        final var user = mock(User.class);
        when(user.getName()).thenReturn("Joao");
        when(user.isInstructor()).thenReturn(false);

        when(findUserService.findById(userId)).thenReturn(Optional.of(user));
        final var exception = assertThrows(NotInstructorException.class, () -> reportUseCase.execute(userId));

        verify(findCourseService, never()).findAllByInstructor(any());
        assertEquals("User Joao is not instructor", exception.getMessage());
    }

    @Test
    @DisplayName("Deve consultar o relatório do instrutor com sucesso")
    void shouldBuildReportWithSuccess() {
        final var user = mock(User.class);
        when(user.getName()).thenReturn("Joao");
        when(user.isInstructor()).thenReturn(true);

        when(findUserService.findById(anyLong())).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> reportUseCase.execute(anyLong()));

        verify(findCourseService, times(1)).findAllByInstructor(user);

    }
}