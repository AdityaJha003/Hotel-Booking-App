package org.ncu.Hotel_Booking.dao;

import java.util.List;

import org.ncu.Hotel_Booking.entity.Admin;
import org.ncu.Hotel_Booking.entity.Hotel;

public interface DaoAdmin {
	public Admin fetchAdmin(int adminId);
	public List<Hotel> getallHotels();
	public int insertHotel(Hotel h);
	public int alterHotel(Hotel h,int hotelId);
	public int deleteHotel(int hotelId);
}
