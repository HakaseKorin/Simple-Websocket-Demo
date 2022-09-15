import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

  onSubmit(formData:any){
    // pass username data to lobby to pass to chatroom for display name
    this.auth.updateDisplayName(formData.username);
    this.router.navigate(['/lobby'])
  }

  constructor(
    private formBuilder:FormBuilder,
    private router:Router,
    private auth:AuthService,
    ) { }

  ngOnInit(): void {
  }

}
