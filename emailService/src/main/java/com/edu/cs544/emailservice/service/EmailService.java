package com.edu.cs544.emailservice.service;

import com.edu.cs544.emailservice.dto.EmailDto;
import org.springframework.mail.MailException;


public interface EmailService {
    void sendMail(EmailDto email) throws MailException;
}