package com.mlefevre.scheduler.mail.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;


    public void run() {

        JobParameters parameters = new JobParametersBuilder()
                .addLong("currentTime", new Long(System.currentTimeMillis()))
                .toJobParameters();

        try {
            JobExecution execution = this.jobLauncher.run(this.job, parameters);

        } catch (JobExecutionAlreadyRunningException e) {
        } catch (JobRestartException e) {
        } catch (JobInstanceAlreadyCompleteException e) {
        } catch (JobParametersInvalidException e) {
        }

    }

}
