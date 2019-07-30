package com.trilogyed.AdminAPI.service;

import com.trilogyed.AdminAPI.model.Customer;
import com.trilogyed.AdminAPI.model.Inventory;
import com.trilogyed.AdminAPI.model.LevelUp;
import com.trilogyed.AdminAPI.model.Product;
import com.trilogyed.AdminAPI.util.*;
import com.trilogyed.AdminAPI.viewmodel.InvoiceItemViewModel;
import com.trilogyed.AdminAPI.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@Component
@RefreshScope
public class AdminServiceLayer {

    @Autowired
    CustomerServiceClient customerClient;

    @Autowired
    InventoryServiceClient inventoryClient;

    @Autowired
    InvoiceServiceClient invoiceClient;

    @Autowired
    LevelUpServiceClient levelUpClient;

    @Autowired
    ProductServiceClient productClient;

    AdminServiceLayer(CustomerServiceClient customerClient, InventoryServiceClient inventoryClient, InvoiceServiceClient invoiceClient, LevelUpServiceClient levelUpClient, ProductServiceClient productClient) {
        this.customerClient = customerClient;
        this.invoiceClient = invoiceClient;
        this.inventoryClient = inventoryClient;
        this.levelUpClient = levelUpClient;
        this.productClient = productClient;
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerClient.createCustomerCont(customer);
    }

    public Customer getCustomerById(int id) {
        return customerClient.getCustomerByIdCont(id);
    }

    public List<Customer> getAllCustomer() {
        return customerClient.getAllCustomerCont();
    }

    public void updateCustomer(int id, Customer customer) {
        customerClient.updateCustomerCont(id, customer);
    }

    public void deleteCustomer(int id) {
        customerClient.deleteCustomerCont(id);
    }

    @Transactional
    public Inventory createInventory(Inventory inventory) {
        return inventoryClient.createInventoryCont(inventory);
    }

    public Inventory getInventoryById(int id) {
        return inventoryClient.getInventoryByIdCont(id);
    }

    public List<Inventory> getAllInventory() {
        return inventoryClient.getAllInventoryCont();
    }

    public void updateInventory(int id, Inventory inventory) {
        inventoryClient.updateInventoryCont(id, inventory);
    }

    public void deleteInventory(int id) {
        inventoryClient.deleteInventoryCont(id);
    }

    public List<Inventory> getInventoryByProductId(int id) {
        return inventoryClient.getInventoryByProductIdCont(id);
    }

    @Transactional
    public InvoiceViewModel createInvoice(@Valid InvoiceViewModel invoiceViewModel) {
        return invoiceClient.createInvoices(invoiceViewModel);
    }

    public InvoiceViewModel getInvoice(int id) {
        return invoiceClient.getInvoice(id);
    }

    public List<InvoiceViewModel> getAllInvoices() {
        return invoiceClient.getAllInvoice();
    }

    public void updateInvoice(@Valid InvoiceViewModel invoiceViewModel, int id) {
        invoiceClient.updateInvoices(invoiceViewModel, id);
    }

    public void deleteInvoice(int id) {
        invoiceClient.deleteInvoice(id);
    }

    @Transactional
    public InvoiceItemViewModel createInvoiceItem(@Valid InvoiceItemViewModel invoiceItemViewModel) {
        return invoiceClient.createInvoiceItems(invoiceItemViewModel);
    }

    public InvoiceItemViewModel getInvoiceItem(int id) {
        return invoiceClient.getInvoiceItems(id);
    }

    public List<InvoiceItemViewModel> getAllInvoiceItems() {
        return invoiceClient.getAllInvoiceItem();
    }

    public List<InvoiceItemViewModel> getInvoiceItemByInvoice(@Valid int id) {
        return invoiceClient.getInvoiceItemByInvoiceId(id);
    }

    public void updateInvoiceItem(@Valid InvoiceItemViewModel invoiceItemViewModel, int id) {
        invoiceClient.updateInvoiceItems(invoiceItemViewModel, id);
    }

    public void deleteInvoiceItem(int id) {
        invoiceClient.deleteInvoiceItem(id);
    }

    @Transactional
    public LevelUp createLevelUp(LevelUp levelUp) {
        return levelUpClient.createLevelUpCont(levelUp);
    }

    public LevelUp getLevelUpById(int id) {
        return levelUpClient.getLevelUpByIdCont(id);
    }

    public List<LevelUp> getAllLevelUp() {
        return levelUpClient.getAllLevelUpCont();
    }

    public void updateLevelUp(int id, LevelUp levelUp) {
        levelUpClient.updateLevelUpCont(id, levelUp);
    }

    public void deleteLevelUp(int id) {
        levelUpClient.deleteLevelUpCont(id);
    }

    public LevelUp getPointsByCustomerId(int id) {
        return levelUpClient.getPointsByCustomerIdCont(id);
    }

    @Transactional
    public Product createProduct(Product product) {
        return productClient.createProductCont(product);
    }

    public Product getProductById(int id) {
        return productClient.getProductByIdCont(id);
    }

    public List<Product> getAllProduct() {
        return productClient.getAllProductCont();
    }

    public void updateProduct(int id, Product product) {
        productClient.updateProductCont(id, product);
    }

    public void deleteProduct(int id) {
        productClient.deleteProductCont(id);
    }
}