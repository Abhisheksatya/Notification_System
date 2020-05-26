package com.nagarro.Notification_System.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Notification_System.Dao.Notification_Dao;
import com.nagarro.Notification_System.Dao.UserLogin_Dao;
import com.nagarro.Notification_System.Model.Notification;
import com.nagarro.Notification_System.Model.UserLogin;
import com.nagarro.Notification_System.Service.Observer;
import com.nagarro.Notification_System.Service.Subject;
@Service
public class Subject_Admin implements Subject {

	@Autowired 
	private UserLogin_Dao userDao;
	
	@Autowired 
	private Notification_Dao NoticDao;
	@Autowired 
	private Observer observer;
	
	@Override
	public UserLogin findByMail(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByMail(userName);
	}

	@Override
	public Notification save(Notification notice,String comm) {
		// TODO Auto-generated method stub
		Notification notices = NoticDao.save(notice);
		if(notices==null) {
			System.out.println("Error in notification");
		}
		else if(comm.equalsIgnoreCase("portal")){
			observer.update(notices);
		}
		else if(comm.equalsIgnoreCase("mail")){
			observer.sendmail(notices);
		}
		else if(comm.equalsIgnoreCase("sms")){
			observer.sendsms(notices);
		}
		return notices;
	}

	@Override
	public List<Notification> getAllNotice() {
		// TODO Auto-generated method stub
		return NoticDao.findAll();
	}

}
