/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Etraining
 */
@Entity
@Table(name = "v_Purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPurchase.findAll", query = "SELECT v FROM VPurchase v")
    , @NamedQuery(name = "VPurchase.findByIdvPurchase", query = "SELECT v FROM VPurchase v WHERE v.idvPurchase = :idvPurchase")
    , @NamedQuery(name = "VPurchase.findByIdPurchase", query = "SELECT v FROM VPurchase v WHERE v.idPurchase = :idPurchase")
    , @NamedQuery(name = "VPurchase.findByDatePurchase", query = "SELECT v FROM VPurchase v WHERE v.datePurchase = :datePurchase")
    , @NamedQuery(name = "VPurchase.findByNameClient", query = "SELECT v FROM VPurchase v WHERE v.nameClient = :nameClient")
    , @NamedQuery(name = "VPurchase.findByIdentificationClient", query = "SELECT v FROM VPurchase v WHERE v.identificationClient = :identificationClient")
    , @NamedQuery(name = "VPurchase.findByNameProduct", query = "SELECT v FROM VPurchase v WHERE v.nameProduct = :nameProduct")
    , @NamedQuery(name = "VPurchase.findByPriceProduct", query = "SELECT v FROM VPurchase v WHERE v.priceProduct = :priceProduct")})
public class VPurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "id_v_Purchase")
    @Id
    private String idvPurchase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_purchase")
    private long idPurchase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_purchase")
    private String datePurchase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name_client")
    private String nameClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identification_client")
    private long identificationClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name_product")
    private String nameProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_product")
    private long priceProduct;

    public VPurchase() {
    }

    public String getIdvPurchase() {
        return idvPurchase;
    }

    public void setIdvPurchase(String idvPurchase) {
        this.idvPurchase = idvPurchase;
    }

    public long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public long getIdentificationClient() {
        return identificationClient;
    }

    public void setIdentificationClient(long identificationClient) {
        this.identificationClient = identificationClient;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        this.priceProduct = priceProduct;
    }
    
}
