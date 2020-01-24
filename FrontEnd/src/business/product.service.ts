import { Injectable } from '@angular/core';
import { ApiRestService } from 'src/service/api-rest.service';
import { Product } from 'src/model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public products: Product[] = [];

  constructor(private apiRest: ApiRestService) { }

  GetProducts() {
    this.products = [];
    this.apiRest.getProducts()
      .subscribe(resp => {
        for (const data of resp.body) {
          this.products.push(data);
        }
      });
  }
  DeleteProduct(idProduct: string) {
    this.apiRest.deleteProduct(idProduct);
    for (let index = 0; index < this.products.length; index++) {
      if (this.products[index].idProduct == idProduct)
        this.products.splice(index, 1);
    }
  }
  UpdateProduct(product: Product) {
    this.apiRest.updateProduct(product);
    for (let index = 0; index < this.products.length; index++) {
      if (this.products[index].idProduct == product.idProduct)
        this.products[index] = product;
    }
  }
  AddProduct(product: Product) {
    this.apiRest.addProduct(product);
    this.products.push(product);
  }

}
