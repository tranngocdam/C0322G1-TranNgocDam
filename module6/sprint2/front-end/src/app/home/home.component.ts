import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../security/token-storage.service';
import {ShareService} from '../security/share.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: string;
  idPatient: number;
  currentUser: string;
  role: string;
  isLoggedIn = false;
  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  ngOnInit(): void {
    this.loadHeader();
  }
  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }

  logOut() {
    this.tokenStorageService.signOut();
  }
}
