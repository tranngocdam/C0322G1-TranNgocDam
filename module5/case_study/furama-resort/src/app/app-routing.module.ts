import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CustomerModule} from './customers/customer.module';
import {FacilityModule} from './facilitys/facility.module';


const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'home'
  },
  {
  path: 'home', component: HomeComponent
  },
  {
  path: 'customers', loadChildren: () => import('./customers/customer.module').then(module => module.CustomerModule)
  },
  {
    path: 'facilitys', loadChildren: () => import('./facilitys/facility.module').then(module => module.FacilityModule)
  }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CustomerModule,
    FacilityModule,
    RouterModule.forRoot(routes,  {initialNavigation: 'enabled' })
  ],
})
export class AppRoutingModule { }
