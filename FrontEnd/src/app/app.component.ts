import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/business/product.service';
import { ClientService } from 'src/business/client.service';
import { PurchaseService } from 'src/business/purchase.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'MilIngresoHitss';
  theme = { themeId: "staticBackdrop" };

  constructor(private productService: ProductService, private clientService: ClientService, private purchaseService: PurchaseService, private toastr: ToastrService) { }

  ngOnInit() {
    this.productService.GetProducts();
    this.clientService.GetClients();
    this.purchaseService.GetPurchase();
  }
  DeleteProduct(idProduct) {
    this.productService.DeleteProduct(idProduct);
    this.toastr.success("Código: " + idProduct, 'Producto eliminado');
  }

}
