package com.example.springtilcode.controller;

import com.example.springtilcode.controller.dto.BoardDto;
import com.example.springtilcode.entity.BoardEntity;
import com.example.springtilcode.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/{id}")
    public BoardEntity read(@PathVariable long id){
        return boardService.read(id);
    }

    @PostMapping("/board")
    public void create(@RequestBody BoardDto dto){
        boardService.create(dto);
    }

    @PutMapping("/board/{id}")
    public void update(@RequestBody BoardDto dto, @PathVariable long id){
        boardService.update(id, dto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable long id){
        boardService.delete(id);
    }
}
