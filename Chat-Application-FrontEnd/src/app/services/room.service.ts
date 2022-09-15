import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http:HttpClient) { }

  createRoom(){ 
    const formData = new FormData();
    formData.append('title', 'title');
    formData.append('password', 'password');
    formData.append('owner', '1');
    return this.http.post<Room>(`localhost:8080/room`, formData);
  }
  
  getAllRooms(){ return this.http.get<Room[]>(`localhost:8080/room/all`); }

  updateRoom(){
    const formData = new FormData();
    formData.append('room_id', '1');
    formData.append('title', 'title');
    formData.append('password', 'password');
    formData.append('owner','1');
    this.http.put<void>(`localhost:8080/room`, formData);
  }

}
