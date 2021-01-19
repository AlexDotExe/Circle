package com.x.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x.dto.CircleDto;
import com.x.service.CircleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subfeed")
@AllArgsConstructor
public class CircleController {

    private final CircleService CircleService;

    @GetMapping
    public List<CircleDto> getAllCircles() {
        return CircleService.getAll();
    }

    @GetMapping("/{id}")
    public CircleDto getCircle(@PathVariable Long id) {
        return CircleService.getCircle(id);
    }

    @PostMapping
    public CircleDto create(@RequestBody @Valid CircleDto CircleDto) {
        return CircleService.save(CircleDto);
    }
}