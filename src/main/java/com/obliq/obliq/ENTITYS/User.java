package com.obliq.obliq.ENTITYS;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
@ColumnDefault("0")
private long points;

@Column (name = "tribe_id")
private long tribe_id;

@Column (name = "career_id")
private long career_id;

@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(nullable = false)
@DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss")
private Date dateCreated;


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

public User(){}
public User(String username, String email, String password, String first_name, String bio, String continent, long points, Date dateCreated, long tribe_id, long career_id, List<Post> posts, List<Comment> comments, List<Comment> comment_with_points) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.first_name = first_name;
      this.bio = bio;
      this.continent = continent;
      this.points = points;
      this.dateCreated = dateCreated;
      this.tribe_id = tribe_id;
      this.career_id = career_id;
      this.posts = posts;
      this.comments = comments;
      this.comment_with_points = comment_with_points;
   }

   public User(User copy) {
      id = copy.id; // This line is SUPER important! Many things won't work if it's absent
      email = copy.email;
      username = copy.username;
      password = copy.password;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getFirst_name() {
      return first_name;
   }

   public void setFirst_name(String first_name) {
      this.first_name = first_name;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   public String getContinent() {
      return continent;
   }

   public void setContinent(String continent) {
      this.continent = continent;
   }

   public long getPoints() {
      return points;
   }

   public void setPoints(long points) {
      this.points = points;
   }

   public Date getDateCreated() {
      return dateCreated;
   }

   public void setDateCreated(Date dateCreated) {
      this.dateCreated = dateCreated;
   }

   public long getTribe_id() {
      return tribe_id;
   }

   public void setTribe_id(long tribe_id) {
      this.tribe_id = tribe_id;
   }

   public long getCareer_id() {
      return career_id;
   }

   public void setCareer_id(long career_id) {
      this.career_id = career_id;
   }

   public List<Post> getPosts() {
      return posts;
   }

   public void setPosts(List<Post> posts) {
      this.posts = posts;
   }

   public List<Comment> getComments() {
      return comments;
   }

   public void setComments(List<Comment> comments) {
      this.comments = comments;
   }

   public List<Comment> getComment_with_points() {
      return comment_with_points;
   }

   public void setComment_with_points(List<Comment> comment_with_points) {
      this.comment_with_points = comment_with_points;
   }
}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */
