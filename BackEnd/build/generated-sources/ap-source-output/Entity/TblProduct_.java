package Entity;

import Entity.TblPurchase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-23T13:51:39")
@StaticMetamodel(TblProduct.class)
public class TblProduct_ { 

    public static volatile SingularAttribute<TblProduct, Long> priceProduct;
    public static volatile CollectionAttribute<TblProduct, TblPurchase> tblPurchaseCollection;
    public static volatile SingularAttribute<TblProduct, Long> idProduct;
    public static volatile SingularAttribute<TblProduct, String> nameProduct;

}