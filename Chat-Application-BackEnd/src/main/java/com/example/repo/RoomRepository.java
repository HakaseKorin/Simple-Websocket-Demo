package com.example.repo;

import com.example.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    public Room getRoomByTitle(String title);
    public Room getRoomByRoomId(Integer roomId);
    @Query(value = "" +
            "select display_name\n" +
            "from room_user \n" +
            "join users\n" +
            "\ton room_user.user_id = users.user_id\n" +
            "join rooms\n" +
            "\ton room_user.room_id = rooms.room_id\n" +
            "where room_user.room_id = ?1",
            nativeQuery = true)
    Set<String> getParticipants(Integer id);
    @Modifying
    @Query(value = "insert into room_user values (?1, ?2)", nativeQuery = true)
    void addParticipant(Integer roomId, Integer userId);
    @Modifying
    @Query(value = "delete from room_user where room_id = ?1 and user_id = ?2", nativeQuery = true)
    void removeParticipant(Integer roomId, Integer userId);
}
