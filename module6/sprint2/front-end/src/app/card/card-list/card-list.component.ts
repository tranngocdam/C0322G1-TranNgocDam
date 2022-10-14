import {Component, OnInit} from '@angular/core';
import {BookService} from '../../service/book.service';
import {DataService} from '../../service/data.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {CartService} from '../../service/cart.service';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css']
})
export class CardListComponent implements OnInit {
  carts: any = [];
  item: any;
  totalQuantity: number = this.cartService.getTotalCartQuantity();

  totalPrice: number = this.cartService.getTotalCartPrice();
  sumPrice: number = this.cartService.getCartTotalPrice();
  sumQuantity: number = this.cartService.getCartTotalQuantity();
  constructor(private cartService: CartService,
              private data: DataService) {
    render(
      {
        id: "#myPaypalButtons",
        currency: "USD",
        value: "100.00",
        onApprove: (details) => {
          alert("Transaction");
        }
      }
    );
  }

  ngOnInit(): void {
    this.carts = this.cartService.getCarts();
  }

  minusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.carts[i].quantity = newQuantity;
    this.cartService.saveCarts(this.carts);
    this.sumPrice = this.cartService.getCartTotalPrice();
    this.sumQuantity = this.cartService.getCartTotalQuantity();
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }

  updateQuantity(i: number, event: any) {
    let newQuantity = event.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    event.target.value = newQuantity;
    this.carts[i].quantity = newQuantity;
    this.cartService.saveCarts(this.carts);
    this.sumPrice = this.cartService.getCartTotalPrice();
    this.sumQuantity = this.cartService.getCartTotalQuantity();
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }

  plusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) + 1;
    this.carts[i].quantity = newQuantity;
    this.cartService.saveCarts(this.carts);
    this.sumPrice = this.cartService.getCartTotalPrice();
    this.sumQuantity = this.cartService.getCartTotalQuantity();
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }

  total(cart: any) {
    return cart.quantity * cart.price;
  }

  remove(idx: number) {
    let _this = this;
    if (confirm('Chắc không')) {
      _this.carts.splice(idx, 1);
      _this.cartService.saveCarts(_this.carts);
    }
  }
  onClearCart() {
    let _this = this;
    sessionStorage.clear();
    _this.carts = [];
  }
}
