package com.studentmanagementsystem.bean;

import java.io.Serializable;
import java.sql.Date;

public class TeacherBean implements Serializable{
private String teacher_id, name, password, subject,department,email;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(String teacher_id) {
	this.teacher_id = teacher_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}


}
