package com.capgemini.dbutil;

/********************************************************************************************************
 * 
 * SQL queries
 * 
 **********************************************************************************************************/
public interface IQueryMapper {
	//Hotel methods Query
	public static final String HOTEL_INSERT_QUERY="INSERT INTO HOTEL VALUES(HOTEL_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	public static final String HOTEL_ID_QUERY_SEQUENCE="SELECT HOTEL_ID_SEQ.CURRVAL FROM DUAL";
	public static final String HOTEL_DELETE_QUERY="DELETE HOTEL WHERE HOTEL_ID=?";
	public static final String HOTEL_DELETE_VALIDATE_QUERY="select count(*) from BOOKINGDETAILS where hotel_id=?";
	public static final String VIEW_HOTEL="SELECT * FROM HOTEL WHERE HOTEL_ID=?";
	public static final String HOTEL_UPDATE_QUERY="UPDATE HOTEL SET CITY=?,HOTEL_NAME=?,ADDRESS=?,DESCRIPTION=?,AVG_RATE_PER_NIGHT=?,PHONE_NO1=?,PHONE_NO2=?,RATING=?,EMAIL=?,FAX=? WHERE HOTEL_ID=?";
	
	
	
	
}
