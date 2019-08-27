package com.cinfy.water.api;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinfy.water.api.service.StateService;
import com.cinfy.water.model.common.StatePayload;
import com.cinfy.water.model.request.GenericRequest;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/state")
public class StateAPIController {

	public static final Logger logger = LoggerFactory.getLogger(StateAPIController.class);

	@Autowired
	private StateService stateService;
	
	
	/*
	 * This is for status of the application.
	 */
	@RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
	public ResponseEntity<String> createUserGet(HttpServletRequest request) {
		logger.info("Requested operation : {}", request.getRequestURI());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<GenericResponse> fetch(@RequestBody(required = false) @PathVariable("id") Integer id, UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get State Data############");
		logger.info("Zone Details fetch details:id-{}",	id);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(id)) {
				res = stateService.findById(id);
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
	
	

		
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<GenericResponse> create(@RequestBody GenericRequest request, UriComponentsBuilder ucBuilder) {
		logger.info("########Into State Controller#########}");


		ObjectMapper mapper = new ObjectMapper();
		GenericResponse res = null;
		try {
			// TODO Should be debug mode
			logger.info("Requested operation : {}", mapper.writeValueAsString(request.getData()));

			StatePayload statePayload = mapper.readValue(mapper.writeValueAsString(request.getData()),
					StatePayload.class);
		
			//mZonePayload.setDeleted(0);
			res = stateService.saveOrUpdate(statePayload);

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
	
//	@RequestMapping(path = "/search",method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<GenericResponse> getResources(
//			
//			 @RequestParam(value = "companyId", required = false) Integer companyId,
//			 @RequestParam(value = "fromDate", required = false) String fromDate,
//			 @RequestParam(value = "toDate", required = false) String toDate,
//			 @RequestParam(value = "empId", required = false) Integer empId,
//			 @RequestParam(value = "projectId", required = false) Integer projectId,
//			 UriComponentsBuilder ucBuilder) {
//	
//		GenericResponse res = null;
//		
//		try {
//			Map<String, Object> params = new HashMap<>();
//			
//			params.put("companyId", companyId);			
//		
//			params.put("fromDate", fromDate);
//			params.put("toDate", toDate);
//			params.put("empId", empId);
//			params.put("projectId", projectId);
//
//			res = this.materialPlanningService.getMaterialPlanningList(params);
//
//		} catch (Exception ex) {
//			// TODO Auto-generated catch block
//			if (res == null) {
//				res = new GenericResponse();
//				res.setStatus(0);
//			}
//			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
//		}
//		return new ResponseEntity<GenericResponse>(res, CommonUtils.getHeaders(), HttpStatus.OK);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
//	public GenericResponse delete(@RequestBody GenericRequest request, UriComponentsBuilder ucBuilder) {
//		logger.info("########Into Material Planning delete#########}");
//
//		ObjectMapper mapper = new ObjectMapper();
//		GenericResponse res = null;
//		MaterialPlanningDeleteRequest materialPlanningDeleteRequest;
//		try {
//			materialPlanningDeleteRequest = mapper.readValue(mapper.writeValueAsString(request.getData()),
//					MaterialPlanningDeleteRequest.class);
//			res = materialPlanningService.updateDelete(materialPlanningDeleteRequest);
//			MaterialPlanningDeleteResponse materialPlanningDeleteResponse = new MaterialPlanningDeleteResponse();
//			materialPlanningDeleteResponse.setMessage("Material Planning Deleted successfully");
//			res = new GenericResponse();
//			res.setStatus(1);
//			res.setData(materialPlanningDeleteResponse);
//
//		} catch (Exception ex) {
//			logger.error("Exception occurred:" + ex);
//			if (res == null) {
//				res = new GenericResponse();
//				res.setStatus(0);
//			}
//			res.setError(new ErrorMessage(0001, "Unable to process the request.", ex.getMessage()));
//		}
//		
//		return res;
//	}
	
	

	
}
