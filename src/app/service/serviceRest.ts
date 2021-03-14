import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';

@Injectable({
  providedIn: 'root',
})

export class ServiceRest {
  constructor(private storage: Storage) { }

  private host;
  private username;
  private password;

  public setHost(host): void {
    this.storage.set('host', host);
  }

  public setAuth(username, password): void {
    this.storage.set('username', username);
    this.storage.set('password', password);
  }

  public loadRestParams(): void {
    this.storage.get('host').then((val) => {
      this.host = val;
    });
    this.storage.get('username').then((val) => {
      this.username = val;
    });
    this.storage.get('password').then((val) => {
      this.password = val;
    });
  }

  public gethost(): string {
    return this.host;
  }

  public getHeaderAuth(): any {
    return { headers: new HttpHeaders().set('Authorization', 'Basic ' + btoa(this.username + ':' + this.password)) };
  }

}
