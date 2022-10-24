import { Component, OnInit } from '@angular/core';
import {AppUser} from '../../model/app-user';
import {FormControl, FormGroup} from '@angular/forms';
import {AppUserService} from '../../service/app-user.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  appUser: AppUser;
  formGroup: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    email: new FormControl('')
  });
  constructor(private appUserService: AppUserService,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(){
    this.appUser = this.formGroup.value;
    this.appUserService.save(this.appUser).subscribe(value => {
      this.toastrService.success('Thêm mới tài khoản thành công!', 'Thông báo');
      this.router.navigateByUrl('/login');
    });
  }
}
