package com.obliq.obliq.repositories;

import com.obliq.obliq.models.Career;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareersRepository extends CrudRepository<Career, Long> {
}
