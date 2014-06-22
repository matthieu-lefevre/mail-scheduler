package com.mlefevre.scheduler.mail.service;

import com.mlefevre.scheduler.mail.model.Report;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.servlet.ServletContext;
import java.io.IOException;

@Service
public class ReportServiceImpl implements ReportService {

    @Value(value = "${report.template.path:@null}")
    private String reportTemplate;

    @Autowired
    private Configuration configuration;

    @Override
    public String buildReport() throws IOException, TemplateException {
        Report report = new Report();
        report.setTitle("Report title.");

        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        SimpleHash root = new SimpleHash();
        root.put("report", report);
        String mailReport = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(reportTemplate), root);
        return mailReport;
    }
}
