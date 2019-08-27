package com.cinfy.water.model.common;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cinfy.water.utils.InvoiceConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseRegistrationPayload {

	private Integer id;
	private Integer caseNo;
	private Integer caseYear;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date petitionDate;

	private String petitionDetails;
	private String caseStatus;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date orderDate;

	private String orderDetails;
	private String advocateOpinion;
	private String actionTaken;
	private String others;

	private MCourtNamePayload courtNameId;

	private MDivisionPayload divisionId;

	private MCirclePayload circleId;

	private ResponsHearingDatePayload responsHearingDateId;

	private UserPayload oic;

	private MCaseTypePayload caseTypeId;

	private MZonePayload zoneId;

	private Collection<CaseAttachmentPayload> caseAttachments;

	private Integer noOfPetitioner;
	private Integer noOfDefendant;

	private List<PetitionerNamePayload> petitionerNames = new ArrayList<PetitionerNamePayload>();

	private List<DefendantNamePayload> defendantNames = new ArrayList<DefendantNamePayload>();

	

	public java.sql.Date getPetitionDate() {
		return petitionDate;
	}

	public void setPetitionDate(java.sql.Date petitionDate) {
		this.petitionDate = petitionDate;
	}

	

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
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

	public String getPetitionDetails() {
		return petitionDetails;
	}

	public void setPetitionDetails(String petitionDetails) {
		this.petitionDetails = petitionDetails;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
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

	public MCourtNamePayload getCourtNameId() {
		return courtNameId;
	}

	public void setCourtNameId(MCourtNamePayload courtNameId) {
		this.courtNameId = courtNameId;
	}

	public MDivisionPayload getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(MDivisionPayload divisionId) {
		this.divisionId = divisionId;
	}

	public MCirclePayload getCircleId() {
		return circleId;
	}

	public void setCircleId(MCirclePayload circleId) {
		this.circleId = circleId;
	}

	public ResponsHearingDatePayload getResponsHearingDateId() {
		return responsHearingDateId;
	}

	public void setResponsHearingDateId(ResponsHearingDatePayload responsHearingDateId) {
		this.responsHearingDateId = responsHearingDateId;
	}

	public UserPayload getOic() {
		return oic;
	}

	public void setOic(UserPayload oic) {
		this.oic = oic;
	}

	public MCaseTypePayload getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(MCaseTypePayload caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public MZonePayload getZoneId() {
		return zoneId;
	}

	public void setZoneId(MZonePayload zoneId) {
		this.zoneId = zoneId;
	}

	public Collection<CaseAttachmentPayload> getCaseAttachments() {
		return caseAttachments;
	}

	public void setCaseAttachments(Collection<CaseAttachmentPayload> caseAttachments) {
		this.caseAttachments = caseAttachments;
	}

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

	public List<PetitionerNamePayload> getPetitionerNames() {
		return petitionerNames;
	}

	public void setPetitionerNames(List<PetitionerNamePayload> petitionerNames) {
		this.petitionerNames = petitionerNames;
	}

	public List<DefendantNamePayload> getDefendantNames() {
		return defendantNames;
	}

	public void setDefendantNames(List<DefendantNamePayload> defendantNames) {
		this.defendantNames = defendantNames;
	}

}
