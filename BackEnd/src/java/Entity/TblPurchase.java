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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPurchase.findAll", query = "SELECT t FROM TblPurchase t")
    , @NamedQuery(name = "TblPurchase.findByIdPurchase", query = "SELECT t FROM TblPurchase t WHERE t.idPurchase = :idPurchase")
    , @NamedQuery(name = "TblPurchase.findByDatePurchase", query = "SELECT t FROM TblPurchase t WHERE t.datePurchase = :datePurchase")})
public class TblPurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_purchase")
    private Long idPurchase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_purchase")
    private String datePurchase;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private TblClient idClient;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne
    private TblProduct idProduct;

    public TblPurchase() {
    }

    public TblPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public TblPurchase(Long idPurchase, String datePurchase) {
        this.idPurchase = idPurchase;
        this.datePurchase = datePurchase;
    }

    public Long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public TblClient getIdClient() {
        return idClient;
    }

    public void setIdClient(TblClient idClient) {
        this.idClient = idClient;
    }

    public TblProduct getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(TblProduct idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPurchase != null ? idPurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPurchase)) {
            return false;
        }
        TblPurchase other = (TblPurchase) object;
        if ((this.idPurchase == null && other.idPurchase != null) || (this.idPurchase != null && !this.idPurchase.equals(other.idPurchase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblPurchase[ idPurchase=" + idPurchase + " ]";
    }
    
}
