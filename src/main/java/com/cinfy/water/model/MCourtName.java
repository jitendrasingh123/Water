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
@Table(name = "m_court_name")
@NamedQueries({ @NamedQuery(name = "MCourtName.findAll", query = "SELECT m FROM MCourtName m") })
public class MCourtName implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "court_name")
	private String courtName;
	// @OneToMany(mappedBy = "courtNameId")
	// private Collection<CaseRegistration> caseRegistrationCollection;

	public MCourtName() {
	}

	public MCourtName(Integer id) {
		this.id = id;
	}

	public MCourtName(Integer id, String courtName) {
		this.id = id;
		this.courtName = courtName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	// public Collection<CaseRegistration> getCaseRegistrationCollection() {
	// return caseRegistrationCollection;
	// }
	//
	// public void setCaseRegistrationCollection(Collection<CaseRegistration>
	// caseRegistrationCollection) {
	// this.caseRegistrationCollection = caseRegistrationCollection;
	// }

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MCourtName)) {
			return false;
		}
		MCourtName other = (MCourtName) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cinfy.water.model.MCourtName[ id=" + id + " ]";
	}

}
