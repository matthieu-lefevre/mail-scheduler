package com.mlefevre.scheduler.mail.util.client;

import com.mlefevre.scheduler.mail.util.client.impl.MailerImpl;

public class MailerFactory {

    public static <T extends MailerImpl> Mailer getMailer(Class<T> mailerImplClass) {
        try {
            return (Mailer) mailerImplClass.newInstance();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
