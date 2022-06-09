package com.example.springtilcode.service;

import com.example.springtilcode.controller.dto.BoardDto;
import com.example.springtilcode.entity.BoardEntity;
import com.example.springtilcode.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void create(BoardDto dto){
        boardRepository.save(BoardEntity.builder()
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build());
    }

    @Transactional
    public void delete(long id){
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        boardRepository.delete(boardEntity);
    }

    @Transactional
    public BoardEntity read(long id){
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Transactional
    public void update(long id, BoardDto dto){
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        boardEntity.update(dto.getWriter(), dto.getTitle(), dto.getContent());
        boardRepository.save(boardEntity);
    }

}
