package com.capgemini.dao;

import java.util.ArrayList;

import com.capgemini.bean.HotelBean;
import com.capgemini.exception.HotelBookingException;

public interface IHotelDAO {

	int addHotel(HotelBean hotelBean) throws HotelBookingException;

	ArrayList<HotelBean> viewHotel(int hotelId);

	int modifyHotel(HotelBean hotelBean) throws HotelBookingException;

	int deleteHotel(int deleteHotelId) throws HotelBookingException;

	int deleteHotelValidate(int deleteHotelId) throws HotelBookingException;

}
