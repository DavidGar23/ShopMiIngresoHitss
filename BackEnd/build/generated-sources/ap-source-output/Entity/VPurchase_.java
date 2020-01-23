package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-23T13:51:39")
@StaticMetamodel(VPurchase.class)
public class VPurchase_ { 

    public static volatile SingularAttribute<VPurchase, String> idvPurchase;
    public static volatile SingularAttribute<VPurchase, Long> identificationClient;
    public static volatile SingularAttribute<VPurchase, Long> idPurchase;
    public static volatile SingularAttribute<VPurchase, Long> priceProduct;
    public static volatile SingularAttribute<VPurchase, String> datePurchase;
    public static volatile SingularAttribute<VPurchase, String> nameClient;
    public static volatile SingularAttribute<VPurchase, String> nameProduct;

}