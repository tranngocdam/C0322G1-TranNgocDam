import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerRoutingModule} from './customer-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CustomerDeleteComponent } from './customer-delete/customer-delete.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [CustomerListComponent, CustomerCreateComponent, CustomerDeleteComponent, CustomerEditComponent],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule,
        FormsModule,
        NgxPaginationModule
    ]
})
export class CustomerModule {

}
