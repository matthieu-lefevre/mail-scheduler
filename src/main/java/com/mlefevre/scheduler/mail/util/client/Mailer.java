package com.mlefevre.scheduler.mail.util.client;

import com.mlefevre.scheduler.mail.util.client.exception.MailerException;
import com.mlefevre.scheduler.mail.util.client.model.Credential;
import com.mlefevre.scheduler.mail.util.client.model.MailMessage;

/**
 *
 */
public interface Mailer {

    void configure(String host);

    void configure(String host, int port);

    void configure(String host, int port, Credential credentials);

    void send(MailMessage message) throws MailerException;

}
