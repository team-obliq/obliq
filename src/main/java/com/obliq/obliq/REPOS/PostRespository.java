package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRespository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long id);
}
