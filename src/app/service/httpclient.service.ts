import { CATEGORY } from "./../model/category";
import { Dvd } from "./../model/dvd";
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { SelectControlValueAccessor } from '@angular/forms';
import { User } from '../model/user';

@Injectable({
  providedIn: "root"
})
export class HttpclientService {
  constructor(private httpClient: HttpClient) { }
  private url = "http://localhost:8080/";

  //user methods -
  getUser() {
    let username = "ships";
    let password = "pasword";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
    return this.httpClient.get<User[]>(this.url + 'user', { headers });
  }

  //dvd's methods -
  getAllDvd() {
    let username = "ships";
    let password = "password";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
    console.log("get all dvd mthod from service.");
    return this.httpClient.get<Dvd[]>(this.url, { headers });
  }
  getDvdById(id) {
    let d = this.httpClient.get<Dvd>(this.url + "/byid/" + id);
    console.log(d);
    return this.httpClient.get<Dvd>(this.url + "/byid/" + id);
  }
  createDvd(dvd) {
    this.httpClient.post(this.url, dvd.value).subscribe(response => {
      console.log(dvd.value + ": from subs...");
    });
    console.log(dvd.value);
    //    console.log(JSON.stringify(dvd.value));
  }
  editDvd(dvd, id) {
    console.log(dvd);
    return this.httpClient.put(this.url + `${id}`, dvd).subscribe(
      success => alert("Item modified..."),
      error => alert(error)
    );
  }

  deleteDvd(id) {
    console.log(id);
    return this.httpClient.delete(this.url + `${id}`).subscribe(
      success => alert("Dvd is successfully deleted."),
      error => alert(error)
    );
  }
  // deletePerson(id) {
  //   return this.httpClient.delete(this.url + `${id}`).subscribe(
  //     success => alert("Done"),
  //     error => alert(error)
  //   );
  // }

  //categories -
  getAllCat() {
    let username = "ships";
    let password = "password";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
    console.log("get all categories.");
    return this.httpClient.get<CATEGORY[]>(this.url + "categories", { headers });
  }
}
