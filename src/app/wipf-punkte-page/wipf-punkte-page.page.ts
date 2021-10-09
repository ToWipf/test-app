import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GluecksPunkte } from '../datatypes';
import { ServiceRest } from '../service/serviceRest';

@Component({
  selector: 'app-wipf-punkte-page',
  templateUrl: './wipf-punkte-page.page.html',
  styleUrls: ['./wipf-punkte-page.page.less'],
})
export class WipfPunktePagePage implements OnInit {

  constructor(private http: HttpClient, private rest: ServiceRest) { }

  public gluecksPunkte: GluecksPunkte;
  public sPunkte: number;

  ngOnInit() {
    this.http.get(this.rest.gethost() + 'wipfapp/getPunkte', this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        this.sPunkte = resdata.punkte.toString();
      },
    );
  }

  public play() {
    this.http.post(this.rest.gethost() + 'wipfapp/playPunkte', this.gluecksPunkte, this.rest.getHeaderAuth()).subscribe(
      (resdata: any) => {
        // neu laden
        this.ngOnInit();
      },
    );
  }

}
