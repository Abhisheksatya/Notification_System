package com.nagarro.Notification_System.Service;

import java.util.List;

import com.nagarro.Notification_System.Model.Notification;
import com.nagarro.Notification_System.Model.UserLogin;

/*Subject Inetrface user for Admin
 *  */
public interface Subject {

	UserLogin findByMail(String userName);

	Notification save(Notification notice,String comm);

	List<Notification> getAllNotice();

	

}
