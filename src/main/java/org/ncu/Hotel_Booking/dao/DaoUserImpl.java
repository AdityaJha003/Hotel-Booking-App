package org.ncu.Hotel_Booking.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DaoUserImpl implements DaoUser{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public ResultSet getBooking(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getHotels() {
		// TODO Auto-generated method stub
		String query ="select * from hotel";
		return jdbcTemplate.query(query, new HotelRowMapper());
	
	}

	@Override
	public int checkout(int userId, int hotelId) {
		// TODO Auto-generated method stub
		String query="insert into bookings values(?,?)";
		Object[] arr = {userId, hotelId};
		return jdbcTemplate.update(query,arr);
	}

	@Override
	public int newUser(User u) {
		// TODO Auto-generated method stub
		String query = "insert into user values(?,?,?,?,?)";
		Object[] arr= {u.getUserId(),u.getUserName(),u.getUserPass(),u.getPhone(),u.getAadharId()};
		int result = jdbcTemplate.update(query, arr);
		return result;
	}

	@Override
	public User checkUser(int userId) {
		// TODO Auto-generated method stub
		String query="select * from user where userId="+userId;
		return jdbcTemplate.queryForObject(query, new UserRowMapper());
	}

	@Override
	public int alterUser(User u, int userId) {
		// TODO Auto-generated method stub
		String query="update user set userName=?, userPass=?, phone=?, aadharId=? where userId=?";
		Object[] arr= {u.getUserName(),u.getUserPass(),u.getPhone(),u.getAadharId(),userId};
		int result = jdbcTemplate.update(query, arr);
		return result;
	}

	@Override
	public Hotel getHotel(int hotelId) {
		// TODO Auto-generated method stub
		String query="select * from hotel where hotelId="+hotelId;
		return jdbcTemplate.queryForObject(query, new HotelRowMapper());
	}

	@Override
	public List<Hotel> filterPrice(int price) {
		// TODO Auto-generated method stub
		String query="select * from hotel where price<="+price;
		return  jdbcTemplate.query(query, new HotelRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Hotel> filterLocation(String location) {
		// TODO Auto-generated method stub
		String query="select * from hotel where location=?";
		Object arr[]= {location};
		return jdbcTemplate.query(query, arr, new HotelRowMapper());
	}

	@Override
	public List<Hotel> filterRatings(int ratings) {
		// TODO Auto-generated method stub
		String query="select * from hotel where ratings>="+ratings;
		return jdbcTemplate.query(query, new HotelRowMapper());
	}

}
