import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../customer.service';
import {CustomerTypeService} from '../customer-type.service';
import {CustomerType} from '../customerType';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  // customerForm: FormGroup;
  // customerType: CustomerType[] = [];
  // constructor(private customerService: CustomerService,
  //             private customerTypeService: CustomerTypeService,
  //             private toastr: ToastrService,
  //             private router: Router) {
  // }
  // ngOnInit(): void {
  //   this.customerType = this.customerTypeService.getAll();
  //   this.customerForm = new FormGroup({
  //     id: new FormControl('', [Validators.required]),
  //     name: new FormControl('', [Validators.required , Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
  //     customerTypeId: new FormControl(' ', [Validators.required]),
  //     dayOfBirth: new FormControl('', [Validators.required, this.check18]),
  //     gender: new FormControl('', [Validators.required]),
  //     idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
  //     phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^((090)[0-9]{7})|((091)[0-9]{7})$')]),
  //     email: new FormControl('', [Validators.required, Validators.email]),
  //     address: new FormControl('', [Validators.required]),
  //   });
  // }
  //

  //   const customer = this.customerForm.value;
  //   // this.customerService.saveCustomer(customer);
  //   this.customerForm.reset();
  //   this.router.navigateByUrl('customers/customer-list');
  //   this.toastr.success('successfully!', 'Create customer!');
  // }
  // check18(ac: AbstractControl): any {
  //   const yearRegister = Number(ac.value.substr(0, 4));
  //   const yearCurrent = new Date().getFullYear();
  //   return yearCurrent - yearRegister >= 18 ? null : {check18: true};
  // }
  customerForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
    customerType: new FormControl(' ', [Validators.required]),
    dayOfBirth: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^((090)[0-9]{7})|((091)[0-9]{7})$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required]),
  });
  customerType: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private toastr: ToastrService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  submit() {
    const customer = this.customerForm.value;
    this.customerTypeService.findById(customer.customerType).subscribe(customerType => {
        customer.customerType = {
          id: customerType.id,
          name: customerType.name
        };
        this.customerService.saveCustomer(customer).subscribe(() => {
          alert('Thành công');
          this.customerForm.reset();
          this.router.navigateByUrl('customers/customer-list');
        }, e => console.log(e));
      }
    );
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(customerType => {
      this.customerType = customerType;
    });
  }
}
