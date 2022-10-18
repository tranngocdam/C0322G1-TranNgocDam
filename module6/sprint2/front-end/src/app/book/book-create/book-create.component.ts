import {Component, OnInit} from '@angular/core';
import {BookService} from '../../service/book.service';
import {CompanyService} from '../../service/company.service';
import {CategoryService} from '../../service/category.service';
import {DiscountService} from '../../service/discount.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {Book} from '../../model/book';
import {Category} from '../../model/category';
import {Company} from '../../model/company';
import {Discount} from '../../model/discount';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-book-create',
  templateUrl: './book-create.component.html',
  styleUrls: ['./book-create.component.css']
})
export class BookCreateComponent implements OnInit {

  constructor(private bookService: BookService,
              private companyService: CompanyService,
              private categoryService: CategoryService,
              private discountService: DiscountService,
              private toastrServiceo: ToastrService,
              private title: Title,
              private router: Router) {
    this.title.setTitle('Tạo mới sách');
  }
  books: Book[] = [];
  categorys: Category[] = [];
  companys: Company[] = [];
  discounts: Discount[] = [];
  bookForm: FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    code: new FormControl(''),
    createDate: new FormControl(''),
    size: new FormControl(''),
    description: new FormControl(''),
    author: new FormControl(''),
    price: new FormControl(''),
    amount: new FormControl(''),
    image: new FormControl(''),
    numberOfPage: new FormControl(''),
    isDelete: new FormControl(''),
    category: new FormControl(''),
    company: new FormControl(''),
    discount: new FormControl(''),
  });

  ngOnInit(): void {
    this.getAllCategory();
    this.getAllCompany();
    this.getAllDiscount();
  }

  getAllCategory() {
    this.categoryService.findAllCategory().subscribe(value => {
      this.categorys = value;
    });
  }

  getAllCompany() {
    this.companyService.findAllCompany().subscribe(value => {
      this.companys = value;
    });
  }

  getAllDiscount() {
    this.discountService.findAllCompany().subscribe(value => {
      this.discounts = value;
    });
  }

  submit() {
    const book = this.bookForm.value;
    this.categoryService.findById(book.category).subscribe(value => {
      this.companyService.findById(book.company).subscribe(value1 => {
        this.discountService.findById(book.discount).subscribe(value2 => {
            book.category = {
              id: value.id,
            };
            book.company = {
              id: value1.id,
            };
            book.discount = {
              id: value2.id,
            };
            this.bookService.saveBook(book).subscribe(() => {
                this.toastrServiceo.success('Thêm mới thành công', 'Thông báo');
                this.bookForm.reset();
                this.router.navigateByUrl('/book/list');
            }, error => console.log(error));
        });
      });
    });
  }
}
