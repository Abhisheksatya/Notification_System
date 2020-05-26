package com.nagarro.Notification_System.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Notification_System.Model.Registration;
import com.nagarro.Notification_System.Model.Token;
import com.nagarro.Notification_System.Model.UserLogin;
import com.nagarro.Notification_System.Service.Observer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*class for the
login
and registration process*/
@RestController
@RequestMapping("user")
public class Controller_UserLogin {
	
	@Autowired
	private Observer observer;
	

	/*
	 * method for user login
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Token login(@RequestBody Map<String, String> json) throws ServletException {
		if(json.get("mail") == null || json.get("password") == null) {
			throw new ServletException("Please fill in username and password");
		}
		String userName = json.get("mail");
		String password = json.get("password");
		UserLogin user = observer.findByMail(userName);
		if(user == null) {
			throw new ServletException ("User name not found.");
		}
		String pwd = user.getPassword();
		String role=user.getRole();
		if (password.equals(pwd)&& role.equalsIgnoreCase("User")) {	}
		else {
			throw new ServletException("Invalid login. Please check your username and password");
		}
		Token token= new Token();
		token.setToken(Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
		return	token;
	}
	
	/*
	 * method for Admin Login
	 */
	@RequestMapping(value="Adminlogin", method=RequestMethod.POST)
	public Token Adminlogin(@RequestBody Map<String, String> json) throws ServletException {
		if(json.get("mail") == null || json.get("password") == null) {
			throw new ServletException("Please fill in username and password");
		}
		String userName = json.get("mail");
		String password = json.get("password");
		UserLogin user = observer.findByMail(userName);
		if(user == null) {
			throw new ServletException ("User name not found..");
		}
		String pwd = user.getPassword();
		String role=user.getRole();
		if (password.equals(pwd)&& role.equalsIgnoreCase("Admin")) {	}
		else {
			throw new ServletException("Invalid login. Please check your username and password");
		}
		Token token= new Token();
		token.setToken(Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact());
		return	token;
	}

	/*
	 * method for User registration
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Registration registerUser(@RequestBody Registration regForm) throws ServletException, AddressException, MessagingException, IOException {
		String mail=regForm.getMail();
		if(observer.findByMail2(mail)!=null) {
			throw new ServletException("MailId Not available");
		}
		Registration serve=observer.save(regForm);
		if(serve==null) {
			throw new ServletException("Invalid Registration");
		}
		UserLogin Auth= new UserLogin();
		Auth.setMail(regForm.getMail());
		Auth.setPassword(regForm.getPassword());
		Auth.setRole("User");
		observer.save(Auth);
		return serve;
	}
}
