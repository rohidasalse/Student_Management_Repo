package com.studentmanagementsystem.bean;

import java.io.Serializable;

public class RegistrationBean implements Serializable{
private String  fullname,studentrollnumber,email,gender,branch,bloodgroup,password;
public RegistrationBean() {
	
}

public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
}

public String getStudentrollnumber() {
	return studentrollnumber;
}

public void setStudentrollnumber(String studentrollnumber) {
	this.studentrollnumber = studentrollnumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getBloodgroup() {
	return bloodgroup;
}

public void setBloodgroup(String bloodgroup) {
	this.bloodgroup = bloodgroup;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}
