import {MaBenhNhan} from './ma-benh-nhan';
import {MaBenhAn} from './ma-benh-an';

export interface BenhAn {
  id ?: number;
  maBenhAn?: MaBenhAn;
  maBenhNhan?: MaBenhNhan;
  tenBenhNhan ?: string;
  ngayNhapVien?: string;
  ngayRaVien?: string;
  liDo?: string;
  phuongPhap?: string;
  bacSi?: string;
}
