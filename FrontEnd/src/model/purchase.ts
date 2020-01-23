import { ClientM } from './clientM';
import { Product } from './product';

export interface Purchase {
    datePurchase: string;
    idPurchase: string;
    idClient: ClientM;
    idProduct: Product;
}