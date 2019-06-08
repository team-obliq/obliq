package com.obliq.obliq.testing;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="testing")
public class Testing{

@Id @GeneratedValue
private long id;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(nullable = false, name = ("date_created"))
@DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
private Date dateCreated;

/* -Constructor------------------------------------------------------------------------------------------ */
    public Testing() {}

/* -Getters------------------------------------------------------------------------------------------ */
    public long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

/* -Setters------------------------------------------------------------------------------------------ */

    public void setId(long id) {
        this.id = id;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}


/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

