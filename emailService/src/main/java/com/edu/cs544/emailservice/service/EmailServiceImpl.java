package com.edu.cs544.emailservice.service;

import com.edu.cs544.emailservice.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${application.email.server}")
    private String sourceEmailAddress;

    @Override
    public void sendMail(EmailDto email) throws MailException {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sourceEmailAddress);
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessageBody());

        mailSender.send(mailMessage);
    }


}