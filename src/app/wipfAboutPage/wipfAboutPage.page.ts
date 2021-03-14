import { Component, OnInit } from '@angular/core';
import { ServiceRest } from '../service/serviceRest';
import { HttpClient } from '@angular/common/http';
import { ServerAuth } from '../datatypes';

@Component({
  selector: 'app-wipf-about-page',
  templateUrl: 'wipfAboutPage.page.html',
  styleUrls: ['wipfAboutPage.page.less']
})
export class WipfAboutPage implements OnInit {

  public sVersion = 'laden';
  public sAuth: ServerAuth;

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public ngOnInit() {
    this.getAuth();
    this.getVersion();
  }

  public getAuth(): void {
    this.sAuth = this.rest.getAuth();
  }

  public saveAndTest(): void {
    this.rest.setAuth(this.sAuth);
    setTimeout(() => {
      this.getAuth();
      this.getVersion();
    }, 500);
  }

  private getVersion(): void {
    this.sVersion = 'nicht verbunden';
    this.http.get(this.rest.gethost() + 'wipf/ver', this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        this.sVersion = resdata.ver.toString();
      },
    );
  }

}
