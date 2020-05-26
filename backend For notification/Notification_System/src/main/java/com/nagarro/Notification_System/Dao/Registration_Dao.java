package com.nagarro.Notification_System.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.Notification_System.Model.Registration;

@Repository
public interface Registration_Dao extends JpaRepository<Registration, Integer>{

	Registration findByMail(String mail);

	List<Registration> findByDepartment(String department);

}
