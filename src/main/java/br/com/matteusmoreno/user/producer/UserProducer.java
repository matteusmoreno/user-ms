package br.com.matteusmoreno.user.producer;

import br.com.matteusmoreno.user.model.User;
import br.com.matteusmoreno.user.request.CreateEmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        CreateEmailRequest request = new CreateEmailRequest();
        request.setUserId(user.getId());
        request.setEmailTo(user.getEmail());
        request.setSubject("Cadastro Realizado com Sucesso !");
        request.setText(user.getName() + ", seja bem vindo(a) !\nAgradecemos o cadastro, aproveite agora todos os recursos da nossa plataforma");

        rabbitTemplate.convertAndSend("", routingKey, request);
    }
}
