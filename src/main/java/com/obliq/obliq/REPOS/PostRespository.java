package com.obliq.obliq.REPOS;

<<<<<<< HEAD:src/main/java/com/obliq/obliq/repositories/PostRespository.java
import com.obliq.obliq.ENTITYS.Post;
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRespository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long id);

    @Query("SELECT p FROM Post p ORDER BY date_created DESC")
    List<Post> findByDateCreated();
}
