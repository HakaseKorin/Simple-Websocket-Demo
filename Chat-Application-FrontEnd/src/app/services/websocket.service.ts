import { Injectable } from '@angular/core';
import * as SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  greetings: any[] = [];
  chatLog: any[] = [];
  stompClient: any;

  constructor() { }

  connect(user?:string) {
    const socket = new SockJS('http://localhost:8080/chatroom-example');
    this.stompClient = Stomp.over(socket)

    const _this = this;
    this.stompClient.connect({}, function (frame: any) {
      console.log('Connected: ' + frame);

      _this.stompClient.subscribe('/topic/message', function (message: any) {
        console.log(JSON.parse(message.body).message);
        _this.showChat(JSON.parse(message.body).message);
      });
    });
  }

  getStompClient() {
    const _this = this;
    return _this.stompClient;
  }

  disconnect(user?:string) {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }

    console.log('Disconnected!');
  }

  sendName(name: any) {
    this.stompClient.send(
      '/app/hello',
      {},
      JSON.stringify({ 'name': name })
    );
  }

  sendChat(user:any, content:any) {
    var timestamp = Date.now().toString();
    this.stompClient.send(
      '/app/send',
      {},
      JSON.stringify({
        'username':user,
        'content':content,
        'time': timestamp
      })
    );
  }

  showGreeting(message: any) {
    this.greetings.push(message);
  }

  showChat(message: any) {
    this.chatLog.push(message);
  }

  getGreeting() {
    return this.greetings;
  }

  getChatLog() {
    return this.chatLog;
  }

}
