package Classes;

/**
 * Created by Monica Stanescu on 16.04.2016.
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "REMINDERS")
//@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Reminders.findAll", query = "SELECT r FROM Reminders r"),
        @NamedQuery(name = "Reminders.findByIdReminder", query = "SELECT r FROM Reminders r WHERE r.idReminder = :idReminder"),
        @NamedQuery(name = "Reminders.findByDateReminder", query = "SELECT r FROM Reminders r WHERE r.dateReminder = :dateReminder"),
        @NamedQuery(name = "Reminders.findByTitle", query = "SELECT r FROM Reminders r WHERE r.title = :title"),
        @NamedQuery(name = "Reminders.findByDescription", query = "SELECT r FROM Reminders r WHERE r.description = :description")})
public class Reminders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REMINDER")
    private Short idReminder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_REMINDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReminder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ID_APP", referencedColumnName = "ID_APP")
    @ManyToOne
    private Appointments idApp;

    public Reminders() {
    }

    public Reminders(Short idReminder) {
        this.idReminder = idReminder;
    }

    public Reminders(Short idReminder, Date dateReminder, String title) {
        this.idReminder = idReminder;
        this.dateReminder = dateReminder;
        this.title = title;
    }

    public Short getIdReminder() {
        return idReminder;
    }

    public void setIdReminder(Short idReminder) {
        this.idReminder = idReminder;
    }

    public Date getDateReminder() {
        return dateReminder;
    }

    public void setDateReminder(Date dateReminder) {
        this.dateReminder = dateReminder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appointments getIdApp() {
        return idApp;
    }

    public void setIdApp(Appointments idApp) {
        this.idApp = idApp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReminder != null ? idReminder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reminders)) {
            return false;
        }
        Reminders other = (Reminders) object;
        if ((this.idReminder == null && other.idReminder != null) || (this.idReminder != null && !this.idReminder.equals(other.idReminder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.medicalweb.Reminders[ idReminder=" + idReminder + " ]";
    }

}
