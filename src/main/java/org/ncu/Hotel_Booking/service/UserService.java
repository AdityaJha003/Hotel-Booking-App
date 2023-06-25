package org.ncu.Hotel_Booking.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.entity.User;

public interface UserService {
	public int insertUser(User u);
	public int updateUser(User u, int userId);
	public User fetchUser(int userId);
	public ResultSet getallBooking(int userId);
	public List<Hotel> fetchHotels();
	public int checkoutPrev(int userId, int hotelId);
	public Hotel fetchHotel(int hotelId);
	public List<Hotel> pFilter(int price);
	public List<Hotel> lFilter(String location);
	public List<Hotel> rFilter(int ratings);
}
