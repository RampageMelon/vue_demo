package com.model;

public class Record {
    private Integer recordId;

    private String recordName;

    private String recordTime;

    private String recordUsername;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime == null ? null : recordTime.trim();
    }

    public String getRecordUsername() {
        return recordUsername;
    }

    public void setRecordUsername(String recordUsername) {
        this.recordUsername = recordUsername;
    }
}