import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../security/token-storage.service';
import {ShareService} from '../security/share.service';
import {Book} from '../model/book';
import {BookService} from '../service/book.service';
import {ToastrService} from 'ngx-toastr';
import {CartService} from '../service/cart.service';
import {DataService} from '../service/data.service';
import {Cart} from '../model/cart';

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

  bname: string;
  bcode: string;
  bcreateDate: string;
  bsize: string;
  bdescription: string;
  bauthor: string;
  bprice: number;
  bamount: number;
  bimage: string;
  bnumberOfPage: number;
  caname: string;
  coname: string;
  dpercent: string;
  cart: Cart;
  cartList: Cart[] = [];
  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private bookService: BookService,
              private cartService: CartService,
              private toastrServiceo: ToastrService,
              private data: DataService) {
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
        discount: book.discount,
        quantity: 1,
      };
      this.carts.push(cartItem);
    }
    let cartJson = JSON.stringify(this.carts);
    localStorage.setItem('cart', cartJson);
    this.toastrServiceo.success('Thêm thêm giỏ hàng thành công', 'Thông báo');
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
  addBook(id: number) {
    this.bookService.findById(id).subscribe((data: any) => {
      this.cart = {
        book: data,
        quantity: 1
      };
      this.cartService.saveBook(this.cart);
      // this.getAllCart();
    });
  }
  // getAllCart() {
  //   if (this.cartService.getCart()) {
  //     this.cartList = this.cartService.getCart();
  //     this.total = 0;
  //     for (const item of this.cartList) {
  //       this.total = this.total + ((item.book.price * (100 - item.book.promotion.promotionPrice) / 100) * item.quantity);
  //     }
  //   } else {
  //     this.cartList = null;
  //   }
  // }
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

  Detail(b: Book) {
    this.bname = b.name;
    this.bcode = b.code;
    this.bcreateDate = b.createDate;
    this.bsize = b.size;
    this.bdescription = b.description;
    this.bauthor = b.author;
    this.bprice = b.price;
    this.bamount = b.amount;
    this.bimage = b.image;
    this.bnumberOfPage = b.numberOfPage;
    this.caname = b.category.name;
    this.coname = b.company.name;
    this.dpercent = b.discount.percent;
  }
  // minusQuantity(i: number, quantity: any) {
  //   let newQuantity = parseInt(quantity) - 1;
  //   newQuantity = newQuantity > 0 ? newQuantity : 1;
  //   this.detail[i].quantity = newQuantity;
  //   this.cartService.saveCarts(this.detail);
  //   this.data.changeData({
  //     totalQuantity: this.cartService.getTotalCartQuantity()
  //   });
  // }

  // updateQuantity(i: number, event: any) {
  //   let newQuantity = event.target.value;
  //   newQuantity = newQuantity > 0 ? newQuantity : 1;
  //   event.target.value = newQuantity;
  //   this.detail[i].quantity = newQuantity;
  //   this.cartService.saveCarts(this.detail);
  //   this.data.changeData({
  //     totalQuantity: this.cartService.getTotalCartQuantity()
  //   });
  // }

  // plusQuantity(i: number, quantity: any) {
  //   let newQuantity = parseInt(quantity) + 1;
  //   this.detail[i].quantity = newQuantity;
  //   this.cartService.saveCarts(this.detail);
  //   this.data.changeData({
  //     totalQuantity: this.cartService.getTotalCartQuantity()
  //   });
  // }
  // onAddToDetail(book: any) {
    //   let detail: any = {
    //     name: book.name,
    //     code: book.code,
    //     createDate: book.createDate,
    //     size: book.size,
    //     description: book.description,
    //     author: book.author,
    //     price: book.price,
    //     amount: book.amount,
    //     image: book.image,
    //     numberOfPage: book.numberOfPage,
    //     category: book.category,
    //     company: book.company,
    //     discount: book.discount,
    //     quantity: 1
    //   };
    //   this.detail.push(detail);
    //   let detailJson = JSON.stringify(this.detail);
    //   localStorage.setItem('detail', detailJson);
    // }


}
