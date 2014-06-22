package com.mlefevre.scheduler.mail.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    protected String title;

    protected String date;


    public Report() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.format(new Date());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }
}
