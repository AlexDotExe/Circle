package com.x.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Commentt;
import com.x.model.Post;
import com.x.model.Userr;

public interface CommentRepository extends JpaRepository<Commentt, Long> {
    List<Commentt> findByPostOrderByCreatedDateDesc(Post post);

    List<Commentt> findAllByUserr(Userr userr);
}