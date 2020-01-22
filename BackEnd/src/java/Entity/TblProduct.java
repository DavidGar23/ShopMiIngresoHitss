/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Etraining
 */
@Entity
@Table(name = "tbl_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t")
    , @NamedQuery(name = "TblProduct.findByIdProduct", query = "SELECT t FROM TblProduct t WHERE t.idProduct = :idProduct")
    , @NamedQuery(name = "TblProduct.findByNameProduct", query = "SELECT t FROM TblProduct t WHERE t.nameProduct = :nameProduct")
    , @NamedQuery(name = "TblProduct.findByPriceProduct", query = "SELECT t FROM TblProduct t WHERE t.priceProduct = :priceProduct")})
public class TblProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private Long idProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name_product")
    private String nameProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_product")
    private long priceProduct;
    @OneToMany(mappedBy = "idProduct")
    private Collection<TblPurchase> tblPurchaseCollection;

    public TblProduct() {
    }

    public TblProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public TblProduct(Long idProduct, String nameProduct, long priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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

    @XmlTransient
    public Collection<TblPurchase> getTblPurchaseCollection() {
        return tblPurchaseCollection;
    }

    public void setTblPurchaseCollection(Collection<TblPurchase> tblPurchaseCollection) {
        this.tblPurchaseCollection = tblPurchaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblProduct[ idProduct=" + idProduct + " ]";
    }
    
}
