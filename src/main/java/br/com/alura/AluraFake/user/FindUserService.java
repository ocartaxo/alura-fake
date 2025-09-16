package br.com.alura.AluraFake.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserService {

    private final UserRepository userRepository;

    public FindUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
