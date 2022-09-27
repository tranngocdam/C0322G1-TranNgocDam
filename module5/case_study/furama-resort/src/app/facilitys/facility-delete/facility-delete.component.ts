import { Component, OnInit } from '@angular/core';
import {FacilityService} from '../facility.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-facility-delete',
  templateUrl: './facility-delete.component.html',
  styleUrls: ['./facility-delete.component.css']
})
export class FacilityDeleteComponent implements OnInit {

  constructor(private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    // const id = Number(this.activatedRoute.snapshot.params.id);
    // this.facilityService.deleteFacility(id);
    // this.router.navigateByUrl('facilitys/facility-list');
  }

}
