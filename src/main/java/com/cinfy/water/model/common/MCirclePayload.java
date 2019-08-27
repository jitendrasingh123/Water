package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MCirclePayload {
	private Integer id;
	private Integer circleCode;
	private String nameEnglish;
	private String nameHindi;
	private String circleHq;

	private MCircleTypePayload circleTypeId;

	private StatePayload stateId;

	private MZonePayload zoneId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(Integer circleCode) {
		this.circleCode = circleCode;
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

	public String getCircleHq() {
		return circleHq;
	}

	public void setCircleHq(String circleHq) {
		this.circleHq = circleHq;
	}

	public MCircleTypePayload getCircleTypeId() {
		return circleTypeId;
	}

	public void setCircleTypeId(MCircleTypePayload circleTypeId) {
		this.circleTypeId = circleTypeId;
	}

	public StatePayload getStateId() {
		return stateId;
	}

	public void setStateId(StatePayload stateId) {
		this.stateId = stateId;
	}

	public MZonePayload getZoneId() {
		return zoneId;
	}

	public void setZoneId(MZonePayload zoneId) {
		this.zoneId = zoneId;
	}

}
