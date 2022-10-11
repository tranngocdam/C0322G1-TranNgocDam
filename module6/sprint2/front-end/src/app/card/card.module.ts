import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CardRoutingModule} from './card-routing.module';
import {CardListComponent} from './card-list/card-list.component';



@NgModule({
  declarations: [CardListComponent],
  imports: [
    CommonModule, CardRoutingModule
  ]
})
export class CardModule { }
