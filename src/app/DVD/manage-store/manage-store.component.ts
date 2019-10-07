import { CartService } from './../../service/cart.service';
import { Dvd } from "./../../model/dvd";
import { HttpclientService } from "./../../service/httpclient.service";
import { Component, OnInit } from "@angular/core";
import { CATEGORY } from "../../model/category";
import { Router } from '@angular/router';

@Component({
  selector: "app-manage-store",
  templateUrl: "./manage-store.component.html",
  styleUrls: ["./manage-store.component.css"]
})
export class ManageStoreComponent implements OnInit {
  dvds: Dvd[];
  categories: CATEGORY[];
  c: any;
  constructor(private dataPass: CartService, private httpClientService: HttpclientService, private router: Router) { }

  ngOnInit() {
    this.dataPass.shoppingCart.subscribe(data => {
      this.c = data, console.log("called from manage-store :" + data);
    });

  }

  editDvd(id) {
    console.log(id);
    this.router.navigate(['edit-dvd', id]);
  }
}
