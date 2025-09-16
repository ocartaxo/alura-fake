package br.com.alura.AluraFake.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PublishCourseUseCaseTest {

    @Mock
    private SaveCourseService saveCourseService;
    @Mock
    private FindCourseService findCourseService;

    @Mock
    PublishCourseValidator validator;

    @InjectMocks
    private PublishCourseUseCase publishCourseUseCase;

    @Test
    @DisplayName("Quando o curso for inválido deve lançar CourseValidationException")
    void shouldThrowExceptionWhenCourseIsInvalid() {
        final var courseId = 1L;
        final var course = mock(Course.class);
        when(findCourseService.findCourseById(courseId)).thenReturn(course);

        doThrow(CourseValidationException.class).when(validator).validate(course);

        assertThrows(CourseValidationException.class, () -> publishCourseUseCase.execute(courseId));

        verify(course, never()).publish();
    }

    @Test
    @DisplayName("Quando o curso for válido deve publicar com sucesso")
    void shouldPublishCourseWithSuccessWhenCourseIsValid() {
        final var now = LocalDateTime.now();

        final var courseId = 1L;
        final var course = mock(Course.class);
        when(course.getStatus()).thenReturn(Status.BUILDING);
        when(course.getPublishedAt()).thenReturn(now);

        when(findCourseService.findCourseById(courseId)).thenReturn(course);

        doNothing().when(validator).validate(course);

        assertDoesNotThrow(() -> publishCourseUseCase.execute(courseId));

        verify(course, times(1)).publish();
        assertEquals(Status.BUILDING, course.getStatus());
        assertEquals(now, course.getPublishedAt());
    }
}