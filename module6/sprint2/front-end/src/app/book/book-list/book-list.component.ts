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
  p = 1;
  role: string;
  username: string;
  currentUser: string;
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

  constructor(private bookService: BookService,
              private categoryService: CategoryService,
              private companyService: CategoryService,
              private discountService: DiscountService,
              private title: Title,
              private shareService: ShareService,
              private tokenStorageService: TokenStorageService) {
      this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd(),
      this.title.setTitle('Danh sách book');
    });
  }
  loadEditAdd(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }
  ngOnInit(): void {
    // this.getAllBook();
    this.getAll();
    this.loadEditAdd();
  }

  // getAllBook() {
  //   this.bookService.findAllBook().subscribe(value => {
  //     this.books = value;
  //   });
  // }

  deleteBook(b: Book) {
    this.nameBook = b.name;
    this.idBook = b.id;
  }

  delete(idBook: number) {
    this.bookService.deleteBook(idBook).subscribe(() => {
      this.getAll();
    }, error => {
      console.log(error);
    });
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
