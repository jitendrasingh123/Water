/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "case_registration")
@NamedQueries({ @NamedQuery(name = "CaseRegistration.findAll", query = "SELECT c FROM CaseRegistration c") })
public class CaseRegistration implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "case_no")
	private Integer caseNo;

	@Column(name = "case_year")
	private Integer caseYear;

	@Column(name = "petition_date")
	private java.sql.Date petitionDate;

	@Lob
	@Column(name = "petition_details")
	private String petitionDetails;

	@Column(name = "case_status")
	private String caseStatus;

	@Column(name = "order_date")
	private java.sql.Date orderDate;

	@Lob
	@Column(name = "order_details")
	private String orderDetails;

	@Lob
	@Column(name = "advocate_opinion")
	private String advocateOpinion;

	@Lob
	@Column(name = "action_taken")
	private String actionTaken;

	@Column(name = "others")
	private String others;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@JoinColumn(name = "court_name_id", referencedColumnName = "id")
	@ManyToOne
	private MCourtName courtNameId;

	@JoinColumn(name = "division_id", referencedColumnName = "id")
	@ManyToOne
	private MDivision divisionId;

	@JoinColumn(name = "circle_id", referencedColumnName = "id")
	@ManyToOne
	private MCircle circleId;

	@JoinColumn(name = "respons_hearing_date_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ResponsHearingDate responsHearingDateId;

	@JoinColumn(name = "oic", referencedColumnName = "id")
	@ManyToOne
	private User oic;

	@JoinColumn(name = "case_type_id", referencedColumnName = "id")
	@ManyToOne
	private MCaseType caseTypeId;

	@JoinColumn(name = "zone_id", referencedColumnName = "id")
	@ManyToOne
	private MZone zoneId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caseId")
	private List<CaseAttachment> caseAttachments = new ArrayList<CaseAttachment>();

	@Column(name = "no_of_petitioner")
	private Integer noOfPetitioner;

	@Column(name = "no_of_defendant")
	private Integer noOfDefendant;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caseId")
	private List<PetitionerName> petitionerNames = new ArrayList<PetitionerName>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caseId")
	private List<DefendantName> defendantNames = new ArrayList<DefendantName>();

	public Integer getNoOfPetitioner() {
		return noOfPetitioner;
	}

	public void setNoOfPetitioner(Integer noOfPetitioner) {
		this.noOfPetitioner = noOfPetitioner;
	}

	public Integer getNoOfDefendant() {
		return noOfDefendant;
	}

	public void setNoOfDefendant(Integer noOfDefendant) {
		this.noOfDefendant = noOfDefendant;
	}

	public List<PetitionerName> getPetitionerNames() {
		return petitionerNames;
	}

	public void setPetitionerNames(List<PetitionerName> petitionerNames) {
		this.petitionerNames = petitionerNames;
	}

	public List<DefendantName> getDefendantNames() {
		return defendantNames;
	}

	public void setDefendantNames(List<DefendantName> defendantNames) {
		this.defendantNames = defendantNames;
	}

	public CaseRegistration() {
	}

	public List<CaseAttachment> getCaseAttachments() {
		return caseAttachments;
	}

	public void setCaseAttachments(List<CaseAttachment> caseAttachments) {
		this.caseAttachments = caseAttachments;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public MCircle getCircleId() {
		return circleId;
	}

	public void setCircleId(MCircle circleId) {
		this.circleId = circleId;
	}

	public CaseRegistration(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(Integer caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getCaseYear() {
		return caseYear;
	}

	public void setCaseYear(Integer caseYear) {
		this.caseYear = caseYear;
	}

	public void setPetitionDate(java.sql.Date petitionDate) {
		this.petitionDate = petitionDate;
	}

	public void setPetitionDetails(String petitionDetails) {
		this.petitionDetails = petitionDetails;
	}

	public java.sql.Date getPetitionDate() {
		return petitionDate;
	}

	public String getPetitionDetails() {
		return petitionDetails;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getAdvocateOpinion() {
		return advocateOpinion;
	}

	public void setAdvocateOpinion(String advocateOpinion) {
		this.advocateOpinion = advocateOpinion;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public MCourtName getCourtNameId() {
		return courtNameId;
	}

	public void setCourtNameId(MCourtName courtNameId) {
		this.courtNameId = courtNameId;
	}

	public MDivision getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(MDivision divisionId) {
		this.divisionId = divisionId;
	}

	public ResponsHearingDate getResponsHearingDateId() {
		return responsHearingDateId;
	}

	public void setResponsHearingDateId(ResponsHearingDate responsHearingDateId) {
		this.responsHearingDateId = responsHearingDateId;
	}

	public User getOic() {
		return oic;
	}

	public void setOic(User oic) {
		this.oic = oic;
	}

	public MCaseType getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(MCaseType caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MZone getZoneId() {
		return zoneId;
	}

	public void setZoneId(MZone zoneId) {
		this.zoneId = zoneId;
	}

	// public Collection<PetitionerName> getPetitionerNameCollection() {
	// return petitionerNameCollection;
	// }
	//
	// public void setPetitionerNameCollection(Collection<PetitionerName>
	// petitionerNameCollection) {
	// this.petitionerNameCollection = petitionerNameCollection;
	// }
	//
	// public Collection<DefendantName> getDefendantNameCollection() {
	// return defendantNameCollection;
	// }
	//
	// public void setDefendantNameCollection(Collection<DefendantName>
	// defendantNameCollection) {
	// this.defendantNameCollection = defendantNameCollection;
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
		if (!(object instanceof CaseRegistration)) {
			return false;
		}
		CaseRegistration other = (CaseRegistration) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cinfy.water.model.CaseRegistration[ id=" + id + " ]";
	}

}
