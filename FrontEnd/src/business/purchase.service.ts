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
}
