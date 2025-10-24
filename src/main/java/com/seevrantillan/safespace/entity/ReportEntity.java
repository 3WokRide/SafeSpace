package com.seevrantillan.safespace.entity;

import java.security.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    private Character targetType;
    private String reason;
    private String status;
    private Timestamp timestamp;

    public ReportEntity() {
    }
    
    public ReportEntity(Character targetType, String reason, String status, Timestamp timestamp) {
        this.targetType = targetType;
        this.reason = reason;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getReportId() {
        return reportId;
    }

    public Character getTargetType() {
        return targetType;
    }

    public void setTargetType(Character targetType) {
        this.targetType = targetType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    
}
