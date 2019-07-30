package com.trilogyed.AdminAPI.util;

import com.trilogyed.AdminAPI.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventory")
public interface InventoryServiceClient {

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    Inventory createInventoryCont(@RequestBody Inventory inventory);

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    Inventory getInventoryByIdCont(@PathVariable int id);

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    List<Inventory> getAllInventoryCont();

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    void updateInventoryCont(@PathVariable("id") int id, @RequestBody Inventory inventory);

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
    public void deleteInventoryCont(@PathVariable int id);


}
