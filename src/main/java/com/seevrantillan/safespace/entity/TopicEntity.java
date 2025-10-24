package com.seevrantillan.safespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicID;

    private String title;
    private String content;
    private Integer orderNumber;
    private LocalDateTime lastUpdated;

    public TopicEntity(String title, String content, Integer orderNumber, LocalDateTime lastUpdated) {
        this.title = title;
        this.content = content;
        this.orderNumber = orderNumber;
        this.lastUpdated = lastUpdated;
    }

    public TopicEntity() {
    }

    public Long getTopicID() {
        return topicID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
