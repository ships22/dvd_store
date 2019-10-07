import { UserLog } from './../model/UserLog';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private url = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) { }

  authenticate(username, password) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<UserLog>(this.url + 'validateLogin', { headers }).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          return userData;
        }
      )
    );
    // if (username === 'ships' && password === 'ships') {
    //   sessionStorage.setItem('username', username);
    //   return true;
    // } else {
    //   return false;
    // }
  }
  isLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log("isLoggedIn :" + !(user === null));
    return !(user === null);
  }
  logOut() {
    sessionStorage.removeItem('username');
  }
}
