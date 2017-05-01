package com.model;

public class DangerCritical {
    private Integer criticalId;

    private String criticalType;

    private String criticalName;

    private Double criticalAmount;


    public Integer getCriticalId() {
        return criticalId;
    }

    public void setCriticalId(Integer criticalId) {
        this.criticalId = criticalId;
    }

    public String getCriticalType() {
        return criticalType;
    }

    public void setCriticalType(String criticalType) {
        this.criticalType = criticalType == null ? null : criticalType.trim();
    }

    public String getCriticalName() {
        return criticalName;
    }

    public void setCriticalName(String criticalName) {
        this.criticalName = criticalName == null ? null : criticalName.trim();
    }

    public Double getCriticalAmount() {
        return criticalAmount;
    }

    public void setCriticalAmount(Double criticalAmount) {
        this.criticalAmount = criticalAmount;
    }
}