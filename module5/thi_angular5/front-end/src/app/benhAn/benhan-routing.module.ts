import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BenhanListComponent} from './benhan-list/benhan-list.component';
import {BenhanCreateComponent} from './benhan-create/benhan-create.component';
import {BenhanEditComponent} from './benhan-edit/benhan-edit.component';


const routes: Routes = [
  {
    path: 'benhan-list',
    component: BenhanListComponent
  }, {
    path: 'benhan-create',
    component: BenhanCreateComponent
  }, {
    path: 'benhan-edit/:id',
    component: BenhanEditComponent
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
export class BenhanRoutingModule { }
