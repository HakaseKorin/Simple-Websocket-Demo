package com.example.controllers;

import com.example.models.Room;
import com.example.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    @ResponseBody
    public void createRoom(@RequestBody Room room){
        roomService.createRoom(room);
    }

    @GetMapping("/room/{title}")
    public Room getRoomByTitle(@PathVariable("title") String title){
        return roomService.getRoomByTitle(title);
    }

    @GetMapping("/room/{id}")
    public Room getRoomByRoomId(@PathVariable("id") Integer roomId){
        return roomService.getRoomByRoomId(roomId);
    }

    @GetMapping("/room/all")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

//    @GetMapping("/room/participants/{id}")
//    public Set<String> getParticipants(@PathVariable("id") Integer roomId) { return roomService.getParticipants(roomId); }

    // updates when user joins/leaves room
    @PutMapping("/room")
    @ResponseBody
    public void updateRoom(@RequestBody Room room){
        roomService.updateRoom(room);
    }

//    @PutMapping("/room/participants/{roomId}/{userId}")
//    public void addParticipant(@PathVariable("roomId") Integer roomId,@PathVariable("userId") Integer userId) { roomService.addParticipant(roomId, userId); }
//
//    @DeleteMapping("/room/participants/{roomId}/{userId}")
//    public void removeParticipant(@PathVariable("roomId") Integer roomId,@PathVariable("userId") Integer userId) { roomService.removeParticipant(roomId, userId); }

    @DeleteMapping("/room")
    @ResponseBody
    public void deleteRoom(@RequestBody Room room){
        roomService.deleteRoom(room);
    }

}
