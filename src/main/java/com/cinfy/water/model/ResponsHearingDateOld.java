/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "respons_hearing_date_old")
@NamedQueries({
    @NamedQuery(name = "ResponsHearingDateOld.findAll", query = "SELECT r FROM ResponsHearingDateOld r")})
public class ResponsHearingDateOld implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "respons_date")
    @Temporal(TemporalType.DATE)
    private Date responsDate;
    
    @Basic(optional = false)
    @Column(name = "hearing_date")
    @Temporal(TemporalType.DATE)
    private Date hearingDate;
    
    @Basic(optional = false)
    @Column(name = "case_id")
    private int caseId;
   
    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public ResponsHearingDateOld() {
    }

    public ResponsHearingDateOld(Integer id) {
        this.id = id;
    }

    public ResponsHearingDateOld( Date responsDate, Date hearingDate, int caseId, Date updatedDate) {
      
        this.responsDate = responsDate;
        this.hearingDate = hearingDate;
        this.caseId = caseId;    
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getResponsDate() {
        return responsDate;
    }

    public void setResponsDate(Date responsDate) {
        this.responsDate = responsDate;
    }

    public Date getHearingDate() {
        return hearingDate;
    }

    public void setHearingDate(Date hearingDate) {
        this.hearingDate = hearingDate;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

   
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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
        if (!(object instanceof ResponsHearingDateOld)) {
            return false;
        }
        ResponsHearingDateOld other = (ResponsHearingDateOld) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.ResponsHearingDateOld[ id=" + id + " ]";
    }
    
}
