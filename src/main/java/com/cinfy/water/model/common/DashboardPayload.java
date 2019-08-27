package com.cinfy.water.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cinfy.water.model.CaseRegistration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardPayload {
	private Integer nextSevenDaysCount;
	private Integer lastSevenDaysCount;
	private Integer lastThirtyDaysCount;

	List<CaseRegistration> totalCasesPendingCount = new ArrayList<CaseRegistration>();
	List<CaseRegistration> nextSevenDaysCountList = new ArrayList<CaseRegistration>();
	List<CaseRegistration> lastSevenDaysCountList = new ArrayList<CaseRegistration>();

	List<Map<Object, Object>> pieChartDataPointsList = new ArrayList<Map<Object, Object>>();
	List<List<Map<Object, Object>>> barChartDataPointsList = new ArrayList<List<Map<Object, Object>>>();
	List<List<Map<Object, Object>>> lineChartDataPointsList = new ArrayList<List<Map<Object, Object>>>();

	public Integer getNextSevenDaysCount() {
		return nextSevenDaysCount;
	}

	public void setNextSevenDaysCount(Integer nextSevenDaysCount) {
		this.nextSevenDaysCount = nextSevenDaysCount;
	}

	public Integer getLastSevenDaysCount() {
		return lastSevenDaysCount;
	}

	public void setLastSevenDaysCount(Integer lastSevenDaysCount) {
		this.lastSevenDaysCount = lastSevenDaysCount;
	}

	public Integer getLastThirtyDaysCount() {
		return lastThirtyDaysCount;
	}

	public void setLastThirtyDaysCount(Integer lastThirtyDaysCount) {
		this.lastThirtyDaysCount = lastThirtyDaysCount;
	}

	public List<CaseRegistration> getTotalCasesPendingCount() {
		return totalCasesPendingCount;
	}

	public void setTotalCasesPendingCount(List<CaseRegistration> totalCasesPendingCount) {
		this.totalCasesPendingCount = totalCasesPendingCount;
	}

	public List<CaseRegistration> getNextSevenDaysCountList() {
		return nextSevenDaysCountList;
	}

	public void setNextSevenDaysCountList(List<CaseRegistration> nextSevenDaysCountList) {
		this.nextSevenDaysCountList = nextSevenDaysCountList;
	}

	public List<CaseRegistration> getLastSevenDaysCountList() {
		return lastSevenDaysCountList;
	}

	public void setLastSevenDaysCountList(List<CaseRegistration> lastSevenDaysCountList) {
		this.lastSevenDaysCountList = lastSevenDaysCountList;
	}

	public List<Map<Object, Object>> getPieChartDataPointsList() {
		return pieChartDataPointsList;
	}

	public void setPieChartDataPointsList(List<Map<Object, Object>> pieChartDataPointsList) {
		this.pieChartDataPointsList = pieChartDataPointsList;
	}

	public List<List<Map<Object, Object>>> getBarChartDataPointsList() {
		return barChartDataPointsList;
	}

	public void setBarChartDataPointsList(List<List<Map<Object, Object>>> barChartDataPointsList) {
		this.barChartDataPointsList = barChartDataPointsList;
	}

	public List<List<Map<Object, Object>>> getLineChartDataPointsList() {
		return lineChartDataPointsList;
	}

	public void setLineChartDataPointsList(List<List<Map<Object, Object>>> lineChartDataPointsList) {
		this.lineChartDataPointsList = lineChartDataPointsList;
	}

}
