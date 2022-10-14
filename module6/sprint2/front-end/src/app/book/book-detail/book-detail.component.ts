import { Component, OnInit } from '@angular/core';
import {BookService} from '../../service/book.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  detail: any = [];
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.detail = this.bookService.getDetail();
  }

}
