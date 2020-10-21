package com.x.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Post;
import com.x.model.Userr;
import com.x.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserrOrderByVoteIdDesc(Post post, Userr currentUser);
}