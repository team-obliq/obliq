package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.Tribe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribesRepository extends CrudRepository<Tribe, Long> {
}
