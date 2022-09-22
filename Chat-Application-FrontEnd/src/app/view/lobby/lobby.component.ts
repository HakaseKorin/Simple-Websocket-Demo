import { Component, OnInit } from '@angular/core';
import { Room } from 'src/app/models/room';
import { RoomService } from 'src/app/services/room.service';
import { WebsocketService } from 'src/app/services/websocket.service';

@Component({
  selector: 'lobby',
  templateUrl: './lobby.component.html',
  styleUrls: ['./lobby.component.css']
})
export class LobbyComponent implements OnInit {

  rooms: Room[] = [];
  //   {
  //     roomId: 1,
  //     ownerId: 1,
  //     password: 'password',
  //     title: 'title'
  //   },
  //   {
  //     roomId: 2,
  //     ownerId: 1,
  //     password: 'password',
  //     title: 'title2'
  //   },
  //   {
  //     roomId: 3,
  //     ownerId: 1,
  //     password: 'password',
  //     title: 'title3'
  //   }
  // ];

  displayName: string = "";

  // pass username data and selected room number to chatroom for websocket and displayname

  constructor(
    private roomService:RoomService,
    private webSocket:WebsocketService,
    ) { this.webSocket.connect("00")}

  ngOnInit(): void {
    this.roomService.getAllRooms().subscribe( (data) => {
      this.rooms = data;
    });
  }

}
