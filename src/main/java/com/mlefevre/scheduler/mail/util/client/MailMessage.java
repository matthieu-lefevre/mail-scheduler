package com.mlefevre.scheduler.mail.util.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Define a mail object
 */
public class MailMessage {

    protected String sender;

    protected List<String> to = new ArrayList<String>();
    protected List<String> bcc = new ArrayList<String>();
    protected List<String> cci = new ArrayList<String>();

    protected String subject;

    protected String body;
    protected Boolean bodyHtml;


    protected List<File> attachments = new ArrayList<File>();


    public MailMessage() { }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public void addTo(String to) {
        this.to.add(to);
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public void addBcc(String bcc) {
        this.bcc.add(bcc);
    }

    public List<String> getCci() {
        return cci;
    }

    public void setCci(List<String> cci) {
        this.cci = cci;
    }

    public void addCci(String cci) {
        this.cci.add(cci);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean isBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(Boolean bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(File attachment) {
        this.attachments.add(attachment);
    }
}
