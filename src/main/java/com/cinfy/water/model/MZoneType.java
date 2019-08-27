/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "m_zone_type")
@NamedQueries({
    @NamedQuery(name = "MZoneType.findAll", query = "SELECT m FROM MZoneType m")})
public class MZoneType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name_english")
    private String nameEnglish;
    @Basic(optional = false)
    @Column(name = "name_hindi")
    private String nameHindi;
//    @OneToMany(mappedBy = "zoneTypeId")
//    private Collection<MZone> mZoneCollection;

    public MZoneType() {
    }

    public MZoneType(Integer id) {
        this.id = id;
    }

    public MZoneType(Integer id, String nameEnglish, String nameHindi) {
        this.id = id;
        this.nameEnglish = nameEnglish;
        this.nameHindi = nameHindi;
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

//    public Collection<MZone> getMZoneCollection() {
//        return mZoneCollection;
//    }
//
//    public void setMZoneCollection(Collection<MZone> mZoneCollection) {
//        this.mZoneCollection = mZoneCollection;
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
        if (!(object instanceof MZoneType)) {
            return false;
        }
        MZoneType other = (MZoneType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.MZoneType[ id=" + id + " ]";
    }
    
}
