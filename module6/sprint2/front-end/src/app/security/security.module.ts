import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SecurityRoutingModule} from './security-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';



@NgModule({
  declarations: [LoginComponent, SignupComponent],
  imports: [
    CommonModule,
    SecurityRoutingModule,
    ReactiveFormsModule
  ]
})
export class SecurityModule { }
