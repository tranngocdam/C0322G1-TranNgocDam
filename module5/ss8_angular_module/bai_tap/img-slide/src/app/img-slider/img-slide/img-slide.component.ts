import {Component, OnChanges, OnInit} from '@angular/core';

@Component({
  selector: 'app-img-slide',
  templateUrl: './img-slide.component.html',
  styleUrls: ['./img-slide.component.css']
})
export class ImgSlideComponent implements OnInit, OnChanges {
  listImage = [
    'https://icdn.dantri.com.vn/thumb_w/640/2020/08/30/diem-danh-nhung-guong-mat-hot-girl-noi-bat-trong-thang-8-docx-1598788426579.jpeg',
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7nt2U35rf9VRZfOSMuoevV7LlWRSSxotVS-vaPS1y00VriKmJj6yeudL86JBLRlEoq1E&usqp=CAU',
    'https://thuthuatnhanh.com/wp-content/uploads/2019/07/anh-girl-xinh-facebook-tuyet-dep-387x580.jpg',
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRviVxCFTAfhYtAAJosXoVtTLIZuLVb2rVBfyufX4SY7QQUjyqtGVnZaw9Z6tnbA6JZOJU&usqp=CAU'
  ];
  currentPage = 0;

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(): void {
  }

  getCurrentValue(event: any): void {
    console.log(event);
    this.currentPage = Number(event);
  }

}
