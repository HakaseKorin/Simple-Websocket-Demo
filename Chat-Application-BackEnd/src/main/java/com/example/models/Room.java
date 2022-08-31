package com.example.models;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    private List<String> participants;

}
