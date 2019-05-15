package com.obliq.obliq.ENTITYS;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="comments")
public class Comment{

@Id @GeneratedValue
private long id;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(nullable = false)
@DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
private Date dateCreated;

@Column (name = "points")
private long points = 0;

@ManyToOne
@JoinColumn (name="user_id", referencedColumnName = "id")
private User user;

@ManyToOne
@JoinColumn (name="post_id", referencedColumnName = "id")
private Post post;

@ManyToMany(mappedBy = "comment_with_points")
private List<User> users;


}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

