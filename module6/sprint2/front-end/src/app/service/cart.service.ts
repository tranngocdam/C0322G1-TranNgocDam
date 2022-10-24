import {Injectable} from '@angular/core';
import {Book} from '../model/book';
import {Cart} from '../model/cart';
const CART_KEY = 'cartId';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
  }
  cartList: Cart[] = [];
  book: Book;

  getCarts() {
    let cartJson = localStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
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
      total += (item.quantity * item.price);
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

  saveCarts(cart: any) {
    let cartJson = JSON.stringify(cart);
    localStorage.setItem('cart', cartJson);
  }

  public saveBook(cartId) {
    if (localStorage.getItem('cart')) {
      this.cartList = JSON.parse(localStorage.getItem('cart'));
    }
    let exists = false;

    this.cartList.forEach(item => {
      if (item.book.id === cartId.book.id) {
        exists = true;
        if (cartId.quantity < 1 && item.quantity === 1) {
          item.quantity = 1;
        } else {
          item.quantity += cartId.quantity;
        }
      }
    });

    if (!exists && cartId.quantity > 0) {
      const cartDto = {} as Cart;
      cartDto.quantity = cartId.quantity;
      cartDto.book = cartId.book;
      this.cartList.push(cartDto);
    }
    window.localStorage.setItem(CART_KEY, JSON.stringify(this.cartList));
  }
}
