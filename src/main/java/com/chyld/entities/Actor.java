package com.chyld.entities;

import com.chyld.enums.Gender;
import com.chyld.enums.Genre;
import com.chyld.enums.Rating;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actors")
public class Actor {
    private int id;
    private int version;
    private String name;
    private Gender gender;
    private Date birthday;
    private Date createdAt;
    private Date updatedAt;

    public Actor() {
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
    @Column(columnDefinition = "Enum('M', 'F')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date released) {
        this.birthday = released;
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

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
