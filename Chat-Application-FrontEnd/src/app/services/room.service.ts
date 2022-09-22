import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http:HttpClient) { }

  createRoom(title:string, owner:number, password:string){ 
    const formData = new FormData();

    formData.append('title', title);
    formData.append('password', password);
    formData.append('owner', owner.toString());

    return this.http.post<Room>(`localhost:8080/room`, formData);
  }
  
  getAllRooms(){ return this.http.get<Room[]>(`localhost:8080/room/all`); }

  updateRoom(roomId:number, title:string, password:string, owner:number){
    const formData = new FormData();
    
    formData.append('room_id', roomId.toString());
    formData.append('title', title);
    formData.append('password', password);
    formData.append('owner',owner.toString());

    this.http.put<void>(`localhost:8080/room`, formData);
  }

}
