import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../security/token-storage.service';
import {ShareService} from '../security/share.service';
import {Book} from '../model/book';
import {BookService} from '../service/book.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  books: Book[] = [];
  nameBook: string;
  idBook: number;
  cards: any = this.bookService.getCards();
  username: string;
  idPatient: number;
  currentUser: string;
  role: string;
  isLoggedIn = false;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private bookService: BookService,
              private toastrServiceo: ToastrService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd();
    });
  }

  ngOnInit(): void {
    this.loadEditAdd();
    this.getAllBook();
  }

  loadEditAdd(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
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

  onAddToCard(book: any) {
    let idx = this.cards.findIndex((item: any) => {
      return item.id == book.id;
    });

    if (idx >= 0) {
      this.cards[idx].quantity += 1;
    } else {
      let cardItem: any = {
        image: book.image,
        name: book.name,
        price: book.price,
        quantity: 1,
        total: function() {
          return this.price * this.quantity;
        }
      };
      this.cards.push(cardItem);
    }
    let cardJson = JSON.stringify(this.cards);
    sessionStorage.setItem('card', cardJson);
    this.toastrServiceo.success('Thêm thêm giỏ hàng thành công', 'Thông báo');
  }
}
