import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/business/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'MilIngresoHitss';

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.GetProducts();
  }
}
