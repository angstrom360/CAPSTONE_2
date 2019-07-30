package com.trilogy.LevelUpQueueConsumer;

import com.trilogy.LevelUpQueueConsumer.model.LevelUp;
import com.trilogy.LevelUpQueueConsumer.util.feign.LevelUpApi;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelUpListener {

    @Autowired
    LevelUpApi client;

    public LevelUpListener(LevelUpApi client) {
        this.client = client;
    }

    @RabbitListener(queues = LevelUpQueueConsumerApplication.QUEUE_NAME)
    public void receiveLevelUp(LevelUp levelUp){
        if (levelUp.getId() != 0) {
            client.updateLevelUps(levelUp, levelUp.getId());
        } else {
            client.createLevelUp(levelUp);
        }
    }
}
