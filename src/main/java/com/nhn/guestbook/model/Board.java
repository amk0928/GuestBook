package com.nhn.guestbook.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Data;

@Data 
public class Board {
	private int id;
	private String email;
	private String password;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int deleted;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		Instant instant = createdAt.toInstant();
		this.createdAt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		Instant instant = updatedAt.toInstant();
		this.updatedAt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
}
