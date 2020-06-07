package com.allos.pomodoro.service;

import com.allos.pomodoro.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstraticEmailService implements EmailService{

    @Value("${defalt.sender}")
    private String sender;

    @Override
    public void sendNewPasswordEmail(Usuario usuario, String newPassword) {
        SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPassword);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuario.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}
