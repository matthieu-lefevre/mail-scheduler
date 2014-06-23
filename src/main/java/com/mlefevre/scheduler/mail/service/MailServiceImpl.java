package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.model.Report;
import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.Credential;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;
import com.mlefevre.scheduler.mail.util.client.Mailer;
import com.mlefevre.scheduler.mail.util.client.MailerFactory;
import com.mlefevre.scheduler.mail.util.client.impl.SpringMailer;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;

@Service
public class MailServiceImpl implements MailService {

    @Value(value = "${mail.host:@null}") private String host;
    @Value(value = "${mail.port:487}") private int port;

    @Value(value = "${report.template.path:@null}") private String reportTemplate;

    @Autowired
    private Configuration configuration;

    @Override
    public void sendMail(MailMessage message) throws MailerException {
        Mailer mailer = MailerFactory.getMailer(SpringMailer.class);
        mailer.configure(host, port, new Credential("matthieu.lefevre91@gmail.com", "eQxOYaxz"));
        mailer.send(message);
    }

    @Override
    public MailMessage buildMailMessage(Report report) throws MailerException {
        MailMessage message = new MailMessage();
        try {
            message.setSender("matthieu.lefevre91@gmail.com");
            message.setSubject("test");
            message.setBody(this.computeReportTemplate(report));
            message.addTo("lefevre.matthieu@outlook.com");

        } catch(IOException e) {
            throw new MailerException(e);
        } catch(TemplateException e) {
            throw new MailerException(e);
        }
        return message;
    }

    private String computeReportTemplate(Report report) throws IOException, TemplateException {
        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        SimpleHash root = new SimpleHash();
        root.put("report", report);
        String mailReport = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(reportTemplate), root);

        return mailReport;
    }

}
