package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Feed;
import com.cg.service.FeedService;

@RestController
@RequestMapping("/api/v1/feeds")
@CrossOrigin
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	public FeedController(FeedService feedService) {
		this.feedService = feedService;
	}

	List<Feed>list=new ArrayList<Feed>();
	
	@GetMapping(path="/get", produces= {"application/json"})
	public ResponseEntity<List<Feed>> findAll() {
		List<Feed> list = feedService.findAll();
		return new ResponseEntity<List<Feed>>(list, HttpStatus.OK);
	}

	@PostMapping(path="/post", consumes= {"application/json"})
	public ResponseEntity<List<Feed>> createFeed(@Valid @RequestBody Feed feed) {
		List<Feed> e = feedService.createFeed(feed);
		return new ResponseEntity <List<Feed>>(e,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/get/{id}")
	public ResponseEntity<Feed> updateFeedById(@PathVariable int id, @RequestBody Feed feed) {
		Feed e = feedService.updateFeed(feed);
		return new ResponseEntity<Feed>(e, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Boolean> deleteFeedById(@PathVariable int id) {
		boolean operation = feedService.deleteById(id);
		return new ResponseEntity<Boolean>(operation, HttpStatus.OK);
	}
	
	@GetMapping(path="/get/{id}")
	public ResponseEntity<Feed> findById(@PathVariable int id) {
		Feed e = feedService.findById(id);
				return new ResponseEntity<Feed>(e, HttpStatus.OK);
			}
		
	
	@GetMapping(path="/get/topic/{topic}")
	public List<Feed> findFeedByTopic(@PathVariable("topic") String topic){
		List<Feed> feeds=feedService.findFeedByTopic(topic);
		return feeds;
	}
	
	@GetMapping(path="/get/topic/keyword/{keyword}")
	public List<Feed> findFeedByKeyword(@PathVariable("keyword") String keyword){
		List<Feed> feeds=feedService.findFeedByKeyword(keyword);
		return feeds;
	}
	


}
