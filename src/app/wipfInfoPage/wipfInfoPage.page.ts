import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ServiceRest } from '../service/serviceRest';

@Component({
  selector: 'app-wipf-info-page',
  templateUrl: 'wipfInfoPage.page.html',
  styleUrls: ['wipfInfoPage.page.less']
})
export class WipfInfoPage {

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public infotext;
  public bLoopStop = false;

  public ionViewWillLeave(): void {
    this.bLoopStop = true;
  }

  public ionViewWillEnter() {
    this.infotext = 'nicht verbunden';
    this.load();
    this.reloadLoop();
  }

  public load(): void {
    this.http.get(this.rest.gethost() + 'wipfapp/infotext', this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        this.infotext = resdata.data;
      },
    );
  }

  private reloadLoop(): void {
    if (!this.bLoopStop) {
      // get current button
      setTimeout(() => {
        this.reloadLoop();
      }, 5000);
      this.load();
    }
  }


}
