import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BookRoutingModule} from '../book/book-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';


const routes: Routes = [
  {
    path: 'customer/edit',
    component: CustomerEditComponent
  },{
    path: 'customer',
    component: CustomerDetailComponent
  }
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports : [CommonModule, BookRoutingModule, ReactiveFormsModule, HttpClientModule, FormsModule, NgxPaginationModule]
})
export class CustomerRoutingModule { }
