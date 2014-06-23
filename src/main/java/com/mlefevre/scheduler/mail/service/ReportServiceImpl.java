package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.model.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public Report buildReport() {
        Report report = new Report();
        report.setTitle("Report title.");

        return report;
    }
}
