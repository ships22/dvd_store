import { AuthenticationService } from './../service/authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';
  invalidLogin = false;

  constructor(private router: Router, private loginService: AuthenticationService) { }

  ngOnInit() {
  }
  checkLogin() {
    (this.loginService.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate([''])
        this.invalidLogin = false;
      },
      err => {
        this.invalidLogin = true;
      }
    )
    )

    //  if (this.loginService.authenticate(this.username, this.password)) {
    //   this.router.navigate([''])
    //   this.invalidLogin = false;
    // } else {
    //   this.invalidLogin = true;
    // }
  }
}
