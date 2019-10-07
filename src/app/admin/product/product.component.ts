import { Router } from '@angular/router';
import { CATEGORY } from "./../../model/category";
import { HttpclientService } from "./../../service/httpclient.service";
import { Component, OnInit } from "@angular/core";
import { Dvd } from "../../model/dvd";

@Component({
  selector: "app-product",
  templateUrl: "./product.component.html",
  styleUrls: ["./product.component.css"]
})
export class ProductComponent implements OnInit {
  private dvd: Dvd[];
  private cat: CATEGORY[];

  constructor(private httpClientService: HttpclientService, private router: Router) { }

  ngOnInit() {
    this.httpClientService
      .getAllDvd()
      .subscribe(response => (this.dvd = Object.values(response)));

    this.httpClientService
      .getAllCat()
      .subscribe(response => (this.cat = Object.values(response)));
  }

  submit(f) {
    this.httpClientService.createDvd(f);
    window.location.reload();
    alert(f.name + " has been added.");
  }
  editDvd(id) {
    console.log(id);
    this.router.navigate(['/edit-dvd', id]);
  }
  deleteDvd(id) {
    this.httpClientService.deleteDvd(id);
    location.reload(true);
  }
}
