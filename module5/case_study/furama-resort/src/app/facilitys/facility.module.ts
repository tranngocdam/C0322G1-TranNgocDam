import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityRoutingModule} from './facility-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FacilityCreateComponent} from './facility-create/facility-create.component';
import { FacilityDeleteComponent } from './facility-delete/facility-delete.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';



@NgModule({
  declarations: [FacilityListComponent, FacilityCreateComponent, FacilityDeleteComponent, FacilityEditComponent],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class FacilityModule { }
