import { Component, OnInit } from '@angular/core';
import { ServiceRest } from './service/serviceRest';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit {
  constructor(private rest: ServiceRest) { }

  public ngOnInit(): void {
    this.rest.loadRestParams();
  }

}
