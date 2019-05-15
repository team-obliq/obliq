package com.obliq.obliq.ENTITYS;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User{

@Id @GeneratedValue
private long id;

@Column (name = "username", nullable = false, length = 50, unique=true )
private String username;

@Column (name = "email", nullable = false, length = 150, unique=true )
private String email;

@Column (name = "password", nullable = false, length = 150)
private String password;

@Column (name = "first_name", length = 150)
private String first_name;

@Column (name = "bio", length = 500)
private String bio;

@Column (name = "continent", length = 20)
private String continent;

@Column (name = "points", nullable = false)
private long points = 0;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(nullable = false)
@DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
private Date dateCreated;

@Column (name = "tribe_id")
private long tribe_id;

@Column (name = "career_id")
private long career_id;

@OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
private List<Post> posts;

@OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
private List<Comment> comments;



@ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
       name="comment_point_tracker",
       joinColumns={@JoinColumn(name="user_id")},
       inverseJoinColumns={@JoinColumn(name="comment_id")}
   )
   private List<Comment> comment_with_points;

}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */
