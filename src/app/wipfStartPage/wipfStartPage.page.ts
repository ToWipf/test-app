import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ServiceRest } from '../service/serviceRest';

@Component({
  selector: 'app-wipf-start-page',
  templateUrl: 'wipfStartPage.page.html',
  styleUrls: ['wipfStartPage.page.less']
})
export class WipfStartPage {

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public infotext;
  public bLoopStop = false;

  public ionViewDidLeave(): void {
    this.bLoopStop = true;
  }

  public ionViewDidEnter() {
    this.infotext = 'nicht verbunden';
    this.load();
    this.reloadLoop();
  }

  public load(): void {
    this.http.get(this.rest.gethost() + 'wipfapp/starttext', this.rest.getHeaderAuth()).subscribe(
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
