package com.cinfy.water.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinfy.water.model.CaseAttachment;
import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.DefendantName;
import com.cinfy.water.model.PetitionerName;
import com.cinfy.water.model.ResponsHearingDateOld;
import com.cinfy.water.model.User;
import com.cinfy.water.model.repositories.CaseRegistrationRepository;
import com.cinfy.water.model.repositories.LoginRepository;
import com.cinfy.water.model.repositories.MCaseTypeRepository;
import com.cinfy.water.model.repositories.MCircleRepository;
import com.cinfy.water.model.repositories.MCourtNameRepository;
import com.cinfy.water.model.repositories.MDesignationRepository;
import com.cinfy.water.model.repositories.MDivisionRepository;
import com.cinfy.water.model.repositories.MRoleRepository;
import com.cinfy.water.model.repositories.MStateRepository;
import com.cinfy.water.model.repositories.MUserLevelRepository;
import com.cinfy.water.model.repositories.MZoneRepository;
import com.cinfy.water.model.repositories.ResponsHearingDateOldRepository;
import com.cinfy.water.model.repositories.ResponsHearingDateRepository;
import com.cinfy.water.model.repositories.SystemAdminTypeRepository;
import com.cinfy.water.model.repositories.UserRepository;
import com.cinfy.water.utils.FTPUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CaseRegistrationController {

	// static String emailSubject, emailMessage;
	// static final String emailFromRecipient = "sender@dpsplfranchisero.org";

	// @Autowired
	// private JavaMailSender mailSenderObj;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	MStateRepository mStateRepository;

	@Autowired
	MZoneRepository mZoneRepository;

	@Autowired
	MCircleRepository mCircleRepository;

	@Autowired
	MDivisionRepository mDivisionRepository;

	// @Autowired
	// MSubDivisionRepository mSubDivisionRepository;

	@Autowired
	MUserLevelRepository mUserLevelRepository;

	@Autowired
	MRoleRepository mRoleRepository;

	@Autowired
	MDesignationRepository mDesignationRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	SystemAdminTypeRepository systemAdminTypeRepository;

	@Autowired
	MCourtNameRepository mCourtNameRepository;

	@Autowired
	MCaseTypeRepository mCaseTypeRepository;

	@Autowired
	CaseRegistrationRepository caseRegistrationRepository;

	@Autowired
	ResponsHearingDateOldRepository responsHearingDateRepositoryOld;

	@Autowired
	ResponsHearingDateRepository responsHearingDateRepository;
	
	@Value("${UPLOAD_PATH_CASE_ATTACHMENTS}")
	private String UPLOAD_PATH_CASE_ATTACHMENTS;

	@RequestMapping(value = "/case_search", method = RequestMethod.GET)
	public ModelAndView search_all_case(@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView("case_search");
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
			mav.addObject("list", caseRegistrationRepository.findAll());
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			mav.addObject("list", caseRegistrationRepository.findAll());
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	mav.addObject("list", caseRegistrationRepository.findByZone(LoginUser.getZoneId().getId()));
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	mav.addObject("list", caseRegistrationRepository.findByZoneCircle(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId()));
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	mav.addObject("list", caseRegistrationRepository.findByZoneCircleDivision(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId()));
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}
		
		 mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
		return mav;
	}

	@RequestMapping(value = "/case_search_filter", method = RequestMethod.POST)
	public ModelAndView case_search_filter(@RequestParam(value = "caseTypeId", required = false) Integer caseTypeId,
			@RequestParam(value = "caseNo", required = false) Integer caseNo,
			@RequestParam(value = "caseYear", required = false) Integer caseYear,
			@RequestParam(value = "zoneId", required = false) Integer zoneId,
			@RequestParam(value = "circleId", required = false) Integer circleId,
			@RequestParam(value = "divisionId", required = false) Integer divisionId,
			@RequestParam(value = "fromDateHearing", required = false) String fromDateHearing,
			@RequestParam(value = "toDateHearing", required = false) String toDateHearing, HttpServletRequest request,
			Model model) {

		ModelAndView mav = new ModelAndView("case_search");
		List<CaseRegistration> list = new ArrayList<CaseRegistration>();

		

		if (zoneId != null && circleId != null && divisionId != null && !fromDateHearing.equals("")
				&& !toDateHearing.equals("")) {
			list = caseRegistrationRepository.findByZoneCircleDivisionHearingDate(zoneId, circleId, divisionId,
					java.sql.Date.valueOf(fromDateHearing), java.sql.Date.valueOf(toDateHearing));
		} else if (zoneId != null && circleId != null && divisionId != null) {
			list = caseRegistrationRepository.findByZoneCircleDivision(zoneId, circleId, divisionId);
		} else if (zoneId != null && circleId != null && !fromDateHearing.equals("") && !toDateHearing.equals("")) {
			list = caseRegistrationRepository.findByZoneCircleHearingDate(zoneId, circleId,
					java.sql.Date.valueOf(fromDateHearing), java.sql.Date.valueOf(toDateHearing));
		} else if (zoneId != null && circleId != null) {
			list = caseRegistrationRepository.findByZoneCircle(zoneId, circleId);
		} else if (zoneId != null && !fromDateHearing.equals("") && !toDateHearing.equals("")) {
			list = caseRegistrationRepository.findByZoneHearingDate(zoneId, java.sql.Date.valueOf(fromDateHearing),
					java.sql.Date.valueOf(toDateHearing));
		} else if (!fromDateHearing.equals("") && !toDateHearing.equals("")) {
			list = caseRegistrationRepository.findByHearingDate(java.sql.Date.valueOf(fromDateHearing),
					java.sql.Date.valueOf(toDateHearing));
		} else if (zoneId != null) {
			list = caseRegistrationRepository.findByZone(zoneId);
		}
		
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
			if (caseTypeId != null && caseNo != null && caseYear != null) {
				list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear);
			}
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			if (caseTypeId != null && caseNo != null && caseYear != null) {
				list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear);
			}
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	if (caseTypeId != null && caseNo != null && caseYear != null) {
    			list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,LoginUser.getZoneId().getId());
    		}
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	if (caseTypeId != null && caseNo != null && caseYear != null) {
    			list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId());
    		}
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	if (caseTypeId != null && caseNo != null && caseYear != null) {
    			list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId());
    		}
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}

		mav.addObject("list", list);
		mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
		
		return mav;
	}
	
	@RequestMapping(value = "/totalcasespending", method = RequestMethod.GET)
	public ModelAndView totalcasespending(HttpServletRequest request, Model model) {

		ModelAndView mav = new ModelAndView("case_search");
		List<CaseRegistration> list = new ArrayList<CaseRegistration>();
		
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
			 list = caseRegistrationRepository.findTotalCasesPending();
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			list = caseRegistrationRepository.findTotalCasesPending();
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}
		
		
		 mav.addObject("list",list);
		 mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
		
		
		return mav;
	}

	@RequestMapping(value = "/next7dayshearing", method = RequestMethod.GET)
	public ModelAndView next7dayshearing(HttpServletRequest request, Model model) {

		ModelAndView mav = new ModelAndView("case_search");
		List<CaseRegistration> list = new ArrayList<CaseRegistration>();

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		
		
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
			 list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}

		

		 mav.addObject("list",list);
		 mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
		
		return mav;
	}

	@RequestMapping(value = "/last7dayshearing", method = RequestMethod.GET)
	public ModelAndView last7dayshearing(HttpServletRequest request, Model model) {

		ModelAndView mav = new ModelAndView("case_search");
		List<CaseRegistration> list = new ArrayList<CaseRegistration>();
		
		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, -7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		
		
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
			 list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}

		

		mav.addObject("list", list);
		mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
	
		return mav;
	}
	
	@RequestMapping(value = "/last30dayshearing", method = RequestMethod.GET)
	public ModelAndView last30dayshearing(HttpServletRequest request, Model model) {

		ModelAndView mav = new ModelAndView("case_search");
		List<CaseRegistration> list = new ArrayList<CaseRegistration>();
		
		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, -30);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());
		

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
			 list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;
		}case 2:{
			list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1,sqlDate2);
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("zoneFlag",true);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 3:{
        	list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circleList", mCircleRepository.findCircleByzoneId(LoginUser.getZoneId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", true);
			mav.addObject("divisionFlag", true);
			break;	
        }case 4:{
        	list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("divisionList",mDivisionRepository.findDivisionByCircleId(LoginUser.getCircleId().getId()));
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", true);
			break;	
        }case 5:{
        	list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1,sqlDate2,LoginUser.getZoneId().getId(),LoginUser.getCircleId().getId(),LoginUser.getDivisionId().getId());
        	mav.addObject("zone", LoginUser.getZoneId());
        	mav.addObject("circle",LoginUser.getCircleId());
        	mav.addObject("division",LoginUser.getDivisionId());
        	mav.addObject("zoneFlag",false);
			mav.addObject("circleFlag", false);
			mav.addObject("divisionFlag", false);
			break;	
        }default:{
		
        	break;
		}
		}

		

		mav.addObject("list", list);
		mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
	
		return mav;
	}

	@RequestMapping(value = "/case_registration", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView("case_detail");

		if (request.getParameter("id") != null) {
			Integer caseId = Integer.parseInt(request.getParameter("id"));
			mav.addObject("caseRegistration", caseRegistrationRepository.findByCaseId(caseId));
		} else {
			mav.addObject("caseRegistration", new CaseRegistration());
		}
		mav.addObject("courtList", mCourtNameRepository.findAll());
		mav.addObject("caseTypeList", mCaseTypeRepository.findAll());
		mav.addObject("zoneList", mZoneRepository.findAll());
		mav.addObject("oicList", userRepository.findAll());
		mav.addObject("zoneList", mZoneRepository.findAll());
		mav.addObject("circleList", mCircleRepository.findAll());
		mav.addObject("divisionList", mDivisionRepository.findAll());

		return mav;
	}

	@RequestMapping(value = "/save_case_registration", method = RequestMethod.POST)
	public ModelAndView register_user(HttpServletRequest request,
			@Valid @ModelAttribute("caseRegistration") CaseRegistration cr, BindingResult result, HttpSession session) {

		try {			

			for (PetitionerName pt : cr.getPetitionerNames()) {
				pt.setCaseId(cr);
			}
			for (DefendantName df : cr.getDefendantNames()) {
				df.setCaseId(cr);
			}

			List<CaseAttachment> caseAttachments= cr.getCaseAttachments();
			for (int i = 0; i < caseAttachments.size(); i++) {
				caseAttachments.get(i).setCaseId(cr);
				caseAttachments.get(i).setDeleted(false);		
				if (caseAttachments.get(i).getFileAttachment() != null	&& !caseAttachments.get(i).getFileAttachment().isEmpty()) {
					caseAttachments.get(i).setPath(FTPUtil.uplo(caseAttachments.get(i).getFileAttachment(), UPLOAD_PATH_CASE_ATTACHMENTS));
				}else {
					caseAttachments.remove(i);
				}		
			}
			
			
			
			User LoginUser = (User) request.getSession().getAttribute("loginUser");
			cr.setCreatedDate(new Date());
			cr.setUpdatedDate(new Date());
			cr.setCreatedBy(LoginUser.getId());
			cr.setUpdatedBy(LoginUser.getId());
			
			cr = caseRegistrationRepository.save(cr);

			ResponsHearingDateOld rhdo = new ResponsHearingDateOld(cr.getResponsHearingDateId().getResponsDate(),
					cr.getResponsHearingDateId().getHearingDate(), cr.getId(), cr.getUpdatedDate());

			rhdo = responsHearingDateRepositoryOld.save(rhdo);

		} catch (Exception ex) {

			ex.printStackTrace();
			return new ModelAndView("redirect:/case_search?error=Not registered please retry later....");

		}
		return new ModelAndView("redirect:/case_search?success=Successfully registered please login....");
	}
	//
	//
	//
	// // For Log-Out
	// @RequestMapping(value = "/logout")
	// public String doLogout(HttpSession session) {
	// session.invalidate();
	// return "redirect:/";
	// }

}
