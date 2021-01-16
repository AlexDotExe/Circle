package com.x.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x.dto.SubfeedDto;
import com.x.service.SubfeedService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subfeed")
@AllArgsConstructor
public class SubfeedController {

    private final SubfeedService SubfeedService;

    @GetMapping
    public List<SubfeedDto> getAllSubfeeds() {
        return SubfeedService.getAll();
    }

    @GetMapping("/{id}")
    public SubfeedDto getSubfeed(@PathVariable Long id) {
        return SubfeedService.getSubfeed(id);
    }

    @PostMapping
    public SubfeedDto create(@RequestBody @Valid SubfeedDto SubfeedDto) {
        return SubfeedService.save(SubfeedDto);
    }
}