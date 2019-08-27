package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetitionerNamePayload {

	private Integer id;
	private String petitionerName;
	//private CaseRegistrationPayload caseId;

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

//	public CaseRegistrationPayload getCaseId() {
//		return caseId;
//	}
//
//	public void setCaseId(CaseRegistrationPayload caseId) {
//		this.caseId = caseId;
//	}

}
