package com.cinfy.water.api;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cinfy.water.api.service.AndroidPushNotificationsService;
import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.User;
import com.cinfy.water.model.repositories.CaseRegistrationRepository;

@Component
public class ScheduledTasks {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	CaseRegistrationRepository caseRegistrationRepository;
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduleTaskWithCronExpression() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<CaseRegistration> list = new ArrayList<CaseRegistration>();

		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate1 = new java.sql.Date(cal.getTimeInMillis());
		System.out.println(sqlDate1);
		cal.add(Calendar.DATE, +7);
		java.sql.Date sqlDate2 = new java.sql.Date(cal.getTimeInMillis());

		list = caseRegistrationRepository.findByNext7DayHearingDate(sqlDate1, sqlDate2);

		for (CaseRegistration caseRegistration : list) {
			if (caseRegistration.getOic() != null) {
				if (caseRegistration.getOic().getDeviceToken() != null
						&& !caseRegistration.getOic().getDeviceToken().isEmpty()) {
					String deviceToken = caseRegistration.getOic().getDeviceToken();
					try {
						String pushNotification = AndroidPushNotificationsService.sendOneByOnePushNotification("Hearing Date Message", deviceToken, "Hello Sir/Ma'am", "Test");

						System.out.println("androidPushNotificationsService work fine--" + pushNotification);
					} catch (IOException e) {
					}
				}
			}
		}

	}

}
