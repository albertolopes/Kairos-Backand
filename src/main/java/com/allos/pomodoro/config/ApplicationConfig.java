package com.allos.pomodoro.config;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.service.EmailService;
import com.allos.pomodoro.service.MockEmailService;
import com.allos.pomodoro.service.SmtpEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService(); }
}
