import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/business/product.service';
import { ClientService } from 'src/business/client.service';
import { PurchaseService } from 'src/business/purchase.service';
import { ToastrService } from 'ngx-toastr';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Product } from 'src/model/product';
import { ClientM } from 'src/model/clientM';
import { Purchase } from 'src/model/purchase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  productSelect: Product;
  clientSelect: ClientM;
  purchaseList: Purchase[] = [];

  constructor(private productService: ProductService, private clientService: ClientService, private purchaseService: PurchaseService, private toastr: ToastrService, private modalService: NgbModal) { }

  ngOnInit() {
    this.productService.GetProducts();
    this.clientService.GetClients();
    this.purchaseService.GetPurchase();
  }

  DeleteProduct(idProduct) {
    if (this.purchaseService.ValidateDelete({ idProduct: idProduct, idClient: 0 })) {
      this.toastr.error("", 'El producto está en una compra');
    } else {
      this.productService.DeleteProduct(idProduct);
      this.toastr.success("Código: " + idProduct, 'Producto eliminado');
    }
  }

  AddProduct(content, product) {
    this.productSelect = product ? product : { idProduct: "", nameProduct: "", priceProduct: "" };
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
  }

  SaveProduct(product) {
    var productSend: Product = { idProduct: this.productSelect.idProduct, nameProduct: product.nameProduct, priceProduct: product.priceProduct };
    if (productSend.idProduct.length == 0) {
      productSend.idProduct = this.productService.products.length == 0 ? 1 : Math.max.apply(Math, this.productService.products.map(function (o) { return o.idProduct; })) + 1;
      this.productService.AddProduct(productSend);
      this.toastr.success("Código: " + productSend.idProduct, 'Producto almacenado');
    } else {
      this.productService.UpdateProduct(productSend);
      this.toastr.success("Código: " + productSend.idProduct, 'Producto actualizado');
    }
    this.modalService.dismissAll();
  }

  DeleteClient(idClient) {
    if (this.purchaseService.ValidateDelete({ idProduct: 0, idClient: idClient })) {
      this.toastr.error("", 'El cliente está en una compra');
    } else {
      this.clientService.DeleteClient(idClient);
      this.toastr.success("Código: " + idClient, 'Cliente eliminado');
    }
  }

  AddClient(content, client) {
    this.clientSelect = client ? client : { idClient: "", nameClient: "", identificationClient: "" };
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
  }

  SaveClient(client) {
    var clientSend: ClientM = { idClient: this.clientSelect.idClient, nameClient: client.nameClient, identificationClient: client.identificationClient };
    if (clientSend.idClient.length == 0) {
      clientSend.idClient = this.clientService.clients.length == 0 ? 1 : Math.max.apply(Math, this.clientService.clients.map(function (o) { return o.idClient; })) + 1;
      this.clientService.AddClient(clientSend);
      this.toastr.success("Código: " + clientSend.idClient, 'Cliente almacenado');
    } else {
      this.clientService.UpdateClient(clientSend);
      this.toastr.success("Código: " + clientSend.idClient, 'Cliente actualizado');
    }
    this.modalService.dismissAll();
  }

  AddPurchase(content, car) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title', size: 'xl' });
  }

  AddPurchaseCart(purchase) {
    if (purchase.idClient.length == "0" || purchase.idProduct.length == "0") {
      this.toastr.error("Revise la información");
    } else {
      let today = new Date().toLocaleDateString();
      var id = this.purchaseService.purchase.length == 0 ? 1 : Math.max.apply(Math, this.purchaseService.purchase.map(function (o) { return o.idPurchase; })) + 1;
      id += this.purchaseList.length == 0 ? 1 : Math.max.apply(Math, this.purchaseList.map(function (o) { return o.idPurchase; }));
      var client: ClientM = this.clientService.clients.find(x => x.idClient == purchase.idClient);
      var product: Product = this.productService.products.find(x => x.idProduct == purchase.idProduct);
      var purchase: any = { datePurchase: today, idPurchase: id, idClient: client, idProduct: product };
      this.purchaseList.push(purchase);
    }
  }
  DeletePurchaseCart(idPurchase) {
    for (let index = 0; index < this.purchaseList.length; index++) {
      if (this.purchaseList[index].idPurchase == idPurchase)
        this.purchaseList.splice(index, 1);
    }
  }

  SaveAll() {
    this.purchaseList.forEach(element => {
      var id = this.purchaseService.purchase.length == 0 ? 1 : Math.max.apply(Math, this.purchaseService.purchase.map(function (o) { return o.idPurchase; })) + 1;
      var purchase: Purchase = { datePurchase: element.datePurchase, idPurchase: id, idProduct: element.idProduct, idClient: element.idClient };
      this.purchaseService.AddPurchase(purchase);
    });
    this.purchaseList = [];
    this.modalService.dismissAll();
    this.toastr.success("Datos Registrados");
  }
  DeletePurchase(idPurchase) {
    this.purchaseService.DeletePurchase(idPurchase);
    this.toastr.success("Código: " + idPurchase, 'Compra eliminada');
  }


}
