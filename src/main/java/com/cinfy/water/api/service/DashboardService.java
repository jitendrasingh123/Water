package com.cinfy.water.api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinfy.water.model.User;
import com.cinfy.water.model.common.DashboardPayload;
import com.cinfy.water.model.repositories.CaseRegistrationRepository;
import com.cinfy.water.model.repositories.UserRepository;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;

@Service
public class DashboardService {

	public static final Logger logger = LoggerFactory.getLogger(DashboardService.class);

	private static final int ERROR_CODE_CLASS = 1600;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	CaseRegistrationRepository caseRegistrationRepository;

	@Transactional
	public GenericResponse findById(Integer id) {
		GenericResponse response = new GenericResponse();
		response.setStatus(0);

		DashboardPayload dashboardPayload = new DashboardPayload();

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

		try {

			User user = this.userRepository.findById(id);

			if (user != null) {

				Integer deptType = 0;

				if (user.getZoneId() == null && user.getCircleId() == null && user.getDivisionId() == null
						&& user.getLavelId().getId() == 1 && user.getRole().getId() == 1) {
					deptType = 1;
				} else if (user.getZoneId() == null && user.getCircleId() == null && user.getDivisionId() == null
						&& user.getLavelId().getId() == 2 && user.getRole().getId() == 2) {
					deptType = 2;
				} else if (user.getZoneId() != null && user.getCircleId() == null && user.getDivisionId() == null
						&& user.getLavelId().getId() == 3 && user.getRole().getId() == 2) {
					deptType = 3;
				} else if (user.getZoneId() != null && user.getCircleId() != null && user.getDivisionId() == null
						&& user.getLavelId().getId() == 4 && user.getRole().getId() == 2) {
					deptType = 4;
				} else if (user.getZoneId() != null && user.getCircleId() != null && user.getDivisionId() != null
						&& user.getLavelId().getId() == 5 && user.getRole().getId() == 2) {
					deptType = 5;
				}

				switch (deptType) {
				case 1: {
					dashboardPayload.setNextSevenDaysCount(
							caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2));
					dashboardPayload.setLastSevenDaysCount(
							caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2));
					dashboardPayload.setLastThirtyDaysCount(
							caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2));
					dashboardPayload.setTotalCasesPendingCount(caseRegistrationRepository.findCountTotalCasesPending());
					break;
				}
				case 2: {
					dashboardPayload.setNextSevenDaysCount(
							caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2));
					dashboardPayload.setLastSevenDaysCount(
							caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2));
					dashboardPayload.setLastThirtyDaysCount(
							caseRegistrationRepository.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2));
					dashboardPayload.setTotalCasesPendingCount(caseRegistrationRepository.findCountTotalCasesPending());
					break;
				}
				case 3: {
					dashboardPayload.setNextSevenDaysCountList(caseRegistrationRepository
							.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2, user.getZoneId().getId()));
					dashboardPayload.setLastSevenDaysCountList(caseRegistrationRepository
							.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2, user.getZoneId().getId()));
					dashboardPayload.setLastThirtyDaysCount(caseRegistrationRepository
							.findByCountLast30DayHearingDate(sqlDate1, last30DaysqlDate2, user.getZoneId().getId()));
					dashboardPayload.setTotalCasesPendingCount(
							caseRegistrationRepository.findCountTotalCasesPending(user.getZoneId().getId()));
					break;
				}
				case 4: {
					dashboardPayload.setNextSevenDaysCountList(
							caseRegistrationRepository.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2,
									user.getZoneId().getId(), user.getCircleId().getId()));
					dashboardPayload.setLastSevenDaysCountList(
							caseRegistrationRepository.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2,
									user.getZoneId().getId(), user.getCircleId().getId()));
					dashboardPayload.setLastThirtyDaysCount(caseRegistrationRepository.findByCountLast30DayHearingDate(
							sqlDate1, last30DaysqlDate2, user.getZoneId().getId(), user.getCircleId().getId()));
					dashboardPayload.setTotalCasesPendingCount(caseRegistrationRepository
							.findCountTotalCasesPending(user.getZoneId().getId(), user.getCircleId().getId()));
					break;
				}
				case 5: {
					dashboardPayload.setNextSevenDaysCountList(caseRegistrationRepository
							.findByCountNext7DayHearingDate(sqlDate1, next7DayssqlDate2, user.getZoneId().getId(),
									user.getCircleId().getId(), user.getDivisionId().getId()));
					dashboardPayload.setLastSevenDaysCountList(caseRegistrationRepository
							.findByCountLast7DayHearingDate(sqlDate1, last7DaysqlDate2, user.getZoneId().getId(),
									user.getCircleId().getId(), user.getDivisionId().getId()));
					dashboardPayload.setLastThirtyDaysCount(caseRegistrationRepository.findByCountLast30DayHearingDate(
							sqlDate1, last30DaysqlDate2, user.getZoneId().getId(), user.getCircleId().getId(),
							user.getDivisionId().getId()));
					dashboardPayload.setTotalCasesPendingCount(caseRegistrationRepository.findCountTotalCasesPending(
							user.getZoneId().getId(), user.getCircleId().getId(), user.getDivisionId().getId()));
					break;
				}
				default: {
					break;
				}
				}

				Map<Object, Object> mapPie = null;
				List<Map<Object, Object>> listPie = new ArrayList<Map<Object, Object>>();
				List<Map<Object, Object>> dataPointsPie = new ArrayList<Map<Object, Object>>();
				mapPie = new HashMap<Object, Object>();
				mapPie.put("name", "Pending");
				mapPie.put("y", 21);
				dataPointsPie.add(mapPie);
				mapPie = new HashMap<Object, Object>();
				mapPie.put("name", "Last 7 days");
				mapPie.put("y", 14);
				dataPointsPie.add(mapPie);
				mapPie = new HashMap<Object, Object>();
				mapPie.put("name", "Updated");
				mapPie.put("y", 14);
				dataPointsPie.add(mapPie);
				mapPie = new HashMap<Object, Object>();
				mapPie.put("name", "Next 7 days");
				mapPie.put("y", 29);
				dataPointsPie.add(mapPie);
				mapPie = new HashMap<Object, Object>();
				mapPie.put("name", "My Cases");
				mapPie.put("y", 22);
				dataPointsPie.add(mapPie);
				listPie.addAll(dataPointsPie);
				dashboardPayload.setPieChartDataPointsList(listPie);
				//mav.addObject("dataPointsListPie", listPie);

				Map<Object, Object> mapBar = null;
				List<List<Map<Object, Object>>> listBar = new ArrayList<List<Map<Object, Object>>>();
				List<Map<Object, Object>> dataPointsBar = new ArrayList<Map<Object, Object>>();

				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1167589800000L);
				mapBar.put("y", 188);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1199125800000L);
				mapBar.put("y", 213);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1230748200000L);
				mapBar.put("y", 213);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1262284200000L);
				mapBar.put("y", 219);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1293820200000L);
				mapBar.put("y", 207);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1325356200000L);
				mapBar.put("y", 167);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1356978600000L);
				mapBar.put("y", 136);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1388514600000L);
				mapBar.put("y", 152);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1420050600000L);
				mapBar.put("y", 129);
				dataPointsBar.add(mapBar);
				mapBar = new HashMap<Object, Object>();
				mapBar.put("x", 1451586600000L);
				mapBar.put("y", 155);
				dataPointsBar.add(mapBar);

				listBar.add(dataPointsBar);
				dashboardPayload.setBarChartDataPointsList(listBar);
				//mav.addObject("dataPointsListBar", listBar);

				Map<Object, Object> mapLine = null;
				List<List<Map<Object, Object>>> listLine = new ArrayList<List<Map<Object, Object>>>();
				List<Map<Object, Object>> dataPointsLine = new ArrayList<Map<Object, Object>>();

				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1483209000000L);
				mapLine.put("y", 7);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1485887400000L);
				mapLine.put("y", 6);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1488306600000L);
				mapLine.put("y", 6);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1490985000000L);
				mapLine.put("y", 9);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1493577000000L);
				mapLine.put("y", 11);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1496255400000L);
				mapLine.put("y", 14);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1498847400000L);
				mapLine.put("y", 17);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1501525800000L);
				mapLine.put("y", 18);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1504204200000L);
				mapLine.put("y", 17);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1506796200000L);
				mapLine.put("y", 15);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1509474600000L);
				mapLine.put("y", 12);
				dataPointsLine.add(mapLine);
				mapLine = new HashMap<Object, Object>();
				mapLine.put("x", 1512066600000L);
				mapLine.put("y", 9);
				dataPointsLine.add(mapLine);

				listLine.add(dataPointsLine);
				dashboardPayload.setLineChartDataPointsList(listLine);
				//mav.addObject("dataPointsListLine", listLine);

				response.setData(dashboardPayload);
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

}
