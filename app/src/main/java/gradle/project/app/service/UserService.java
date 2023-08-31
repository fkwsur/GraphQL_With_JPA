package gradle.project.app.service;

import lombok.RequiredArgsConstructor;
import gradle.project.app.model.User;
import gradle.project.app.repository.*;
import gradle.project.app.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public Map<String, String> createBoard(User user) throws Exception {
        try {
            Map<String, String> map = new HashMap<>();
            userRepository.save(user);
            map.put("result", "가입 성공");
            return map;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
