package com.metahospital.datacollector.dao.config;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 2021/12/28.
 */
@Component
public class DepartmentConfigData {
	private int hospitalId;
	private int departmentId;
	private String departmentName;
	private List<Integer> examinationItemIds;

	public DepartmentConfigData() {
	}

	public DepartmentConfigData(int hospitalId, int departmentId, String departmentName, List<Integer> examinationItemIds) {
		this.hospitalId = hospitalId;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.examinationItemIds = examinationItemIds;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public List<Integer> getExaminationItemIds() {
		return examinationItemIds;
	}
}
