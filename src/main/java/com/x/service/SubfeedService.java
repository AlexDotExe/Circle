package com.x.service;


import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.dto.SubfeedDto;
import com.x.exception.FeedbackException;
import com.x.mapper.SubfeedMapper;
import com.x.model.Subfeed;
import com.x.repository.SubfeedRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubfeedService {

    private final SubfeedRepository subfeedRepository;
    private final SubfeedMapper subfeedMapper;
    private final AuthService authService;

    @Transactional
    public SubfeedDto save(SubfeedDto subfeedDto) {
    	if(subfeedRepository.findByName(subfeedDto.getName()) != null) {subfeedDto.setName("-1"); return subfeedDto;}
        Subfeed save = subfeedRepository.save(subfeedMapper.mapDtoToSubfeed((subfeedDto), authService.getCurrentUser()));
        subfeedDto.setId(save.getId());
        return subfeedDto;
    }

    @Transactional(readOnly = true)
    public List<SubfeedDto> getAll() {
        return subfeedRepository.findAll()
                .stream()
                .map(subfeedMapper::mapSubfeedToDto)
                .collect(toList());
    }

    public SubfeedDto getSubfeed(Long id) {
        Subfeed subfeed = subfeedRepository.findById(id)
                .orElseThrow(() -> new FeedbackException("No subfeed found with ID - " + id));
        return subfeedMapper.mapSubfeedToDto(subfeed);
    }
}