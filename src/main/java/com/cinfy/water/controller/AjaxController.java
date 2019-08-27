package com.cinfy.water.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinfy.water.model.MCircle;
import com.cinfy.water.model.MDivision;
import com.cinfy.water.model.repositories.MCircleRepository;
import com.cinfy.water.model.repositories.MDivisionRepository;
import com.cinfy.water.model.repositories.UserRepository;

@Controller
public class AjaxController {

	@Autowired
	MCircleRepository mCircleRepository;

	@Autowired
	MDivisionRepository mDivisionRepository;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/existEmail", method = RequestMethod.GET)
	@ResponseBody
	public Boolean get_Email_UniqCheck(HttpServletRequest request, @RequestParam("userId") String userId) {

		Boolean b = false;
		try {
			b = userRepository.existsByEmail(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	// check mobile Availability for user Registration
	@RequestMapping(value = "/existContact", method = RequestMethod.GET)
	@ResponseBody
	public Boolean get_Contact_UniqCheck(HttpServletRequest request, @RequestParam("mobileNo") String mobileNo) {

		Boolean b = false;
		try {
			b = userRepository.existsByMobile(mobileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@RequestMapping(value = "/get_circle_list")
	@ResponseBody
	public List<MCircle> getAll_Circle_By_ZoneId(@RequestParam("zoneId") Integer zoneId, HttpServletRequest request) {
		// System.out.println("officeId:"+officeId);
		// Integer language = (Integer) request.getSession().getAttribute("language");
		List<MCircle> circleList = null;
		if (zoneId != null) {
			System.out.println("id--" + zoneId);
			try {
				circleList = mCircleRepository.findCircleByzoneId(zoneId);
				for (MCircle mCircle : circleList) {
					System.out.println("LLL--" + mCircle.getNameEnglish());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// System.out.println("-----" + l.toString());
			return circleList;
		} else {
			System.out.println("PP");
			return null;
		}
	}

	@RequestMapping(value = "/get_division_list")
	@ResponseBody
	public List<MDivision> getAll_Division_By_CircleId(@RequestParam("circleId") Integer circleId,
			HttpServletRequest request) {
		// System.out.println("officeId:"+officeId);
		// Integer language = (Integer) request.getSession().getAttribute("language");
		List<MDivision> divisionList = null;
		if (circleId != null) {
			System.out.println("id--" + circleId);
			try {
				divisionList = mDivisionRepository.findDivisionByCircleId(circleId);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// System.out.println("-----" + l.toString());
			return divisionList;
		} else {
			return null;
		}
	}

	// @RequestMapping(value = "/get_subdivision_list")
	// @ResponseBody
	// public List<MSubDivision>
	// getAll_SubDivision_By_DivisionId(@RequestParam("divisionId") Integer
	// divisionId, HttpServletRequest request) {
	// // System.out.println("officeId:"+officeId);
	// //Integer language = (Integer) request.getSession().getAttribute("language");
	// List<MSubDivision> subDivisionList = null;
	// if (divisionId != null) {
	// System.out.println("id--"+divisionId);
	// try {
	// subDivisionList =
	// mSubDivisionRepository.findSubDivisionBydivisionId(divisionId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // System.out.println("-----" + l.toString());
	// return subDivisionList;
	// } else {
	// return null;
	// }
	// }

}
