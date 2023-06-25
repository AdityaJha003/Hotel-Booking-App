package org.ncu.Hotel_Booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ncu.Hotel_Booking.entity.Hotel;
import org.ncu.Hotel_Booking.entity.User;
import org.ncu.Hotel_Booking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl usServ;
	
	@ModelAttribute(value="user")
	public User getUser(){
		return new User();
	}
	@ModelAttribute(value="hotel")
	public Hotel getHotel() {
		return new Hotel();
	}
	
	
	@RequestMapping(value="/userLogin")
	public String userPage() {
		return "user-login";
	}
	
	@RequestMapping(value="/loginUser")
	public String loginCheck(@ModelAttribute("User")User us, Model model, HttpServletRequest req) {
		User u = usServ.fetchUser(us.getUserId());
		if(u!=null) {
			if(u.getUserPass().equals(us.getUserPass())) {
				HttpSession se=req.getSession();
				se.setAttribute("uid", us.getUserId());
				model.addAttribute("User", u.getUserName().toUpperCase());
				return "user-home";
			}
			else {
				model.addAttribute("error", "Incorrect password!!");
				return "user-login";
			}
		}
		else {
			model.addAttribute("err","No such record found");
			return "user-login";
		}
	}
	
	@RequestMapping(value="/register")
	public String registerUser() {
		return "user-register";
	}
	
	@RequestMapping(value="/registerProcess")
	public String registerProecss(@ModelAttribute("User")User us, Model model) {
		int i = usServ.insertUser(us);
		if(i>0) {
			return "confirmation-user";
		}
		else {
			return "error";
		}
	}
	
	@RequestMapping(value="/updateProfile")
	public String updateProfile() {
		return"update-profile";
	}
	
	@RequestMapping(value="/updateProcess")
	public String updateProcess(@ModelAttribute("User")User us, Model model,HttpServletRequest req) {
		HttpSession ses=req.getSession(false);
		int id = (Integer) ses.getAttribute("uid");
		int res=usServ.updateUser(us, id);
		if (res>0) {
			return "confirmation-user";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value="/showHotelss")
	public String showHotels(Model model) {
		List<Hotel> ho = usServ.fetchHotels();
		model.addAttribute("hotels", ho);
		return "show-hotels";
	}
	
	@RequestMapping(value="/bookHotel")
	public String bookHotel(int hotelId,Model model, HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		int id = (Integer) ses.getAttribute("uid");
		int res = usServ.checkoutPrev(id, hotelId);
		if (res>0) {
			Hotel h=usServ.fetchHotel(hotelId);
			model.addAttribute("hotel",h);
			return"booking-checkout";
		} else {
			return"error" ;
		}
	}
	
	@RequestMapping(value="/filterPrice")
	public String priceFilter(int price,Model model) {
		List<Hotel> ho = usServ.pFilter(price);
		model.addAttribute("hotels", ho);
		return "show-hotels";
	}
	
	@RequestMapping(value="/filterLocation")
	public String locationFilter(String location, Model model) {
		List<Hotel> ho= usServ.lFilter(location);
		model.addAttribute("hotels", ho);
		return "show-hotels";
	}
	
	@RequestMapping(value="/filterRatings")
	public String ratingsFilter(int ratings, Model model) {
		List<Hotel> ho= usServ.rFilter(ratings);
		model.addAttribute("hotels", ho);
		return "show-hotels";
	}
}

