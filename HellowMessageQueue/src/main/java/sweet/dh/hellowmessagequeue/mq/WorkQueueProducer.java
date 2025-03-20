package sweet.dh.hellowmessagequeue.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorkQueueProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendWorkQueue(String workQueueMessage, int duration, boolean error) {
        String message = workQueueMessage + "|" + duration + "|" + error;
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("Sent workqueue " + message);
    }

}