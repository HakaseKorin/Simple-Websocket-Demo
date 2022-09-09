package com.example.services;

import com.example.models.Room;
import com.example.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

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

    public Set<String> getParticipants(Integer roomId) { return roomRepository.getParticipants(roomId); }

    public void updateRoom(Room room){
        roomRepository.save(room);
    }

    public void addParticipant(Integer roomId, Integer userId) { roomRepository.addParticipant(roomId, userId); }

    public void removeParticipant(Integer roomId, Integer userId) { roomRepository.removeParticipant(roomId, userId);}

    public void deleteRoom(Room room){
        roomRepository.delete(room);
    }
}
