package net.cloudcentrik.dagenslunch.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(){
        MimeMessagePreparator messagePreparator = mimeMessage -> {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("info.cloudcentrik@gmail.com");
            helper.setTo("ismail7043@yahoo.com");
            helper.setSubject("Dagenslunch server");
            helper.setText("Test Email from Dagenslunch server");
        };

        mailSender.send(messagePreparator);
    }
}
