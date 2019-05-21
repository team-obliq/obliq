package com.obliq.obliq.repositories;

import com.obliq.obliq.models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
