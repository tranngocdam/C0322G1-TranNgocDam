import {Injectable} from '@angular/core';
import {element} from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
  }

  getCarts() {
    let cartJson = sessionStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
  }

  saveCarts(cart: any) {
    let cartJson = JSON.stringify(cart);
    sessionStorage.setItem('cart', cartJson);
  }

  getTotalCartQuantity(): number {
    let cartList = this.getCarts();
    let totalQuantity = 0;
    cartList.forEach((item: any) => {
      totalQuantity += item.quantity;
    });
    return totalQuantity;
  }

  getTotalCartPrice(): number {
    let cartList = this.getCarts();
    let totalPrice = 0;
    cartList.forEach((item: any) => {
      totalPrice += item.quantity * item.price;
    });
    return totalPrice;
  }

  getCartTotalPrice() {
    let carts = this.getCarts();
    let total: number = 0;
    carts.forEach((item: any) => {
      total += item.quantity * item.price;
    });
    return total;
  }

  getCartTotalQuantity() {
    let carts = this.getCarts();
    let total: number = 0;
    carts.forEach((item: any) => {
      total += item.quantity;
    });
    return total;
  }
}
