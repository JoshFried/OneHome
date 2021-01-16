package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.model.ConfirmationToken;
import com.htne.helpthehomeless.dal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public ConfirmationToken createAndSendEmailConfirmation(final User user) {
        final ConfirmationToken token = new ConfirmationToken(user);

        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Email Confirmation");
        email.setFrom("sc2021jf@gmail.com");
        email.setText("To confirm your email click here : "
                              + "http://localhost:8080/confirm-account?token=" + token.getConfirmationToken());
        mailSender.send(email);
        return token;
    }
}