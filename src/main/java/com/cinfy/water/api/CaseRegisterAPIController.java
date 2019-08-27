package com.cinfy.water.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinfy.water.api.service.CaseRegisterService;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.utils.CommonUtils;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/caseRegister")
public class CaseRegisterAPIController {

	public static final Logger logger = LoggerFactory.getLogger(CaseRegisterAPIController.class);

	@Autowired
	private CaseRegisterService caseRegisterService;	

	@RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
	public ResponseEntity<String> createCaseRegisterGet(HttpServletRequest request) {
		logger.info("Requested operation : {}", request.getRequestURI());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetch(@RequestBody(required = false) @PathVariable("id") Integer id, UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Registration Data ############");
		logger.info("Case Registration Details fetch details:id-{}",id);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(id)) {
				res = caseRegisterService.findById(id);
			}
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/caseType", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCaseType(
			 UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Type Data ############");
		GenericResponse res = null;
		try {
			// TODO Should be debug mode			
				res = caseRegisterService.findCaseType();
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/courtName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCourtName(UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Court Name Data ############");
		GenericResponse res = null;
		try {
			// TODO Should be debug mode			
				res = caseRegisterService.findCourtName();
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/search",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> getCaseRegistrationList(	
			@RequestParam(value = "loginUserId", required = false) Integer loginUserId,
			@RequestParam(value = "caseTypeId", required = false) Integer caseTypeId,
			@RequestParam(value = "caseNo", required = false) Integer caseNo,
			@RequestParam(value = "courtId", required = false) Integer courtId,
			@RequestParam(value = "caseYear", required = false) Integer caseYear,
			@RequestParam(value = "zoneId", required = false) Integer zoneId,
			@RequestParam(value = "circleId", required = false) Integer circleId,
			@RequestParam(value = "divisionId", required = false) Integer divisionId,
			@RequestParam(value = "fromDateHearing", required = false) String fromDateHearing,
			@RequestParam(value = "toDateHearing", required = false) String toDateHearing,
			 UriComponentsBuilder ucBuilder) {
	
		GenericResponse res = null;
		
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("caseTypeId", caseTypeId);
			params.put("caseNo", caseNo);
			params.put("loginUserId", loginUserId);
			params.put("courtId", courtId);
			params.put("caseYear", caseYear);
			params.put("zoneId", zoneId);
			params.put("circleId", circleId);
			params.put("divisionId", divisionId);
			params.put("fromDateHearing", fromDateHearing);
			params.put("toDateHearing", toDateHearing);

			res = this.caseRegisterService.getCaseRegistrationList(params);

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/totalCasePending/{UserId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCaseRegistrationTotalCasePending(
			@RequestBody(required = false) @PathVariable("UserId") Integer UserId,
			UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Registration Data ############");
		logger.info("Case Registration Details fetch details:id-{}",UserId);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(UserId)) {
				res = caseRegisterService.findByUserIdForTotalCasePending(UserId);
			}
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/next7DaysHearing/{UserId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCaseRegistrationNext7DaysHearing(
			@RequestBody(required = false) @PathVariable("UserId") Integer UserId,
			UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Registration Data ############");
		logger.info("Case Registration Details fetch details:id-{}",UserId);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(UserId)) {
				res = caseRegisterService.findByUserIdForNext7DaysHearing(UserId);
			}
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/last7DaysHearing/{UserId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCaseRegistrationLast7DaysHearing(
			@RequestBody(required = false) @PathVariable("UserId") Integer UserId,
			UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Registration Data ############");
		logger.info("Case Registration Details fetch details:id-{}",UserId);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(UserId)) {
				res = caseRegisterService.findByUserIdForLast7DaysHearing(UserId);
			}
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/last30DaysHearing/{UserId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetchCaseRegistrationLast30DaysHearing(
			@RequestBody(required = false) @PathVariable("UserId") Integer UserId,
			UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get Case Registration Data Last 30 Days Hearing ############");
		logger.info("Case Registration Details fetch details:id-{}",UserId);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(UserId)) {
				res = caseRegisterService.findByUserIdForLast30DaysHearing(UserId);
			}
		} catch (Exception ex) {
			logger.error("Exception occurred:" + ex);
			if (res == null) {
				res = new GenericResponse();
				res.setStatus(0);
			}
			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
		}
		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
	}
	

}
