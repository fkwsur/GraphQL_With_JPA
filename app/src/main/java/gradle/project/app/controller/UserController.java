package gradle.project.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import gradle.project.app.model.User;
import gradle.project.app.repository.UserRepository;
import gradle.project.app.service.UserService;

import java.nio.ByteBuffer;
import java.util.*;

@RestController // restApi를 작성할 수 있는 컨트롤러
@RequestMapping("/api/v1/user") // url을 api로 지정
@CrossOrigin(origins = "*", allowedHeaders = "*") // cors허용
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> AddUser(@RequestBody User user) throws Exception {
        try {
            Map<String, String> map= userService.createBoard(user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


}
