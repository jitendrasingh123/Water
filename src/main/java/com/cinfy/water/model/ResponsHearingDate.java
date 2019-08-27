/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "respons_hearing_date")
@NamedQueries({
    @NamedQuery(name = "ResponsHearingDate.findAll", query = "SELECT r FROM ResponsHearingDate r")})
public class ResponsHearingDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "respons_date")
    private Date responsDate;
    
    @Basic(optional = false)
    @Column(name = "hearing_date")
    private Date hearingDate;
    
   
    public ResponsHearingDate() {
    }

    public ResponsHearingDate(Integer id) {
        this.id = id;
    }

  

    public ResponsHearingDate(Date responsDate, Date hearingDate) {
		super();
		this.responsDate = responsDate;
		this.hearingDate = hearingDate;
		
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

   

  

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsHearingDate)) {
            return false;
        }
        ResponsHearingDate other = (ResponsHearingDate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cinfy.water.model.ResponsHearingDate[ id=" + id + " ]";
    }
    
}
