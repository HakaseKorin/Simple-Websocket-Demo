package com.example.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "display_name", nullable = false, unique = true)
    private String displayName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Room> ownedRooms = new HashSet<>();

    @ManyToMany(mappedBy = "participants")
    private Set<Room> joinedRooms = new HashSet<>();

    public User() {
    }

    public User(Integer id, String email, String password, String displayName, Set<Room> ownedRooms, Set<Room> joinedRooms) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.ownedRooms = ownedRooms;
        this.joinedRooms = joinedRooms;
    }

    public Integer getId() {
        return id;
    }

    public Set<Room> getOwnedRooms() {
        return ownedRooms = new HashSet<>();
    }

    public Set<Room> getJoinedRooms() {
        return joinedRooms = new HashSet<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
