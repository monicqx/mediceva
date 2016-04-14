/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.medicalweb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "PROFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiles.findAll", query = "SELECT p FROM Profiles p"),
    @NamedQuery(name = "Profiles.findByBirthDate", query = "SELECT p FROM Profiles p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Profiles.findByUserId", query = "SELECT p FROM Profiles p WHERE p.userId = :userId"),
    @NamedQuery(name = "Profiles.findBySex", query = "SELECT p FROM Profiles p WHERE p.sex = :sex"),
    @NamedQuery(name = "Profiles.findByWeight", query = "SELECT p FROM Profiles p WHERE p.weight = :weight"),
    @NamedQuery(name = "Profiles.findByHeight", query = "SELECT p FROM Profiles p WHERE p.height = :height"),
    @NamedQuery(name = "Profiles.findByDefaultReminderTime", query = "SELECT p FROM Profiles p WHERE p.defaultReminderTime = :defaultReminderTime"),
    @NamedQuery(name = "Profiles.findByDefaultBtests", query = "SELECT p FROM Profiles p WHERE p.defaultBtests = :defaultBtests")})
public class Profiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Short userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEX")
    private Character sex;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WEIGHT")
    private BigDecimal weight;
    @Column(name = "HEIGHT")
    private Short height;
    @Column(name = "DEFAULT_REMINDER_TIME")
    private Short defaultReminderTime;
    @Column(name = "DEFAULT_BTESTS")
    private Short defaultBtests;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Appointments> appointmentsCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<BloodTests> bloodTestsCollection;

    public Profiles() {
    }

    public Profiles(Short userId) {
        this.userId = userId;
    }

    public Profiles(Short userId, Character sex) {
        this.userId = userId;
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public Short getDefaultReminderTime() {
        return defaultReminderTime;
    }

    public void setDefaultReminderTime(Short defaultReminderTime) {
        this.defaultReminderTime = defaultReminderTime;
    }

    public Short getDefaultBtests() {
        return defaultBtests;
    }

    public void setDefaultBtests(Short defaultBtests) {
        this.defaultBtests = defaultBtests;
    }

    @XmlTransient
    public Collection<Appointments> getAppointmentsCollection() {
        return appointmentsCollection;
    }

    public void setAppointmentsCollection(Collection<Appointments> appointmentsCollection) {
        this.appointmentsCollection = appointmentsCollection;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<BloodTests> getBloodTestsCollection() {
        return bloodTestsCollection;
    }

    public void setBloodTestsCollection(Collection<BloodTests> bloodTestsCollection) {
        this.bloodTestsCollection = bloodTestsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profiles)) {
            return false;
        }
        Profiles other = (Profiles) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.medicalweb.Profiles[ userId=" + userId + " ]";
    }
    
}
