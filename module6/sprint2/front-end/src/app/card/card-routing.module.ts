import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from '../book/book-list/book-list.component';
import {BookDetailComponent} from '../book/book-detail/book-detail.component';
import {BookCreateComponent} from '../book/book-create/book-create.component';
import {CardListComponent} from './card-list/card-list.component';



const routes: Routes = [
  {
    path: 'card',
    component: CardListComponent
  }];
@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports : [RouterModule]
})
export class CardRoutingModule { }
