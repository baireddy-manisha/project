package com.app.model;

public class Employee {
private String emailid;
private String password;
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Employee [emailid=" + emailid + ", password=" + password + "]";
}

}
