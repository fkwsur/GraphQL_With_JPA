package gradle.project.app.controller;

import org.springframework.stereotype.Controller;

import gradle.project.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;


}
