/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "m_zone")
@NamedQueries({
    @NamedQuery(name = "MZone.findAll", query = "SELECT m FROM MZone m")})
public class MZone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_english")
    private String nameEnglish;
    @Column(name = "name_hindi")
    private String nameHindi;
    @Column(name = "zone_hq")
    private String zoneHq;
    
//    @OneToMany(mappedBy = "zoneId")    
//    private Collection<CaseRegistration> caseRegistrationCollection;
    
    @JsonIgnore
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne
    private State stateId;
    
    @JsonIgnore
    @JoinColumn(name = "zone_type_id", referencedColumnName = "id")
    @ManyToOne
    private MZoneType zoneTypeId;
    
//    @OneToMany(mappedBy = "zoneId")
//    private Collection<User> userCollection;
//    
//    @OneToMany(mappedBy = "zoneId")
//    private Collection<MCircle> mCircleCollection;

    public MZone() {
    }

    public MZone(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameHindi() {
        return nameHindi;
    }

    public void setNameHindi(String nameHindi) {
        this.nameHindi = nameHindi;
    }

    public String getZoneHq() {
        return zoneHq;
    }

    public void setZoneHq(String zoneHq) {
        this.zoneHq = zoneHq;
    }

//    public Collection<CaseRegistration> getCaseRegistrationCollection() {
//        return caseRegistrationCollection;
//    }
//
//    public void setCaseRegistrationCollection(Collection<CaseRegistration> caseRegistrationCollection) {
//        this.caseRegistrationCollection = caseRegistrationCollection;
//    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public MZoneType getZoneTypeId() {
        return zoneTypeId;
    }

    public void setZoneTypeId(MZoneType zoneTypeId) {
        this.zoneTypeId = zoneTypeId;
    }

//    public Collection<User> getUserCollection() {
//        return userCollection;
//    }
//
//    public void setUserCollection(Collection<User> userCollection) {
//        this.userCollection = userCollection;
//    }
//
//    public Collection<MCircle> getMCircleCollection() {
//        return mCircleCollection;
//    }
//
//    public void setMCircleCollection(Collection<MCircle> mCircleCollection) {
//        this.mCircleCollection = mCircleCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MZone)) {
            return false;
        }
        MZone other = (MZone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.MZone[ id=" + id + " ]";
    }
    
}
