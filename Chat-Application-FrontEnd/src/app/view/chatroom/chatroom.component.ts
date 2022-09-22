import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Room } from 'src/app/models/room';
import { AuthService } from 'src/app/services/auth.service';
import { SocketioService } from 'src/app/services/socketio.service';
import { WebsocketService } from 'src/app/services/websocket.service';

@Component({
  selector: 'chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css']
})
export class ChatroomComponent implements OnInit, OnDestroy {

  chatLog: any[] = [ ];
  participants: any[] = [
    {
      username: "John"
    },
    {
      username: "Jane"
    }
  ];

  @Input()
  room: Room = {
    roomId: 0,
    ownerId: 0,
    password: 'password',
    title: 'title'
  }

  message: string = "default message";
  username: string = "default user";
  disabled = true;

constructor(
  // private webSocketService: WebsocketService,
  private socket:SocketioService,
  private auth:AuthService,
  ) { }

  send(){
    this.socket.sendMessage(this.username,this.message);
  }

  ngOnInit(): void {
    this.socket.setupSocketConnection();
    this.chatLog = this.socket.getChatLog();
  }

  ngOnDestroy(): void {
    this.socket.disconnect();
  }

// setConnected(status:boolean){
//   this.disabled = !status;

//   if(status) { 
//     this.chatLog = [];
//    }
// }

//   send() {
//     this.webSocketService.sendChat(this.username, this.message, this.room.roomId);
//     this.message = "";
//   }

//   connect() {
//     this.webSocketService.connect(this.room.roomId.toString());
//     this.setConnected(true);
//     this.chatLog = this.webSocketService.getChatLog();
    
//   }
//   disconnect() {
//     this.webSocketService.disconnect();
//     this.setConnected(false);
//   }

//   ngOnInit(): void {
//     this.connect();
//     this.username = this.auth.getDisplayName();

//   }

//   ngOnDestroy(): void {
//     this.disconnect();
//   }

}
