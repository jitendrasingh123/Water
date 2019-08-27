package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefendantNamePayload {

	private Integer id;
	//private CaseRegistrationPayload caseId;
	private UserPayload defendantId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public CaseRegistrationPayload getCaseId() {
//		return caseId;
//	}
//
//	public void setCaseId(CaseRegistrationPayload caseId) {
//		this.caseId = caseId;
//	}

	public UserPayload getDefendantId() {
		return defendantId;
	}

	public void setDefendantId(UserPayload defendantId) {
		this.defendantId = defendantId;
	}

}
