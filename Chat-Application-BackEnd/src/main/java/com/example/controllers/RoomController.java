package com.example.controllers;

import com.example.models.Room;
import com.example.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/room")
    @ResponseBody
    public void updateRoom(@RequestBody Room room){
        roomService.updateRoom(room);
    }

    @DeleteMapping("/room")
    @ResponseBody
    public void deleteRoom(@RequestBody Room room){
        roomService.deleteRoom(room);
    }

}
