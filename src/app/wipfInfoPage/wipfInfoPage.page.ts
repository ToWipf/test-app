import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ServiceRest } from '../service/serviceRest';

@Component({
  selector: 'app-wipf-info-page',
  templateUrl: 'wipfInfoPage.page.html',
  styleUrls: ['wipfInfoPage.page.less']
})
export class WipfInfoPage implements OnInit {

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public infotext;

  public ngOnInit() {
    this.infotext = 'nicht verbunden';
    this.load();
  }

  public load(): void {
    this.http.get(this.rest.gethost() + 'wipfapp/infotext', this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        this.infotext = resdata.data;
      },
    );
  }

}
