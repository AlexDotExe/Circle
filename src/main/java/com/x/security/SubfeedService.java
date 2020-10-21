package com.x.security;


import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.dto.SubfeedDto;
import com.x.exception.FeedbackException;
import com.x.model.Subfeed;
import com.x.repository.SubfeedRepository;
import com.x.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubfeedService {

    private final SubfeedRepository subfeedRepository;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<SubfeedDto> getAll() {
        return subfeedRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional
    public SubfeedDto save(SubfeedDto subfeedDto) {
        Subfeed subfeed = subfeedRepository.save(mapToSubfeed(subfeedDto));
        subfeedDto.setId(subfeed.getId());
        return subfeedDto;
    }

    @Transactional(readOnly = true)
    public SubfeedDto getSubfeed(Long id) {
        Subfeed subfeed = subfeedRepository.findById(id)
                .orElseThrow(() -> new FeedbackException("Subfeed not found with id -" + id));
        return mapToDto(subfeed);
    }

    private SubfeedDto mapToDto(Subfeed subfeed) {
        return SubfeedDto.builder().name(subfeed.getName())
                .id(subfeed.getId())
                .postCount(subfeed.getPosts().size())
                .build();
    }

    private Subfeed mapToSubfeed(SubfeedDto subfeedDto) {
        return Subfeed.builder().name("/r/" + subfeedDto.getName())
                .description(subfeedDto.getDescription())
                .userr(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}