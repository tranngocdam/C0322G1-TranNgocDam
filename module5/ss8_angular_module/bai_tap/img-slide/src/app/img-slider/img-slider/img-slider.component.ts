import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-img-slider',
  templateUrl: './img-slider.component.html',
  styleUrls: ['./img-slider.component.css']
})
export class ImgSliderComponent implements OnInit {

  @Output()
  eventCurrent = new EventEmitter();
  current = 0;

  constructor() {

  }

  ngOnInit(): void {
  }


  changeCurrent(number: number) {
    this.current += Number(number);
    if (this.current < 0) {
      this.current = 0;
    }
    if (this.current > 3) {
      this.current = 3;
    }
    this.eventCurrent.emit(this.current);
  }



}
