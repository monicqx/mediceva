package Classes;

/**
 * Created by Monica Stanescu on 16.04.2016.
 */
import java.io.Serializable;
import java.math.BigDecimal;
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
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "BLOOD_TESTS")
//@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "BloodTests.findAll", query = "SELECT b FROM BloodTests b"),
        @NamedQuery(name = "BloodTests.findByIdTest", query = "SELECT b FROM BloodTests b WHERE b.idTest = :idTest"),
        @NamedQuery(name = "BloodTests.findByName", query = "SELECT b FROM BloodTests b WHERE b.name = :name"),
        @NamedQuery(name = "BloodTests.findByValue", query = "SELECT b FROM BloodTests b WHERE b.value = :value"),
        @NamedQuery(name = "BloodTests.findByType", query = "SELECT b FROM BloodTests b WHERE b.type = :type"),
        @NamedQuery(name = "BloodTests.findByResult", query = "SELECT b FROM BloodTests b WHERE b.result = :result")})
public class BloodTests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TEST")
    private Short idTest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALUE")
    private BigDecimal value;
    @Column(name = "TYPE")
    private Short type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESULT")
    private short result;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Profiles userId;

    public BloodTests() {
    }

    public BloodTests(Short idTest) {
        this.idTest = idTest;
    }

    public BloodTests(Short idTest, String name, short result) {
        this.idTest = idTest;
        this.name = name;
        this.result = result;
    }

    public Short getIdTest() {
        return idTest;
    }

    public void setIdTest(Short idTest) {
        this.idTest = idTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    public Profiles getUserId() {
        return userId;
    }

    public void setUserId(Profiles userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTest != null ? idTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodTests)) {
            return false;
        }
        BloodTests other = (BloodTests) object;
        if ((this.idTest == null && other.idTest != null) || (this.idTest != null && !this.idTest.equals(other.idTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.medicalweb.BloodTests[ idTest=" + idTest + " ]";
    }

}
