package com.example.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "password")
    private String password;

    @Column(name = "owner")
    private Integer owner;

    @ManyToMany
    @JoinTable(
            name = "room_user",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants = new HashSet<>();

    public Room() {
    }

    public Room(Integer roomId, String title, String password, Integer owner, Set<User> participants) {
        this.roomId = roomId;
        this.title = title;
        this.password = password;
        this.owner = owner;
        this.participants = participants;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOwner() {
        return owner;
    }

//    public Set<String> getParticipants() {
//        return participants;
//    }
//
//    public void setParticipants(Set<String> participants) {
//        this.participants = participants;
//    }
}
