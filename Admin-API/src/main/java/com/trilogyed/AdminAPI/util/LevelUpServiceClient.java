package com.trilogyed.AdminAPI.util;

import com.trilogyed.AdminAPI.model.LevelUp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "levelUp")
public interface LevelUpServiceClient {

    @RequestMapping(value = "/levelup", method = RequestMethod.POST)
    LevelUp createLevelUpCont (@RequestBody LevelUp levelUp);

    @RequestMapping(value = "/levelup/{id}", method = RequestMethod.GET)
    LevelUp getLevelUpByIdCont(@PathVariable int id);

    @RequestMapping(value = "/levelup", method = RequestMethod.GET)
    List<LevelUp> getAllLevelUpCont();

    @RequestMapping(value = "/levelup/{id}",method = RequestMethod.PUT)
    void updateLevelUpCont (@PathVariable ("id")int id,@RequestBody LevelUp levelUp);

    @RequestMapping(value = "/levelup/{id}",method = RequestMethod.DELETE)
    void deleteLevelUpCont (@PathVariable int id);

    }
