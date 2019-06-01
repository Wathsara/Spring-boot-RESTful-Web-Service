package com.example.demo.topiccontroller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicCrud extends CrudRepository<Topic, Integer> {

}
