package com.example.XLSReading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pincodedetails")
public class PinCodeEntity {
	@Id
    @GeneratedValue
    private int id;
	
	private String pinCode;
	
	private String city;
	
	private String division;
	

	private String region;
	
	private String taluk;
	
	private String district;
	
	private String state;
	
	private String stateAddr;
	
	private int isEligible;
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateAddr() {
		return stateAddr;
	}

	public void setStateAddr(String stateAddr) {
		this.stateAddr = stateAddr;
	}

	public int getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(int isEligible) {
		this.isEligible = isEligible;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	
}
