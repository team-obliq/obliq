package com.obliq.obliq.repositories;

import com.obliq.obliq.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
