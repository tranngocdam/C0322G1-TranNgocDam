import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {ToastrService} from 'ngx-toastr';
import {TokenStorageService} from '../../security/token-storage.service';
import {AppUserService} from '../../service/app-user.service';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  username: string;
  customer: Customer;
  constructor(private tokenStorageService: TokenStorageService,
              private toastrService: ToastrService,
              private appUserService: AppUserService,
              private customerService: CustomerService) { }

  ngOnInit(): void {
    this.username = this.tokenStorageService.getUser().username;
    this.appUserService.getAppUser(this.username).subscribe(value => {
      this.customerService.getCustomer(value?.id).subscribe(item => {
        this.customer = item;
      });
    });
  }
}
