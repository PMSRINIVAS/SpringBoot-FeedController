package com.cg.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.entity.Feed;

@Service
public interface FeedService {

	public List<Feed> findAll();

	public List<Feed> createFeed(@Valid Feed feed);
	

	public Feed updateFeed(Feed feed);

	public boolean deleteById(int id);

	public Feed findById(int id);

	public List<Feed> findFeedByTopic(String topic);

	public List<Feed> findFeedByKeyword(String keyword);


}
