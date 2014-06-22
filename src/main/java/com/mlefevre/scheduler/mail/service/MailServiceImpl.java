package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.Credential;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;
import com.mlefevre.scheduler.mail.util.client.Mailer;
import com.mlefevre.scheduler.mail.util.client.MailerFactory;
import com.mlefevre.scheduler.mail.util.client.impl.SpringMailer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Value(value = "${mail.host:@null}")
    private String host;

    @Value(value = "${mail.port:487}")
    private int port;

    @Override
    public void sendMail(String content) throws MailerException {
        MailMessage message = new MailMessage();
        message.setSender("matthieu.lefevre91@gmail.com");
        message.setSubject("test");
        message.setBody(content);
        message.addTo("lefevre.matthieu@outlook.com");

        Mailer mailer = MailerFactory.getMailer(SpringMailer.class);
        mailer.configure(host, port, new Credential(null, null));
        mailer.send(message);
    }

}
