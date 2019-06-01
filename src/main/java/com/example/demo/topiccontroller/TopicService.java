package com.example.demo.topiccontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicService {
	@Autowired
	private TopicCrud tc;	
	
	public List<Topic> getTopics(){
		List<Topic> topics = new ArrayList<>();
		tc.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getSingleTopic(int id) {
		return tc.findById(id);
	}

	public void addNew(Topic topic) {
		tc.save(topic);
	}
	
	public void updateTopic(Topic topic, int id) {
		tc.save(topic);	
	}
	
	public void delete(int id) {
		tc.deleteById(id);
	}
	
}
