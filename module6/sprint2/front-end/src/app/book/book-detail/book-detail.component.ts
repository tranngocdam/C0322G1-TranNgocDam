import { Component, OnInit } from '@angular/core';
import {BookService} from '../../service/book.service';
import {CartService} from '../../service/cart.service';
import {DataService} from '../../service/data.service';
import {ToastrService} from 'ngx-toastr';
import {Book} from '../../model/book';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  detail: any = [];
  books: Book[] = [];
  carts: any = this.cartService.getCarts();
  constructor(private bookService: BookService,
              private cartService: CartService,
              private data: DataService,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.detail = this.bookService.getDetail();
  }
  minusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.detail[i].quantity = newQuantity;
    this.cartService.saveCarts(this.detail);
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }

  updateQuantity(i: number, event: any) {
    let newQuantity = event.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    event.target.value = newQuantity;
    this.detail[i].quantity = newQuantity;
    this.cartService.saveCarts(this.detail);
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }

  plusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) + 1;
    this.detail[i].quantity = newQuantity;
    this.cartService.saveCarts(this.detail);
    this.data.changeData({
      totalQuantity: this.cartService.getTotalCartQuantity()
    });
  }
  onAddToCart(book: any) {
    let idx = this.carts.findIndex((item: any) => {
      return item.id == book.id;
    });

    if (idx >= 0) {
      this.carts[idx].quantity += 1;
    } else {
      let cartItem: any = {
        id: book.id,
        image: book.image,
        name: book.name,
        price: book.price,
        quantity: 1,
      };
      this.carts.push(cartItem);
    }
    let cartJson = JSON.stringify(this.carts);
    sessionStorage.setItem('cart', cartJson);
    this.toastrService.success('Thêm thêm giỏ hàng thành công', 'Thông báo');
  }

}
