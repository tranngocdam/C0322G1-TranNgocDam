import { NgModule } from '@angular/core';
import {CommonModule, DatePipe} from '@angular/common';
import {BookListComponent} from './book-list/book-list.component';
import {BookRoutingModule} from './book-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {BookCreateComponent} from './book-create/book-create.component';

@NgModule({
    declarations: [BookListComponent, BookDetailComponent, BookCreateComponent],
    imports: [
        CommonModule, BookRoutingModule, ReactiveFormsModule, HttpClientModule, FormsModule,
    ],
  providers: [DatePipe]
})
export class BookModule { }
