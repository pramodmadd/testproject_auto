package Mails;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail2 {

    public static void main(String[] args) {

        // SMTP Username change accordingly
        final String username = "728e73a6ce02b9";
        // SMTP password change accordingly
        final String password = "e60b50f7ca374f";
        // or IP address
        final String host = "smtp.mailtrap.io";
        // Get system properties
        Properties props = new Properties();
        // Enable authentication
        props.put("mail.smtp.auth", "true");
        // Enable STARTTLS
        props.put("mail.smtp.starttls.enable", "true");
        // Setup mail server
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        // TLS Port
        props.put("mail.smtp.port", "25");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // compose the message
            // javax.mail.internet.MimeMessage class is
            // mostly used for abstraction.
            Message message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress("pramodcrazy063@gmail.com"));
            //Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pramodmaddu7@gmail.com"));
            // Set the subject
            message.setSubject("hello");
            // Set the body of the email
            message.setText("Yo it has been sent");
            // Send the message
            Transport.send(message);

            System.out.println("Email Sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
