package com.cinfy.water.api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.MCaseType;
import com.cinfy.water.model.MCourtName;
import com.cinfy.water.model.User;
import com.cinfy.water.model.common.CaseRegistrationPayload;
import com.cinfy.water.model.common.MCaseTypePayload;
import com.cinfy.water.model.common.MCourtNamePayload;
import com.cinfy.water.model.mapper.CaseRegistrationMapper;
import com.cinfy.water.model.mapper.MCaseTypeMapper;
import com.cinfy.water.model.mapper.MCourtNameMapper;
import com.cinfy.water.model.repositories.CaseRegistrationRepository;
import com.cinfy.water.model.repositories.MCaseTypeRepository;
import com.cinfy.water.model.repositories.MCourtNameRepository;
import com.cinfy.water.model.repositories.UserRepository;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.utils.Messages;

@Service
public class CaseRegisterService {

	public static final Logger logger = LoggerFactory.getLogger(CaseRegisterService.class);

	private static final int ERROR_CODE_CLASS = 1600;

	@Autowired
	private CaseRegistrationRepository caseRegistrationRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private MCaseTypeRepository mCaseTypeRepository;

	@Autowired
	private MCourtNameRepository mCourtNameRepository;

	@Transactional
	public GenericResponse findById(Integer id) {
		GenericResponse response = new GenericResponse();
		response.setStatus(0);
		try {

			CaseRegistration caseRegistration = this.caseRegistrationRepository.getOne(id);

			if (caseRegistration != null) {

				CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
						.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

				response.setData(caseRegistrationPayload);
				response.setStatus(1);
			}
		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(
					new ErrorMessage(ERROR_CODE_CLASS, "Project Resource not found for the id", ex.getMessage()));
		}
		return response;
	}

	@Transactional
	public GenericResponse findCaseType() {
		GenericResponse response = new GenericResponse();
		// response.setStatus(0);
		List<MCaseTypePayload> result = null;
		List<MCaseType> caseTypeList = new ArrayList<MCaseType>();
		try {

			caseTypeList = this.mCaseTypeRepository.findAll();

			if (caseTypeList != null && !caseTypeList.isEmpty()) {
				result = new ArrayList<>();
				for (MCaseType caseType : caseTypeList) {

					MCaseTypePayload mCaseTypePayload = MCaseTypeMapper.INSTANCE
							.mCaseTypeEntityToMCaseTypePayload(caseType);

					result.add(mCaseTypePayload);
				}
			}
			response.setData(result);
			response.setStatus(1);
		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(
					new ErrorMessage(ERROR_CODE_CLASS, "Project Resource not found for the id", ex.getMessage()));
		}
		return response;
	}

	@Transactional
	public GenericResponse findCourtName() {
		GenericResponse response = new GenericResponse();
		// response.setStatus(0);
		List<MCourtNamePayload> result = null;
		List<MCourtName> courtNameList = new ArrayList<MCourtName>();
		try {

			courtNameList = this.mCourtNameRepository.findAll();

			if (courtNameList != null && !courtNameList.isEmpty()) {
				result = new ArrayList<>();
				for (MCourtName courtName : courtNameList) {

					MCourtNamePayload mCourtNamePayload = MCourtNameMapper.INSTANCE
							.mCourtNameEntityToMCourtNamePayload(courtName);

					result.add(mCourtNamePayload);
				}
			}
			response.setData(result);
			response.setStatus(1);
		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(
					new ErrorMessage(ERROR_CODE_CLASS, "Project Resource not found for the id", ex.getMessage()));
		}
		return response;
	}

	public GenericResponse getCaseRegistrationList(Map<String, Object> params) {
		// TODO Need to implement Pagination
		logger.info("Getting the list of details ....Case Registration Services");
		List<CaseRegistrationPayload> result = null;
		GenericResponse response = new GenericResponse();
		response.setStatus(1);
		try {
			Integer loginUserId = (Integer) params.get("loginUserId");

			User LoginUser = userRepository.findById(loginUserId);
			if (LoginUser != null) {

				Integer caseNo = (Integer) params.get("caseNo");
				Integer courtId = (Integer) params.get("courtId");
				Integer zoneId = (Integer) params.get("zoneId");
				Integer circleId = (Integer) params.get("circleId");
				Integer divisionId = (Integer) params.get("divisionId");
				Integer caseTypeId = (Integer) params.get("caseTypeId");
				Integer caseYear = (Integer) params.get("caseYear");

				String fromDateHearing = params.get("fromDateHearing") != null
						? params.get("fromDateHearing").toString().trim()
						: "";
				String toDateHearing = params.get("toDateHearing") != null
						? params.get("toDateHearing").toString().trim()
						: "";

				List<CaseRegistration> list = new ArrayList<CaseRegistration>();

				if (zoneId != null && circleId != null && divisionId != null && !fromDateHearing.equals("")
						&& !toDateHearing.equals("")) {
					list = caseRegistrationRepository.findByZoneCircleDivisionHearingDate(zoneId, circleId, divisionId,
							java.sql.Date.valueOf(fromDateHearing), java.sql.Date.valueOf(toDateHearing));
				} else if (zoneId != null && circleId != null && divisionId != null) {
					list = caseRegistrationRepository.findByZoneCircleDivision(zoneId, circleId, divisionId);
				} else if (zoneId != null && circleId != null && !fromDateHearing.equals("")
						&& !toDateHearing.equals("")) {
					list = caseRegistrationRepository.findByZoneCircleHearingDate(zoneId, circleId,
							java.sql.Date.valueOf(fromDateHearing), java.sql.Date.valueOf(toDateHearing));
				} else if (zoneId != null && circleId != null) {
					list = caseRegistrationRepository.findByZoneCircle(zoneId, circleId);
				} else if (zoneId != null && !fromDateHearing.equals("") && !toDateHearing.equals("")) {
					list = caseRegistrationRepository.findByZoneHearingDate(zoneId,
							java.sql.Date.valueOf(fromDateHearing), java.sql.Date.valueOf(toDateHearing));
				} else if (!fromDateHearing.equals("") && !toDateHearing.equals("")) {
					list = caseRegistrationRepository.findByHearingDate(java.sql.Date.valueOf(fromDateHearing),
							java.sql.Date.valueOf(toDateHearing));
				} else if (zoneId != null) {
					list = caseRegistrationRepository.findByZone(zoneId);
				} else if (courtId != null) {
					list = caseRegistrationRepository.findByCourtId(courtId);
				}

				Integer deptType = 0;

				if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 1
						&& LoginUser.getRole().getId() == 1) {
					deptType = 1;
				} else if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 2
						&& LoginUser.getRole().getId() == 2) {
					deptType = 2;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 3
						&& LoginUser.getRole().getId() == 2) {
					deptType = 3;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 4
						&& LoginUser.getRole().getId() == 2) {
					deptType = 4;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() != null && LoginUser.getLavelId().getId() == 5
						&& LoginUser.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					if (caseTypeId != null && caseNo != null && caseYear != null) {
						list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear);
					}

					break;
				}
				case 2: {
					if (caseTypeId != null && caseNo != null && caseYear != null) {
						list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear);
					}

					break;
				}
				case 3: {
					if (caseTypeId != null && caseNo != null && caseYear != null) {
						list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,
								LoginUser.getZoneId().getId());
					}

					break;
				}
				case 4: {
					if (caseTypeId != null && caseNo != null && caseYear != null) {
						list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,
								LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId());
					}

					break;
				}
				case 5: {
					if (caseTypeId != null && caseNo != null && caseYear != null) {
						list = caseRegistrationRepository.findByCaseTypeIdCaseNoYear(caseTypeId, caseNo, caseYear,
								LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId(),
								LoginUser.getDivisionId().getId());
					}

					break;
				}
				default: {

					break;
				}
				}

				if (list != null && !list.isEmpty()) {
					result = new ArrayList<>();
					for (CaseRegistration caseRegistration : list) {

						CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
								.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

						result.add(caseRegistrationPayload);
					}
				}
				response.setData(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;
	}

	public GenericResponse findByUserIdForTotalCasePending(Integer userId) {
		// TODO Need to implement Pagination
		logger.info("Getting the list of details ....Case Registration Services total case pending");
		List<CaseRegistrationPayload> result = null;
		GenericResponse response = new GenericResponse();
		response.setStatus(1);
		try {
			User LoginUser = userRepository.findById(userId);
			if (LoginUser != null) {

				List<CaseRegistration> list = new ArrayList<CaseRegistration>();

				Integer deptType = 0;

				if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 1
						&& LoginUser.getRole().getId() == 1) {
					deptType = 1;
				} else if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 2
						&& LoginUser.getRole().getId() == 2) {
					deptType = 2;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 3
						&& LoginUser.getRole().getId() == 2) {
					deptType = 3;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 4
						&& LoginUser.getRole().getId() == 2) {
					deptType = 4;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() != null && LoginUser.getLavelId().getId() == 5
						&& LoginUser.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					list = caseRegistrationRepository.findTotalCasesPending();
					break;
				}
				case 2: {
					list = caseRegistrationRepository.findTotalCasesPending();
					break;
				}
				case 3: {
					list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId());
					break;
				}
				case 4: {
					list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId(),
							LoginUser.getCircleId().getId());
					break;
				}
				case 5: {
					list = caseRegistrationRepository.findTotalCasesPending(LoginUser.getZoneId().getId(),
							LoginUser.getCircleId().getId(), LoginUser.getDivisionId().getId());
					break;
				}
				default: {
					break;
				}
				}

				if (list != null && !list.isEmpty()) {
					result = new ArrayList<>();
					for (CaseRegistration caseRegistration : list) {

						CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
								.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

						result.add(caseRegistrationPayload);
					}
				}
				response.setData(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;
	}

	public GenericResponse findByUserIdForNext7DaysHearing(Integer userId) {
		// TODO Need to implement Pagination
		logger.info("Getting the list of details ....Case Registration Services Next 7 days");
		List<CaseRegistrationPayload> result = null;
		GenericResponse response = new GenericResponse();
		response.setStatus(1);

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());

		try {
			User LoginUser = userRepository.findById(userId);
			if (LoginUser != null) {

				List<CaseRegistration> list = new ArrayList<CaseRegistration>();

				Integer deptType = 0;

				if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 1
						&& LoginUser.getRole().getId() == 1) {
					deptType = 1;
				} else if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 2
						&& LoginUser.getRole().getId() == 2) {
					deptType = 2;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 3
						&& LoginUser.getRole().getId() == 2) {
					deptType = 3;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 4
						&& LoginUser.getRole().getId() == 2) {
					deptType = 4;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() != null && LoginUser.getLavelId().getId() == 5
						&& LoginUser.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 2: {
					list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 3: {
					list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId());
					break;
				}
				case 4: {
					list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId());
					break;
				}
				case 5: {
					list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId(),
							LoginUser.getDivisionId().getId());
					break;
				}
				default: {

					break;
				}
				}

				if (list != null && !list.isEmpty()) {
					result = new ArrayList<>();
					for (CaseRegistration caseRegistration : list) {

						CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
								.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

						result.add(caseRegistrationPayload);
					}
				}
				response.setData(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;
	}

	public GenericResponse findByUserIdForLast7DaysHearing(Integer userId) {
		// TODO Need to implement Pagination
		logger.info("Getting the list of details ....Case Registration Services Last 7 Days Hearing");
		List<CaseRegistrationPayload> result = null;
		GenericResponse response = new GenericResponse();
		response.setStatus(1);

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());

		try {
			User LoginUser = userRepository.findById(userId);
			if (LoginUser != null) {

				List<CaseRegistration> list = new ArrayList<CaseRegistration>();

				Integer deptType = 0;

				if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 1
						&& LoginUser.getRole().getId() == 1) {
					deptType = 1;
				} else if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 2
						&& LoginUser.getRole().getId() == 2) {
					deptType = 2;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 3
						&& LoginUser.getRole().getId() == 2) {
					deptType = 3;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 4
						&& LoginUser.getRole().getId() == 2) {
					deptType = 4;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() != null && LoginUser.getLavelId().getId() == 5
						&& LoginUser.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 2: {
					list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 3: {
					list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId());
					break;
				}
				case 4: {
					list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId());
					break;
				}
				case 5: {
					list = caseRegistrationRepository.findByLast7DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId(),
							LoginUser.getDivisionId().getId());
					break;
				}
				default: {
					break;
				}
				}

				if (list != null && !list.isEmpty()) {
					result = new ArrayList<>();
					for (CaseRegistration caseRegistration : list) {

						CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
								.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

						result.add(caseRegistrationPayload);
					}
				}
				response.setData(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;
	}

	public GenericResponse findByUserIdForLast30DaysHearing(Integer userId) {
		// TODO Need to implement Pagination
		logger.info("Getting the list of details ....Case Registration Services Last 30 Days Hearing");
		List<CaseRegistrationPayload> result = null;
		GenericResponse response = new GenericResponse();
		response.setStatus(1);

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());

		try {
			User LoginUser = userRepository.findById(userId);
			if (LoginUser != null) {

				List<CaseRegistration> list = new ArrayList<CaseRegistration>();

				Integer deptType = 0;

				if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 1
						&& LoginUser.getRole().getId() == 1) {
					deptType = 1;
				} else if (LoginUser.getZoneId() == null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 2
						&& LoginUser.getRole().getId() == 2) {
					deptType = 2;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() == null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 3
						&& LoginUser.getRole().getId() == 2) {
					deptType = 3;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() == null && LoginUser.getLavelId().getId() == 4
						&& LoginUser.getRole().getId() == 2) {
					deptType = 4;
				} else if (LoginUser.getZoneId() != null && LoginUser.getCircleId() != null
						&& LoginUser.getDivisionId() != null && LoginUser.getLavelId().getId() == 5
						&& LoginUser.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 2: {
					list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1, sqlDate2);
					break;
				}
				case 3: {
					list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId());
					break;
				}
				case 4: {
					list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId());
					break;
				}
				case 5: {
					list = caseRegistrationRepository.findByLast30DayHearingDate(sqlDate1, sqlDate2,
							LoginUser.getZoneId().getId(), LoginUser.getCircleId().getId(),
							LoginUser.getDivisionId().getId());
					break;
				}
				default: {
					break;
				}
				}

				if (list != null && !list.isEmpty()) {
					result = new ArrayList<>();
					for (CaseRegistration caseRegistration : list) {

						CaseRegistrationPayload caseRegistrationPayload = CaseRegistrationMapper.INSTANCE
								.caseRegistrationEntityToCaseRegistrationPayload(caseRegistration);

						result.add(caseRegistrationPayload);
					}
				}
				response.setData(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;
	}

}
