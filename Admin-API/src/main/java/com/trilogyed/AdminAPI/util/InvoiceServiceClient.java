package com.trilogyed.AdminAPI.util;

import com.trilogyed.AdminAPI.viewmodel.InvoiceItemViewModel;
import com.trilogyed.AdminAPI.viewmodel.InvoiceViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "invoice")
public interface InvoiceServiceClient {

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    InvoiceViewModel createInvoices(@RequestBody @Valid InvoiceViewModel invoiceViewModel);

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    InvoiceViewModel getInvoice(@PathVariable int id);

    @RequestMapping(value = "/invoice/all", method = RequestMethod.GET)
    List<InvoiceViewModel> getAllInvoice();

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT)
    void updateInvoices(@RequestBody @Valid InvoiceViewModel invoiceViewModel, @PathVariable int id);

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    void deleteInvoice(@PathVariable int id);

    @RequestMapping(value = "/invoiceItem", method = RequestMethod.POST)
    InvoiceItemViewModel createInvoiceItems(@RequestBody @Valid InvoiceItemViewModel invoiceItemViewModel);

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.GET)
    InvoiceItemViewModel getInvoiceItems(@PathVariable int id);

    @RequestMapping(value = "/invoiceItem/all", method = RequestMethod.GET)
    List<InvoiceItemViewModel> getAllInvoiceItem();

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.PUT)
    void updateInvoiceItems(@RequestBody @Valid InvoiceItemViewModel invoiceItemViewModel, @PathVariable int id);

    @RequestMapping(value = "/invoiceItem/{id}", method = RequestMethod.DELETE)
    void deleteInvoiceItem(@PathVariable int id);

}
