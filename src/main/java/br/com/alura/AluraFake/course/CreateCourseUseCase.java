package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.FindUserService;
import br.com.alura.AluraFake.user.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CreateCourseUseCase {

    private final SaveCourseService saveCourseService;

    private final FindUserService findUserService;

    public CreateCourseUseCase(
            SaveCourseService saveCourseService,
            FindUserService findUserService
    ) {
        this.saveCourseService = saveCourseService;
        this.findUserService = findUserService;
    }

    @Transactional
    void execute(NewCourseDTO request) {

        //Caso implemente o bonus, pegue o instrutor logado
        Optional<User> possibleAuthor = findUserService.findByEmail(request.getEmailInstructor())
                .filter(User::isInstructor);


        if(possibleAuthor.isEmpty()) {
            throw new IllegalArgumentException("User is not instructor");
        }

        saveCourseService.save(request, possibleAuthor.get());
    }


}
