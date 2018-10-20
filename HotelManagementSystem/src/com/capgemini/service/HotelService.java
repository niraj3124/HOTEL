package com.capgemini.service;



import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.HotelBean;
import com.capgemini.dao.HotelDAO;
import com.capgemini.dao.IHotelDAO;
import com.capgemini.exception.HotelBookingException;





public class HotelService implements IHotelService {
	IHotelDAO dao = new HotelDAO();
	@Override
	public boolean isValidRating(String ratingstr) {
		Pattern pattern = Pattern.compile("[0-5]{1}|[0-5]{1}.[0-9]{1}");
		Matcher matcher = pattern.matcher(ratingstr);

		return matcher.matches();
	}

	@Override
	public boolean isValidCost(String avgRatePerNightStr) {
		Pattern pattern = Pattern.compile("[0-9]{0,6}");
		Matcher matcher = pattern.matcher(avgRatePerNightStr);
		return matcher.matches();
	}

	@Override
	public boolean isValidDescription(String description) {
		Pattern pattern = Pattern.compile("[0-9A-Za-z, ]{2,50}");
		Matcher matcher = pattern.matcher(description);
		return matcher.matches();
	}

	@Override
	public boolean isValidFax(String fax) {
		Pattern pattern = Pattern.compile("[0-9]{1,3}-[0-9]{3}\\-[0-9]{7}");
		Matcher matcher = pattern.matcher(fax);

		return matcher.matches();
	}

	@Override
	public boolean isValidEmail(String hotelEmail) {
		Pattern pattern = Pattern
				.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
		Matcher matcher = pattern.matcher(hotelEmail);

		return matcher.matches();

	}

	@Override
	public boolean isValidMobileNo(String phoneNo2) {
		Pattern pattern = Pattern.compile("^[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(phoneNo2);

		return matcher.matches();
	}

	@Override
	public boolean isValidCity(String city) {
		Pattern pattern = Pattern.compile("[A-Za-z]{2,10}");
		Matcher matcher = pattern.matcher(city);
		return matcher.matches();
	}

	@Override
	public boolean isValidAddress(String hotelAddress) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9#, ]{5,100}");
		Matcher matcher = pattern.matcher(hotelAddress);

		return matcher.matches();
	}

	@Override
	public boolean isValidName(String hotelName) {
		Pattern pattern = Pattern.compile("[A-Za-z ]{2,}");
		Matcher matcher = pattern.matcher(hotelName);

		return matcher.matches();
	}
/*delete validation*/
	@Override
	public int deleteHotelValidate(int deleteHotelId) throws HotelBookingException {
		
		return dao.deleteHotelValidate(deleteHotelId);
	}


	/*****************************************************************************************************
	 * 
	 * Hotel Methods
	 * @throws HotelBookingException 
	 * 
	 *****************************************************************************************************/

	@Override
	public int addHotel(HotelBean hotelBean) throws HotelBookingException {
	


		return dao.addHotel(hotelBean);
	}

	@Override
	public ArrayList<HotelBean> viewHotel(int hotelId) {
		return dao.viewHotel(hotelId);
	}

	@Override
	public int modifyHotel(HotelBean hotelBean) throws HotelBookingException {
	
		return dao.modifyHotel(hotelBean);
	}

	

	@Override
	public int deleteHotel(int deleteHotelId) throws HotelBookingException {
		
		return dao.deleteHotel(deleteHotelId);
	}

}
