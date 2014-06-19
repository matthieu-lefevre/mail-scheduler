package com.mlefevre.scheduler.mail.util.client;


public interface Mailer {

    void send(MailMessage message, String host);

}
