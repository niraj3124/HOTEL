package com.capgemini.service;

import java.util.ArrayList;

import com.capgemini.bean.HotelBean;
import com.capgemini.exception.HotelBookingException;

public interface IHotelService 
{

	///Case 1:Hotel

	boolean isValidRating(String ratingstr);

	boolean isValidCost(String avgRatePerNightStr);

	boolean isValidDescription(String description);

	boolean isValidFax(String fax);

	boolean isValidEmail(String hotelEmail);

	boolean isValidMobileNo(String phoneNo2);

	boolean isValidCity(String city);

	boolean isValidAddress(String hotelAddress);

	boolean isValidName(String hotelName);

	int addHotel(HotelBean hotelBean) throws HotelBookingException;

	ArrayList<HotelBean> viewHotel(int hotelId);

	int modifyHotel(HotelBean hotelBean) throws HotelBookingException;

	int deleteHotelValidate(int deleteHotelId) throws HotelBookingException;

	int deleteHotel(int deleteHotelId) throws HotelBookingException;

}
