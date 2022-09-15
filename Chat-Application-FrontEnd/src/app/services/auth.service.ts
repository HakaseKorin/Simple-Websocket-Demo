import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private displayname: string = "";

  updateDisplayName(name:string){ this.displayname = name; }
  getDisplayName(){ return this.displayname; }

  constructor() { }
}
