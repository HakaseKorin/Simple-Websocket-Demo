package com.example.services;

import com.example.models.Room;
import com.example.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createRoom(Room room){
        roomRepository.save(room);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomByTitle(String title){
        return roomRepository.getRoomByTitle(title);
    }

    public Room getRoomByRoomId(Integer roomId){
        return roomRepository.getRoomByRoomId(roomId);
    }

    public void updateRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(Room room){
        roomRepository.delete(room);
    }
}
