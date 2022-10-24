import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HistoryCartComponent} from './history-cart/history-cart.component';
import {CommonModule} from '@angular/common';
import {BookRoutingModule} from '../book/book-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';


const routes: Routes = [
  {  path : 'book/history',
    component : HistoryCartComponent
  }
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports : [CommonModule, BookRoutingModule, ReactiveFormsModule, HttpClientModule, FormsModule, NgxPaginationModule]
})
export class HistoryRoutingModule { }
