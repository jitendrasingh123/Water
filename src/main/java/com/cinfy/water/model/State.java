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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "state")
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")})
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "stateId")
//    private Collection<MZone> mZoneCollection;
//    @OneToMany(mappedBy = "stateId")
//    private Collection<MDivision> mDivisionCollection;
//    @OneToMany(mappedBy = "stateId")
//    private Collection<MCircle> mCircleCollection;
//    @OneToMany(mappedBy = "stateId")
//    private Collection<MSubDivision> mSubDivisionCollection;

    public State() {
    }

    public State(Integer id) {
        this.id = id;
    }

    public State(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Collection<MZone> getMZoneCollection() {
//        return mZoneCollection;
//    }
//
//    public void setMZoneCollection(Collection<MZone> mZoneCollection) {
//        this.mZoneCollection = mZoneCollection;
//    }
//
//    public Collection<MDivision> getMDivisionCollection() {
//        return mDivisionCollection;
//    }
//
//    public void setMDivisionCollection(Collection<MDivision> mDivisionCollection) {
//        this.mDivisionCollection = mDivisionCollection;
//    }
//
//    public Collection<MCircle> getMCircleCollection() {
//        return mCircleCollection;
//    }
//
//    public void setMCircleCollection(Collection<MCircle> mCircleCollection) {
//        this.mCircleCollection = mCircleCollection;
//    }
//
//    public Collection<MSubDivision> getMSubDivisionCollection() {
//        return mSubDivisionCollection;
//    }
//
//    public void setMSubDivisionCollection(Collection<MSubDivision> mSubDivisionCollection) {
//        this.mSubDivisionCollection = mSubDivisionCollection;
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
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.State[ id=" + id + " ]";
    }
    
}
