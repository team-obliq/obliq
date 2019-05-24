package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.Card;
import com.obliq.obliq.ENTITYS.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long id);

    @Query("SELECT p FROM Post p ORDER BY date_created DESC")
    List<Post> findByDateCreated();

}
