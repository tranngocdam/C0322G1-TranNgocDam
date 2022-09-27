import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../customer.service';
import {CustomerType} from '../customerType';
import {CustomerTypeService} from '../customer-type.service';
import {Customer} from '../customer';
import {ToastrService} from 'ngx-toastr';
import {FacilityType} from '../../facilitys/FacilityType';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  // customerForm: FormGroup;
  // customerType: CustomerType[];
  // customer: Customer = {};
  // constructor(
  //   private customerService: CustomerService,
  // private activatedRoute: ActivatedRoute,
  // private customerTypeService: CustomerTypeService,
  // private router: Router,
  // private toastr: ToastrService
  // ) {
  // }
  // ngOnInit(): void {
  // const id = Number(this.activatedRoute.snapshot.params.id);
  // const customer = this.customerService.findById(id);
  // this.customerType = this.customerTypeService.getAll();
  // this.customerForm = new FormGroup({
  //   id: new FormControl(customer.id),
  //   customerTypeId: new FormControl(customer.customerTypeId),
  //   name: new FormControl(customer.name, [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
  //   dayOfBirth: new FormControl(customer.dayOfBirth, [Validators.required]),
  //   gender: new FormControl(customer.gender, [Validators.required]),
  //   idCard: new FormControl(customer.idCard, [Validators.required, Validators.pattern('^[0-9]{9}$')]),
  //   phoneNumber: new FormControl(customer.phoneNumber, [Validators.required, Validators.pattern('^((090)[0-9]{7})|((091)[0-9]{7})$')]),
  //   email: new FormControl(customer.email, [Validators.required, Validators.email]),
  //   address: new FormControl(customer.address, [Validators.required]),
  // });
  // }
  // onSubmit() {
  // this.customerService.updateCustomer(this.customerForm.value);
  // this.router.navigateByUrl('customers/customer-list');
  // this.toastr.success('successfully!', 'Edit customer!');
  // }
  // compareCustomerType(c1: CustomerType, c2: CustomerType) {
  //   if ((c1 && c2) !== undefined) {
  //     return c1.id === c2.id;
  //   }
  // }

  customerForm: FormGroup = new FormGroup({
    customerType: new FormControl(''),
    name: new FormControl('', [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
    dayOfBirth: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^((090)[0-9]{7})|((091)[0-9]{7})$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required]),
  });
  customerType: CustomerType[] = [];
  id: number;

  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private customerTypeService: CustomerTypeService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.customerForm = new FormGroup({
        customerType: new FormControl(customer.customerType.id),
        name: new FormControl(customer.name, [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
        dayOfBirth: new FormControl(customer.dayOfBirth, [Validators.required]),
        gender: new FormControl(customer.gender, [Validators.required]),
        idCard: new FormControl(customer.idCard, [Validators.required, Validators.pattern('^[0-9]{9}$')]),
        phoneNumber: new FormControl(customer.phoneNumber, [Validators.required, Validators.pattern('^((090)[0-9]{7})|((091)[0-9]{7})$')]),
        email: new FormControl(customer.email, [Validators.required, Validators.email]),
        address: new FormControl(customer.address, [Validators.required]),
      });
    });
  }

  onSubmit(id: number) {
    const customer = this.customerForm.value;
    this.customerTypeService.findById(customer.customerType).subscribe(customerType => {
      customer.customerType = {
        id: customerType.id,
        name: customerType.name
      };
      this.customerService.editCustomer(id, customer).subscribe(() => {
        alert('Sửa thành công');
        this.router.navigateByUrl('customer-list');
      }, e => console.log(e));
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(customerType => {
      this.customerType = customerType;
    });
  }
}
