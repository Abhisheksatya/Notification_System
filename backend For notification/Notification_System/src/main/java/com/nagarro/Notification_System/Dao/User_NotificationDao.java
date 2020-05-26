package com.nagarro.Notification_System.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.Notification_System.Model.User_Notification;;


@Repository
public interface User_NotificationDao extends JpaRepository<User_Notification, Integer>{

	List<User_Notification> findByReciver(String userName);
	

}
