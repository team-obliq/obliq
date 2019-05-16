package com.obliq.obliq.models;

import javax.persistence.*;

@Entity
@Table(name="tribes")
public class Tribe{

@Id @GeneratedValue
private long id;

    public Tribe() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

