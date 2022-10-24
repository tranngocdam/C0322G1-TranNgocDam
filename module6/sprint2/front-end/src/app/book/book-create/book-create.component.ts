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
import {FormControl, FormGroup, Validators} from '@angular/forms';

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
    name: new FormControl('', [Validators.required]),
    code: new FormControl('', [Validators.required]),
    createDate: new FormControl('', [Validators.required]),
    size: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
    price: new FormControl('', [Validators.required, Validators.pattern('^[1-9]{1,}$')]),
    amount: new FormControl('', [Validators.required, Validators.min(1), Validators.max(100)]),
    image: new FormControl('', [Validators.required]),
    numberOfPage: new FormControl('', [Validators.required, Validators.min(1)]),
    category: new FormControl('', [Validators.required]),
    company: new FormControl('', [Validators.required]),
    discount: new FormControl('', [Validators.required]),
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
