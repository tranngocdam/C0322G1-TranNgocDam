import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BenhanListComponent} from './benhAn/benhan-list/benhan-list.component';
import {BenhanCreateComponent} from './benhAn/benhan-create/benhan-create.component';
import {HeaderComponent} from './header/header.component';



const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'header'
  },
  {
    path: 'header', component: HeaderComponent
  },
  {
    path: 'benhAn',
    loadChildren: () => import('./benhAn/benhan.module').then(module => module.BenhanModule)
  },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)],
  ]
})
export class AppRoutingModule {
}
