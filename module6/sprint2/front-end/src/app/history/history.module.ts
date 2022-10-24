import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HistoryCartComponent} from './history-cart/history-cart.component';
import {HistoryRoutingModule} from './history-routing.module';



@NgModule({
  declarations: [HistoryCartComponent],
  imports: [
    CommonModule, HistoryRoutingModule
  ]
})
export class HistoryModule { }
