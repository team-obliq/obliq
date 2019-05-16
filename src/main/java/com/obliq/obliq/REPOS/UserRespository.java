package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User, Long> {
}
