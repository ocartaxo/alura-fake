package br.com.alura.AluraFake.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final ReportUseCase reportUseCase;

    public InstructorController(ReportUseCase reportUseCase) {
        this.reportUseCase = reportUseCase;
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<InstructorReportDTO> report(@PathVariable Long id) {
        return ResponseEntity.ok(reportUseCase.execute(id));
    }
}
