import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BenhanListComponent} from './benhan-list/benhan-list.component';
import {BenhanCreateComponent} from './benhan-create/benhan-create.component';
import {BenhanRoutingModule} from './benhan-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BenhanEditComponent } from './benhan-edit/benhan-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [BenhanListComponent, BenhanCreateComponent, BenhanEditComponent],
  imports: [
    CommonModule,
    BenhanRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class BenhanModule {
}
