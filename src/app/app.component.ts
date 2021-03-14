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
    this.rest.setHost('http://192.168.2.11:8080/');
    this.rest.setAuth('admin', 'jadmin');

    setTimeout(() => {
      this.rest.loadRestParams();
    }, 500);

  }

}
