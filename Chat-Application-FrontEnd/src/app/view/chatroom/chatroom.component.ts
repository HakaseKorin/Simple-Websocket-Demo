import { Component, OnInit } from '@angular/core';
import { WebsocketService } from 'src/app/services/websocket.service';

@Component({
  selector: 'chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css']
})
export class ChatroomComponent implements OnInit {

  chatLog: any[] = [ ];
  participants: any[] = [
    {
      username: "John"
    },
    {
      username: "Jane"
    }
  ];
  message: string = "";
  username: string = "";
  disabled = true;

  constructor(private webSocketService: WebsocketService) { }

setConnected(status:boolean){
  this.disabled = !status;

  if(status)
    this.chatLog = [];
}

  // send message to chat
  send() {
    this.webSocketService.sendChat(this.username, this.message);
    this.message = "";
  }
  // connect to chat, notifies chat
  connect() {
    this.webSocketService.connect(this.username);
    this.setConnected(true);
    this.chatLog = this.webSocketService.getChatLog();
    // this.webSocketService.sendChat("SYSTEM",`>> ${this.username} has joined the chatroom`);
    
  }
  // discconect from chat, notifies chat
  disconnect() {
    // this.webSocketService.sendChat("SYSTEM",`>> ${this.username} has left the chatroom`);
    this.webSocketService.disconnect(this.username);
    this.setConnected(false);
  }

  ngOnInit(): void {
  }

}
