package com.x.service;


import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.dto.CircleDto;
import com.x.exception.CircleException;
import com.x.mapper.CircleMapper;
import com.x.model.Circle;
import com.x.repository.CircleRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CircleService {

    private final CircleRepository circleRepository;
    private final CircleMapper circleMapper;
    private final AuthService authService;

    @Transactional
    public CircleDto save(CircleDto circleDto) {
    	if(circleRepository.findByName(circleDto.getName()).isPresent()) {System.out.println("\n\nthere is a duplicate\n\n");circleDto.setName("-1"); return circleDto; }
        Circle save = circleRepository.save(circleMapper.mapDtoToCircle((circleDto), authService.getCurrentUser()));
        circleDto.setId(save.getId());
        return circleDto;
    }

    @Transactional(readOnly = true)
    public List<CircleDto> getAll() {
        return circleRepository.findAll()
                .stream()
                .map(circleMapper::mapCircleToDto)
                .collect(toList());
    }

    public CircleDto getCircle(Long id) {
        Circle circle = circleRepository.findById(id)
                .orElseThrow(() -> new CircleException("No circle found with ID - " + id));
        return circleMapper.mapCircleToDto(circle);
    }
}