/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.medicalweb;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "APPOINTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointments.findAll", query = "SELECT a FROM Appointments a"),
    @NamedQuery(name = "Appointments.findByIdApp", query = "SELECT a FROM Appointments a WHERE a.idApp = :idApp"),
    @NamedQuery(name = "Appointments.findByIdType", query = "SELECT a FROM Appointments a WHERE a.idType = :idType"),
    @NamedQuery(name = "Appointments.findByDate", query = "SELECT a FROM Appointments a WHERE a.date = :date"),
    @NamedQuery(name = "Appointments.findByLocation", query = "SELECT a FROM Appointments a WHERE a.location = :location"),
    @NamedQuery(name = "Appointments.findByDoctor", query = "SELECT a FROM Appointments a WHERE a.doctor = :doctor"),
    @NamedQuery(name = "Appointments.findByPhone", query = "SELECT a FROM Appointments a WHERE a.phone = :phone"),
    @NamedQuery(name = "Appointments.findByFrequency", query = "SELECT a FROM Appointments a WHERE a.frequency = :frequency"),
    @NamedQuery(name = "Appointments.findByDescription", query = "SELECT a FROM Appointments a WHERE a.description = :description"),
    @NamedQuery(name = "Appointments.findByTimeReminder", query = "SELECT a FROM Appointments a WHERE a.timeReminder = :timeReminder")})
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APP")
    private Short idApp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TYPE")
    private short idType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 30)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 40)
    @Column(name = "DOCTOR")
    private String doctor;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 11)
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FREQUENCY")
    private Short frequency;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TIME_REMINDER")
    private Short timeReminder;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Profiles userId;
    @OneToMany(mappedBy = "idApp")
    private Collection<Reminders> remindersCollection;

    public Appointments() {
    }

    public Appointments(Short idApp) {
        this.idApp = idApp;
    }

    public Appointments(Short idApp, short idType, Date date) {
        this.idApp = idApp;
        this.idType = idType;
        this.date = date;
    }

    public Short getIdApp() {
        return idApp;
    }

    public void setIdApp(Short idApp) {
        this.idApp = idApp;
    }

    public short getIdType() {
        return idType;
    }

    public void setIdType(short idType) {
        this.idType = idType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getFrequency() {
        return frequency;
    }

    public void setFrequency(Short frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getTimeReminder() {
        return timeReminder;
    }

    public void setTimeReminder(Short timeReminder) {
        this.timeReminder = timeReminder;
    }

    public Profiles getUserId() {
        return userId;
    }

    public void setUserId(Profiles userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Reminders> getRemindersCollection() {
        return remindersCollection;
    }

    public void setRemindersCollection(Collection<Reminders> remindersCollection) {
        this.remindersCollection = remindersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApp != null ? idApp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointments)) {
            return false;
        }
        Appointments other = (Appointments) object;
        if ((this.idApp == null && other.idApp != null) || (this.idApp != null && !this.idApp.equals(other.idApp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.medicalweb.Appointments[ idApp=" + idApp + " ]";
    }
    
}
