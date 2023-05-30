package bilgeadam.service;

import bilgeadam.dto.ForgotPasswordMailResponseDto;
import bilgeadam.rabbitmq.model.RegisterMailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {
    private final JavaMailSender javaMailSender;

       public Boolean sendMailForgotPassword(ForgotPasswordMailResponseDto dto){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("${spring.mail.username}");
            mailMessage.setTo(dto.getEmail());
            mailMessage.setSubject("SIFRE SIFIRLAMA E-POSTASI");
            mailMessage.setText("Yeni şifreniz : " + dto.getPassword() +
                    "\nGiriş yaptıktan sonra güvenlik nedeniyle şifrenizi değiştiriniz.");
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            e.getMessage();
        }
        return true;
    }
}
