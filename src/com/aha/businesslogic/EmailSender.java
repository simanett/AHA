package com.aha.businesslogic;

import com.aha.businesslogic.model.Booking;
import com.aha.service.EmailService;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author simonicsanett
 */
public class EmailSender implements EmailService {

    private final String emailAddress;
    private final String emailPassword;

    private Properties mailServerProperties;
    private Session getMailSession;
    private MimeMessage generateMailMessage;

    private static final String SUBJECT_TEMPLATE = "Confirmation for booking {0} - {1}";
    private static final String BODY_TEMPLATE = "Dear {0},<br>"
            + "Your booking <strong>{1}</strong> has been created.<br>"
            + "Details:<br>"
            + "<ul>"
            + "<li>Departure: {2}</li>"
            + "<li>Arrival: {3}</li>"
            + "<li>Departure date: {4}</li>"
            + "<li>Seat: {5}</li>"
            + "<li>Price: {6}</li>"
            + "</ul>"
            + "Yours sincerely,<br>"
            + "AHA Bookings team";

    public EmailSender(String email, String password) {
        this.emailAddress = email;
        this.emailPassword = password;
    }

    @Override
    public void sendConfirmation(Booking booking) {
        if (emailAddress == null || emailPassword == null) {
            System.out.println("No email credentials provided, will not send email.");
            return;
        }

        try {
            // Step1
            System.out.println("\n 1st ===> setup Mail Server Properties..");
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            System.out.println("Mail Server Properties have been setup successfully..");

            // Step2
            System.out.println("\n\n 2nd ===> get Mail Session..");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(booking.getPassenger().getEmail()));
            generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailAddress));
            generateMailMessage.setSubject(MessageFormat.format(SUBJECT_TEMPLATE, booking.getBookingReference(), booking.getPassenger().getName()));

            String emailBody = MessageFormat.format(BODY_TEMPLATE,
                    booking.getPassenger().getName(),
                    booking.getBookingReference(),
                    booking.getFlight().getAirportFrom().getCity(),
                    booking.getFlight().getAirportTo().getCity(),
                    booking.getFlight().getDeparture(),
                    booking.getSeat().getRow() + booking.getSeat().getLetter(),
                    booking.getPrice()
            );
            generateMailMessage.setContent(emailBody, "text/html");
            System.out.println("Mail Session has been created successfully..");

            // Step3
            System.out.println("\n\n 3rd ===> Get Session and Send mail");
            Transport transport = getMailSession.getTransport("smtp");

            // Enter your correct gmail UserID and Password
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("smtp.gmail.com", emailAddress, emailPassword);
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
