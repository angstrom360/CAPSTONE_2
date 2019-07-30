package com.trilogyed.Invoice.model;

import java.time.LocalDate;
import java.util.Objects;

public class Invoice {

    private int invoiceId;
    private int customerId;
    private LocalDate purchaseDate;

    public Invoice(int invoiceId, int customerId, LocalDate purchaseDate) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.purchaseDate = purchaseDate;
    }

    public Invoice() {
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                customerId == invoice.customerId &&
                purchaseDate.equals(invoice.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customerId, purchaseDate);
    }
}
