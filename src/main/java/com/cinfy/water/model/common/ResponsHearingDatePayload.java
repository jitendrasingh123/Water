package com.cinfy.water.model.common;

import java.sql.Date;

import com.cinfy.water.utils.InvoiceConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsHearingDatePayload {

	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date responsDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = InvoiceConstants.ISO_DATE_FORMAT)
	private Date hearingDate;
	
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

}
