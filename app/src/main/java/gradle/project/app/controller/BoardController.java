package gradle.project.app.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import gradle.project.app.model.Board;
import gradle.project.app.repository.BoardRepository;
import gradle.project.app.repository.UserRepository;
import gradle.project.app.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @QueryMapping
    public List<Board> getBoardData(@Argument Board board) throws Exception{
        try {
            return boardService.getBoardData();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @QueryMapping
    public Board findBoard(@Argument int idx) throws Exception{
        try {
            return boardService.findBoard(idx);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    @QueryMapping
    public String createBoard(@Argument String username,@Argument String title, @Argument String content) throws Exception{
        try {
            String rows = boardService.createBoard(username,title,content);
            return rows;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @QueryMapping
    public String updateBoard(@Argument int idx, @Argument String username,@Argument String title, @Argument String content) throws Exception{
        try {
            String rows = boardService.updateBoard(idx,username,title,content);
            return rows;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @QueryMapping
    public String deleteBoard(@Argument int idx) throws Exception{
        try {
            boardService.deleteBoard(idx);
            return "success";
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
