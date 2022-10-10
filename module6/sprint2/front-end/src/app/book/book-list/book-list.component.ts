import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../../security/token-storage.service';
import {ShareService} from '../../security/share.service';
import {Book} from '../../model/book';
import {BookService} from '../../service/book.service';
import {CategoryService} from '../../service/category.service';
import {DiscountService} from '../../service/discount.service';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: Book[] = [];
  nameBook: string;
  idBook: number;

  constructor(private bookService: BookService,
              private categoryService: CategoryService,
              private companyService: CategoryService,
              private discountService: DiscountService,
              private title: Title) {
    this.title.setTitle('Danh sách book');
  }

  ngOnInit(): void {
    this.getAllBook();
  }

  getAllBook() {
    this.bookService.findAllBook().subscribe(value => {
      this.books = value;
    });
  }

  deleteBook(b: Book) {
    this.nameBook = b.name;
    this.idBook = b.id;
  }

  delete(idBook: number) {
    this.bookService.deleteBook(idBook).subscribe(() => {
      this.getAllBook();
    }, error => {
      console.log(error);
    });
  }
}
