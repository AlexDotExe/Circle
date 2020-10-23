package com.x.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.x.dto.PostRequest;
import com.x.dto.PostResponse;
import com.x.model.Post;
import com.x.model.Subfeed;
import com.x.model.Userr;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "subfeed", source = "subfeed")
    @Mapping(target = "userr", source = "user")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Subfeed subfeed, Userr user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "subfeedName", source = "subfeed.name")
    @Mapping(target = "userName", source = "userr.username")
    PostResponse mapToDto(Post post);
}