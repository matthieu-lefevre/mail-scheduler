package com.mlefevre.scheduler.mail.batch;

import com.mlefevre.scheduler.mail.service.MailService;
import com.mlefevre.scheduler.mail.service.ReportService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderTasklet implements Tasklet {

    @Autowired
    private ReportService reportService;

    @Autowired
    private MailService mailService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        String mailContent = this.reportService.buildReport();
        this.mailService.sendMail(mailContent);

        return RepeatStatus.FINISHED;
    }
}
