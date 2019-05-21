package com.obliq.obliq.ENTITYS;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="tribes")
public class Tribe{

@Id @GeneratedValue
private long id;

@Column (name = "member_count")
@ColumnDefault("0")
private long member_count;

    public Tribe() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMember_count(long member_count) {
        this.member_count = member_count;
    }

    public long getMember_count() {
        return member_count;
    }
}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

