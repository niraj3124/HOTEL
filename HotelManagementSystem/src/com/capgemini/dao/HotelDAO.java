package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.capgemini.bean.HotelBean;
import com.capgemini.dbutil.DBUtil;
import com.capgemini.dbutil.IQueryMapper;
import com.capgemini.exception.HotelBookingException;

public class HotelDAO implements IHotelDAO
{

	@Override
	public int addHotel(HotelBean hotelBean) throws HotelBookingException {
		Connection connection = null;
		int hotelStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.HOTEL_INSERT_QUERY);
			preparedStatement.setString(1, hotelBean.getCity());
			preparedStatement.setString(2, hotelBean.getHotelName());
			preparedStatement.setString(3, hotelBean.getAddress());
			preparedStatement.setString(4, hotelBean.getDescription());
			preparedStatement.setDouble(5, hotelBean.getAvgRatePerNight());
			preparedStatement.setString(6, hotelBean.getPhoneNo1());
			preparedStatement.setString(7, hotelBean.getPhoneNo2());
			preparedStatement.setFloat(8, hotelBean.getRating());
			preparedStatement.setString(9, hotelBean.getEmail());
			preparedStatement.setString(10, hotelBean.getFax());

			hotelStatus = preparedStatement.executeUpdate();

			preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_ID_QUERY_SEQUENCE);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				hotelBean.setHotelId(id);
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelStatus;
	}

	@Override
	public ArrayList<HotelBean> viewHotel(int hotelId) {

		return null;
	}

	@Override
	public int modifyHotel(HotelBean hotelBean) throws HotelBookingException {
		Connection connection = null;
		int hotelStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_UPDATE_QUERY);
			preparedStatement.setString(1, hotelBean.getCity());
			preparedStatement.setString(2, hotelBean.getHotelName());
			preparedStatement.setString(3, hotelBean.getAddress());
			preparedStatement.setString(4, hotelBean.getDescription());
			preparedStatement.setDouble(5, hotelBean.getAvgRatePerNight());
			preparedStatement.setString(6, hotelBean.getPhoneNo1());
			preparedStatement.setString(7, hotelBean.getPhoneNo2());
			preparedStatement.setFloat(8, hotelBean.getRating());
			preparedStatement.setString(9, hotelBean.getEmail());
			preparedStatement.setString(10, hotelBean.getFax());
			preparedStatement.setInt(11, hotelBean.getHotelId());

			hotelStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelStatus;
	}

	@Override
	public int deleteHotel(int deleteHotelId) throws HotelBookingException {
		int hotelDeleteStatus = 0;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.HOTEL_DELETE_QUERY);
			preparedStatement.setInt(1, deleteHotelId);

			hotelDeleteStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelDeleteStatus;
	}

	@Override
	public int deleteHotelValidate(int deleteHotelId) throws HotelBookingException {
		int idDeleteStatus=0;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.HOTEL_DELETE_VALIDATE_QUERY);
			preparedStatement.setInt(1, deleteHotelId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				idDeleteStatus=resultSet.getInt(1);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return idDeleteStatus;
	
	}

}
