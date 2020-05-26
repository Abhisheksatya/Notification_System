package com.nagarro.Notification_System.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Notification_System.Model.Notification;
import com.nagarro.Notification_System.Model.User_Notification;
import com.nagarro.Notification_System.Service.Observer;
import com.nagarro.Notification_System.Service.Subject;

/*class for authorised user and admin 
*/
@RestController
@RequestMapping("/rest")
public class Resource_Subject {
	
	@Autowired
	private Subject subject;
	@Autowired
	private Observer observer;

	/*
	 * method for sending notification to the user portal
	 */
	@RequestMapping(value="/Admin/NotificationSend", method=RequestMethod.POST)
	public Notification NotificationSend(@RequestBody Notification notice) {
		notice.setSendDate(java.time.LocalDate.now().toString());
		return subject.save(notice,"portal");
	}
	
	/*
	 * method for sending notification to the user mail
	 */
	@RequestMapping(value="/Admin/Notificationmail", method=RequestMethod.POST)
	public Notification Notificationmail(@RequestBody Notification notice) {
		notice.setSendDate(java.time.LocalDate.now().toString());
		return subject.save(notice,"mail");
	}
	
	/*
	 * method for sending notification to the user	sms
	 */
	@RequestMapping(value="/Admin/Notificationsms", method=RequestMethod.POST)
	public Notification Notificationsms(@RequestBody Notification notice) {
		notice.setSendDate(java.time.LocalDate.now().toString());
		return subject.save(notice,"sms");
	}
	
	/*
	 * method for view notification for Admin only
	 */
	@RequestMapping(value="/Admin/viewNotification", method=RequestMethod.POST)
	public List<Notification> getNotices(@RequestBody Notification notice) {
		List<Notification> Notices= subject.getAllNotice();
		return Notices;
	}
	
	/*
	 * method for view notification for user only
	 */
	@RequestMapping(value="/user/viewNotification", method=RequestMethod.POST)
	public List<User_Notification> findnotification(@RequestBody Map<String,String> json) {
		String userName = json.get("mail");
		System.out.println(userName);
		System.out.println("qwertyuio");
		List<User_Notification> notification= observer.findByMail3(userName);
		return notification;
	}

	
}
