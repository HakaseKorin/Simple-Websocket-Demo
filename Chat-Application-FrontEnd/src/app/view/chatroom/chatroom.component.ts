import { Component, OnInit } from '@angular/core';
import { WebsocketService } from 'src/app/services/websocket.service';

@Component({
  selector: 'chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css']
})
export class ChatroomComponent implements OnInit {

  chatLog: any[] = [
    {
      username: "SYSTEM",
      message: ">> john has connected.",
      timestamp: "10:51AM"
    },
    {
      username: "SYSTEM",
      message: ">> jane has connected.",
      timestamp: "10:52AM"
    },
    {
      username: "john",
      message: "hello jane",
      timestamp: "10:53AM"
    },
    {
      username: "jane",
      message: "hello John",
      timestamp: "10:54AM"
    },
    {
      username: "john",
      message: "hows the weather",
      timestamp: "10:55AM"
    },        
  ];

  content: any[] = [
    {
      username: "john"
    },
    {
      username: "jane"
    }
  ];
  message: string = "";
  username: string = "";
  disabled = false;

  constructor(private webSocketService: WebsocketService) { }
  // send message to chat
  send() {}
  // connect to chat, notifies chat
  connect() {
    this.webSocketService.connect();
    this.chatLog = this.webSocketService.getChatLog();
  }
  // discconect from chat, notifies chat
  disconnect() {
    this.webSocketService.disconnect();
  }

  ngOnInit(): void {
  }

}
