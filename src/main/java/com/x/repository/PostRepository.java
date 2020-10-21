package com.x.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Post;
import com.x.model.Subfeed;
import com.x.model.Userr;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubfeed(Subfeed subfeed);

    List<Post> findByUserr(Userr userr);
}