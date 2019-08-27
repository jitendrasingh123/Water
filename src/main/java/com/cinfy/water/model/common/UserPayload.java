package com.cinfy.water.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPayload {
	private Integer id;
	private String userName;
	private String userId;
	private String password;
	private String mobile;

	private MCirclePayload circleId;

	private MDesignationPayload designationId;

	private MDivisionPayload divisionId;

	private MUserLevelPayload lavelId;

	private MRolePayload role;

	private SystemsAdminTypePayload systemsAdminTypeId;

	private MZonePayload zoneId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public MCirclePayload getCircleId() {
		return circleId;
	}

	public void setCircleId(MCirclePayload circleId) {
		this.circleId = circleId;
	}

	public MDesignationPayload getDesignationId() {
		return designationId;
	}

	public void setDesignationId(MDesignationPayload designationId) {
		this.designationId = designationId;
	}

	public MDivisionPayload getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(MDivisionPayload divisionId) {
		this.divisionId = divisionId;
	}

	public MUserLevelPayload getLavelId() {
		return lavelId;
	}

	public void setLavelId(MUserLevelPayload lavelId) {
		this.lavelId = lavelId;
	}

	public MRolePayload getRole() {
		return role;
	}

	public void setRole(MRolePayload role) {
		this.role = role;
	}

	public SystemsAdminTypePayload getSystemsAdminTypeId() {
		return systemsAdminTypeId;
	}

	public void setSystemsAdminTypeId(SystemsAdminTypePayload systemsAdminTypeId) {
		this.systemsAdminTypeId = systemsAdminTypeId;
	}

	public MZonePayload getZoneId() {
		return zoneId;
	}

	public void setZoneId(MZonePayload zoneId) {
		this.zoneId = zoneId;
	}

}
