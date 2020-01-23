import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const apiUrl = 'http://localhost:8080/BackEnd/webresources/entity.tblproduct';

@Injectable({
  providedIn: 'root'
})

export class ApiRestService {


  constructor() { }

  RestGet(entity) {
    console.log(apiUrl);
    // return this.http.get(apiUrl);
    return null;
  }
}
