package com.example.demo.courseontroller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.topiccontroller.Topic;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private int id;	
	private String name;	
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(int id, String name, String description, int tid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(tid , "" , "");
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
