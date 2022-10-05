import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BookListComponent} from './book-list/book-list.component';
import {BookRoutingModule} from './book-routing.module';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [BookListComponent],
  imports: [
    CommonModule, BookRoutingModule, ReactiveFormsModule
  ]
})
export class BookModule { }
