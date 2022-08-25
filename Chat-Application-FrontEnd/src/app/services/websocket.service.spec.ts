import { TestBed } from '@angular/core/testing';

import { WebsocketService } from './websocket.service';

describe('WebsocketService', () => {
  let service: WebsocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WebsocketService);
  });

  it('#should be created', () => {
    expect(service).toBeTruthy();
  });

  it('#showChat should push an object onto the chatLog[]', () =>{
    service.showChat("Hello Chat");
    expect(service.chatLog).toEqual(["Hello Chat"]);
  })

  it('#connect', () => {
    const mockedService = 
      jasmine.createSpyObj('WebsocketService', ['connect']);
    
    mockedService.connect();

    expect(mockedService.connect).toHaveBeenCalled();
  })

  it('#disconnect', () => {
    const mockedService = 
      jasmine.createSpyObj('WebsocketService', ['disconnect']);

      mockedService.disconnect();

      expect(mockedService.disconnect).toHaveBeenCalled();
  })

  it('#getChatLog returns chatLog', () => {
    expect(service.getChatLog()).toEqual([]);
  })
});
