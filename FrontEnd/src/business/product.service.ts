import { Injectable } from '@angular/core';
import { ApiRestService } from 'src/service/api-rest.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: any = [];

  constructor(private apiRest: ApiRestService) { }

  GetProducts() {
    this.apiRest.RestGet("")
      .subscribe(data => {
        for (const d of (data as any)) {
          this.products.push({
            name: d.nameProduct,
            price: d.priceProduct
          });
        }
        console.log(this.apiRest);
      });
  }
}
