import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../security/token-storage.service';
import {ShareService} from '../security/share.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  username: string;
  idPatient: number;
  currentUser: string;
  role: string;
  isLoggedIn = false;
  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadEditAdd();
    });
  }

  ngOnInit(): void {
    this.loadEditAdd();
  }
  loadEditAdd(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }
}
