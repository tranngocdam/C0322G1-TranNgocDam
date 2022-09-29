import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MaBenhAn} from '../../model/ma-benh-an';
import {MaBenhNhan} from '../../model/ma-benh-nhan';
import {BenhAnService} from '../../service/benh-an.service';
import {MaBenhAnService} from '../../service/ma-benh-an.service';
import {MaBenhNhanService} from '../../service/ma-benh-nhan.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-benhan-edit',
  templateUrl: './benhan-edit.component.html',
  styleUrls: ['./benhan-edit.component.css']
})
export class BenhanEditComponent implements OnInit {
  maBenhAns: MaBenhAn[] = [];
  maBenhNhans: MaBenhNhan[] = [];
  id: number;
  benhAnForm: FormGroup = new FormGroup({
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
              private router: Router,
              private activatedRoute: ActivatedRoute
  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getBenhAn(this.id);
    });
  }
  ngOnInit(): void {
    this.getAllMaBenhAn();
    this.getAllMaBenhNhan();
  }
  getBenhAn(id: number) {
    return this.benhAnService.findById(id).subscribe(benhAn => {
      this.benhAnForm = new FormGroup({
        maBenhAn: new FormControl(benhAn.maBenhAn.id, [Validators.required, Validators.pattern('^(BA-)[0-9]{3}$')]),
        maBenhNhan: new FormControl(benhAn.maBenhNhan.id, [Validators.required, Validators.pattern('^(BN-)[0-9]{3}$')]),
        tenBenhNhan: new FormControl(benhAn.tenBenhNhan, [Validators.required]),
        ngayNhapVien: new FormControl(benhAn.ngayNhapVien, [Validators.required]),
        ngayRaVien: new FormControl(benhAn.ngayRaVien, [Validators.required]),
        liDo: new FormControl(benhAn.liDo, [Validators.required]),
        phuongPhap: new FormControl(benhAn.phuongPhap, [Validators.required]),
        bacSi: new FormControl(benhAn.bacSi, [Validators.required])
      });
    });
  }



  submit(id: number) {
    const benhan = this.benhAnForm.value;
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
            this.benhAnService.editBenhAn(id, benhan).subscribe(() => {
              alert('Sửa thành công');
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
