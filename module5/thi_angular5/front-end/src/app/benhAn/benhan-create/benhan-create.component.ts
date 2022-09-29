import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MaBenhNhan} from '../../model/ma-benh-nhan';
import {BenhAnService} from '../../service/benh-an.service';

import {Router, Routes} from '@angular/router';
import {MaBenhAn} from '../../model/ma-benh-an';
import {MaBenhAnService} from '../../service/ma-benh-an.service';
import {MaBenhNhanService} from '../../service/ma-benh-nhan.service';

@Component({
  selector: 'app-benhan-creat',
  templateUrl: './benhan-create.component.html',
  styleUrls: ['./benhan-create.component.css']
})
export class BenhanCreateComponent implements OnInit {
  maBenhAns: MaBenhAn[] = [];
  maBenhNhans: MaBenhNhan[] = [];
  benhanForm: FormGroup = new FormGroup({
    maBenhAn: new FormControl('', [Validators.required, Validators.pattern('^(BA-)[0-9]{3}$')]),
    maBenhNhan: new FormControl('', [Validators.required, Validators.pattern('^(BN-)[0-9]{3}$')]),
    tenBenhNhan: new FormControl('', [Validators.required]),
    ngayNhapVien: new FormControl('', [Validators.required]),
    ngayRaVien: new FormControl('', [Validators.required]),
    liDo: new FormControl('', [Validators.required]),
    phuongPhap: new FormControl('', [Validators.required]),
    bacSi: new FormControl('', [Validators.required])
  });


  constructor(private benhAnService: BenhAnService,
              private maBenhAnService: MaBenhAnService,
              private maBenhNhanService: MaBenhNhanService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllMaBenhAn();
    this.getAllMaBenhNhan();
  }

  submit() {
    const benhan = this.benhanForm.value;
    this.maBenhAnService.findById(benhan.maBenhAn).subscribe(maBenhAn => {
        this.maBenhNhanService.findById(benhan.maBenhNhan).subscribe(maBenhNhan => {
            benhan.maBenhAn = {
              id: maBenhAn.id,
              name: maBenhAn.name
            };
            benhan.maBenhNhan = {
              id: maBenhNhan.id,
              name: maBenhNhan.name
            };

            this.benhAnService.saveBenhAn(benhan).subscribe(() => {
              alert('Thêm mới thành công');
              this.benhanForm.reset();
              this.router.navigateByUrl('/benhAn/benhan-list');
            }, e => console.log(e));
          }
        );
      }
    );
  }

  getAllMaBenhNhan() {
    this.maBenhNhanService.getAll().subscribe(maBenhNhan => {
      this.maBenhNhans = maBenhNhan;
    });
  }

  getAllMaBenhAn() {
    this.maBenhAnService.getAll().subscribe(maBenhAn => {
      this.maBenhAns = maBenhAn;
    });
  }
}
