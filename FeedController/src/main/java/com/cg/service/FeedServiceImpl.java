package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.entity.Feed;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.repository.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService {
	
	@Autowired
	FeedRepository feedRepository;
	
	public FeedServiceImpl(FeedRepository feedRepository) {
		super();
		this.feedRepository = feedRepository;
	}


	@Override
	public List<Feed> findAll() {
//		return feedRepository.findAll();
		return feedRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

//		return feedRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));

	}

	@Override
	public List<Feed> createFeed(@Valid Feed feed) {
		feedRepository.save(feed);
		
		return feedRepository.findAll() ;
	}

	@Override
	public Feed updateFeed(Feed feed) {
		// !GETTING FIRST AND THEN UPDATE
		feedRepository.save(feed);
		return feed;
	}

	@Override
	public boolean deleteById(int id) {
		feedRepository.deleteById(id);
		return true;
	}

	@Override
	public Feed findById(int id) {
		Optional <Feed> e = feedRepository.findById(id);
		if(e.isEmpty()||e==null) {
			throw new ResourceNotFoundException("Feed Id not found for given Id : " +id);
		}
		return e.get();
	}


	@Override
	public List<Feed> findFeedByTopic(String topic) {
		List<Feed> feeds=feedRepository.findFeedByTopic(topic);
		if(feeds.isEmpty()||feeds==null) {
			throw new ResourceNotFoundException("Feed not found for given Topic:" +topic);
		}
		return feeds;
	}


	@Override
	public List<Feed> findFeedByKeyword(String keyword) {
		List<Feed> feeds=feedRepository.findFeedByKeyword(keyword);
		if(feeds.isEmpty()||feeds==null) {
			throw new ResourceNotFoundException("Feed not found for given Keyword : "+keyword);
		}
		return feeds;
	}

}
