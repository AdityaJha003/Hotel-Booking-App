package org.ncu.Hotel_Booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.Hotel_Booking.entity.Hotel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class HotelRowMapper implements RowMapper<Hotel>{

	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hotel h = new Hotel();
		h.setHotelId(rs.getInt(1));
		h.setHotelName(rs.getString(2));
		h.setLocation(rs.getString(3));
		h.setRatings(rs.getInt(4));
		h.setSwimmingPool(rs.getString(5));
		h.setTourGuide(rs.getString(6));
		h.setPrice(rs.getInt(7));
		h.setDiscount(rs.getInt(8));
		return h;
	}

}
