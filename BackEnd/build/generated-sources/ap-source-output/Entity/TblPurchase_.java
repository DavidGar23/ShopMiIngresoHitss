package Entity;

import Entity.TblClient;
import Entity.TblProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-23T13:51:39")
@StaticMetamodel(TblPurchase.class)
public class TblPurchase_ { 

    public static volatile SingularAttribute<TblPurchase, Long> idPurchase;
    public static volatile SingularAttribute<TblPurchase, TblClient> idClient;
    public static volatile SingularAttribute<TblPurchase, String> datePurchase;
    public static volatile SingularAttribute<TblPurchase, TblProduct> idProduct;

}