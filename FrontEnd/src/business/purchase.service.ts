import { Injectable } from '@angular/core';
import { Purchase } from 'src/model/purchase';
import { ApiRestService } from 'src/service/api-rest.service';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  public purchase: Purchase[] = [];

  constructor(private apiRest: ApiRestService) { }

  GetPurchase() {
    this.apiRest.getPurchase()
      .subscribe(resp => {
        for (const data of resp.body) {
          this.purchase.push(data);
        }
        this.purchase.sort((a, b) => (a.datePurchase > b.datePurchase) ? 1 : ((b.datePurchase > a.datePurchase) ? -1 : 0));
      });
  }
  ValidateDelete(filter) {
    var result = false;
    this.purchase.forEach(element => {
      if (element.idClient.idClient == filter.idClient || element.idProduct.idProduct == filter.idProduct) {
        result = true;
      }
    });
    return result;
  }
  DeletePurchase(idPurchase: string) {
    this.apiRest.deletePurchase(idPurchase);
    for (let index = 0; index < this.purchase.length; index++) {
      if (this.purchase[index].idPurchase == idPurchase)
        this.purchase.splice(index, 1);
    }
  }
  AddPurchase(purchase: Purchase) {
    this.purchase.push(purchase);
    this.apiRest.addPurchase(purchase);
  }
}
