package org.ncu.Hotel_Booking.service;

import java.util.List;

import org.ncu.Hotel_Booking.dao.DaoAdminImpl;
import org.ncu.Hotel_Booking.entity.Admin;
import org.ncu.Hotel_Booking.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminServiceImpl implements AdminService{

	@Autowired
	DaoAdminImpl daoAdmin;
	
	@Override
	public Admin getAdmin(int adminId) {
		// TODO Auto-generated method stub
		return daoAdmin.fetchAdmin(adminId);
	}

	@Override
	public List<Hotel> fetchallHotels() {
		// TODO Auto-generated method stub
		List<Hotel> ho = daoAdmin.getallHotels();
		if(ho!=null) {
			return ho;
		}
		else {
			return null;
		}
	}

	@Override
	public int insertHotel(Hotel h) {
		// TODO Auto-generated method stub
		int result = daoAdmin.insertHotel(h);
		if(result==0) {
			return 0;
		}
		else {
			return 1;
		}
	}

	@Override
	public int updateHotel(Hotel h, int hotelId) {
		int res=daoAdmin.alterHotel(h, hotelId);
		if (res>0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int deleteHotel(int hotelId) {
		// TODO Auto-generated method stub
		int res= daoAdmin.deleteHotel(hotelId);
		if (res>0) {
			return 1;
		} else {
			return 0;
		}
	}

}
