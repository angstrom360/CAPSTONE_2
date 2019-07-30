package com.trilogy.LevelUpQueueConsumer.util.feign;

import com.trilogy.LevelUpQueueConsumer.model.LevelUp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@FeignClient(name = "levelUp")
public interface LevelUpApi {

    @RequestMapping(value = "/levelUp/customer/{id}", method = RequestMethod.GET)
    LevelUp getLevelUpByCustomerId(@PathVariable @Valid int id);

    @RequestMapping(value = "/levelUp/{id}", method = RequestMethod.PUT)
    void updateLevelUps(@RequestBody @Valid LevelUp levelUp, @PathVariable int id);

    @RequestMapping(value = "/levelUp", method = RequestMethod.POST)
    LevelUp createLevelUp(@RequestBody @Valid LevelUp levelUp);


}
