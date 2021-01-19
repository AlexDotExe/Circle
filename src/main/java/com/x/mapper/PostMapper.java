package com.x.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.x.dto.PostRequest;
import com.x.dto.PostResponse;
import com.x.model.Post;
import com.x.model.Circle;
import com.x.model.Userr;
import com.x.model.Vote;
import com.x.model.VoteType;
import com.x.repository.*;
import com.x.service.AuthService;
import static com.x.model.VoteType.DOWNVOTE;
import static com.x.model.VoteType.UPVOTE;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
	  @Autowired
	    private CommentRepository commentRepository;
	    @Autowired
	    private VoteRepository voteRepository;
	    @Autowired
	    private AuthService authService;
	    
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "circle", source = "circle")
    @Mapping(target = "userr", source = "user")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "description", source = "postRequest.description")
    public abstract Post map(PostRequest postRequest, Circle circle, Userr user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "circleName", source = "circle.name")
    @Mapping(target = "userName", source = "userr.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    public abstract PostResponse mapToDto(Post post);
    
    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

    boolean isPostUpVoted(Post post) {
        return checkVoteType(post, UPVOTE);
    }

    boolean isPostDownVoted(Post post) {
        return checkVoteType(post, DOWNVOTE);
    }

    private boolean checkVoteType(Post post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForPostByUser = voteRepository.findTopByPostAndUserrOrderByVoteIdDesc(post,
                    authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }
}