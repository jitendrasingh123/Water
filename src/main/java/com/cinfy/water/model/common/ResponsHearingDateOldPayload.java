package com.cinfy.water.model.common;

import java.util.Date;

import com.cinfy.water.utils.InvoiceConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsHearingDateOldPayload {

	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date responsDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date hearingDate;
	
	private int caseId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date updatedDate;

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

}
