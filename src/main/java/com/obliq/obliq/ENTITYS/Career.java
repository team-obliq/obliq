package com.obliq.obliq.ENTITYS;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="careers")
public class Career{

@Id @GeneratedValue
private long id;

@Column (name = "title", nullable = false, length = 250, unique=true )
private String title;

public Career(){}
public Career(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

