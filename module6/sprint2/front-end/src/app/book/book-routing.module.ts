import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from './book-list/book-list.component';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {BookCreateComponent} from './book-create/book-create.component';
import {BookUpdateComponent} from './book-update/book-update.component';


const routes: Routes = [
  {
    path: 'book/list',
    component: BookListComponent
  }, {
    path: 'book/detail',
    component: BookDetailComponent
  }, {
    path: 'book/create',
    component: BookCreateComponent
  }, {
    path: 'book/update',
    component: BookUpdateComponent
  }
  ];
@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports : [RouterModule]
})
export class BookRoutingModule { }
