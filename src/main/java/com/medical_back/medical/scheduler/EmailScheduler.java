package com.medical_back.medical.scheduler;

import com.medical_back.medical.config.AdminConfig;
import com.medical_back.medical.domain.Mail;
import com.medical_back.medical.repository.VisitRepository;
import com.medical_back.medical.service.SimpleEmailService;
import com.medical_back.medical.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private final SimpleEmailService simpleEmailService;
    private final VisitDbService service;
    private final AdminConfig adminConfig;
    private static final String SUBJECT = "Visits: Once a day email";

    //    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 6 * * *")
    public void sendInformationEmail() {
        long size = service.allVisits().size();
        if (size == 1) {
            simpleEmailService.send(
                    new Mail(
                            adminConfig.getAdminMail(),
                            SUBJECT,
                            "Currently in database you got: " + size + " visit"
                    )
            );
        } else {
            simpleEmailService.send(
                    new Mail(
                            adminConfig.getAdminMail(),
                            SUBJECT,
                            "Currently in database you got: " + size + " visits"
                    )
            );
        }

    }
}

