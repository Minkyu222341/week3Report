package com.sprta.apireport.controller;

import com.sprta.apireport.domain.Board;
import com.sprta.apireport.domain.BoardMapping;
import com.sprta.apireport.domain.BoardRequestDto;
import com.sprta.apireport.domain.BoardValidDto;
import com.sprta.apireport.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
        public List<BoardMapping> getList() {
        return boardService.getBoardList();
    }

    @GetMapping("/board/{id}")
    public Optional<Board> detail(@PathVariable Long id) {
        return boardService.detailPost(id);
    }

    @PostMapping("/board")
    public Board addPost(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.savePost(boardRequestDto);
    }

    @PutMapping("/board/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.update(id, boardRequestDto);
    }

    @DeleteMapping("/board/{id}")
    public String delPost(@PathVariable Long id, @RequestBody BoardValidDto boardValidDto) {
        return boardService.delete(id, boardValidDto);
    }

    @PostMapping("/board/{id}")
    public Boolean validPassword(@PathVariable Long id, @RequestBody BoardValidDto boardValidDto) {
        return boardService.validPwd(id, boardValidDto);
    }

}

