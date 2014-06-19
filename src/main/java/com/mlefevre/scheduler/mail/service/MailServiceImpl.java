package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.util.client.MailMessage;
import com.mlefevre.scheduler.mail.util.client.Mailer;
import com.mlefevre.scheduler.mail.util.client.MailerFactory;
import com.mlefevre.scheduler.mail.util.client.impl.SpringMailer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Value(value = "${mail.host:@null}")
    private String host;

    private static Mailer mailer = MailerFactory.getMailer(SpringMailer.class);

    @Override
    public void sendMail(MailMessage mail) {
        mailer.send(mail, host);
    }

}
