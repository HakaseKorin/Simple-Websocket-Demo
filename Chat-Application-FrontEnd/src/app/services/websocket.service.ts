import { Injectable } from '@angular/core';
import * as SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  chatLog: any[] = [];
  stompClient: any;

  constructor() { }

  connect(roomId:string) {
    const socket = new SockJS('http://localhost:8080/chatroom-example');
    this.stompClient = Stomp.over(socket)

    const _this = this;
    this.stompClient.connect({}, function (frame: any) {
      console.log('Connected: ' + frame);

      _this.stompClient.subscribe(`/topic/${roomId}`, function (message: any) {
        // console.log(JSON.parse(message.body));

        var username = JSON.parse(message.body).username;
        var content = JSON.parse(message.body).content;
        var time = JSON.parse(message.body).time;
        _this.showChat(`${username} [${time}] : ${content}`);

        // _this.showChat(JSON.parse(message.body).message);
      });
    });
  }

  disconnect() {
    if (this.stompClient != null)
      this.stompClient.disconnect();
  }

  sendChat(user:any, content:any, roomId:any) {
    this.stompClient.send(
      `/app/send/${roomId}`,
      {},
      JSON.stringify({
        'username':user,
        'content':content,
        'time': null
      })
    );
  }

  showChat(message: any) { this.chatLog.push(message); }

  getChatLog() { return this.chatLog; }

}
