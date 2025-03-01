package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "test2@test.com", "Test", "Test Message");

        Mail mail2 = Mail.builder()
                .mailTo("test3@test.com")
                .toCc("test4@test.com")
                .subject("Teeeestyy")
                .message("To jest wersja testowa")
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail2.getMailTo());
        mailMessage.setSubject(mail2.getSubject());
        mailMessage.setText(mail2.getMessage());
        mailMessage.setCc(mail2.getToCc());

        //When
        simpleEmailService.send(mail2);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);

    }

}