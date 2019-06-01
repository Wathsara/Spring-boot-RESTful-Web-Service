package com.example.demo.courseontroller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCrud extends CrudRepository<Course, Integer> {
	public List<Course> findByTopicId(int id);
}
