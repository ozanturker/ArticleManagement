/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author ozan
 */
public class SendMail {

    public SendMail(String receiver, String subject, String content) {
        send(receiver, subject, content);
    }

    public void send(String receiver, String subject, String content) {
        final String username = "ozanturkerceng@gmail.com";
        final String password = "turker35";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ozanturkerceng@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            JOptionPane.showMessageDialog(null, "E-mail send succesfully!", "Information Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "E-mail send fail!", "Information Message", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);

        }
    }
}
