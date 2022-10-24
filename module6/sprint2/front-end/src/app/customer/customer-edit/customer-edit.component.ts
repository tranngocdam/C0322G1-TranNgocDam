import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup} from '@angular/forms';
import {AppUser} from '../../model/app-user';
import {TokenStorageService} from '../../security/token-storage.service';
import {ToastrService} from 'ngx-toastr';
import {AppUserService} from '../../service/app-user.service';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  username: string;
  customer: Customer;
  customerForm: FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    dayOfBirth: new FormControl(''),
    address: new FormControl(''),
    phone: new FormControl(''),
    email: new FormControl(''),
  });

  constructor(private tokenStorageService: TokenStorageService,
              private toastrService: ToastrService,
              private appUserService: AppUserService,
              private customerService: CustomerService,
              private router: Router) { }

  ngOnInit(): void {
    this.username = this.tokenStorageService.getUser().username;
    this.appUserService.getAppUser(this.username).subscribe(value => {
      this.customerService.getCustomer(value?.id).subscribe(item => {
        this.customerForm.patchValue(item);
      });
    });
  }

  onSubmit() {
    this.customer = this.customerForm.value;
    console.log(this.customer);
    this.customerService.edit(this.customer).subscribe(value => {
      this.toastrService.success('Cập nhập thông tin thành công', 'Thông Báo');
      this.router.navigateByUrl('/customer');
    });
  }
}
