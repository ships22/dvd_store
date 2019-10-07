import { Dvd } from './../model/dvd';
import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private serviceCart = new BehaviorSubject<any>([]);
  shoppingCart = this.serviceCart.asObservable();
  constructor() { }
  changeCart(Dvd: any[]) {
    this.serviceCart.next(Dvd);
  }
}
