import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChatroomComponent } from './view/chatroom/chatroom.component';
import { LobbyComponent } from './view/lobby/lobby.component';
import { LoginComponent } from './view/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { RoomComponent } from './components/room/room.component'

@NgModule({
  declarations: [
    AppComponent,
    ChatroomComponent,
    LobbyComponent,
    LoginComponent,
    RoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
