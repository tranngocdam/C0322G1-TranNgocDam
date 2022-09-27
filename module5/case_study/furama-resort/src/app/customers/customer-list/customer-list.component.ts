import {Component, OnInit} from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {ToastrService} from 'ngx-toastr';
import {CustomerType} from '../customerType';
import {CustomerTypeService} from '../customer-type.service';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customerType: CustomerType[] = [];
  p = 1;
  idModal: number;
  nameModal: string;
  name1 = '';
  name2 = '';

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) {
  }

  getDataForModal(c: Customer) {
    this.idModal = c.id;
    this.nameModal = c.name;

  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(() => {
      this.getAll();
    }, e => {
      console.log(e);
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
    this.customerTypeService.getAll().subscribe(customerTypes => {
      this.customerType = customerTypes;
    });
  }

  searchCustomer() {
    return this.customerService.searchCustomer(this.name1, this.name2).subscribe(listSearch => {
      this.customers = listSearch;
      this.name2 = '';
      this.p = 1;
    });
  }
}
