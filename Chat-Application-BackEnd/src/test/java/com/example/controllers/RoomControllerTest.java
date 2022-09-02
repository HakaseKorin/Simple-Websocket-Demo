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

import java.util.ArrayList;
import java.util.List;

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
        user = new User("username", "password", "JohnDoe", "JohnDoe@email.com");
        room = new Room(0,"Title", "password", user);
        rooms.add(room);
        rooms.add(new Room(1,"Two","password",new User()));
        rooms.add(new Room(2, "Three", "password", new User()));
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
        List<Room> result = roomController.getAllRooms();
        assertEquals(rooms, result);
    }

    @Test
    void updateRoom() {
        roomController.updateRoom(room);
        verify(roomService).updateRoom(room);
    }

    @Test
    void deleteRoom() {
        roomController.deleteRoom(room);
        verify(roomService).deleteRoom(room);
    }
}