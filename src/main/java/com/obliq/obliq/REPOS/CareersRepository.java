package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.Career;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareersRepository extends CrudRepository<Career, Long> {
}
