package com.obliq.obliq.ENTITYS;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

@Column (name = "body", nullable = false, length = 500)
private String body;

@Column (name = "points")
private long points = 0;

@ManyToOne
@JoinColumn (name="user_id", referencedColumnName = "id")
private User user;

@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn (name="post_id", referencedColumnName = "id")
private Post post;

@ManyToMany(mappedBy = "comment_with_points")
private List<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="comment_point_tracker",
            joinColumns={@JoinColumn(name="comment_id")},
            inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    private List<Comment> commentPoints;

public Comment(){}

public Comment(Date dateCreated, String body, long points, User user, Post post, List<Comment> commentPoints) {
        this.dateCreated = dateCreated;
        this.body = body;
        this.points = points;
        this.user = user;
        this.post = post;
        this.commentPoints = commentPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Comment> getCommentPoints() {
        return commentPoints;
    }

    public void setCommentPoints(List<Comment> commentPoints) {
        this.commentPoints = commentPoints;
    }
}

/* --1 (name of the table you want to create----------------------------------------------------------------------------------------- */
/* --2 (name of the entity object you are creating----------------------------------------------------------------------------------------- */
/* --3 (title of the column heading----------------------------------------------------------------------------------------- */
/* --4 (If this entity is owned by an Object----------------------------------------------------------------------------------------- */
/* --5 (Object owners nickname----------------------------------------------------------------------------------------- */

