package bilgeadam.rabbitmq.consumer;

import bilgeadam.rabbitmq.model.RegisterMailModel;
import bilgeadam.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
@RequiredArgsConstructor
public class RegisterMailConsumer {
    private final MailSenderService mailSenderService;

    /*@RabbitListener(queues = "${rabbitmq.registerMailQueue}")
    public void sendActivationCode(RegisterMailModel registerMailModel){
        mailSenderService.sendMail(registerMailModel);
    }


     */
}
