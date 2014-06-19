package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.util.client.MailMessage;

public interface MailService {

    void sendMail(MailMessage mail);

}
