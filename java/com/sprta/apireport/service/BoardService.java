package com.sprta.apireport.service;

import com.sprta.apireport.domain.Board;
import com.sprta.apireport.domain.BoardMapping;
import com.sprta.apireport.domain.BoardRequestDto;
import com.sprta.apireport.domain.BoardValidDto;
import com.sprta.apireport.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String update(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        log.info("board password={}", board.getPassword());
        log.info("update password={}", boardRequestDto.getPassword());
        if(board.getPassword().equals(boardRequestDto.getPassword())){
            board.update(boardRequestDto);
            return board.getId()+"번 수정완료";
        }else {
            return "비밀번호를 확인해주세요";
        }
    }

    public String delete(Long id, BoardValidDto boardValidDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        if (board.getPassword().equals(boardValidDto.getPassword())) {
            boardRepository.delete(board);
            return board.getId()+"번 삭제완료";
        }else{
            return "비밀번호를 확인해주세요";
        }
    }

    public Boolean validPwd(Long id, BoardValidDto boardValidDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다"));

        if (board.getPassword().equals(boardValidDto.getPassword())) {
            return true;
        }else{
            return false;
        }
    }

    public List<BoardMapping> getBoardList() {
//        LocalDateTime start = LocalDateTime.now().minusDays(1);
//        LocalDateTime end = LocalDateTime.now();
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    public Optional<Board> detailPost(Long id) {
        return boardRepository.findById(id);
    }

    public Board savePost(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        return boardRepository.save(board);
    }

}