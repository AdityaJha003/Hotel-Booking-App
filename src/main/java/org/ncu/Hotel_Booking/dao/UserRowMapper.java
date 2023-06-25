package org.ncu.Hotel_Booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.Hotel_Booking.entity.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User us = new User();
		us.setUserId(rs.getInt(1));
		us.setUserName(rs.getString(2));
		us.setUserPass(rs.getString(3));
		us.setPhone(rs.getInt(4));
		us.setAadharId(rs.getInt(5));
		return us;
	}

}
