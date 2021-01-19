package com.x.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.dto.PostRequest;
import com.x.dto.PostResponse;
import com.x.exception.CircleException;
import com.x.mapper.PostMapper;
import com.x.model.Post;
import com.x.model.Circle;
import com.x.model.Userr;
import com.x.repository.PostRepository;
import com.x.repository.CircleRepository;
import com.x.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final CircleRepository circleRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new CircleException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    public void save(PostRequest postRequest) {
        Circle circle = circleRepository.findByName(postRequest.getCircleName())
                .orElseThrow(() -> new CircleException(postRequest.getCircleName()));
        postRepository.save(postMapper.map(postRequest, circle, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByCircle(Long circleId) {
        Circle circle = circleRepository.findById(circleId)
                .orElseThrow(() -> new CircleException(circleId.toString()));
        List<Post> posts = postRepository.findAllByCircle(circle);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        Userr user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUserr(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}