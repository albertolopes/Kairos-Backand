package com.allos.pomodoro.config;

import com.allos.pomodoro.service.EmailService;
import com.allos.pomodoro.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
