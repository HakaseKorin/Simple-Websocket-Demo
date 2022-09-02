package com.example.repo;

import com.example.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    public Room getRoomByTitle(String title);
    public Room getRoomByRoomId(Integer roomId);
}
