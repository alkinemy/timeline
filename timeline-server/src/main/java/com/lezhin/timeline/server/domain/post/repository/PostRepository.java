package com.lezhin.timeline.server.domain.post.repository;

import com.lezhin.timeline.server.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
