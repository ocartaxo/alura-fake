package br.com.alura.AluraFake.course;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;

    private final FindAllCourseUseCase findAllCourseUseCase;

    private final PublishCourseUseCase publishCourseUseCase;

    public CourseController(
            CreateCourseUseCase createCourseUseCase,
            FindAllCourseUseCase findAllCourseUseCase,
            PublishCourseUseCase publishCourseUseCase
    ) {
        this.createCourseUseCase = createCourseUseCase;
        this.findAllCourseUseCase = findAllCourseUseCase;
        this.publishCourseUseCase = publishCourseUseCase;
    }

    @PostMapping("/course/new")
    public ResponseEntity createCourse(@Valid @RequestBody NewCourseDTO newCourse) {
        createCourseUseCase.execute(newCourse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/course/all")
    public ResponseEntity<List<CourseListItemDTO>> createCourse() {
        return ResponseEntity.ok(findAllCourseUseCase.execute());
    }

    @PostMapping("/course/{id}/publish")
    public ResponseEntity createCourse(@PathVariable("id") Long id) {
        publishCourseUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

}
