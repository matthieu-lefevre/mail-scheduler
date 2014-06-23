package com.mlefevre.scheduler.mail.batch;

import com.mlefevre.scheduler.mail.model.Report;
import com.mlefevre.scheduler.mail.service.MailService;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportProcessor implements ItemProcessor<Report, MailMessage> {

    @Autowired
    private MailService mailService;

    @Override
    public MailMessage process(Report report) throws Exception {
        return this.mailService.buildMailMessage(report);
    }

}
