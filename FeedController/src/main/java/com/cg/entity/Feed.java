package com.cg.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Feed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String query;
	
//	@JsonFormat(pattern="dd-MM-yyyy")
	private String feedDate;
	
	

	private String feedTime;
	
	private String topic;
	private int relevance;
	private int totalComments;
	private int likes;
	public Feed(int id, String query, String feedDate, String feedTime, String topic, int relevance,
			int totalComments, int likes) {
		super();
		this.id = id;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
		this.relevance = relevance;
		this.totalComments = totalComments;
		this.likes = likes;
	}
	public Feed() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(String feedDate) {
		this.feedDate = feedDate;
	}
	public String getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(String feedTime) {
		this.feedTime = feedTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public int getTotalComments() {
		return totalComments;
	}
	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "Feed [id=" + id + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime + ", topic="
				+ topic + ", relevance=" + relevance + ", totalComments=" + totalComments + ", likes=" + likes + "]";
	}
	
	
}
