import {Injectable} from '@angular/core';
import {Contract} from './Contract';


@Injectable({
  providedIn: 'root'
})
export class ContractService {
  contracts: Contract[] = [{
    id: 1,
    code: 'HD-001',
    customerId: {id: 1, name: 'Lam Linh'},
    dayStart: '2020-10-01',
    dayEnd: '2021-04-30',
    facilityId: {id: 2, name: 'House'},
    deposit: 2323231,
  }, {
    id: 2,
    code: 'HD-002',
    customerId: {id: 3, name: 'Chấn Hiệp'},
    dayStart: '2022-07-01',
    dayEnd: '2022-07-30',
    facilityId: {id: 1, name: 'Room'},
    deposit: 450000,
  }, {
    id: 3,
    code: 'HD-003',
    customerId: {id: 2, name: 'An Hòa'},
    dayStart: '2022-07-23',
    dayEnd: '2022-07-25',
    facilityId: {id: 1, name: 'Villa'},
    deposit: 900099,
  }];

  constructor() {
  }
  getAll() {
   return this.contracts;
  }
}
