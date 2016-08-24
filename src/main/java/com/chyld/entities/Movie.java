package com.chyld.entities;

import com.chyld.enums.Genre;
import com.chyld.enums.Rating;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    private int id;
    private int version;
    private String name;
    private Genre genre;
    private Rating rating;
    private Date released;
    private Date createdAt;
    private Date updatedAt;
    private Studio studio;
    private List<Actor> actors;

    public Movie() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "Enum('ACTION', 'SCIFI', 'HORROR')")
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "Enum('G', 'PG', 'PG13', 'R')")
    public Rating getRating() {
        return rating;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Temporal(TemporalType.DATE)
    public Date getReleased() {
        return released;
    }
    public void setReleased(Date released) {
        this.released = released;
    }

    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "studio_id")
    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actors_movies",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    public List<Actor> getActors() {
        return actors;
    }
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
