package com.example.controllers;

import com.example.models.Room;
import com.example.models.User;
import com.example.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @InjectMocks
    RoomController roomController;

    @Mock
    RoomService roomService;

    private Room room;
    private User user;
    private List<Room> rooms = new ArrayList<>();

    @BeforeEach
    public void init(){
        user = new User(1, "email", "password", "display name", new HashSet<>(), new HashSet<>());
        room = new Room(0,"Title", "password", user.getId(), new HashSet<>());
        rooms.add(room);
        rooms.add(new Room(1,"Two","password",2, new HashSet<>()));
        rooms.add(new Room(2, "Three", "password", 3, new HashSet<>()));
    }

    @Test
    void createRoom() {
        // arrange
        // act
        roomController.createRoom(room);
        // assert
        verify(roomService).createRoom(room);
    }

    @Test
    void getRoomByTitle() {
        // arrange
        // act
        when(roomService.getRoomByTitle(anyString())).thenReturn(room);
        Room result = roomController.getRoomByTitle("Title");
        // assert
        assertEquals(room, result);
    }

    @Test
    void getRoomByTitle_Returns_Null(){
        when(roomService.getRoomByTitle(anyString())).thenReturn(null);
        Room result = roomController.getRoomByTitle("Does Not Exist");
        assertNull(result);
    }

    @Test
    void getRoomByRoomId() {
        when(roomService.getRoomByRoomId(any(Integer.class))).thenReturn(room);
        Room result = roomController.getRoomByRoomId(0);
        assertEquals(room, result);
    }

    @Test
    void getAllRooms() {
        when(roomService.getAllRooms()).thenReturn(rooms);
        ResponseEntity<List<Room>> result = roomController.getAllRooms();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void getParticipants(){
        Set<String> list = new HashSet<>();
        when(roomService.getParticipants(any(Integer.class))).thenReturn(list);
        Set<String> result = roomController.getParticipants(1);
        assertEquals(list, result);
    }

    @Test
    void updateRoom() {
        roomController.updateRoom(room);
        verify(roomService).updateRoom(room);
    }

    @Test
    void addParticipant(){
        roomController.addParticipant(1,1);
        verify(roomService).addParticipant(1,1);
    }

    @Test
    void removeParticipant(){
        roomController.removeParticipant(1,1);
        verify(roomService).removeParticipant(1,1);
    }

    @Test
    void deleteRoom() {
        roomController.deleteRoom(room);
        verify(roomService).deleteRoom(room);
    }
}