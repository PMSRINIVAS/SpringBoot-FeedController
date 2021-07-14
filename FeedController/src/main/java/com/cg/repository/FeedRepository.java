package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

	@Query("from Feed where topic = :topic")
	public List<Feed> findFeedByTopic(@PathVariable("topic") String topic);

	@Query(value="select * from Feed fd where fd.topic like %:keyword%", nativeQuery = true)
	public List<Feed> findFeedByKeyword(@PathVariable("keyword") String keyword);

}
