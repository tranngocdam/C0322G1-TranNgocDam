import {Component, OnInit} from '@angular/core';
import {MaBenhNhan} from '../../model/ma-benh-nhan';
import {MaBenhAn} from '../../model/ma-benh-an';
import {BenhAnService} from '../../service/benh-an.service';
import {MaBenhAnService} from '../../service/ma-benh-an.service';
import {MaBenhNhanService} from '../../service/ma-benh-nhan.service';
import {BenhAn} from '../../model/benh-an';

@Component({
  selector: 'app-benhan-list',
  templateUrl: './benhan-list.component.html',
  styleUrls: ['./benhan-list.component.css']
})
export class BenhanListComponent implements OnInit {
  maBenhNhans: MaBenhNhan[] = [];
  maBenhAns: MaBenhAn [] = [];
  benhAn: BenhAn[] = [];
  liDo1 = '';
  p = 1;
  constructor(private benhAnService: BenhAnService,
              private maBenhAnService: MaBenhAnService,
              private maBenhNhanService: MaBenhNhanService) {
  }

  idModal: number;
  nameModal: string;

  ngOnInit(): void {
    this.getAll(0);
  }

  getAll(page: number) {
    this.benhAnService.getAll(page).subscribe(benhAn => {
      this.benhAn = benhAn;
    });
    this.maBenhAnService.getAll().subscribe(maBenhAn => {
      this.maBenhAns = maBenhAn;
    });
    this.maBenhNhanService.getAll().subscribe(maBenhNhan => {
      this.maBenhNhans = maBenhNhan;
    });
  }

  deleteCustomer(id: number) {
    this.benhAnService.deleteCustomer(id).subscribe(() => {
      this.getAll(0);
    }, e => {
      console.log(e);
    });
  }

  getDataForModal(c: BenhAn) {
    this.idModal = c.id;
    this.nameModal = c.maBenhAn.name;
  }

  searchliDoBenhAn() {
    return this.benhAnService.searchBenhAn(this.liDo1).subscribe(listSearch => {
      this.benhAn = listSearch;
    });
  }
}
