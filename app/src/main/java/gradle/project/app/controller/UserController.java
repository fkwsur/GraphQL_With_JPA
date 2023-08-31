package gradle.project.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import gradle.project.app.model.Board;
import gradle.project.app.model.User;
import gradle.project.app.repository.UserRepository;
import gradle.project.app.service.BoardService;
import gradle.project.app.service.UserService;

import java.nio.ByteBuffer;
import java.util.*;

@RestController // restApi를 작성할 수 있는 컨트롤러
@RequestMapping("/api/v1/user") // url을 api로 지정
@CrossOrigin(origins = "*", allowedHeaders = "*") // cors허용
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BoardService boardService;

    // restAPi 방식
    @PostMapping("/signup")
    public ResponseEntity<Object> SignUpByRestAPI(@RequestBody User user) throws Exception {
        try {
            Map<String, String> map= userService.createBoard(user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    // GraphQL 방식
    @QueryMapping
    public Map<String, String> SignUpByGraphQL(@Argument String username,@Argument String password) throws Exception{
        try {
            User user = User.builder()
            .username(username)
            .password(password)
            .build();
            Map<String, String> map= userService.createBoard(user);
            return map;
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("error", e.toString());
            return map;
        }
    }



}
