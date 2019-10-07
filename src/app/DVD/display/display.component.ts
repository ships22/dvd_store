import { CartService } from './../../service/cart.service';
import { Dvd } from './../../model/dvd';


import { HttpclientService } from "./../../service/httpclient.service";
import { Component, OnInit, Input } from "@angular/core";
import { Observable, BehaviorSubject } from "rxjs";

@Component({
  selector: "app-display",
  templateUrl: "./display.component.html",
  styleUrls: ["./display.component.css"]
})
export class DISPLAYComponent implements OnInit {
  dvds: Dvd[];
  cart: Dvd[] = [];
  c: any[];
  total: number;
  category: any[];
  selectedCat: '';
  dvdDisplay: Dvd[];

  //c = this.cartt.asObservable();
  items: number = 0;
  constructor(
    private httpClientService: HttpclientService,
    private dataPass: CartService
  ) { }

  ngOnInit() {
    this.httpClientService
      .getAllDvd()
      .subscribe(response => this.handleResponse(response));
    // this.dataPass.shoppingCart.subscribe(data => this.cart = data);
    this.dataPass.shoppingCart.subscribe(data => {
      this.c = data
    });
    this.httpClientService
      .getAllCat()
      .subscribe(response => this.category = Object.values(response));
  }

  handleResponse(response) {
    this.dvds = Object.values(response);
    this.dvdDisplay = this.dvds;
  }
  addToCart(d) {
    let exist = this.cart.find(dvd => dvd.id == d.id);
    if (!exist) {
      d.qty = 1;
      d.added = true;
      this.cart.push(d);
    } else {
      exist.qty++;
    }
    this.dataPass.changeCart(this.cart);
  }
  filter(selectedCat) {
    let filteredDvds = this.dvds.filter((dvd) => dvd.cat === selectedCat);
    if (selectedCat) {
      return this.dvdDisplay = filteredDvds;
    } else if (selectedCat.length === 0) {
      return this.dvdDisplay = this.dvds;
    }
  }

}
