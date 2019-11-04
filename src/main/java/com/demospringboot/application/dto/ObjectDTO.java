package com.demospringboot.application.dto;

import java.util.Date;

public class ObjectDTO extends PersistableElementDTO  {

    private String name;
    private String status;
    private Date date;
    private int minValue;
    private int maxValue;
    private int actualValue;

    public ObjectDTO() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() { return date;}
    public void setDate(Date date) { this.date = date; }

    public int getActualValue() { return actualValue ;}
    public void setActualValue(int actualValue) { this.actualValue = actualValue; }

    public int getMaxValue() { return maxValue; }
    public void setMaxValue(int maxValue) { this.maxValue = maxValue; }

    public int getMinValue() { return minValue; }
    public void setMinValue(int minValue) { this.minValue = minValue; }


}
