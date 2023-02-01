package com.medical_back.medical.service;

import com.medical_back.medical.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleEmailService {
    private final JavaMailSender sender;

    public void send(final Mail mail) {
        log.info("Starting message preparation...");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            sender.send(mailMessage);
            log.info("The message has been sent.");
        } catch (MailException e) {
            log.error("The message sending process has failed: " + e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }
}