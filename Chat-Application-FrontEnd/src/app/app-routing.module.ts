import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatroomComponent } from './view/chatroom/chatroom.component';
import { LobbyComponent } from './view/lobby/lobby.component';
import { LoginComponent } from './view/login/login.component';

const routes: Routes = [
  {path: 'lobby', component: LobbyComponent},
  {path: 'chatroom', component: ChatroomComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo:'login',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
