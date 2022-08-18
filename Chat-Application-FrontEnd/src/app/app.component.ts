import { Component } from '@angular/core';
import { WebsocketService } from './services/websocket.service';
// import * as SockJS from 'sockjs-client';
// import Stomp from 'stompjs'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'chat-application';
  description = 'Angular-WebSocket Demo';

  greetings: any[] = [];
  disabled = true;
  name: string = "";

  // private stompClient: any;

  constructor(private webSocketService: WebsocketService) { }

  setConnected(connected: boolean) {
    this.disabled = !connected;

    if (connected) {
      this.greetings = [];
    }
  }

  connect() {
    this.webSocketService.connect();
    this.setConnected(true);
    this.greetings = this.webSocketService.getGreeting();
  //   const socket = new SockJS('http://localhost:8080/chatroom-example');
  //   this.stompClient = Stomp.over(socket)

  //   const _this = this;
  //   this.stompClient.connect({}, function (frame: any) {
  //     _this.setConnected(true);
  //     console.log('Connected: ' + frame);

  //     _this.stompClient.subscribe('/topic/hi', function (hello: any) {
  //       _this.showGreeting(JSON.parse(hello.body).greeting);
  //     });
  //   });
  }

  disconnect() {
    this.webSocketService.disconnect();
    this.setConnected(false);
  //   if (this.stompClient != null) {
  //     this.stompClient.disconnect();
  //   }

  //   this.setConnected(false);
  //   console.log('Disconnected!');
  }

  sendName() {
    this.webSocketService.sendName(this.name);
  //   this.stompClient.send(
  //     '/app/hello',
  //     {},
  //     JSON.stringify({ 'name': this.name })
  //   );
  }

}
