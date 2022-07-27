package com.sprta.apireport.repository;

import com.sprta.apireport.domain.Board;
import com.sprta.apireport.domain.BoardMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
//    List<BoardMapping> findBoardByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);

    List<BoardMapping> findAllByOrderByCreatedAtDesc();
}