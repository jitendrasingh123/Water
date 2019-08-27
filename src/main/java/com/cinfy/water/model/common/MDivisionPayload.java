package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MDivisionPayload {
	private Integer id;
	private Integer divisionCode;
	private String nameEnglish;
	private String nameHindi;
	private String divisionHq;

	private MCirclePayload circleId;

	private StatePayload stateId;

	private MDivisionTypePayload divisionTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(Integer divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getNameHindi() {
		return nameHindi;
	}

	public void setNameHindi(String nameHindi) {
		this.nameHindi = nameHindi;
	}

	public String getDivisionHq() {
		return divisionHq;
	}

	public void setDivisionHq(String divisionHq) {
		this.divisionHq = divisionHq;
	}

	public MCirclePayload getCircleId() {
		return circleId;
	}

	public void setCircleId(MCirclePayload circleId) {
		this.circleId = circleId;
	}

	public StatePayload getStateId() {
		return stateId;
	}

	public void setStateId(StatePayload stateId) {
		this.stateId = stateId;
	}

	public MDivisionTypePayload getDivisionTypeId() {
		return divisionTypeId;
	}

	public void setDivisionTypeId(MDivisionTypePayload divisionTypeId) {
		this.divisionTypeId = divisionTypeId;
	}

}
