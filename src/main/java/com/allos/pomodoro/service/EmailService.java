package com.allos.pomodoro.service;

import com.allos.pomodoro.entity.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Usuario usuario, String newPass);
}
