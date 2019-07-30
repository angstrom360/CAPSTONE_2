package com.trilogyed.AdminAPI.controller;

import com.trilogyed.AdminAPI.model.Customer;
import com.trilogyed.AdminAPI.model.Inventory;
import com.trilogyed.AdminAPI.model.LevelUp;
import com.trilogyed.AdminAPI.model.Product;
import com.trilogyed.AdminAPI.service.AdminServiceLayer;
import com.trilogyed.AdminAPI.viewmodel.InvoiceItemViewModel;
import com.trilogyed.AdminAPI.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class AdminController {

    @Autowired
    AdminServiceLayer serviceLayer;

    AdminController(AdminServiceLayer serviceLayer) {
        this.serviceLayer= serviceLayer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer createCustomer (@RequestBody Customer customer) {
        return serviceLayer.createCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Customer getCustomerById (@PathVariable int id) {
        return serviceLayer.getCustomerById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Customer> getAllCustomer() {
        return serviceLayer.getAllCustomer();
    }

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCustomer (@PathVariable ("id")int id,@RequestBody Customer customer) {
        serviceLayer.updateCustomer(id, customer);
    }

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer (@PathVariable int id) {
        serviceLayer.deleteCustomer(id);
    }


    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Inventory createInventoryCont(@RequestBody Inventory inventory) {
        return serviceLayer.createInventory(inventory);
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Inventory getInventoryByIdCont(@PathVariable int id) {
        return serviceLayer.getInventoryById(id);
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Inventory> getAllInventoryCont() {
        return serviceLayer.getAllInventory();
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateInventoryCont(@PathVariable("id") int id, @RequestBody Inventory inventory) {
        serviceLayer.updateInventory(id, inventory);
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventoryCont(@PathVariable int id) {
        serviceLayer.deleteInventory(id);
    }

    @RequestMapping(value = "/inventory/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getInventoryByProductIdCont(@PathVariable int id) {
        return serviceLayer.getInventoryByProductId(id);
    }


    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    InvoiceViewModel createInvoices(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
         return serviceLayer.createInvoice(invoiceViewModel);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    InvoiceViewModel getInvoice(@PathVariable int id) {
        return serviceLayer.getInvoice(id);
    }

    @RequestMapping(value = "/invoice/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<InvoiceViewModel> getAllInvoice() {
        return serviceLayer.getAllInvoices();
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT)
    void updateInvoices(@RequestBody @Valid InvoiceViewModel invoiceViewModel, @PathVariable int id) {
        serviceLayer.updateInvoice(invoiceViewModel, id);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInvoice(@PathVariable int id) {
        serviceLayer.deleteInvoice(id);
    }

    @RequestMapping(value = "/invoiceItem", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    InvoiceItemViewModel createInvoiceItems(@RequestBody @Valid InvoiceItemViewModel invoiceItemViewModel) {
        return serviceLayer.createInvoiceItem(invoiceItemViewModel);
    }

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    InvoiceItemViewModel getInvoiceItems(@PathVariable int id) {
        return serviceLayer.getInvoiceItem(id);
    }

    @RequestMapping(value = "/invoiceItem/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<InvoiceItemViewModel> getAllInvoiceItem() {
        return serviceLayer.getAllInvoiceItems();
    }

    @RequestMapping(value = "/invoiceItem/invoice/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<InvoiceItemViewModel> getInvoiceItemByInvoiceId(@PathVariable @Valid int id) {
        return serviceLayer.getInvoiceItemByInvoice(id);
    }

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateInvoiceItems(@RequestBody @Valid InvoiceItemViewModel invoiceItemViewModel, @PathVariable int id) {
        serviceLayer.updateInvoiceItem(invoiceItemViewModel, id);
    }

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInvoiceItem(@PathVariable int id) {
        serviceLayer.deleteInvoiceItem(id);
    }

    @RequestMapping(value = "/levelup", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    LevelUp createLevelUp(@RequestBody LevelUp levelUp) {
        return serviceLayer.createLevelUp(levelUp);
    }

    @RequestMapping(value = "/levelup/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    LevelUp getLevelUpById(@PathVariable int id) {
        return serviceLayer.getLevelUpById(id);
    }

    @RequestMapping(value = "/levelup", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<LevelUp> getAllLevelUp() {
        return serviceLayer.getAllLevelUp();
    }

    @RequestMapping(value = "/levelup/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateLevelUp(@PathVariable ("id")int id,@RequestBody LevelUp levelUp) {
        serviceLayer.updateLevelUp(id, levelUp);
    }

    @RequestMapping(value = "/levelup/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteLevelUp(@PathVariable int id) {
        serviceLayer.deleteLevelUp(id);
    }

    @RequestMapping(value = "/levelup/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    LevelUp getPointsByCustomerId(@PathVariable  int id) {
        return serviceLayer.getPointsByCustomerId(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Product createProductCont (@RequestBody Product product) {
        return serviceLayer.createProduct(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Product getProductByIdCont (@PathVariable int id) {
        return serviceLayer.getProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Product> getAllProductCont() {
        return serviceLayer.getAllProduct();
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProductCont (@PathVariable ("id")int id,@RequestBody Product product) {
        serviceLayer.updateProduct(id, product);
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductCont (@PathVariable int id) {
        serviceLayer.deleteProduct(id);
    }
}
