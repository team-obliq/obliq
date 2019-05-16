package com.obliq.obliq.repositories;

import com.obliq.obliq.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByUserId(Long id);
    List<Comment> findByPostId(Long id);
}
