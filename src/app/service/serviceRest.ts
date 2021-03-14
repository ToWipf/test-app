import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})

export class ServiceRest {

  private host = 'http://localhost:8080/';
  private username = 'admin';
  private password = 'jadmin';

  public gethost(): string {
    return this.host;
  }

  public sethost(host: string): void {
    this.host = host;
  }

  public getheader(): any {
    return { headers: new HttpHeaders().set('Authorization', 'Basic ' + btoa(this.username + ':' + this.password)) };
  }

}
