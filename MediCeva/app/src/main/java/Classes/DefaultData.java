package Classes;

/**
 * Created by Monica Stanescu on 16.04.2016.
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "DEFAULT_DATA")
//@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DefaultData.findAll", query = "SELECT d FROM DefaultData d"),
        @NamedQuery(name = "DefaultData.findByIdIde", query = "SELECT d FROM DefaultData d WHERE d.idIde = :idIde"),
        @NamedQuery(name = "DefaultData.findByValue", query = "SELECT d FROM DefaultData d WHERE d.value = :value")})
public class DefaultData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_IDE")
    private Short idIde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private short value;

    public DefaultData() {
    }

    public DefaultData(Short idIde) {
        this.idIde = idIde;
    }

    public DefaultData(Short idIde, short value) {
        this.idIde = idIde;
        this.value = value;
    }

    public Short getIdIde() {
        return idIde;
    }

    public void setIdIde(Short idIde) {
        this.idIde = idIde;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIde != null ? idIde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DefaultData)) {
            return false;
        }
        DefaultData other = (DefaultData) object;
        if ((this.idIde == null && other.idIde != null) || (this.idIde != null && !this.idIde.equals(other.idIde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.medicalweb.DefaultData[ idIde=" + idIde + " ]";
    }

}
