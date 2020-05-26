package com.nagarro.Notification_System.serviceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Notification_System.Dao.Registration_Dao;
import com.nagarro.Notification_System.Dao.UserLogin_Dao;
import com.nagarro.Notification_System.Dao.User_NotificationDao;
import com.nagarro.Notification_System.Model.Notification;
import com.nagarro.Notification_System.Model.Registration;
import com.nagarro.Notification_System.Model.UserLogin;
import com.nagarro.Notification_System.Model.User_Notification;
import com.nagarro.Notification_System.Service.Observer;

@Service
public class Observer_User implements Observer {
	public String sender="@gmail.com";
	public String password="******";
	
	@Autowired 
	private UserLogin_Dao userDao;
	
	@Autowired 
	private Registration_Dao regDao;
	
	@Autowired 
	private User_NotificationDao noticeDao;
	
	@Override
	public UserLogin findByMail(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByMail(userName);
	}

	@Override
	public Registration findByMail2(String mail) {
		// TODO Auto-generated method stub
		return regDao.findByMail(mail);
	}

	@Override
	public Registration save(Registration user) {
		// TODO Auto-generated method stub
		return regDao.save(user);
	}

	@Override
	public void save(UserLogin auth) {
		// TODO Auto-generated method stub
		userDao.save(auth);
	}
	
	@Override
	public List<User_Notification> findByMail3(String userName) {
		// TODO Auto-generated method stub
		System.out.println("work");
		return 	noticeDao.findByReciver(userName);
	}


	@Override
	public void update(Notification notices) {
		// TODO Auto-generated method stub
		String department=notices.getDepartment();
		if(department.equalsIgnoreCase("All Department")) {
			List<Registration> reg=regDao.findAll();
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				noticeDao.save(notification);
				
			}
		}
		else {
			List<Registration> reg=regDao.findByDepartment(department);
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				noticeDao.save(notification);
				
			}
			
		}
	}

	@Override
	public void sendmail(Notification notices) {
		// TODO Auto-generated method stub
		String department=notices.getDepartment();
		if(department.equalsIgnoreCase("All Department")) {
			List<Registration> reg=regDao.findAll();
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				System.out.println("sendmail to all department");
				try {
					mailed(notification.getReciver(),notification.getSubject(),notification.getBody()+"\n"+notification.getSignature());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			List<Registration> reg=regDao.findByDepartment(department);
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				System.out.println("sendmail to some department");
				try {
					mailed(notification.getReciver(),notification.getSubject(),notification.getBody()+"\n"+notification.getSignature());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

	
	@Override
	public void sendsms(Notification notices) {
		// TODO Auto-generated method stub
		String department=notices.getDepartment();
		System.out.println("\n\n\n");
		if(department.equalsIgnoreCase("All Department")) {
			List<Registration> reg=regDao.findAll();
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				System.out.println("SMS send ");
				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println(re.getPhone());
				System.out.println(notification.getSubject());
				System.out.println(notification.getBody());
				System.out.println(notification.getSendDate());
				System.out.println(notification.getSignature());
				System.out.println("**********************************");
				System.out.println("**********************************");
				
			}
		}
		else {
			List<Registration> reg=regDao.findByDepartment(department);
			for(int i=0;i<reg.size();i++) {
				Registration re=reg.get(i);
				User_Notification notification=new User_Notification();
				notification.setReciver(re.getMail());
				notification.setMail(notices.getMail());
				notification.setBody(notices.getBody());
				notification.setDepartment(department);
				notification.setSendDate(notices.getSendDate());
				notification.setSignature(notices.getSignature());
				notification.setSubject(notices.getSubject());
				System.out.println("SMS Send");
				System.out.println("**********************************");
				System.out.println("**********************************");
				System.out.println(re.getPhone());
				System.out.println(notification.getSubject());
				System.out.println(notification.getBody());
				System.out.println(notification.getSendDate());
				System.out.println(notification.getSignature());
				System.out.println("**********************************");
				System.out.println("**********************************");
				
			}
			
		}
		
	}
	/*
	 * method for sending Mails
	 */
	public void mailed(String reciver,String subject,String content) throws AddressException, MessagingException, IOException {
	       Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(sender, password);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(reciver, false));
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciver));
		   msg.setSubject(subject);
		   msg.setContent(content, "text/html");
		   msg.setSentDate(new Date());
		   Transport.send(msg); 
		   return;
		}

}
