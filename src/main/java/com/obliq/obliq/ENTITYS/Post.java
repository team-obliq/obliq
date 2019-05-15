package com.obliq.obliq.ENTITYS;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts")
public class Post{

@Id @GeneratedValue
private long id;

@Column (name = "title", nullable = false, length = 50)
private String title;

@Column (name = "body", nullable = false, length = 500)
private String body;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(nullable = false)
@DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
private Date dateCreated;

@ManyToOne
@JoinColumn (name="user_id", referencedColumnName = "id")
private User user;


@OneToMany (cascade = CascadeType.ALL, mappedBy = "post")
private List<Comment> comments;


/* Child (Copy and paste)

*/

    /* --1 (This should match 6 and should mirror the nickname for the parent object nickname on the child--- */
    /* --2 (name of the child object you want to fill the list with------------------------------------------ */
    /* --3 (nick name of child object you want to fill the list --------------------------------------------- */
    /* --4 (title of the join table that will be created holding both the reference IDs for both objects----- */
    /* --5 (This should be name of the title of the column that holds the parents IDs------------------------ */
    /* --6 (the name of the parent object-------------------------------------------------------------------- */
    /* --7 (The nick name for the parent object-------------------------------------------------------------- */


}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

