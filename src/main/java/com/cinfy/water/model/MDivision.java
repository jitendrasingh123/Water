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
@Table(name = "m_division")
@NamedQueries({
    @NamedQuery(name = "MDivision.findAll", query = "SELECT m FROM MDivision m")})
public class MDivision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "division_code")
    private Integer divisionCode;
    @Column(name = "name_english")
    private String nameEnglish;
    @Column(name = "name_hindi")
    private String nameHindi;
    @Column(name = "division_hq")
    private String divisionHq;
    
//    @OneToMany(mappedBy = "divisionId")
//    private Collection<CaseRegistration> caseRegistrationCollection;
    
    @JoinColumn(name = "circle_id", referencedColumnName = "id")
    @ManyToOne
    private MCircle circleId;
    
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne
    private State stateId;
    
    @JoinColumn(name = "division_type_id", referencedColumnName = "id")
    @ManyToOne
    private MDivisionType divisionTypeId;
    
//    @OneToMany(mappedBy = "divisionId")
//    private Collection<User> userCollection;
//    
//    @OneToMany(mappedBy = "divisionId")
//    private Collection<MSubDivision> mSubDivisionCollection;

    public MDivision() {
    }

    public MDivision(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(Integer divisionCode) {
        this.divisionCode = divisionCode;
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

    public String getDivisionHq() {
        return divisionHq;
    }

    public void setDivisionHq(String divisionHq) {
        this.divisionHq = divisionHq;
    }

//    public Collection<CaseRegistration> getCaseRegistrationCollection() {
//        return caseRegistrationCollection;
//    }
//
//    public void setCaseRegistrationCollection(Collection<CaseRegistration> caseRegistrationCollection) {
//        this.caseRegistrationCollection = caseRegistrationCollection;
//    }

    public MCircle getCircleId() {
        return circleId;
    }

    public void setCircleId(MCircle circleId) {
        this.circleId = circleId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public MDivisionType getDivisionTypeId() {
        return divisionTypeId;
    }

    public void setDivisionTypeId(MDivisionType divisionTypeId) {
        this.divisionTypeId = divisionTypeId;
    }

//    public Collection<User> getUserCollection() {
//        return userCollection;
//    }
//
//    public void setUserCollection(Collection<User> userCollection) {
//        this.userCollection = userCollection;
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
        if (!(object instanceof MDivision)) {
            return false;
        }
        MDivision other = (MDivision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.MDivision[ id=" + id + " ]";
    }
    
}
