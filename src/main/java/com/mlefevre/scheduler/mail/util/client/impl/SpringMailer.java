package com.mlefevre.scheduler.mail.util.client.impl;

import com.mlefevre.scheduler.mail.util.client.*;
import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SpringMailer extends MailerImpl {

    private JavaMailSenderImpl sender;

    public SpringMailer() {
        this.sender = new JavaMailSenderImpl();
        this.sender.setDefaultEncoding("UTF-8");
    }

    @Override
    public void send(MailMessage message) throws MailerException {
        try {
            MimeMessage mail = this.sender.createMimeMessage();
            mail.setFrom(this.buildAddress(message.getSender()));
            mail.setSubject(message.getSubject());
            mail.setRecipients(Message.RecipientType.TO, this.buildAddresses(message.getTo()));
            mail.setRecipients(Message.RecipientType.CC, this.buildAddresses(message.getBcc()));
            mail.setRecipients(Message.RecipientType.BCC, this.buildAddresses(message.getCci()));
            mail.setContent(this.createContent(message.getBody()));

            this.setUpSmtpProperties();
            this.sender.send(mail);

        } catch(MessagingException e) {

        }
    }


    private void setUpSmtpProperties() throws MailerException {
        if(this.host == null) {
            throw new MailerException("please configure a host before sending an email.");
        }
        this.sender.setHost(this.host);
        this.sender.setPort(this.port);
        if(this.credentials != null) {
            this.sender.setUsername(this.credentials.getUsername());
            this.sender.setPassword(this.credentials.getPassword());
        }

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        this.sender.setJavaMailProperties(properties);
    }


    private Multipart createContent(String body) throws MailerException {
        try {
            Multipart content = new MimeMultipart();
            MimeBodyPart htmlBody = new MimeBodyPart();
            htmlBody.setContent(body, "text/html");
            content.addBodyPart(htmlBody);

            return content;

        } catch(MessagingException e) {
            throw new MailerException(e);
        }
    }


    private InternetAddress[] buildAddresses(List<String> emails) throws MailerException {
        if(emails == null) {
            return new InternetAddress[0];
        }
        if(emails.size() > MAX_RECIPIENTS) {
            throw new MailerException("The number of recipients cannot exceed " + MAX_RECIPIENTS + " but " + emails.size() + " given.");
        }

        List<InternetAddress> addresses = new ArrayList<InternetAddress>();
        for(String email : emails) {
            addresses.add(this.buildAddress(email));
        }
        return addresses.toArray(new InternetAddress[emails.size()]);
    }


    private InternetAddress buildAddress(String email) throws MailerException {
        if(email == null) {
            return new InternetAddress();
        }
        if(MailUtils.checkEmail(email)) {
            try {
                return new InternetAddress(email);
            } catch(AddressException e) {
                throw new MailerException(e);
            }
        }
        throw new MailerException("Given email: " + email + " is not a valid email");
    }

}
