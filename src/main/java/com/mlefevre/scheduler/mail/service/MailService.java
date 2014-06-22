package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;

public interface MailService {

    void sendMail(String content) throws MailerException;

}
