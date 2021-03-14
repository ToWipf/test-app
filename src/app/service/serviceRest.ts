import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { ServerAuth } from '../datatypes';

@Injectable({
  providedIn: 'root',
})

export class ServiceRest {
  constructor(private storage: Storage) { }

  private sAuth: ServerAuth = {};

  public setAuth(i: ServerAuth): void {
    this.storage.set('host', i.host);
    this.storage.set('username', i.username);
    this.storage.set('password', i.password);
    setTimeout(() => {
      this.loadRestParams();
    }, 200);
  }

  public loadRestParams(): void {
    this.storage.get('host').then((val) => {
      this.sAuth.host = val;
    }).catch((e) => this.sAuth.host = 'http://192.168.2.11/');
    this.storage.get('username').then((val) => {
      this.sAuth.username = val;
    }).catch((e) => this.sAuth.username = '-');
    this.storage.get('password').then((val) => {
      this.sAuth.password = val;
    }).catch((e) => this.sAuth.password = '-');
  }

  public getAuth(): ServerAuth {
    return this.sAuth;
  }

  public gethost(): string {
    return this.sAuth.host;
  }

  public getHeaderAuth(): any {
    return { headers: new HttpHeaders().set('Authorization', 'Basic ' + btoa(this.sAuth.username + ':' + this.sAuth.password)) };
  }

}
