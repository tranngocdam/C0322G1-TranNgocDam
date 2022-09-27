import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {DictionaryPageComponent} from './dictionary-page/dictionary-page.component';
import {DistionaryDetailComponent} from './distionary-detail/distionary-detail.component';


const routes: Routes = [
  {
    path: 'list', component: DictionaryPageComponent
  },
  {
    path: 'detail/:word', component: DistionaryDetailComponent
  }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class DictionaryRoutingModule { }
