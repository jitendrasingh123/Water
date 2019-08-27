package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MZonePayload {
	private Integer id;
	private String nameEnglish;
	private String nameHindi;
	private String zoneHq;

//	private StatePayload stateId;
//
//	private MZoneTypePayload zoneTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getZoneHq() {
		return zoneHq;
	}

	public void setZoneHq(String zoneHq) {
		this.zoneHq = zoneHq;
	}

//	public StatePayload getStateId() {
//		return stateId;
//	}
//
//	public void setStateId(StatePayload stateId) {
//		this.stateId = stateId;
//	}
//
//	public MZoneTypePayload getZoneTypeId() {
//		return zoneTypeId;
//	}
//
//	public void setZoneTypeId(MZoneTypePayload zoneTypeId) {
//		this.zoneTypeId = zoneTypeId;
//	}

}
