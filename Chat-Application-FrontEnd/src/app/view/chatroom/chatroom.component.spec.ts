import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WebsocketService } from 'src/app/services/websocket.service';

import { ChatroomComponent } from './chatroom.component';

describe('ChatroomComponent', () => {
  let component: ChatroomComponent;
  let fixture: ComponentFixture<ChatroomComponent>;
  // let service: WebsocketService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChatroomComponent ],
      providers: [{
        provide: WebsocketService,
        useValue: jasmine.createSpyObj('WebsocketService', ['connect','disconnect','sendChat','getChatLog'])
      }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChatroomComponent);
    component = fixture.componentInstance;
    // service = TestBed.inject(WebsocketService);
    fixture.detectChanges();
  });

  it('#should create', () => {
    expect(component).toBeTruthy();
  });

  it('#setConnected is set to true', () => {
      component.setConnected(true);
      expect(component.disabled)
        .withContext('to set disabled to false')
        .toBe(false);
      expect(component.chatLog)
        .withContext('should clear chatlog')
        .toEqual([]);
  });

  it('#setConnected is set to false', () => {
    component.setConnected(false);
    expect(component.disabled)
      .withContext('to set disabled to true')
      .toBe(true);
  })

  it('#connect()', () => {
    component.connect();

    expect(component.disabled)
      .withContext('sets disabled to false')
      .toBe(false);
  });

  it('#disconnect()', () => {
    component.disconnect();

    expect(component.disabled)
      .withContext('sets disabled to true')
      .toBe(true);
  });

  it('#send()', () => {
    // const mockedService = jasmine.createSpyObj('WebSocketService',['sendChat'])
    component.username = 'username';
    component.message = 'message';
    component.send();
    expect(component.message)
      .withContext('to be cleared')
      .toEqual("");
  })
});
