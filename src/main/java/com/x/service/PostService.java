package com.x.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.dto.PostRequest;
import com.x.dto.PostResponse;
import com.x.exception.FeedbackException;
import com.x.mapper.PostMapper;
import com.x.model.Post;
import com.x.model.Subfeed;
import com.x.model.Userr;
import com.x.repository.PostRepository;
import com.x.repository.SubfeedRepository;
import com.x.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final SubfeedRepository subfeedRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new FeedbackException(id.toString()));
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
        Subfeed subfeed = subfeedRepository.findByName(postRequest.getSubfeedName())
                .orElseThrow(() -> new FeedbackException(postRequest.getSubfeedName()));
        postRepository.save(postMapper.map(postRequest, subfeed, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubfeed(Long subfeedId) {
        Subfeed subfeed = subfeedRepository.findById(subfeedId)
                .orElseThrow(() -> new FeedbackException(subfeedId.toString()));
        List<Post> posts = postRepository.findAllBySubfeed(subfeed);
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