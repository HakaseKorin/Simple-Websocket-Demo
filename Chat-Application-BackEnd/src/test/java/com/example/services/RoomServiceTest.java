package com.example.services;

import com.example.models.Room;
import com.example.models.User;
import com.example.repo.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @InjectMocks
    RoomService roomService;

    @Mock
    RoomRepository roomRepository;

    private Room room;
    private User user;
    private List<Room> rooms = new ArrayList<>();

    @BeforeEach
    public void init(){
        user = new User(1, "email", "password", "display name", new HashSet<>(), new HashSet<>());
        room = new Room(0,"Title", "password", user.getId(), new HashSet<>());
        rooms.add(room);
        rooms.add(new Room(1,"Two","password", 2, new HashSet<>()));
        rooms.add(new Room(2, "Three", "password", 3, new HashSet<>()));
    }

    @Test
    void createRoom() {
        roomService.createRoom(room);
        verify(roomRepository).save(room);
    }

    @Test
    void getAllRooms() {
        when(roomRepository.findAll()).thenReturn(rooms);
        List<Room> result = roomService.getAllRooms();
        assertEquals(rooms,result);
    }

    @Test
    void getRoomByTitle() {
        when(roomRepository.getRoomByTitle(anyString())).thenReturn(room);
        Room result = roomService.getRoomByTitle("Title");
        assertEquals(room,result);
    }

    @Test
    void getRoomByTitle_Returns_Null(){
        when(roomRepository.getRoomByTitle(anyString())).thenReturn(null);
        Room result = roomService.getRoomByTitle("Does Not Exist");
        assertNull(result);
    }

    @Test
    void getRoomByRoomId() {
        when(roomRepository.getRoomByRoomId(any(Integer.class))).thenReturn(room);
        Room result = roomService.getRoomByRoomId(0);
        assertEquals(room,result);
    }

    @Test
    void getRoomByRoomId_Returns_Null(){
        when(roomRepository.getRoomByRoomId(any(Integer.class))).thenReturn(null);
        Room result = roomService.getRoomByRoomId(-1);
        assertNull(result);
    }

    @Test
    void getParticipants(){
        Set<String> list = new HashSet<>();
        when(roomRepository.getParticipants(any(Integer.class))).thenReturn(list);
        Set<String> result = roomService.getParticipants(1);
        assertEquals(list, result);
    }

    @Test
    void addParticipant(){
        roomService.addParticipant(1,1);
        verify(roomRepository).addParticipant(1,1);
    }

    @Test
    void removeParticipant(){
        roomService.removeParticipant(1,1);
        verify(roomRepository).removeParticipant(1,1);
    }

    @Test
    void updateRoom() {
        roomService.updateRoom(room);
        verify(roomRepository).save(room);
    }

    @Test
    void deleteRoom() {
        roomService.deleteRoom(room);
        verify(roomRepository).delete(room);
    }
}