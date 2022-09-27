import {IWord} from '../iword';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaryList: IWord[] = [
    {
      word: 'hello',
      mean: 'xin chào'
    },
    {
      word: 'bye',
      mean: 'tạm biệt'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.dictionaryList;
  }

  findByWord(word: string) {
    return this.dictionaryList.find(dic => dic.word === word);
  }
}



