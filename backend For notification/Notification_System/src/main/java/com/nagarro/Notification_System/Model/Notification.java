package com.nagarro.Notification_System.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*model class for Admin notification 
 * and notification table object
*/
@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long noticid;
	@Column
	public String mail;
	@Column
	public String department;
	@Column
	public String subject;
	@Column
	public String body;
	@Column
	public String signature;
	@Column
	public String sendDate;
	public Long getNoticid() {
		return noticid;
	}
	public void setNoticid(Long noticid) {
		this.noticid = noticid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	@Override
	public String toString() {
		return "Notification [noticid=" + noticid + ", mail=" + mail + ", department=" + department
				+ ", subject=" + subject + ", body=" + body + ", signature=" + signature + ", sendDate=" + sendDate
				+ "]";
	}
	
}
