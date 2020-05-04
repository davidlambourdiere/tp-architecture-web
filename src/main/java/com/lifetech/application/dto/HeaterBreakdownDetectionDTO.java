package com.lifetech.application.dto;

import java.util.Date;

public class HeaterBreakdownDetectionDTO {

    Date insertDate;

    HeaterBreakdownDetectionDTO(){
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
