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
@Table(name = "petitioner_name")
@NamedQueries({
    @NamedQuery(name = "PetitionerName.findAll", query = "SELECT p FROM PetitionerName p")})
public class PetitionerName implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
  
    @Column(name = "petitioner_name")
    private String petitionerName;
    
    @JoinColumn(name = "case_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CaseRegistration caseId;

    public PetitionerName() {
    }

    public PetitionerName(Integer id) {
        this.id = id;
    }

    public PetitionerName(Integer id, String petitionerName) {
        this.id = id;
        this.petitionerName = petitionerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetitionerName() {
        return petitionerName;
    }

    public void setPetitionerName(String petitionerName) {
        this.petitionerName = petitionerName;
    }

    public CaseRegistration getCaseId() {
        return caseId;
    }

    public void setCaseId(CaseRegistration caseId) {
        this.caseId = caseId;
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
        if (!(object instanceof PetitionerName)) {
            return false;
        }
        PetitionerName other = (PetitionerName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.PetitionerName[ id=" + id + " ]";
    }
    
}
