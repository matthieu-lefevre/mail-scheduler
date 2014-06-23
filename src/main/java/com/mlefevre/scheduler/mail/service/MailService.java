package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.model.Report;
import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;

public interface MailService {

    void sendMail(MailMessage message) throws MailerException;

    MailMessage buildMailMessage(Report report) throws MailerException;

}
