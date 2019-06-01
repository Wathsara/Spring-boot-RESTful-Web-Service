package com.example.demo.courseontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CourseService {
	@Autowired
	private CourseCrud cc;	
	
	public List<Course> getTopics(int id){
		List<Course> courses = new ArrayList<>();
		cc.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getSingleCourse(int id) {
		return cc.findById(id);
	}

	public void addNew(Course course) {
		cc.save(course);
	}
	
	public void updateCourse(Course course) {
		cc.save(course);	
	}
	
	public void delete(int id) {
		cc.deleteById(id);
	}
	
}
