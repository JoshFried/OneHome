package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.model.ConfirmationToken;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.events.AvailableSpotEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final ShelterService shelterService;
    private final String         SYSTEM_EMAIL = "htne2021@gmail.com";
    private final String         URL          = "http://localhost:8080/";

    public ConfirmationToken createAndSendEmailConfirmation(final User user) {
        final ConfirmationToken token     = new ConfirmationToken(user);
        final String            emailBody = "To confirm your email click here : " + URL + "confirm-account?token=" + token.getConfirmationToken();

        sendEmail(user.getEmail(), "Email Confirmation", emailBody);
        return token;
    }

    private void sendEmail(final String to, final String subject, final String emailBody) {
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(SYSTEM_EMAIL);
        email.setSubject(subject);
        email.setTo(to);
        email.setText(emailBody);
        mailSender.send(email);
    }

    public void emailQRCode(final String to, final Path path) throws MessagingException {
        final MimeMessage       email  = mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(email, true);
        helper.setTo(to);
        helper.setSubject("Your QR code!");
        helper.setText("Please present this QR code upon check-in to help ensure you a place tonight!");
        final FileSystemResource qrCode = new FileSystemResource(path);
        helper.addAttachment("QRCode", qrCode);
        mailSender.send(email);
    }

    @EventListener
    public void availableSpotListener(final AvailableSpotEvent event) {
        final Shelter shelter = shelterService.fetchShelter(event.getShelterId());

        final String emailBody = String.format("This is an automated email, " +
                                                       "to advise you that a spot has opened up at shelter: %s " +
                                                       "if you would like to reserve this spot, please click the following link %srsvp/%d",
                                               shelter.getName(),
                                               URL,
                                               shelter.getId());

        shelter.getWaitingList().forEach(user -> sendEmail(user.getEmail(), "Shelter opening!", emailBody));
    }

}