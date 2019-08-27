package com.cinfy.water.model.request;

public class LoginUser {

	private String userId;

	private String password;

	private String mobile;

	private String deviceToken;
	
	
	

	public LoginUser(String userId, String password, String mobile) {
		super();
		this.userId = userId;
		this.password = password;
		this.mobile = mobile;
	 
	}

	 

	public LoginUser() {
	}



	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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



	public String getDeviceToken() {
		return deviceToken;
	}



	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	

}
