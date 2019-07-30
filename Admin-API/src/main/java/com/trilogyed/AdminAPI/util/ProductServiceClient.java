package com.trilogyed.AdminAPI.util;

import com.trilogyed.AdminAPI.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product")
public interface ProductServiceClient {

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    Product createProductCont (@RequestBody Product product);

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    Product getProductByIdCont (@PathVariable int id);

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    List<Product> getAllProductCont();

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    void updateProductCont (@PathVariable ("id")int id,@RequestBody Product product);

    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    public void deleteProductCont (@PathVariable int id);

}
