package logging;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMail {
    public static void sendMail(String mes) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String recepient = "yliana.sh41@gmail.com";
        String myAccountEmail = "yliana.sh41@gmail.com";
        String password = "slimshady1905";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient, mes);
        Transport.send(message);
        System.out.println("Message sent successfully.");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String mes) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient) );
            message.setSubject("SEVERE");
            message.setText(mes);
            return message;
        }catch (Exception ex){
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
