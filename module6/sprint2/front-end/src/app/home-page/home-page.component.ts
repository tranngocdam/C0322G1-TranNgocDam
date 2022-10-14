import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../security/token-storage.service';
import {ShareService} from '../security/share.service';
import {Book} from '../model/book';
import {BookService} from '../service/book.service';
import {ToastrService} from 'ngx-toastr';
import {Category} from '../model/category';
import {Company} from '../model/company';
import {Discount} from '../model/discount';
import {CartService} from '../service/cart.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  books: Book[] = [];
  nameBook: string;
  idBook: number;
  carts: any = this.cartService.getCarts();
  detail: any = this.bookService.getDetail();
  username: string;
  currentUser: string;
  role: string;
  isLoggedIn = false;

  indexPagination = 0;
  keyword = '';
  pageSize: number;
  totalPage: Array<number>;
  displayPagination = 'inline-block';
  number: number;
  numberOfElement = 0;
  totalElements = 0;
  previousPageStyle = 'inline-block';
  nextPageStyle = 'inline-block';
  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private bookService: BookService,
              private cartService: CartService,
              private toastrServiceo: ToastrService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd();
    });
  }

  ngOnInit(): void {
    this.loadEditAdd();
    this.getAll();
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
    this.toastrServiceo.success('Thêm thêm giỏ hàng thành công', 'Thông báo');
  }
  onAddToDetail(book: any) {
    let detail: any = {
      name: book.name,
      code: book.code,
      createDate: book.createDate,
      size: book.size,
      description: book.description,
      author: book.author,
      price: book.price,
      amount: book.amount,
      image: book.image,
      numberOfPage: book.numberOfPage,
      category: book.category,
      company: book.company,
      discount: book.discount,
    };
    this.detail.push(detail);
    let detailJson = JSON.stringify(this.detail);
    sessionStorage.setItem('detail', detailJson);
  }
  getAll(): void {
    this.bookService.findAll(this.indexPagination, this.keyword, this.pageSize).subscribe((result?: any) => {
      if (result === null) {
        this.totalPage = new Array(0);
        this.books = [];
        this.displayPagination = 'none';
      } else {
        this.number = result?.number;
        this.pageSize = result?.size;
        this.numberOfElement = result?.numberOfElements;
        this.books = result.content;
        this.totalElements = result?.totalElements;
        this.totalPage = new Array(result?.totalPages);
      }
      this.checkPreviousAndNext();
    });
  }

  checkPreviousAndNext() {
    if (this.indexPagination === 0) {
      this.previousPageStyle = 'none';
    } else if (this.indexPagination !== 0) {
      this.previousPageStyle = 'inline-block';
    }
    if (this.indexPagination < (this.totalPage.length - 1)) {
      this.nextPageStyle = 'inline-block';
    } else if (this.indexPagination === (this.totalPage.length - 1) || this.indexPagination > (this.totalPage.length - 1)) {
      this.nextPageStyle = 'none';
    }
  }
  previousPage(event: any) {
    event.preventDefault();
    this.indexPagination--;
    this.ngOnInit();
  }

  nextPage(event: any) {
    event.preventDefault();
    this.indexPagination++;
    this.ngOnInit();
  }
  checkRegex(content: string): boolean {
    const format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    return format.test(content);
  }
  search() {
    if (this.checkRegex(this.keyword)) {
      this.indexPagination = 0;
      this.totalPage = new Array(0);
      this.books = [];
      this.displayPagination = 'none';
      this.checkPreviousAndNext();
    } else {
      this.indexPagination = 0;
      this.displayPagination = 'inline-block';
      this.getAll();
    }
  }
}
