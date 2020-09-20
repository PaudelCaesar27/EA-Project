package com.edu.cs544.emailservice.controller;

import com.edu.cs544.emailservice.dto.EmailDto;
import com.edu.cs544.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/email")
@Api(description = "Email controller handles end points related to email operations")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendemail")
    String sendMail(@RequestBody EmailDto email) {
        emailService.sendMail(email);
        return "Email sent successfully";
    }
}
