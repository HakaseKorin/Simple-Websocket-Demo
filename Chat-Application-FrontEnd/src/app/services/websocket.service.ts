import { Injectable } from '@angular/core';
import * as SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  greetings: any[] = [];
  stompClient: any;

  constructor() { }

  connect() {
    const socket = new SockJS('http://localhost:8080/chatroom-example');
    this.stompClient = Stomp.over(socket)

    const _this = this;
    this.stompClient.connect({}, function (frame: any) {
      console.log('Connected: ' + frame);

      _this.stompClient.subscribe('/topic/hi', function (hello: any) {
        _this.showGreeting(JSON.parse(hello.body).greeting);
      });
    });
  }

  getStompClient() {
    const _this = this;
    return _this.stompClient;
  }

  disconnect() {
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

  showGreeting(message: any) {
    this.greetings.push(message);
  }

  getGreeting() {
    return this.greetings;
  }

}
