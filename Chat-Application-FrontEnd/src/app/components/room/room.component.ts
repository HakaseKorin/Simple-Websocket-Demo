import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from 'src/app/models/room';

@Component({
  selector: 'room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  @Input()
  room: Room = {
    roomId: 0,
    ownerId: 0,
    password: 'password',
    title: 'title'
  }

  joinRoom(){
    this.router.navigate(['/chatroom'])
  }

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

}
