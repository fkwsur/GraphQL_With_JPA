package gradle.project.app.service;

import lombok.RequiredArgsConstructor;
import gradle.project.app.model.Board;
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
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getBoardData() throws Exception {
        try {
            return boardRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Board findBoard(int idx) throws Exception {
        try {
            return boardRepository.findOneByIdx(idx);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public String createBoard(String username,String title,String content) throws Exception {
        try {
            Board board = Board.builder()
            .username(username)
            .title(title)
            .content(content)
            .build();
            boardRepository.save(board);
            return "success";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public String updateBoard(int idx,String username,String title,String content) throws Exception {
        try {
            Board getIdx = boardRepository.findOneByIdx(idx);
            if (getIdx == null) {
                return "failed";
            }
            Board board = Board.builder()
            .idx(idx)
            .username(username)
            .title(title)
            .content(content)
            .build();
            boardRepository.save(board);
            return "success";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public void deleteBoard(int idx) throws Exception {
        try {
            boardRepository.deleteByIdx(idx);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
