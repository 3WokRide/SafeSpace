package com.seevrantillan.safespace.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.seevrantillan.safespace.entity.TopicEntity;
import com.seevrantillan.safespace.repository.TopicRepository;

import jakarta.transaction.Transactional;

public class TopicService {

    @Autowired
    private final TopicRepository repo;

    public TopicService(TopicRepository repo) {
        this.repo = repo;
    }

    public TopicEntity createTopic(TopicEntity topic) {
        return repo.save(topic);
    }

    public List<TopicEntity> getAllTopics() {
        return repo.findAll();
    }

    public TopicEntity getTopicById(long topicId) {
        return repo.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Topic not found with ID: " + topicId));
    }


    @Transactional
    public TopicEntity updateTopic(long topicId, TopicEntity topicDetails) {
        TopicEntity existingTopic = repo.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Topic not found with ID: " + topicId));

        existingTopic.setTitle(topicDetails.getTitle());
        existingTopic.setContent(topicDetails.getContent());
        existingTopic.setOrderNumber(topicDetails.getOrderNumber());
        existingTopic.setLastUpdated(topicDetails.getLastUpdated());

        return repo.save(existingTopic);
    }
}
