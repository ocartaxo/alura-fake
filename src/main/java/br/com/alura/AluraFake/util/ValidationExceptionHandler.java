package br.com.alura.AluraFake.util;

import br.com.alura.AluraFake.course.CourseValidationException;
import br.com.alura.AluraFake.task.TaskValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorItemDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorItemDTO> errors = ex.getBindingResult().getFieldErrors().stream().map(ErrorItemDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(TaskValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorItemDTO>> handleValidationExceptions(TaskValidationException ex) {
        final var error = new ErrorItemDTO(ex.getField(), ex.getMessage());
        return ResponseEntity.badRequest().body(Collections.singletonList(error));
    }

    @ExceptionHandler(CourseValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorItemDTO>> handleValidationExceptions(CourseValidationException ex) {
        final var error =  new ErrorItemDTO(ex.getField(), ex.getMessage());
        return ResponseEntity.badRequest().body(Collections.singletonList(error));
    }
}