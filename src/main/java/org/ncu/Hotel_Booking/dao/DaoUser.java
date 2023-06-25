package org.ncu.Hotel_Booking.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.entity.User;

public interface DaoUser {
	public int newUser(User u);
	public int alterUser(User u,int userId);
	public User checkUser(int userId);
	public ResultSet getBooking(int userId);
	public List<Hotel> getHotels();
	public int checkout(int userId, int hotelId);
	public Hotel getHotel(int hotelId);
	public List<Hotel> filterPrice(int price);
	public List<Hotel> filterLocation(String location);
	public List<Hotel> filterRatings(int ratings);
}
