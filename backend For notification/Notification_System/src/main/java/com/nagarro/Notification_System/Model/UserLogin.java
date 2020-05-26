package com.nagarro.Notification_System.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*model class for login of user or admin
*/
@Entity
public class UserLogin {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
		@Column(name = "mail")
		private String mail ;
		@Column(name = "password")
		private String password ;
		@Column 
		private String role;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
}