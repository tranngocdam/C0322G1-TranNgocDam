import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CustomerRoutingModule} from './customer-routing.module';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';



@NgModule({
  declarations: [CustomerEditComponent, CustomerDetailComponent],
  imports: [
    CommonModule, CustomerRoutingModule
  ]
})
export class CustomerModule { }
