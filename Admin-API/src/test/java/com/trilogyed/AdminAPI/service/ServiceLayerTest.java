package com.trilogyed.AdminAPI.service;


import com.trilogyed.AdminAPI.model.*;
import com.trilogyed.AdminAPI.util.*;
import com.trilogyed.AdminAPI.viewmodel.InvoiceItemViewModel;
import com.trilogyed.AdminAPI.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    @Mock
    CustomerServiceClient customerClient;

    @Mock
    InventoryServiceClient inventoryClient;

    @Mock
    InvoiceServiceClient invoiceClient;

    @Mock
    LevelUpServiceClient levelUpClient;

    @Mock
    ProductServiceClient productClient;

    AdminServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpCustomerServer();
        setUpInventoryServer();
        setUpInvoiceServer();
        setUpLevelUpServer();
        setUpProductServer();
        serviceLayer = new AdminServiceLayer(customerClient,inventoryClient,invoiceClient,levelUpClient,productClient);
    }
    public void setUpCustomerServer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("First");
        customer.setLastName("Last");
        customer.setStreet("Street");
        customer.setCity("City");
        customer.setZip("Zip");
        customer.setEmail("Email");
        customer.setPhone("Phone");

        Customer customer1 = new Customer();
        customer1.setFirstName("First");
        customer1.setLastName("Last");
        customer1.setStreet("Street");
        customer1.setCity("City");
        customer1.setZip("Zip");
        customer1.setEmail("Email");
        customer1.setPhone("Phone");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        
        doReturn(customer).when(customerClient).createCustomerCont(customer1);
        doReturn(customer).when(customerClient).getCustomerByIdCont(customer.getId());
        doReturn(customerList).when(customerClient).getAllCustomerCont();

    }
    public void setUpInventoryServer() {
        /*Product product = new Product();
        product.setId(1);
        product.setProductName("Name");
        product.setProductDescription("Description");
        product.setListPrince(new BigDecimal(4.55));
        product.setUnitCost(new BigDecimal(4.55));*/

        Inventory inventory = new Inventory();
        inventory.setId(1);
        inventory.setProductId(2);
        inventory.setQuantity(3);

        Inventory inventory1 = new Inventory();
        inventory1.setProductId(2);
        inventory1.setQuantity(3);

        List<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);

        doReturn(inventory).when(inventoryClient).createInventoryCont(inventory1);
        doReturn(inventory).when(inventoryClient).getInventoryByIdCont(inventory.getId());
        doReturn(inventoryList).when(inventoryClient).getAllInventoryCont();
        //doReturn(inventory).when(inventoryClient).getInventoryByProductIdCont(product.getId());

    }
    public void setUpInvoiceServer() {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(1);
        invoiceViewModel.setCustomerId(2);
        invoiceViewModel.setPurchaseDate(LocalDate.now());
        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        InvoiceItem invoiceItem1 = new InvoiceItem(1,2,3,4,new BigDecimal(5.99));
        invoiceItemList.add(invoiceItem1);
        invoiceViewModel.setInvoiceItems(invoiceItemList);


        InvoiceViewModel invoiceViewModel1 = new InvoiceViewModel();
        invoiceViewModel1.setCustomerId(2);
        invoiceViewModel1.setPurchaseDate(LocalDate.now());
        List<InvoiceItem> invoiceItemList1 = new ArrayList<>();
        InvoiceItem invoiceItem2 = new InvoiceItem(1,2,3,4,new BigDecimal(5.99));
        invoiceItemList1.add(invoiceItem2);
        invoiceViewModel1.setInvoiceItems(invoiceItemList1);

        List<InvoiceViewModel> invoiceList = new ArrayList<>();
        invoiceList.add(invoiceViewModel);

        doReturn(invoiceViewModel).when(invoiceClient).createInvoices(invoiceViewModel1);
        doReturn(invoiceViewModel).when(invoiceClient).getInvoice(invoiceViewModel.getId());
        doReturn(invoiceList).when(invoiceClient).getAllInvoice();
        //doReturn(invoiceViewModel).when(invoiceClient).getInvoiceItemByInvoiceId(1);

        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel();
        invoiceItemViewModel.setInvoiceItemId(1);
        invoiceItemViewModel.setInvoiceId(2);
        invoiceItemViewModel.setInventoryId(1);
        invoiceItemViewModel.setQuantity(2);
        invoiceItemViewModel.setUnitPrice(new BigDecimal(2.55));

        InvoiceItemViewModel invoiceItemViewModel1 = new InvoiceItemViewModel();
        invoiceItemViewModel1.setInvoiceId(2);
        invoiceItemViewModel1.setInventoryId(1);
        invoiceItemViewModel1.setQuantity(2);
        invoiceItemViewModel1.setUnitPrice(new BigDecimal(2.55));

        List<InvoiceItemViewModel> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItemViewModel);

        doReturn(invoiceItemViewModel).when(invoiceClient).createInvoiceItems(invoiceItemViewModel1);
        doReturn(invoiceItemViewModel).when(invoiceClient).getInvoiceItems(invoiceViewModel.getId());
        //doReturn(invoiceItemViewModel).when(invoiceClient).getInvoiceItemByInvoiceId(1);
        doReturn(invoiceItems).when(invoiceClient).getAllInvoiceItem();

    }

    public void setUpLevelUpServer() {
        LevelUp levelUp = new LevelUp();
        levelUp.setId(1);
        levelUp.setCustomerId(2);
        levelUp.setPoints(3);
        levelUp.setMemberDate(LocalDate.now());

        LevelUp levelUp1 = new LevelUp();
        levelUp1.setCustomerId(2);
        levelUp1.setPoints(3);
        levelUp1.setMemberDate(LocalDate.now());

        List<LevelUp> levelUpList = new ArrayList<>();
        levelUpList.add(levelUp);

        doReturn(levelUp).when(levelUpClient).createLevelUpCont(levelUp1);
        doReturn(levelUp).when(levelUpClient).getLevelUpByIdCont(levelUp.getId());
        doReturn(levelUp).when(levelUpClient).getPointsByCustomerIdCont(levelUp.getCustomerId());
        doReturn(levelUpList).when(levelUpClient).getAllLevelUpCont();


    }
    public void setUpProductServer() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Name");
        product.setProductDescription("Description");
        product.setListPrince(new BigDecimal(4.55));
        product.setUnitCost(new BigDecimal(4.55));

        Product product1 = new Product();
        product1.setProductName("Name");
        product1.setProductDescription("Description");
        product1.setListPrince(new BigDecimal(4.55));
        product1.setUnitCost(new BigDecimal(4.55));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        doReturn(product).when(productClient).createProductCont(product1);
        doReturn(product).when(productClient).getProductByIdCont(product.getId());
        doReturn(productList).when(productClient).getAllProductCont();

    }

    @Test
    public void addGetCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("First");
        customer.setLastName("Last");
        customer.setStreet("Street");
        customer.setCity("City");
        customer.setZip("Zip");
        customer.setEmail("Email");
        customer.setPhone("Phone");

        customer = serviceLayer.createCustomer(customer);
        Customer customer1 = serviceLayer.getCustomerById(customer.getId());
        assertEquals(customer, customer1);
    }
    @Test
    public void getAllCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("First");
        customer.setLastName("Last");
        customer.setStreet("Street");
        customer.setCity("City");
        customer.setZip("Zip");
        customer.setEmail("Email");
        customer.setPhone("Phone");

        customer = serviceLayer.createCustomer(customer);
        List<Customer> customerList = serviceLayer.getAllCustomer();
        assertEquals(1, customerList.size());
    }

    @Test
    public void addGetInventory() {
        Inventory inventory = new Inventory();
        inventory.setProductId(2);
        inventory.setQuantity(3);

        inventory=serviceLayer.createInventory(inventory);
        Inventory inventory1 = serviceLayer.getInventoryById(inventory.getId());
        assertEquals(inventory, inventory1);
    }
    @Test
    public void getAllInventory() {
        Inventory inventory = new Inventory();
        inventory.setProductId(2);
        inventory.setQuantity(3);

        inventory=serviceLayer.createInventory(inventory);
        List<Inventory> inventory1 = serviceLayer.getAllInventory();
        assertEquals(1, inventory1.size());
    }
    @Test
    public void addGetInvoice() {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setCustomerId(2);
        invoiceViewModel.setPurchaseDate(LocalDate.now());
        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        InvoiceItem invoiceItem1 = new InvoiceItem(1, 2, 3, 4, new BigDecimal(5.99));
        invoiceItemList.add(invoiceItem1);
        invoiceViewModel.setInvoiceItems(invoiceItemList);

        invoiceViewModel = serviceLayer.createInvoice(invoiceViewModel);

        InvoiceViewModel invoiceViewModel1 = serviceLayer.getInvoice(invoiceViewModel.getId());

        assertEquals(invoiceViewModel, invoiceViewModel1);
    }
    @Test
    public void getAllInvoice() {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setCustomerId(2);
        invoiceViewModel.setPurchaseDate(LocalDate.now());
        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        InvoiceItem invoiceItem1 = new InvoiceItem(1, 2, 3, 4, new BigDecimal(5.99));
        invoiceItemList.add(invoiceItem1);
        invoiceViewModel.setInvoiceItems(invoiceItemList);

        invoiceViewModel = serviceLayer.createInvoice(invoiceViewModel);

        List<InvoiceViewModel> invoiceViewModelList = serviceLayer.getAllInvoices();

        assertEquals(1, invoiceItemList.size());
    }
    @Test
    public void addGetInvoiceItem() {
        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel();
        invoiceItemViewModel.setInvoiceId(2);
        invoiceItemViewModel.setInventoryId(1);
        invoiceItemViewModel.setQuantity(2);
        invoiceItemViewModel.setUnitPrice(new BigDecimal(2.55));

        invoiceItemViewModel = serviceLayer.createInvoiceItem(invoiceItemViewModel);

        InvoiceItemViewModel invoiceItemViewModel1 = serviceLayer.getInvoiceItem(invoiceItemViewModel.getInvoiceItemId());

        assertEquals(invoiceItemViewModel, invoiceItemViewModel1);
    }
    @Test
    public void getAllInvoiceItem() {
        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel();
        invoiceItemViewModel.setInvoiceId(2);
        invoiceItemViewModel.setInventoryId(1);
        invoiceItemViewModel.setQuantity(2);
        invoiceItemViewModel.setUnitPrice(new BigDecimal(2.55));

        invoiceItemViewModel = serviceLayer.createInvoiceItem(invoiceItemViewModel);

        List<InvoiceItemViewModel> invoiceItemViewModelList = serviceLayer.getAllInvoiceItems();

        assertEquals(1, invoiceItemViewModelList.size());
    }
    @Test
    public void addGetLevelUp() {
        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(3);
        levelUp.setMemberDate(LocalDate.now());

        levelUp = serviceLayer.createLevelUp(levelUp);

        LevelUp levelUp1 = serviceLayer.getLevelUpById(levelUp.getId());

        assertEquals(levelUp, levelUp1);

    }
    @Test
    public void getAllLevelUp() {
        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(3);
        levelUp.setMemberDate(LocalDate.now());

        levelUp = serviceLayer.createLevelUp(levelUp);

        List<LevelUp> levelUpList = serviceLayer.getAllLevelUp();

        assertEquals(1, levelUpList.size());

    }

    @Test
    public void getLevelUpByCustomerId() {
        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(3);
        levelUp.setMemberDate(LocalDate.now());

        levelUp = serviceLayer.createLevelUp(levelUp);

        levelUp = serviceLayer.getPointsByCustomerId(levelUp.getCustomerId());
        int points = levelUp.getPoints();
        assertEquals(3, points);

    }

    @Test
    public void addGetProduct() {
        Product product = new Product();
        product.setProductName("Name");
        product.setProductDescription("Description");
        product.setListPrince(new BigDecimal(4.55));
        product.setUnitCost(new BigDecimal(4.55));

        product = serviceLayer.createProduct(product);

        Product product1 = serviceLayer.getProductById(product.getId());

        assertEquals(product, product1);
    }

    @Test
    public void getAllProduct() {
        Product product = new Product();
        product.setProductName("Name");
        product.setProductDescription("Description");
        product.setListPrince(new BigDecimal(4.55));
        product.setUnitCost(new BigDecimal(4.55));

        product = serviceLayer.createProduct(product);

        List<Product> productList = serviceLayer.getAllProduct();

        assertEquals(1, productList.size());
    }
}
