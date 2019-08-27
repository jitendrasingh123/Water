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

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "m_circle")
@NamedQueries({
    @NamedQuery(name = "MCircle.findAll", query = "SELECT m FROM MCircle m")})
public class MCircle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "circle_code")
    private Integer circleCode;
    @Column(name = "name_english")
    private String nameEnglish;
    @Column(name = "name_hindi")
    private String nameHindi;
    @Column(name = "circle_hq")
    private String circleHq;
    
//    @OneToMany(mappedBy = "circleId")
//    private Collection<MDivision> mDivisionCollection;
//    
//    @OneToMany(mappedBy = "circleId")
//    private Collection<User> userCollection;
    
    @JoinColumn(name = "circle_type_id", referencedColumnName = "id")
    @ManyToOne
    private MCircleType circleTypeId;
    
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne
    private State stateId;
    
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    @ManyToOne
    private MZone zoneId;

    public MCircle() {
    }

    public MCircle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCircleCode() {
        return circleCode;
    }

    public void setCircleCode(Integer circleCode) {
        this.circleCode = circleCode;
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

    public String getCircleHq() {
        return circleHq;
    }

    public void setCircleHq(String circleHq) {
        this.circleHq = circleHq;
    }

//    public Collection<MDivision> getMDivisionCollection() {
//        return mDivisionCollection;
//    }
//
//    public void setMDivisionCollection(Collection<MDivision> mDivisionCollection) {
//        this.mDivisionCollection = mDivisionCollection;
//    }
//
//    public Collection<User> getUserCollection() {
//        return userCollection;
//    }
//
//    public void setUserCollection(Collection<User> userCollection) {
//        this.userCollection = userCollection;
//    }

    public MCircleType getCircleTypeId() {
        return circleTypeId;
    }

    public void setCircleTypeId(MCircleType circleTypeId) {
        this.circleTypeId = circleTypeId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public MZone getZoneId() {
        return zoneId;
    }

    public void setZoneId(MZone zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MCircle)) {
            return false;
        }
        MCircle other = (MCircle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.MCircle[ id=" + id + " ]";
    }
    
}
