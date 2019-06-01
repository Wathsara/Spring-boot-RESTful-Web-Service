package com.example.demo.courseontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topiccontroller.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> showTopics(@PathVariable int topicId) {
		return courseService.getTopics(topicId);
	}
//	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getSingleTopic(@PathVariable int courseId) {
		return courseService.getSingleCourse(courseId);
	}
	
	@RequestMapping(method = RequestMethod.POST , value="/topics/{topicId}/courses")
	public void addNew(@RequestBody Course course , @PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addNew(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}")
	public void update(@RequestBody Course course , @PathVariable int courseId ,  @PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}")
	public void delete( @PathVariable int courseId) {
		courseService.delete(courseId);
	}
}
