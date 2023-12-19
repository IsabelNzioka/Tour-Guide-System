package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.AuditLog;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Email;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import java.io.Serializable;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Singleton
public class EmailBean implements EmailBeanI, Serializable {
    private final int port = 587;
    private final String host = "smtp-mail.outlook.com";

    private final String from = "natatours@outlook.com";
    private final boolean auth = true;
    private final Session session;
    private final String password = "nzioka15";
    private final String username = "natatours@outlook.com";
    private final boolean debug = true;

    public EmailBean(){

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable","true");

        this.session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(debug);

    }
   
   @Override
   public void sendEmail(Email email) {

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(email.getRecipient())};
            InternetAddress[] replyToEmail = {new InternetAddress(from)};

            message.setRecipients(Message.RecipientType.TO, address);
            message.setReplyTo(replyToEmail);
            message.setSubject(email.getSubject());
            message.setSentDate(new Date());
            message.setContent(email.getMessage(),"text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException ex) {
            System.out.println("ex = " + ex);;
            throw new RuntimeException(ex);
        }

    }

    public void email(@Observes Booking book) {
        System.out.println("Emailing");


        StringBuilder stringBuilder = new StringBuilder()
                .append("Dear ").append(book.getUser().getUsername())
                .append(", \n").append(" Your Booking for ")
                .append(book.getNoOfPeople()).append("people ")
                .append("at $").append(book.getTotalPrice())
                .append(" has been received successfully. \n")
                .append("Please pay your deposit of $100 to complete the booking. ")
                .append("\n Thank you. " +
                        "\n Yours Nata Tours");


        Email email = new Email();
        email.setSubject("Booking Completed Successfully");
        email.setRecipient(book.getUser().getEmail());
        email.setMessage(stringBuilder.toString());
        sendEmail(email);

    }

}
