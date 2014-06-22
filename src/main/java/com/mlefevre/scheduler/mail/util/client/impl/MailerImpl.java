package com.mlefevre.scheduler.mail.util.client.impl;

import com.mlefevre.scheduler.mail.util.client.model.Credential;
import com.mlefevre.scheduler.mail.util.client.Mailer;

public abstract class MailerImpl implements Mailer {

    protected static final int MAX_RECIPIENTS = 10;

    protected String host;
    protected int port = 587;
    protected Credential credentials;


    public void configure(String host) {
        this.host = host;
    }

    public void configure(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void configure(String host, int port, Credential credentials) {
        this.host = host;
        this.port = port;
        this.credentials = credentials;
    }

}
