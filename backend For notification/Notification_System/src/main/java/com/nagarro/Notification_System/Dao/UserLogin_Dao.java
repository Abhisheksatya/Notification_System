package com.nagarro.Notification_System.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.Notification_System.Model.UserLogin;

@Repository
public interface UserLogin_Dao extends JpaRepository<UserLogin, Long>{

	UserLogin findByMail(String userName);

}
