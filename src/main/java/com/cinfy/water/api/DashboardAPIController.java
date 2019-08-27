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

import com.cinfy.water.api.service.DashboardService;
import com.cinfy.water.api.service.StateService;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.utils.CommonUtils;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/dashboard")
public class DashboardAPIController {

	public static final Logger logger = LoggerFactory.getLogger(DashboardAPIController.class);

	@Autowired
	private DashboardService dashboardService;
	
	
	/*
	 * This is for status of the application.
	 */
	@RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
	public ResponseEntity<String> getDashboardHealthCheck(HttpServletRequest request) {
		logger.info("Requested operation : {}", request.getRequestURI());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<GenericResponse> fetch(@RequestBody(required = false) @PathVariable("id") Integer id, UriComponentsBuilder ucBuilder) {
		logger.info("##########Requested operation into get dashboard Data############");
		logger.info("Dashboard Details fetch details:id-{}",id);
		GenericResponse res = null;
		try {
			// TODO Should be debug mode

			if (!StringUtils.isEmpty(id)) {
				res = dashboardService.findById(id);
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
