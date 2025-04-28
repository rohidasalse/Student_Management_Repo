package com.studentmanagementsystem.bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class AssignmentBean {
    private String title;
    private String description;
    private String subject;
    private String dueDate;
    private Date assigned_date;
    public Date getAssigned_date() {
		return assigned_date;
	}

	public void setAssigned_date(Date assigned_date) {
		this.assigned_date = assigned_date;
	}

	private byte[] assignmentFile; // Changed from Part to byte[]

    

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dateTime) {
        this.dueDate = dateTime;
    }

    public byte[] getAssignmentFile() {
        return assignmentFile;
    }

    public void setAssignmentFile(byte[] assignmentFile) {
        this.assignmentFile = assignmentFile;
    }

	@Override
	public String toString() {
		return "AssignmentBean [title=" + title + ", description=" + description + ", subject=" + subject + ", dueDate="
				+ dueDate + ", assigned_date=" + assigned_date + ", assignmentFile=" + Arrays.toString(assignmentFile)
				+ "]";
	}
    
}
