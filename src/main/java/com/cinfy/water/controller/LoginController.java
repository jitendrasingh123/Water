package com.cinfy.water.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.Login;
import com.cinfy.water.model.User;
import com.cinfy.water.model.repositories.LoginRepository;
import com.cinfy.water.model.repositories.MCircleRepository;
import com.cinfy.water.model.repositories.MDesignationRepository;
import com.cinfy.water.model.repositories.MDivisionRepository;
import com.cinfy.water.model.repositories.MRoleRepository;
import com.cinfy.water.model.repositories.MStateRepository;
import com.cinfy.water.model.repositories.MUserLevelRepository;
import com.cinfy.water.model.repositories.MZoneRepository;
import com.cinfy.water.model.repositories.SystemAdminTypeRepository;
import com.cinfy.water.model.repositories.UserRepository;
import com.cinfy.water.utils.FTPUtil;
import com.cinfy.water.utils.InvoiceConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	static String emailSubject, emailMessage;
	static final String emailFromRecipient = "sender@dpsplfranchisero.org";

	@Autowired
	private JavaMailSender mailSenderObj;

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

	@Value("${UPLOAD_PATH_PROFILE_IMAGE}")
	private String UPLOAD_PATH_PROFILE_IMAGE;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("login") Login login, BindingResult result,
			HttpSession session) {

		try {

			String securePassword = Base64.getEncoder().encodeToString(login.getPassword().getBytes("utf-8"));
			User loggedInUser = loginRepository.findByPasswordAndEmailOrMobileAllIgnoreCase(securePassword,
					login.getUserId(), login.getMobile());

			int lang = 1;

			if (loggedInUser != null) {
				session.setAttribute("loginUser", loggedInUser);

				session.setAttribute("language", lang);

				return new ModelAndView("redirect:/index");

			} else {
				return new ModelAndView("redirect:/login?error=Invalid UserId Or Password. Please try again...");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("redirect:/login?error=Error in login please try after some time...");
		}
	}

	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public ModelAndView user_list(HttpServletRequest request, Model model) {
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		if (LoginUser.getRole().getId() == 1) {
			ModelAndView mav = new ModelAndView("user_list");
			mav.addObject("userList", userRepository.findAllUser());
			mav.addObject("zoneList", mZoneRepository.findAll());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new Login());
			return mav;
		}

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView create_user_new(HttpServletRequest request) throws Exception {
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		if (LoginUser.getRole().getId() == 1) {
			ModelAndView mav = new ModelAndView("new_user");
			User user = null;
			if (request.getParameter("id") != null) {
				Integer userId = Integer.parseInt(request.getParameter("id"));
				try {
					if (userId != null) {
						user = userRepository.findById(userId);
						String securePassword = new String(
								Base64.getDecoder().decode(user.getPassword().getBytes(InvoiceConstants.UTF8)));
						user.setPassword(securePassword);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				mav.addObject("userRegistration", userRepository.findById(userId));
				mav.addObject("divisionList", mDivisionRepository.findAll());
				mav.addObject("circleList", mCircleRepository.findAll());
			} else {
				mav.addObject("userRegistration", new User());
			}

			mav.addObject("statesList", mStateRepository.findOne(17));
			mav.addObject("zoneList", mZoneRepository.findAll());
			mav.addObject("designationList", mDesignationRepository.findAll());
			mav.addObject("roleList", mRoleRepository.findAll());
			mav.addObject("parentList", userRepository.findAll());
			mav.addObject("levelList", mUserLevelRepository.findAll());
			mav.addObject("sysAdminTypeList", systemAdminTypeRepository.findAll());

			String message = request.getParameter("message");
			mav.addObject("message", message);

			return mav;
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new Login());
			return mav;
		}
	}

	@RequestMapping(value = "/save_registration", method = RequestMethod.POST)
	public ModelAndView register_user(HttpServletRequest request, @Valid @ModelAttribute("userRegistration") User user,
			BindingResult result, HttpSession session) {
		String message = "";
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		if (LoginUser.getRole().getId() == 1) {

		try {
		
			String securePassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes("utf-8"));
			user.setPassword(securePassword);

			if (user.getZoneId().getId() == null) {
				user.setZoneId(null);
			}
			if (user.getCircleId().getId() == null) {
				user.setCircleId(null);
			}
			if (user.getDivisionId().getId() == null) {
				user.setDivisionId(null);
			}

			if (user.getId() != null) {
				user.setUpdatedDate(new Date());
				user.setUpdatedBy(LoginUser.getId());
				message = "User updated successfully..";
			} else {
				user.setCreatedDate(new Date());
				user.setUpdatedDate(new Date());
				user.setCreatedBy(LoginUser.getId());
				user.setUpdatedBy(LoginUser.getId());
				message = "User created successfully..";
			}

			if (user.getFileAttachment() != null && !user.getFileAttachment().isEmpty()) {
				user.setPath(FTPUtil.uplo(user.getFileAttachment(), UPLOAD_PATH_PROFILE_IMAGE));
			}
			user.setDeleted(false);
			loginRepository.save(user);

			// mailSenderObj.send(new MimeMessagePreparator() {
			// public void prepare(MimeMessage mimeMessage) throws Exception {
			//
			// MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true,
			// "UTF-8");
			// mimeMsgHelperObj.setFrom(emailFromRecipient);
			// mimeMsgHelperObj.setTo(user.getUserId());
			// mimeMsgHelperObj.setText("Hi " + user.getUserName()
			// + ",\nThanks for registration with Jal Nigam. \n You Have Successfully
			// registered for login.\n please login with \n user Id : "
			// + user.getUserId() + "\n Password : "
			// + new String(Base64.getDecoder().decode(user.getPassword()), "utf-8")
			// + "\n\n\nThanks And Regards \n Jal Nigam ");
			// mimeMsgHelperObj.setSubject("Jal Nigam Registration Success....");
			//
			// }
			// });

		} catch (Exception ex) {

			ex.printStackTrace();
			return new ModelAndView("redirect:/index?error=Not registered please retry later....");

		}
		return new ModelAndView("redirect:/signup?message=" + message);
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new Login());
			return mav;
		}
	}

	@RequestMapping(value = "/user_search_filter", method = RequestMethod.POST)
	public ModelAndView case_search_filter(@RequestParam(value = "zoneId", required = false) Integer zoneId,
			@RequestParam(value = "circleId", required = false) Integer circleId,
			@RequestParam(value = "divisionId", required = false) Integer divisionId, HttpServletRequest request,
			Model model) {
		User LoginUser = (User) request.getSession().getAttribute("loginUser");
		if (LoginUser.getRole().getId() == 1) {
		ModelAndView mav = new ModelAndView("user_list");
		List<User> list = new ArrayList<User>();

		if (zoneId != null && circleId != null && divisionId != null) {
			list = userRepository.findByZoneCircleDivision(zoneId, circleId, divisionId);
		} else if (zoneId != null && circleId != null) {
			list = userRepository.findByZoneCircle(zoneId, circleId);
		} else if (zoneId != null) {
			list = userRepository.findByZone(zoneId);
		} else {
			list = userRepository.findAllUser();
		}

		mav.addObject("userList", list);
		mav.addObject("zoneList", mZoneRepository.findAll());
		return mav;
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new Login());
			return mav;
		}
	}

	// For Log-Out
	@RequestMapping(value = "/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
