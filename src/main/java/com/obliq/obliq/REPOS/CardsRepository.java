package com.obliq.obliq.REPOS;

import com.obliq.obliq.ENTITYS.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {

}
