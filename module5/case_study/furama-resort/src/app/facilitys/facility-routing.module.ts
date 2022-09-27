import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityCreateComponent} from './facility-create/facility-create.component';
import {FacilityDeleteComponent} from './facility-delete/facility-delete.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';


const routes: Routes = [
  {
    path: 'facility-list', component: FacilityListComponent
}, {
    path: 'facility-create', component: FacilityCreateComponent
  }, {
    path: 'facility-delete/:id', component: FacilityDeleteComponent
  }, {
    path: 'facility-edit/:id', component: FacilityEditComponent
  }];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
