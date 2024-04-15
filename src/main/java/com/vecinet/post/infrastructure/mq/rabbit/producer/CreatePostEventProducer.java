package com.vecinet.post.infrastructure.mq.rabbit.producer;

import com.vecinet.post.domain.port.EventPort;
import com.vecinet.post.domain.port.EventProducerPort;
import com.vecinet.post.infrastructure.mq.rabbit.config.CreatePostConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("createPostEventProducer")
public class CreatePostEventProducer implements EventProducerPort {
    private final RabbitTemplate rabbitTemplate;

    public CreatePostEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Override
//    public EventPort sendSyncEvent(EventPort event) {
//        // Configura un tiempo de espera máximo en milisegundos (por ejemplo, 5000 ms = 5 segundos)
//        long timeoutMillis = 5000;
//
//        // Crea un MessagePostProcessor para configurar el tiempo de espera en el mensaje
//        MessagePostProcessor messagePostProcessor = message -> {
//            message.getMessageProperties().setExpiration(String.valueOf(timeoutMillis));
//            return message;
//        };
//
//        // Envía el evento a la cola y espera una respuesta con un tiempo de espera máximo
//        Object response = this.rabbitTemplate.convertSendAndReceive("create-post-sync", event, messagePostProcessor);
//
//        // Verifica si se recibió una respuesta
//        if (response != null) {
//            return response.toString();
//        } else {
//            // Maneja el caso de tiempo de espera excedido
//            throw new TimeoutException("Tiempo de espera máximo excedido al esperar la respuesta del evento");
//        }
//    }

    @Override
    public void sendAsyncEvent(EventPort event) {
        this.rabbitTemplate.convertAndSend(CreatePostConfig.EXCHANGE_NAME, CreatePostConfig.ROUTING_KEY, event);
    }
}
