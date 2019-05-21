package com.obliq.obliq.repositories;

import com.obliq.obliq.models.Tribe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribesRepository extends CrudRepository<Tribe, Long> {
}
