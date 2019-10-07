import { element } from 'protractor';
import { Dvd } from './../../../model/dvd';
import { CartService } from './../../../service/cart.service';
import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  cart: any = [];
  t: number = 0;

  constructor(private dataPass: CartService) { }

  ngOnInit() {
    this.dataPass.shoppingCart.subscribe(data => {
      this.cart = data;
      this.getTotal();
    });
  }

  addItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].qty++;
    this.getTotal();
  }
  removeItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].qty--;
    if (this.cart[itemIndex].qty == 0) {
      this.cart[itemIndex].added = false;
      this.cart.splice(itemIndex, 1);
    }
    this.getTotal();
  }
  cancelItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].added = false;
    this.cart.splice(itemIndex, 1);
  }

  getTotal() {
    this.t = 0;
    for (let i = 0; i < this.cart.length; i++) {
      let q = this.cart[i].qty;
      let p = this.cart[i].price;
      this.t += q * p;
    }
    console.log("getTotal : " + this.t);
  }

}
