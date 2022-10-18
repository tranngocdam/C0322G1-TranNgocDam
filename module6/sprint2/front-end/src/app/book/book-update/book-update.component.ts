import {Component, OnInit} from '@angular/core';
import {FormControl, FormControlName, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {Company} from '../../model/company';
import {Discount} from '../../model/discount';
import {BookService} from '../../service/book.service';
import {CategoryService} from '../../service/category.service';
import {CompanyService} from '../../service/company.service';
import {DiscountService} from '../../service/discount.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {Book} from '../../model/book';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {
  // book: Book = {};
  categorys: Category[] = [];
  companys: Company[] = [];
  discounts: Discount[] = [];
  id: number;
  bookForm: FormGroup = new FormGroup({
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
    category: new FormControl(''),
    company: new FormControl(''),
    discount: new FormControl('')
  });

  constructor(private bookService: BookService,
              private categoryService: CategoryService,
              private companyService: CompanyService,
              private discountService: DiscountService,
              private toastrService: ToastrService,
              private title: Title,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.title.setTitle('Sửa thông tin sách'),
      this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        this.id = +paramMap.get('id');
        this.getBook(this.id);
      });
  }

  ngOnInit(): void {
    this.getAllCategory();
    this.getAllCompany();
    this.getAllDiscount();
  }

  getBook(id: number) {
    return this.bookService.findById(id).subscribe(book => {
      this.bookForm = new FormGroup({
        id: new FormControl(book.id),
        name: new FormControl(book.name),
        code: new FormControl(book.code),
        createDate: new FormControl(book.createDate),
        size: new FormControl(book.size),
        description: new FormControl(book.description),
        author: new FormControl(book.author),
        price: new FormControl(book.price),
        amount: new FormControl(book.amount),
        image: new FormControl(book.image),
        numberOfPage: new FormControl(book.numberOfPage),
        category: new FormControl(book.category.id),
        company: new FormControl(book.company.id),
        discount: new FormControl(book.discount.id)
      });
    });
  }

  submit(id: number) {
    const book = this.bookForm.value;
    this.categoryService.findById(book.category).subscribe(category => {
        this.companyService.findById(book.company).subscribe(company => {
            this.discountService.findById(book.discount).subscribe(discount => {
                book.category = {
                  id: category.id,
                };
                book.company = {
                  id: company.id,
                };
                book.discount = {
                  id: discount.id,
                };
                this.bookService.updateBook(id, book).subscribe(() => {
                  console.log(book);
                  this.toastrService.success('Cập nhật thành công', 'Thông báo');
                  // this.bookForm.reset();
                  this.router.navigateByUrl('/homepage');
                }, e => console.log(e));
              }
            );
          }
        );
      }
    );
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
}
