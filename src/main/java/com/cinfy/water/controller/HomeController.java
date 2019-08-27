package com.cinfy.water.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.Login;
import com.cinfy.water.model.User;
import com.cinfy.water.model.repositories.CaseRegistrationRepository;


@Controller
public class HomeController {
	
	static String emailSubject, emailMessage;
	static final String emailFromRecipient = "sender@dpsplfranchisero.org";
	
	@Autowired
	CaseRegistrationRepository caseRegistrationRepository;
	
	@Autowired
	private JavaMailSender mailSenderObj;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("index");

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date next7DayssqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(next7DayssqlDate2);
		
		
		
		cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, -7);
		java.sql.Date last7DaysqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(last7DaysqlDate2);
		
		
		cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, -30);
		java.sql.Date last30DaysqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(last30DaysqlDate2);
		
	
		
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		Integer deptType=0;
	
		if(LoginUser.getZoneId()==null && LoginUser.getCircleId()==null && LoginUser.getDivisionId()==null && LoginUser.getLavelId().getId()==1  && LoginUser.getRole().getId()==1) {
			deptType=1;
		}else if(LoginUser.getZoneId()==null && LoginUser.getCircleId()==null && LoginUser.getDivisionId()==null && LoginUser.getLavelId().getId()==2  && LoginUser.getRole().getId()==2) {
			deptType=2;
		}else if(LoginUser.getZoneId()!=null && LoginUser.getCircleId()==null && LoginUser.getDivisionId()==null && LoginUser.getLavelId().getId()==3  && LoginUser.getRole().getId()==2) {
			deptType=3;
		}else if(LoginUser.getZoneId()!=null && LoginUser.getCircleId()!=null && LoginUser.getDivisionId()==null && LoginUser.getLavelId().getId()==4  && LoginUser.getRole().getId()==2) {
			deptType=4;
		}else if(LoginUser.getZoneId()!=null && LoginUser.getCircleId()!=null && LoginUser.getDivisionId()!=null && LoginUser.getLavelId().getId()==5  && LoginUser.getRole().getId()==2) {
			deptType=5;
		}
		
		switch (deptType) {
		case 1:{
			
			mav.addObject("next7dayscount",caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2)) ;
			mav.addObject("last7dayscount",caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2)) ;
		    mav.addObject("last30dayscount",caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2)) ;		
			mav.addObject("totalcasespendingcount",caseRegistrationRepository.findCountTotalCasesPending()) ;
			
			break;
		}case 2:{
			mav.addObject("next7dayscount",caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2)) ;
			mav.addObject("last7dayscount",caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2)) ;
		    mav.addObject("last30dayscount",caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2)) ;		
			mav.addObject("totalcasespendingcount",caseRegistrationRepository.findCountTotalCasesPending()) ;
			
			break;	
        }case 3:{
        	mav.addObject("next7dayscount",caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2,LoginUser.getZoneId().getId())) ;
			mav.addObject("last7dayscount",caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2,LoginUser.getZoneId().getId())) ;
		    mav.addObject("last30dayscount",caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2,LoginUser.getZoneId().getId())) ;		
			mav.addObject("totalcasespendingcount",caseRegistrationRepository.findCountTotalCasesPending(LoginUser.getZoneId().getId())) ;
			
			break;	
        }case 4:{
        	mav.addObject("next7dayscount",caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId())) ;
			mav.addObject("last7dayscount",caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId())) ;
		    mav.addObject("last30dayscount",caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId())) ;		
			mav.addObject("totalcasespendingcount",caseRegistrationRepository.findCountTotalCasesPending(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId())) ;
			
			break;	
        }case 5:{
        	mav.addObject("next7dayscount",caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId())) ;
			mav.addObject("last7dayscount",caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId())) ;
		    mav.addObject("last30dayscount",caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId())) ;		
			mav.addObject("totalcasespendingcount",caseRegistrationRepository.findCountTotalCasesPending(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId())) ;
			
			break;	
        }default:{
		
        	break;
		}
		}
		
	
		 Map<Object,Object> mapPie = null;
		 List<List<Map<Object,Object>>> listPie = new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPointsPie = new ArrayList<Map<Object,Object>>();
		 mapPie = new HashMap<Object,Object>(); mapPie.put("name", "Pending"); mapPie.put("y", 21);dataPointsPie.add(mapPie);
		 mapPie = new HashMap<Object,Object>(); mapPie.put("name", "Last 7 days"); mapPie.put("y", 14);dataPointsPie.add(mapPie);
		 mapPie = new HashMap<Object,Object>(); mapPie.put("name", "Updated"); mapPie.put("y", 14);dataPointsPie.add(mapPie);
		 mapPie = new HashMap<Object,Object>(); mapPie.put("name", "Next 7 days"); mapPie.put("y", 29);dataPointsPie.add(mapPie);
		 mapPie = new HashMap<Object,Object>(); mapPie.put("name", "My Cases"); mapPie.put("y", 22);dataPointsPie.add(mapPie);		
		listPie.add(dataPointsPie);		
		mav.addObject("dataPointsListPie", listPie);
	
		Map<Object,Object> mapBar = null;
		List<List<Map<Object,Object>>> listBar = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPointsBar = new ArrayList<Map<Object,Object>>();
		
		
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1167589800000L); mapBar.put("y", 188);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1199125800000L); mapBar.put("y", 213);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1230748200000L); mapBar.put("y", 213);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1262284200000L); mapBar.put("y", 219);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1293820200000L); mapBar.put("y", 207);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1325356200000L); mapBar.put("y", 167);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1356978600000L); mapBar.put("y", 136);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1388514600000L); mapBar.put("y", 152);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1420050600000L); mapBar.put("y", 129);dataPointsBar.add(mapBar);
			mapBar = new HashMap<Object,Object>(); mapBar.put("x", 1451586600000L); mapBar.put("y", 155);dataPointsBar.add(mapBar);
	 
			listBar.add(dataPointsBar);
			mav.addObject("dataPointsListBar", listBar);
			
			 Map<Object,Object> mapLine = null;
			 List<List<Map<Object,Object>>> listLine = new ArrayList<List<Map<Object,Object>>>();
			 List<Map<Object,Object>> dataPointsLine = new ArrayList<Map<Object,Object>>();
			
			
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1483209000000L); mapLine.put("y", 7);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1485887400000L); mapLine.put("y", 6);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1488306600000L); mapLine.put("y", 6);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1490985000000L); mapLine.put("y", 9);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1493577000000L); mapLine.put("y", 11);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1496255400000L); mapLine.put("y", 14);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1498847400000L); mapLine.put("y", 17);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1501525800000L); mapLine.put("y", 18);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1504204200000L); mapLine.put("y", 17);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1506796200000L); mapLine.put("y", 15);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1509474600000L); mapLine.put("y", 12);dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object,Object>(); mapLine.put("x", 1512066600000L); mapLine.put("y", 9);dataPointsLine.add(mapLine);
		 
				listLine.add(dataPointsLine);
				mav.addObject("dataPointsListLine", listLine);
		
		return mav;
	}
	@RequestMapping(value = "/sm", method = RequestMethod.GET)
	public ModelAndView sm(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("sm");
		 
		return mav;
	}
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("login");
		  mav.addObject("login", new Login());
		return mav;
	
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("about");
		 
		return mav;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("profile");
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		mav.addObject("LoginUser",LoginUser);
		 
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/new_user", method = RequestMethod.GET)
	public ModelAndView new_user(HttpServletRequest request, Model model) {	
		ModelAndView mav=new ModelAndView("new_user");
		 
		return mav;
	}
	
	
//	@RequestMapping(value = "/case_registration", method = RequestMethod.GET)
//	public ModelAndView case_registration(HttpServletRequest request, Model model) {	
//		ModelAndView mav=new ModelAndView("case_details");
//		 
//		return mav;
//	}
	

}
