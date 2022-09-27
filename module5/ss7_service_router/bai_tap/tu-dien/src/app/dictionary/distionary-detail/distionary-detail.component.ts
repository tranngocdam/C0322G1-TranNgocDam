import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DictionaryService} from '../service/distionary-service';

@Component({
  selector: 'app-distionary-detail',
  templateUrl: './distionary-detail.component.html',
  styleUrls: ['./distionary-detail.component.css']
})
export class DistionaryDetailComponent implements OnInit {
  result: any;

  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute) {}


  ngOnInit(): void {
    const keyword = this.activatedRoute.snapshot.params.word;
    this.result = this.dictionaryService.findByWord(keyword);
    console.log(keyword);
  }

}
