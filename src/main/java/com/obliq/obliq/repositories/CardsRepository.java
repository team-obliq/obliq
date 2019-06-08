package com.obliq.obliq.repositories;

import com.obliq.obliq.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {

}
