package org.ncu.Hotel_Booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.Hotel_Booking.entity.Admin;
import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin ad = new Admin();
		ad.setAdminId(rs.getInt(1));
		ad.setAdminName(rs.getString(2));
		ad.setAdminPass(rs.getString(3));
		ad.setPhone(rs.getInt(4));
		return ad;
	}

}