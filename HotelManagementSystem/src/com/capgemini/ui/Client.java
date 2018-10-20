package com.capgemini.ui;

import java.util.ArrayList;
import java.util.Scanner;










import com.capgemini.bean.HotelBean;
import com.capgemini.bean.RoomDetailsBean;
import com.capgemini.dbutil.IMsgMapper;
import com.capgemini.exception.HotelBookingException;
import com.capgemini.service.HotelService;
import com.capgemini.service.IHotelService;


public class Client 
{
	static Scanner scanner = new Scanner(System.in);
	IHotelService service= new HotelService();
	static char ch;
	static RoomDetailsBean room = new RoomDetailsBean();
	public static void main(String[] args) throws HotelBookingException 
	{


		System.out.println("---------Hotel Booking Management System------------- ");
		System.out.println("*******Welcome Admin*******");
		/**************************************************************************************
		 * Admin Login
		 **************************************************************************************/
		System.out.println("Enter Admin Id: ");
		String	adminid=scanner.next();
		System.out.println("Enter Admin Password: ");
		String	adminpasswd=scanner.next();
		System.out.println();
		if(adminid.equals("admin")&&adminpasswd.equals("admin"))
		{

			System.out.println("Admin Login Successfull!!!!");

			/*********************************************************************************
			 * Admin Functions
			 *********************************************************************************/

			System.out.println("1.Perform Hotel Management\n2.Perform Room Management\n3.Generate various Reports");
			System.out.println();
			System.out.println("Choose Option");
			int option1 = scanner.nextInt();
			switch (option1) {
			case 1:
				/************************************************************************************
				 * Hotel Management
				 *************************************************************************************/
				System.out.println("1.Add Hotel\n2.Update Hotel\n3.Delete Hotel");
				System.out.println();
				System.out.println("Choose Option");
				int option2 = scanner.nextInt();

				switch (option2) 
				{

				/************************************************************************************
				 * Add Hotel
				 *************************************************************************************/
				case 1:
					new Client().addHotel();

					break;
					/***********************************************************************************
					 * Update hotel
					 ***********************************************************************************/

				case 2:
					new Client().updateHotel();
					break;
					/***********************************************************************************
					 * Delete hotel
					 *************************************************************************************/
				case 3:
					new Client().deleteHotel();
					break;

				default:
					System.err
					.println("Enter valid option");
					break;
				}

				break;
				/*****************************************************************************
				 * Room Management
				 ******************************************************************************/
			case 2:
				System.out.println("1.Add Room\n2.Update Room\n3.Delete Room");
				System.out.println();
				System.out.println("choose option");
				option2 = scanner.nextInt();

				switch (option2) {
				/**************************************************************************
				 * Add room
				 ***************************************************************************/
				case 1:
					new Client().addRoom();
					break;

					/*********************************************************************************
					 * update room
					 *********************************************************************************/
				case 2:
					new Client().updateRoom();
					break;

					/********************************************************************************
					 * Delete room
					 ********************************************************************************/
				case 3:
					new Client().deleteRoom();
					break;

				default:
					System.out.println("Enter valid option");
					break;
				}

				break;

				/*************************************************************************************
				 * Generate Reports
				 *************************************************************************************/
			case 3:
				System.out
				.println("1. View List of Hotels\n2. View Bookings of specific hotel\n3. View guest list of specific hotel\n4. View bookings for specified date");
				System.out.println();
				System.out.println("Choose Option");
				int generateOption = scanner.nextInt();
				switch (generateOption) {
				/*************************************************************************************
				 * view list of all hotels
				 *************************************************************************************/
				case 1:

					new Client().allHotelsList();

					break;
					/*************************************************************************************
					 * view bookings of specific hotel
					 *************************************************************************************/
				case 2:
					new Client().viewSpecificHotelBooking();
					break;

					/*************************************************************************************
					 * view guest list of specific hotel
					 *************************************************************************************/
				case 3:
					new Client()
					.viewSpecificHotelGuestList();
					break;
					/*************************************************************************************
					 * view bookings for specified date
					 *************************************************************************************/
				case 4:
					new Client().viewSpecificDateBooking();
					break;

				default:
					break;
				}
				break;
			default:
				System.err.println("Enter valid option");
				break;
			}
			System.out.println("Do you want to continue? Yes or No");
			ch = scanner.next().charAt(0);

			while (ch == 'y' || ch == 'Y');
		}
		else {
			//logger.error("Admin Login failed");
			System.out.println("Not a Valid Admin");
			System.out.println("Check your credentials and login again");
			System.out.println();

		}

	}	
	//////////Methods///////	

	private void addHotel() throws HotelBookingException 
	{

		System.out.println("Enter Hotel Name");

		String hotelName = scanner.next();
		while (!service.isValidName(hotelName)) {
			System.err.println(IMsgMapper.NAME_ERROR);
			hotelName = scanner.next();
		}
		System.out.println("Enter Hotel Address : ");
		String hotelAddress = scanner.next();
		while (!service.isValidAddress(hotelAddress)) {
			System.err.println(IMsgMapper.ADDRESS_ERROR);
			hotelAddress = scanner.next();
		}
		System.out.println("Enter City : ");
		String city = scanner.next();
		while (!service.isValidCity(city)) {
			System.err.println(IMsgMapper.CITY_ERROR);
			city = scanner.next();
		}
		System.out.println("Enter Phone No1 : ");
		String phoneNo1 = scanner.next();
		while (!service.isValidMobileNo(phoneNo1)) {
			System.err.println(IMsgMapper.MOBILE_NO_ERROR);
			phoneNo1 = scanner.next();
		}
		System.out.println("Enter Phone No2 : ");
		String phoneNo2 = scanner.next();
		while (!service.isValidMobileNo(phoneNo2)) {
			System.err.println(IMsgMapper.MOBILE_NO_ERROR);
			phoneNo2 = scanner.next();
		}
		System.out.println("Enter Email : ");
		String hotelEmail = scanner.next();
		while (!service.isValidEmail(hotelEmail)) {

			System.err.println(IMsgMapper.EMAIL_ERROR);
			hotelEmail = scanner.next();
		}
		System.out.println("Enter fax : ");
		String fax = scanner.next();
		while (!service.isValidFax(fax)) {
			System.err.println(IMsgMapper.FAX_ERROR);
			fax = scanner.next();
		}
		System.out.println("Enter Description : ");
		String description = scanner.next();
		while (!service.isValidDescription(description)) {

			System.err.println(IMsgMapper.DESCRIPTION_ERROR);
			description = scanner.next();
		}
		System.out.println("Enter average cost per night : ");
		String avgRatePerNightStr = scanner.next();
		while (!service.isValidCost(avgRatePerNightStr)) {

			System.err.println(IMsgMapper.COST_ERROR);
			avgRatePerNightStr = scanner.next();
		}
		Double avgRatePerNight=Double.parseDouble(avgRatePerNightStr);
		System.out.println("Enter Hotel rating (0-5) : ");
		String ratingstr = scanner.next();
		while (!service.isValidRating(ratingstr)) {

			System.err.println(IMsgMapper.RATING_ERROR);
			ratingstr = scanner.next();
		}

		Float rating=Float.parseFloat(ratingstr);
		HotelBean hotelBean = new HotelBean(city, hotelName, hotelAddress,
				description, avgRatePerNight, phoneNo1, phoneNo2, rating,
				hotelEmail, fax);
		// Add hotel method
		int hotelAddStatus = service.addHotel(hotelBean);
		if (hotelAddStatus == 1) {
			/*logger.info("Hotel Id "+hotelBean.getHotelId()+" added successfully");*/
			System.out.println("Hotel Id "+hotelBean.getHotelId()+" added successfully");
		} else {
			//logger.error("Hotel is not added");
			System.err.println("Hotel is not added");
		}

	}

	private void updateHotel() throws HotelBookingException 
	{
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter hotel id to update");
		int hotelId = scanner.nextInt();

		hotelList = service.viewHotel(hotelId);
		if (hotelList.isEmpty()) {
			//logger.error("No records found to update");
			System.err.println("No records found to update");
			return;
		}

		for (HotelBean hotelBean1 : hotelList) {
			System.out.println("Below Details stored in the database");
			System.out.println();
			System.out.println("1) Hotel Name : " + hotelBean1.getHotelName());
			System.out.println("2) Address : " + hotelBean1.getAddress());
			System.out.println("3) Contact Number 1 : "
					+ hotelBean1.getPhoneNo1());
			System.out.println("4) Contact Number 2 : "
					+ hotelBean1.getPhoneNo2());
			System.out.println("5) Email : " + hotelBean1.getEmail());
			System.out.println("6) Fax : " + hotelBean1.getFax());
			System.out.println("7) Average Cost per Night : "
					+ hotelBean1.getAvgRatePerNight());
			System.out.println("8) Hotel Rating : " + hotelBean1.getRating());
			System.out.println();
			System.out.println();
		}
		System.out.println("Update Hotel Name : ");
		String hotelName = scanner1.nextLine();
		System.out.println("Update Hotel Address");
		String hotelAddress = scanner1.nextLine();
		System.out.println("Update City");
		String city = scanner1.nextLine();
		System.out.println("Update Phone No1");
		String phoneNo1 = scanner1.nextLine();
		System.out.println("Update Phone No2");
		String phoneNo2 = scanner1.nextLine();
		System.out.println("Update Email");
		String hotelEmail = scanner1.nextLine();
		System.out.println("Update fax");
		String fax = scanner1.nextLine();
		System.out.println("Update Description");
		String description = scanner1.nextLine();
		System.out.println("Update average cost per night");
		double avgRatePerNight = scanner.nextDouble();
		System.out.println("Update Hotel rating");
		float rating = scanner1.nextFloat();
		HotelBean hotelBean = new HotelBean(hotelId, city, hotelName,
				hotelAddress, description, avgRatePerNight, phoneNo1, phoneNo2,
				rating, hotelEmail, fax);
		int hotelUpdateStatus = service.modifyHotel(hotelBean);
		if (hotelUpdateStatus == 1) {
			//logger.info("Hotel Id " + hotelBean.getHotelId()+ " updated successfully");
			System.out.println("Hotel Id " + hotelBean.getHotelId()
					+ " updated successfully");
		} else {
			//logger.error("Hotel Id " + hotelBean.getHotelId()+ " is not updated");
			System.err.println("Hotel Id " + hotelBean.getHotelId()
					+ " is not updated");
		}

	}
	
	/*Delete Method*/
	

	private void deleteHotel() throws HotelBookingException {
		System.out.println("Enter hotel id to delete");
		int deleteHotelId = scanner.nextInt();

		int validDelete = service.deleteHotelValidate(deleteHotelId);
		if (validDelete == 0) {
			int deleteStatus = service.deleteHotel(deleteHotelId);

			if (deleteStatus == 1) {
				//logger.info("Hotel " + deleteHotelId+ " deleted Successfully");
				System.out.println("Hotel " + deleteHotelId
						+ " deleted Successfully");

			} else {
				//logger.error("Delete failed");
				System.err.println("Delete failed");
			}
		} else {
			//logger.error("Hotel is already booked");
			System.err.println("Hotel is already booked");
		}

	}
	
	/*Room Methods*/
	
	public void addRoom() throws HotelBookingException {
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Hotel Id : ");
		String hotelIdstr = scanner1.nextLine();
		while (!service.isValidId(hotelIdstr)) {

			System.err.println(IMsgMapper.ID_ERROR);
			hotelIdstr = scanner1.nextLine();
		}
		int hotelId=Integer.parseInt(hotelIdstr);
		System.out.println("Enter Room No : ");
		String roomNo = scanner1.nextLine();
		while (!service.isValidRoomNo(roomNo)) {

			System.err.println(IMsgMapper.ROOM_NO_ERROR);
			roomNo = scanner1.nextLine();
		}
		System.out.println("Enter Room Type : ");
		String roomType = scanner1.nextLine();
		while (!service.isValidRoomType(roomType)) {

			System.err.println(IMsgMapper.ROOM_TYPE_ERROR);
			roomType = scanner1.nextLine();
		}
		System.out.println("Enter Room Size");
		String roomSizestr = scanner1.nextLine();
		while (!service.isValidRoomSize(roomSizestr)) {

			System.err.println(IMsgMapper.ROOM_SIZE_ERROR);
			roomSizestr = scanner1.nextLine();
		}
		int roomSize=Integer.parseInt(roomSizestr);
		
		System.out.println("Enter cost per night : ");
		String perNightRatestr = scanner1.nextLine();
		while (!service.isValidCost(perNightRatestr)) {

			System.err.println(IMsgMapper.COST_ERROR);
			perNightRatestr = scanner1.nextLine();
		}
		Double perNightRate=Double.parseDouble(perNightRatestr);
		System.out.println("Enter availability (true or false) : ");
		String availability = scanner1.nextLine();
		while (!service.isValidAvailability(availability)) {

			System.err.println(IMsgMapper.AVAILABILITY_ERROR);
			availability = scanner1.nextLine();
		}
		RoomDetailsBean roomDetailsBean = new RoomDetailsBean(hotelId, roomNo,
				roomType, perNightRate, availability, roomSize);
		// Add room method
		int roomAddStatus = service.addRoom(roomDetailsBean);
		if (roomAddStatus == 1) {
			//logger.info("Room Id "+roomDetailsBean.getRoomId()+" added successfully");
			System.out.println("Room Id "+roomDetailsBean.getRoomId()+" added successfully");
		} else {
			//logger.error("Room not added");
			System.err.println("Room not added");
		}
	}

	public void updateRoom() throws HotelBookingException {
		
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter hotel id to update");
		int hotelId = scanner.nextInt();
		System.out.println("Enter room id to update");
		int roomId = scanner.nextInt();

		room = service.viewRoom(roomId, hotelId);
		if (room.getRoomId()==0) {
			//logger.error("No records found to update");
			System.err.println("No records found to update");
			return;
		}
		System.out.println("Below Details stored in the database");
		System.out.println();
		System.out.println("Room Number : " + roomDetailsBean.getRoomNo());
		System.out.println("Room type : " + roomDetailsBean.getRoomType());
		System.out.println("Room Cost : " + roomDetailsBean.getPerNightRate());
		System.out.println("Room size : " + roomDetailsBean.getRoomSize());
		System.out.println("Availability Status : "
				+ roomDetailsBean.getAvailability());
		System.out.println();
		System.out.println();
		System.out.println("Update Room No");
		String roomNo = scanner1.nextLine();
		System.out.println("Update Room Type");
		String roomType = scanner1.nextLine();
		System.out.println("Update Room Size");
		int roomSize = scanner.nextInt();
		System.out.println("Update cost per night");
		double perNightRate = scanner.nextDouble();
		System.out.println("Update availability");
		String availability = scanner1.nextLine();

		RoomDetailsBean roomDetailsBean = new RoomDetailsBean(hotelId, roomId,
				roomNo, roomType, perNightRate, availability, roomSize);

		// update room method
		int roomUpdateStatus = service.modifyRoom(roomDetailsBean);
		if (roomUpdateStatus == 1) {
			logger.info("Room " + roomId + " updated Successfuly");
			System.out.println("Room " + roomId + " updated Successfuly");
		} else {
			logger.error("Room " + roomId + " not updated");
			System.err.println("Room " + roomId + " not updated");
		}

	}

	public void deleteRoom() throws HotelBookingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel id ");
		int hotelId = scanner.nextInt();
		System.out.println("Enter room id to delete");
		int roomId = scanner.nextInt();

		RoomDetailsBean roomDetailsBean = new RoomDetailsBean();

		roomDetailsBean.setHotelId(hotelId);
		roomDetailsBean.setRoomId(roomId);
		int validDelete = service.deleteRoomValidate(hotelId, roomId);
		if (validDelete == 0) {
			int deleteStatus = service.deleteRoom(roomDetailsBean);

			if (deleteStatus == 1) {
				logger.info("Room " + roomId+ " deleted Successfully in Hotel " + hotelId);
				System.out.println("Room " + roomId+ " deleted Successfully in Hotel " + hotelId);

			} else {
				logger.error("Delete failed");
				System.out.println("Delete failed");
			}
		} else {
			logger.error("Room is already booked");
			System.out.println("Room is already booked");
			System.out.println();
		}
	}


	
	

	private void allHotelsList() {
		// TODO Auto-generated method stub

	}

	private void viewSpecificHotelBooking() {
		// TODO Auto-generated method stub

	}

	private void viewSpecificHotelGuestList() {
		// TODO Auto-generated method stub

	}

	private void viewSpecificDateBooking() {
		// TODO Auto-generated method stub

	}

	






}


