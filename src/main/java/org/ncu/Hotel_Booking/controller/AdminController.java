package org.ncu.Hotel_Booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ncu.Hotel_Booking.entity.Admin;
import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
//	@Autowired
//	DaoAdminImpl daoAdmin;
	@Autowired
	AdminServiceImpl adServ;
	
	@ModelAttribute(value="admin")
	public Admin getAdmin() {
		return new Admin();
	}
	
	@ModelAttribute(value="hotel")
	public Hotel getHotel() {
		return new Hotel();
	}
	
	@RequestMapping(value="/adminlogin")
		public String adminPage() {
			return "admin-login";
	}
	
	@RequestMapping(value="/login")
	public String loginCheck(@ModelAttribute("Admin") Admin ad, Model model, HttpServletRequest req) {
		Admin a = adServ.getAdmin(ad.getAdminId());
		if(a!=null) {
			if(a.getAdminPass().equals(ad.getAdminPass())) {
				HttpSession se=req.getSession();
				model.addAttribute("Admin", a.getAdminName().toUpperCase());
				return "admin-home";
			}
			else {
				model.addAttribute("error", "Incorrect password!!");
				return "admin-login";
			}
			
		}
		else {
			model.addAttribute("err","No such record found");
			return "admin-login";
		}
	}
	
	@RequestMapping(value="/showHotels")
	public String adminHomePage(Model model) {
		List<Hotel>ho = adServ.fetchallHotels();
		model.addAttribute("hotels", ho);
		return "hotels-list";
	}
	
	@RequestMapping(value="/deleteHotel", method=RequestMethod.GET)
	public String deleteHotel(int hotelId,Model model) {
		int res=adServ.deleteHotel(hotelId);
		if (res>0) {
			return "confirmation";
		} else {
			return "error";
		}
	}
	@RequestMapping(value="/updateHotel", method=RequestMethod.GET)
	public String updateHotelDetails(int hotelId, HttpServletRequest req) {
		HttpSession ses=req.getSession();
		ses.setAttribute("id", hotelId);
		return "update-hotel";
	}
	
	@RequestMapping(value="/updateprocess", method=RequestMethod.POST)
	public String updateHotel(@ModelAttribute("Hotel")Hotel h, Model model,HttpServletRequest req) {
		HttpSession ses=req.getSession(false);
		int id = (Integer) ses.getAttribute("id");
		int res=adServ.updateHotel(h, id);
		if (res>0) {
			return "confirmation";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value="/insertHotel",method=RequestMethod.GET)
	public String insertHotel(){
		return"insert-hotel";
	}
	
	@RequestMapping(value="/insertprocess",method=RequestMethod.POST)
	public String insertProcess(@ModelAttribute("Hotel") Hotel h, Model model) {
		int i=adServ.insertHotel(h);
		if(i>0) {
			return "confirmation";
		}
		else {
			return "error";
		}
	}
}
