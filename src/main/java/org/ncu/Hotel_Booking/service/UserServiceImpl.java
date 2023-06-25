package org.ncu.Hotel_Booking.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ncu.Hotel_Booking.dao.DaoUserImpl;
import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	DaoUserImpl daoUser;
	@Override
	public int insertUser(User u) {
		int result = daoUser.newUser(u);
		if(result==0) {
			return 0;
		}
		else {
			return 1;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public User fetchUser(int userId) {
		// TODO Auto-generated method stub
		return daoUser.checkUser(userId);
	}

	@Override
	public ResultSet getallBooking(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> fetchHotels() {
		// TODO Auto-generated method stub
		List<Hotel> ho = daoUser.getHotels();
		if(ho!=null) {
			return ho;
		}
		else {
			return null;
		}
	}

	@Override
	public int checkoutPrev(int userID, int hotelId) {
		// TODO Auto-generated method stub
		int res = daoUser.checkout(userID, hotelId);
		if (res>0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateUser(User u, int userId) {
		// TODO Auto-generated method stub
		int res=daoUser.alterUser(u, userId);
		if (res>0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Hotel fetchHotel(int hotelId) {
		// TODO Auto-generated method stub
		Hotel res=daoUser.getHotel(hotelId);
		if (res!=null) {
			return res;
		} else {
			return null;
		}
	}

	@Override
	public List<Hotel> pFilter(int price) {
		// TODO Auto-generated method stub
		List<Hotel> ho = daoUser.filterPrice(price);
		if(ho!=null) {
			return ho;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Hotel> lFilter(String location) {
		// TODO Auto-generated method stub
		List<Hotel> ho = daoUser.filterLocation(location);
		if(ho!=null) {
			return ho;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Hotel> rFilter(int ratings) {
		// TODO Auto-generated method stub
		List<Hotel> ho = daoUser.filterRatings(ratings);
		if(ho!=null) {
			return ho;
		}
		else {
			return null;
		}
	}

}
