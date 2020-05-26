package com.nagarro.Notification_System.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.Notification_System.Model.Notification;
@Repository
public interface Notification_Dao extends JpaRepository<Notification, Long>{

}
