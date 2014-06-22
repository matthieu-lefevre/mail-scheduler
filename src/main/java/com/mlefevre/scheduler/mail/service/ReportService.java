package com.mlefevre.scheduler.mail.service;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface ReportService {

    String buildReport() throws IOException, TemplateException;

}
