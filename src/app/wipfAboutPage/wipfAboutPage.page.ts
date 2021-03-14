import { Component, OnInit } from '@angular/core';
import { ServiceRest } from '../service/serviceRest';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-wipf-about-page',
  templateUrl: 'wipfAboutPage.page.html',
  styleUrls: ['wipfAboutPage.page.scss']
})
export class WipfAboutPage implements OnInit {

  public sVersion = 'loading';

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public ngOnInit() {
    this.getVersion();
  }

  private getVersion(): void {
    this.rest.loadRestParams();

    this.http.get(this.rest.gethost() + 'wipf/ver', this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        this.sVersion = resdata.ver.toString();
      },
    );
  }

}
