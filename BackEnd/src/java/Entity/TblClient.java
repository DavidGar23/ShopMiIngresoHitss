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
@Table(name = "tbl_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblClient.findAll", query = "SELECT t FROM TblClient t")
    , @NamedQuery(name = "TblClient.findByIdClient", query = "SELECT t FROM TblClient t WHERE t.idClient = :idClient")
    , @NamedQuery(name = "TblClient.findByNameClient", query = "SELECT t FROM TblClient t WHERE t.nameClient = :nameClient")
    , @NamedQuery(name = "TblClient.findByIdentificationClient", query = "SELECT t FROM TblClient t WHERE t.identificationClient = :identificationClient")})
public class TblClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private Long idClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name_client")
    private String nameClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identification_client")
    private long identificationClient;
    @OneToMany(mappedBy = "idClient")
    private Collection<TblPurchase> tblPurchaseCollection;

    public TblClient() {
    }

    public TblClient(Long idClient) {
        this.idClient = idClient;
    }

    public TblClient(Long idClient, String nameClient, long identificationClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.identificationClient = identificationClient;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblClient)) {
            return false;
        }
        TblClient other = (TblClient) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblClient[ idClient=" + idClient + " ]";
    }
    
}
