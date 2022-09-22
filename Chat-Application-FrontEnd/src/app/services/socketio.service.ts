import { Injectable } from '@angular/core';
import { io } from 'socket.io-client';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SocketioService {

  socket:any;
  chatLog: any[] = [];

  constructor() { }

  setupSocketConnection() {
    this.socket = io(environment.SOCKET_ENDPOINT);
  }

  disconnect(){
    if(this.socket)
      this.socket.disconnect();
  }

  sendMessage(user:string, content:string){
    this.socket.emit('chatevent', JSON.stringify({
      'userName':user,
      'message':content
    }))
  }

  logEvent(message:string){
    this.chatLog.push(message);
  }

  getChatLog(){
    return this.chatLog;
  }

}
