import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../service/distionary-service';
import {IWord} from '../iword';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionaryList: IWord[];
  result: any;
  constructor(private dictionaryService: DictionaryService) { }


  ngOnInit(): void {
    this.dictionaryList = this.dictionaryService.getAll();
  }

}
