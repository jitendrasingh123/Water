package com.cinfy.water.api.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinfy.water.model.request.LoginUser;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.model.response.UserProfileGetResponse;

import com.cinfy.water.utils.InvoiceConstants;
import com.cinfy.water.utils.Messages;

import com.cinfy.water.model.repositories.UserRepository;
import com.cinfy.water.model.mapper.UserMapper;
import com.cinfy.water.model.User;
import com.cinfy.water.model.common.UserPayload;


@Service
public class LoginService {

	public static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	private static final int ERROR_CODE_CLASS = 1000;

	@Autowired
	UserRepository userRepository;	
	/*
	 * Login check
	 */
	public GenericResponse login(LoginUser user) {
		logger.info("User loging by ID: {}", user.getUserId());
		logger.info("User loging by getPassword: {}", user.getPassword());
		GenericResponse response = new GenericResponse();
		response.setStatus(1);
		UserProfileGetResponse dataResponse = null;
		try {
           if(user.getUserId()!=null && user.getPassword()!=null){
			String securePassword = Base64.getEncoder()
					.encodeToString(user.getPassword().getBytes(InvoiceConstants.UTF8));
			logger.info("Errror111");
			User account = this.userRepository.findByPasswordAndUserIdOrMobileAllIgnoreCase(securePassword,
					user.getUserId(), user.getMobile());

			if (account != null) {
				logger.info("Errror222");
				dataResponse = new UserProfileGetResponse();
				UserPayload userPayload = UserMapper.INSTANCE.userEntityToUserPayload(account);
				dataResponse.setUser(userPayload);
				response.setData(dataResponse);
				
				if(user.getDeviceToken() != null && !user.getDeviceToken().isEmpty()) {			
				
						this.userRepository.updateDeviceToken(user.getDeviceToken(), account.getId());
					
				}
				
				logger.info("AAAAAAA: {}", response);
			} else {
				logger.info("User not found for the userId:" + user.getUserId());
				response.setStatus(0);				
				response.setError(new ErrorMessage(ERROR_CODE_CLASS, "User not found for the userId :" + user.getUserId()));
			}
           } else {
				response.setStatus(0);
				response.setError(new ErrorMessage(ERROR_CODE_CLASS, "Null Values"));
			}			
		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("user.login.failed"), ex.getMessage()));
		}
		logger.info("BBBBBB: {}", response);
		return response;

	}

	
	public GenericResponse getUserList(Map<String, Object> params) {		  
		
		  logger.info("Getting the list of user details .... ");		  
		  GenericResponse response = new GenericResponse();		  
		  
		  List<User> users = null;
		  List<UserPayload> result = null;
		  response.setStatus(1);		  
		  try{
			  
			  Integer id =  (Integer) params.get("id");	
			  String email =  (String) params.get("email");
			  
			  if(email != null){
				  users = userRepository.findByUserId(email);
			  }else {
				  users = userRepository.findAllUser();
			  }
			  
			  if (users != null && !users.isEmpty()) {
					result = new ArrayList<>();
					for (User s : users) {
						UserPayload payload = UserMapper.INSTANCE
								.userEntityToUserPayload(s);
						result.add(payload);
					}
					response.setData(result);
				}else {				
			
					response.setError(new ErrorMessage(ERROR_CODE_CLASS,Messages.get("sales.save.update"), "Not Found"));
				}
				
		  }catch (Exception ex) {
			   logger.error(ERROR_CODE_CLASS+"-Exception occurred due to the:"+ex.fillInStackTrace());
			   response.setStatus(0);
			   response.setError(new ErrorMessage(ERROR_CODE_CLASS,Messages.get("sales.save.update"),ex.getMessage()));
			  }
		return response;
	}

}
