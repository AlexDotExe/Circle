package com.x.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.x.dto.SubfeedDto;
import com.x.model.Post;
import com.x.model.Subfeed;

@Mapper(componentModel = "spring")
public interface SubfeedMapper {

    @Mapping(target = "postCount", expression = "java(mapPosts(subfeed.getPosts()))")
    SubfeedDto mapSubfeedToDto(Subfeed subfeed);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subfeed mapDtoToSubfeed(SubfeedDto subfeed);
}