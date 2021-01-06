package com.kodilla.project.scheduler;

import com.kodilla.project.config.AdminConfig;
import com.kodilla.project.domain.Mail;
import com.kodilla.project.repository.UserDao;
import com.kodilla.project.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Users: information email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendUserInformationEmail() {
        long size = userDao.count();
        String message;
        if(size > 1) {
            message = "There are " + size + " users registered in your database";
        } else {
            message = "There is " + size + " user registered in your database";
        }
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                message

        ));

    }
}
