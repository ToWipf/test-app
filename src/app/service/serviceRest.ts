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
    var headers_object = new HttpHeaders();
    headers_object.append('Content-Type', 'application/json');
    headers_object.append('Authorization', 'Basic ' + btoa(this.username + ':' + this.password));

    const httpOptions = {
      headers: headers_object
    };
    return httpOptions;
  }

}
