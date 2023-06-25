package org.ncu.Hotel_Booking.dao;

import java.util.List;

import org.ncu.Hotel_Booking.entity.Admin;
import org.ncu.Hotel_Booking.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoAdminImpl implements DaoAdmin{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Hotel> getallHotels() {
		String query ="select * from hotel";
		return jdbcTemplate.query(query, new HotelRowMapper());
	}

	@Override
	public int insertHotel(Hotel h) {
		String query = "insert into hotel values(?,?,?,?,?,?,?,?)";
		Object[] arr= {h.getHotelId(),h.getHotelName(),h.getLocation(),h.getRatings(),h.getSwimmingPool(),h.getTourGuide(),h.getPrice(),h.getDiscount()};
		int result = jdbcTemplate.update(query, arr);
		return result;
		
	}

	@Override
	public int alterHotel(Hotel h,int hotelId) {
		String query= "update hotel set hotelName=?,location=?, ratings=?, swimmingPool=?, tourGuide=?, price=?, discount=? where hotelId=?";
		int result = jdbcTemplate.update(query,h.getHotelName(),h.getLocation(),h.getRatings(),h.getSwimmingPool(),h.getTourGuide(),h.getPrice(),h.getDiscount(),hotelId);
		return result;
	}

	@Override
	public int deleteHotel(int hotelId) {
		String query="delete from hotel where hotelId=?";
		int result = jdbcTemplate.update(query, hotelId);
		return result;
	}

	@Override	
	public Admin fetchAdmin(int adminId) {
		String query="select * from admin where adminId="+adminId;
		return jdbcTemplate.queryForObject(query, new AdminRowMapper());
	}

}
