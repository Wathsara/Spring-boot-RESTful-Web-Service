package com.example.demo.topiccontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicServices;
	
	
	@RequestMapping("/topics")
	public List<Topic> showTopics() {
		return topicServices.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getSingleTopic(@PathVariable int id) {
		return topicServices.getSingleTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value="/topics")
	public void addNew(@RequestBody Topic topic) {
		topicServices.addNew(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/topics/{id}")
	public void update(@RequestBody Topic topic , @PathVariable int id) {
		topicServices.updateTopic(topic,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="/topics/{id}")
	public void delete( @PathVariable int id) {
		topicServices.delete(id);
	}
}
