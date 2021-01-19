package com.x.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.x.dto.CircleDto;
import com.x.model.Post;
import com.x.model.Circle;
import com.x.model.Userr;

@Mapper(componentModel = "spring")
public interface CircleMapper {

    @Mapping(target = "postCount", expression = "java(mapPosts(subfeed.getPosts()))")
    CircleDto mapCircleToDto(Circle circle);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "userr", source = "user")
    Circle mapDtoToCircle(CircleDto subfeed, Userr user);
}