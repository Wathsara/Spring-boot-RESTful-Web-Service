package com.example.demo.topiccontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicService {
	@Autowired
	private TopicCrud tc;
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic(1, "Java", "OOP Language"),
			new Topic(2, "React", "JS FrameWork"),
			new Topic(3, "Spring", "java framework"),
			new Topic(4, "Laravel", "PHP Framework")			
			
			));
	public List<Topic> getTopics(){
		List<Topic> topics = new ArrayList<>();
		tc.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getSingleTopic(int id) {
		return topics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addNew(Topic topic) {
		tc.save(topic);
	}
	
	public void updateTopic(Topic topic, int id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId()==id) {
				topics.set(i, topic);
				return;
			}
		}		
	}
	
	public void delete(int id) {
		topics.removeIf(t -> t.getId() == id);
	}
	
}
