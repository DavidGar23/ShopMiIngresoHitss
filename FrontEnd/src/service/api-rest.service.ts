import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Product } from 'src/model/product';
import { ClientM } from 'src/model/clientM';
import { Purchase } from 'src/model/purchase';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

const apiUrl = 'http://localhost:8080/BackEnd/webresources/entity.';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    // 'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})

export class ApiRestService {

  public modal: any;
  constructor(private http: HttpClient) { }

  getProducts(): Observable<HttpResponse<Product[]>> {
    return this.http.get<Product[]>(
      apiUrl + "tblproduct", { observe: 'response' });
  }

  addProduct(product: Product): Promise<Product> {
    return this.http
      .post(apiUrl + "tblproduct", product)
      .toPromise()
      .then(x => {
        return Promise.resolve(<Product>x);
      })
      .catch(x => {
        throw x;
      });
  }

  deleteProduct(idProduct: string): Promise<Product> {
    return this.http
      .delete(apiUrl + "tblproduct/" + idProduct)
      .toPromise()
      .then(x => {
        return Promise.resolve(<Product>x);
      })
      .catch(x => {
        throw x;
      });
  }

  getClients(): Observable<HttpResponse<ClientM[]>> {
    return this.http.get<ClientM[]>(
      apiUrl + "tblclient", { observe: 'response' });
  }

  getPurchase(): Observable<HttpResponse<Purchase[]>> {
    return this.http.get<Purchase[]>(
      apiUrl + "tblpurchase", { observe: 'response' });
  }

}
