package org.ncu.Hotel_Booking.service;

import java.util.List;

import org.ncu.Hotel_Booking.entity.Admin;
import org.ncu.Hotel_Booking.entity.Hotel;

public interface AdminService {
	public Admin getAdmin(int adminId);
	public List<Hotel> fetchallHotels();
	public int insertHotel(Hotel h);
	public int updateHotel(Hotel h,int hotelId);
	public int deleteHotel(int hotelId);
}
