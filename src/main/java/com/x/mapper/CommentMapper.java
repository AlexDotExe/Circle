package com.x.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.x.dto.CommentsDto;
import com.x.model.Commentt;
import com.x.model.Post;
import com.x.model.Userr;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    Commentt map(CommentsDto commentsDto, Post post, Userr user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUserr().getUsername())")
    CommentsDto mapToDto(Commentt comment);
}