import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentType} from '../RentType';
import {FacilityType} from '../FacilityType';
import {FacilityService} from '../facility.service';
import {RentTypeService} from '../rent-type.service';
import {FacilityTypeService} from '../facility-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {CustomerType} from '../../customers/customerType';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  rentTypes: RentType[] = [];
  facilityTypes: FacilityType[] = [];
  id: number;
  facilityForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    area: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
    cost: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
    maxPeople: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{1,}$')]),
    rentType: new FormControl('', [Validators.required]),
    facilityType: new FormControl('', [Validators.required]),
    standardRoom: new FormControl('', [Validators.required]),
    descriptionOtherConvenience: new FormControl('', [Validators.required]),
    poolArea: new FormControl('', [Validators.required]),
    numberOfFloods: new FormControl('', [Validators.required]),
    facilityFree: new FormControl('', [Validators.required]),
    img: new FormControl('', [Validators.required])
  });

  constructor(private facilityService: FacilityService,
              private rentTypeService: RentTypeService,
              private facilityTypeService: FacilityTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private toastr: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) =>{
      this.id = +paramMap.get('id');
      this.getFacility(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllFacilityType();
    this.getAllRentType();
  }

  submit(id: number) {
    const facility = this.facilityForm.value;
    this.rentTypeService.findById(facility.rentType).subscribe(rentType => {
        this.facilityTypeService.findById(facility.facilityType).subscribe(facilityType => {
            facility.rentType = {
              id: rentType.id,
              name: rentType.name
            };
            facility.facilityType = {
              id: facilityType.id,
              name: facilityType.name
            };

            this.facilityService.editFacility(id, facility).subscribe(() => {
              alert('Thành công');
              this.facilityForm.reset();
              this.router.navigateByUrl('facilitys/facility-list');
            }, e => console.log(e));
          }
        );

      }
    );

  }

  compareRentType(r1: RentType, r2: RentType) {
    if ((r1 && r2) !== undefined) {
      return r1.id === r2.id;
    }
  }

  compareFacilityType(f1: FacilityType, f2: FacilityType) {
    if ((f1 && f2) !== undefined) {
      return f1.id === f2.id;
    }
  }

  getFacility(id: number) {
    return this.facilityService.findById(id).subscribe(facility => {
      this.facilityForm = new FormGroup({
        name: new FormControl(facility.name, [Validators.required]),
        area: new FormControl(facility.area, [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
        cost: new FormControl(facility.cost, [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
        maxPeople: new FormControl(facility.maxPeople, [Validators.required, Validators.pattern('^[0-9]{1,}$')]),
        rentType: new FormControl(facility.rentType.id, [Validators.required]),
        facilityType: new FormControl(facility.facilityType.id, [Validators.required]),
        standardRoom: new FormControl(facility.standardRoom, [Validators.required]),
        descriptionOtherConvenience: new FormControl(facility.descriptionOtherConvenience, [Validators.required]),
        poolArea: new FormControl(facility.poolArea, [Validators.required]),
        numberOfFloods: new FormControl(facility.numberOfFloods, [Validators.required]),
        facilityFree: new FormControl(facility.facilityFree, [Validators.required]),
        img: new FormControl(facility.img, [Validators.required])
      });
    });
  }

  getAllRentType() {
    this.rentTypeService.getAll().subscribe(rentTypes => {
      this.rentTypes = rentTypes;
    });
  }

  getAllFacilityType() {
    this.facilityTypeService.getAll().subscribe(facilitytypes => {
      this.facilityTypes = facilitytypes;
    });
  }
}
