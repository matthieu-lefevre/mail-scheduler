package com.mlefevre.scheduler.mail.batch;

import com.mlefevre.scheduler.mail.service.MailService;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailReportWriter implements ItemWriter<MailMessage> {

    @Autowired
    private MailService mailService;

    @Override
    public void write(List<? extends MailMessage> mailMessages) throws Exception {
        MailMessage message = mailMessages.get(0);
        this.mailService.sendMail(message);
    }

}
