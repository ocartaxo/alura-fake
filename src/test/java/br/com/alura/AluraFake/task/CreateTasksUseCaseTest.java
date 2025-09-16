package br.com.alura.AluraFake.task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateTasksUseCaseTest {

    @Mock
    private SaveTaskService saveTaskService;

    @Mock
    private ExistsTaskService existsTaskService;

    @Mock
    private TaskValidatorStrategyFactory validatorStrategyFactory;

    @InjectMocks
    private CreateTasksUseCase createTasksUseCase;

    @Test
    @DisplayName("Deve lançar exceção quando falhar na validação")
    void shouldThrowsExceptionWhenGivenTaskIsInvalid() {
        // Arrange
        var dto = TaskFactory.buildNewOpenTextTaskDTO();
        var mockValidator = mock(TaskValidator.class);
        var expectedException = new TaskValidationException("Validation Error");

        when(validatorStrategyFactory.getStrategyByType(dto.type())).thenReturn(List.of(mockValidator));
        doThrow(expectedException).when(mockValidator).validate(dto);

        // Act / Assert
        assertThrows(TaskValidationException.class, () -> {
            createTasksUseCase.execute(dto);
        });

        verify(saveTaskService, never()).shiftUpTaskOrders(dto);
        verify(saveTaskService, never()).save(any());
    }

    @Test
    @DisplayName("Deve salvar tarefa com sucesso quando os dados são válidos e não existe ordem repetida")
    void shouldSaveTaskWithSuccessWhenGivenTaskIsValidAndNotExistsRepeatedOrder() {
        // Arrange
        var dto = TaskFactory.buildNewSingleChoiceTaskDTO();
        var mockValidator = mock(TaskValidator.class);

        when(validatorStrategyFactory.getStrategyByType(dto.type())).thenReturn(List.of(mockValidator));
        when(existsTaskService.existsTaskByOrder(dto.order())).thenReturn(false);

        // Act
        createTasksUseCase.execute(dto);

        // Assert
        verify(validatorStrategyFactory).getStrategyByType(dto.type());
        verify(mockValidator).validate(dto);
        verify(existsTaskService).existsTaskByOrder(dto.order());
        verify(saveTaskService, never()).shiftUpTaskOrders(any());
        verify(saveTaskService).save(dto);
    }

    @Test
    @DisplayName("Deve salvar tarefa com sucesso quando os dados são válidos e existir ordem repetida")
    void shouldSaveTaskWithSuccessWhenGivenTaskIsValidAndExistsRepeatedOrder() {
        // Arrange
        var dto = TaskFactory.buildNewMultipleChoicesTaskDTO();
        var mockValidator = mock(TaskValidator.class);

        when(validatorStrategyFactory.getStrategyByType(dto.type())).thenReturn(List.of(mockValidator));
        when(existsTaskService.existsTaskByOrder(dto.order())).thenReturn(true);

        // Act
        createTasksUseCase.execute(dto);

        // Assert
        verify(validatorStrategyFactory).getStrategyByType(dto.type());
        verify(mockValidator).validate(dto);
        verify(existsTaskService).existsTaskByOrder(dto.order());
        verify(saveTaskService).shiftUpTaskOrders(any());
        verify(saveTaskService).save(dto);
    }

}