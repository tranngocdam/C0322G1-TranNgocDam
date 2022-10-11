import {Component, OnInit} from '@angular/core';
import {BookService} from '../../service/book.service';
import {DataService} from '../../service/data.service';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css']
})
export class CardListComponent implements OnInit {
  cards: any = [];
  item: any;
  totalQuantity: number = this.bookService.getTotalCartQuantity();
  totalPrice: number = this.bookService.getTotalCartPrice();
   private Swal: any;

  constructor(private bookService: BookService,
              private data: DataService) {
  }

  ngOnInit(): void {
    this.cards = this.bookService.getCards();
  }

  minusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.cards[i].quantity = newQuantity;
    this.bookService.saveCarts(this.cards);
    this.totalQuantity = this.bookService.getTotalCartQuantity();
    this.totalPrice = this.bookService.getTotalCartPrice();
    this.data.changeData({
      totalQuantity: this.bookService.getTotalCartQuantity()
    });
  }

  updateQuantity(i: number, event: any) {
    let newQuantity = event.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    event.target.value = newQuantity;
    this.cards[i].quantity = newQuantity;
    this.bookService.saveCarts(this.cards);
    this.totalQuantity = this.bookService.getTotalCartQuantity();
    this.totalPrice = this.bookService.getTotalCartPrice();
    this.data.changeData({
      totalQuantity: this.bookService.getTotalCartQuantity()
    });
  }

  plusQuantity(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) + 1;
    this.cards[i].quantity = newQuantity;
    this.bookService.saveCarts(this.cards);
    this.totalQuantity = this.bookService.getTotalCartQuantity();
    this.totalPrice = this.bookService.getTotalCartPrice();
    this.data.changeData({
      totalQuantity: this.bookService.getTotalCartQuantity()
    });
  }

  total(card: any) {
    return card.quantity * card.price;
  }

  remove(idx: number) {
    if (confirm('Chắc không')) {
      this.cards.splice(idx, 1);
      this.bookService.saveCarts(this.cards);
    }
  }
}
