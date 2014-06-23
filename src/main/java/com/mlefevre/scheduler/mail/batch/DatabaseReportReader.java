package com.mlefevre.scheduler.mail.batch;

import com.mlefevre.scheduler.mail.model.Report;
import com.mlefevre.scheduler.mail.service.ReportService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatabaseReportReader implements ItemReader<Report> {

    @Autowired
    private ReportService reportService;

    @Override
    public Report read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return this.reportService.buildReport();
    }

}
