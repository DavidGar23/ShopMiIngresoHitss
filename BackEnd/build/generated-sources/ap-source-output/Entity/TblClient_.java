package Entity;

import Entity.TblPurchase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-23T13:51:39")
@StaticMetamodel(TblClient.class)
public class TblClient_ { 

    public static volatile SingularAttribute<TblClient, Long> identificationClient;
    public static volatile SingularAttribute<TblClient, Long> idClient;
    public static volatile CollectionAttribute<TblClient, TblPurchase> tblPurchaseCollection;
    public static volatile SingularAttribute<TblClient, String> nameClient;

}