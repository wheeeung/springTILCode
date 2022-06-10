package com.example.springtilcode.domain.board.service;

import com.example.springtilcode.domain.board.controller.BoardDto;
import com.example.springtilcode.domain.board.entity.Board;
import com.example.springtilcode.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void create(BoardDto dto){
        boardRepository.save(Board.builder()
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build());
    }

    @Transactional
    public void delete(long id){
        Board boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        boardRepository.delete(boardEntity);
    }

    @Transactional
    public Board read(long id){
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Transactional
    public void update(long id, BoardDto dto){
        Board boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        boardEntity.update(dto.getWriter(), dto.getTitle(), dto.getContent());
        boardRepository.save(boardEntity);
    }

}
