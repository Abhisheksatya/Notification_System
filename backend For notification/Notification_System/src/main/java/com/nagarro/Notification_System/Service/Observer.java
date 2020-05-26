package com.nagarro.Notification_System.Service;

import java.util.List;

import com.nagarro.Notification_System.Model.Notification;
import com.nagarro.Notification_System.Model.Registration;
import com.nagarro.Notification_System.Model.UserLogin;
import com.nagarro.Notification_System.Model.User_Notification;

/*Observer interface is user for User only
*/
public interface Observer {
	
	UserLogin findByMail(String userName);
	
	Registration findByMail2(String mail);

	Registration save(Registration user);

	void save(UserLogin auth);

	void update(Notification notices);

	void sendmail(Notification notices);

	void sendsms(Notification notices);

	List<User_Notification> findByMail3(String userName);

	
}
