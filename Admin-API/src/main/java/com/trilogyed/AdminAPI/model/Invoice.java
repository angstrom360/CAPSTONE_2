package com.trilogyed.AdminAPI.model;

import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private int Id;
    private int customerId;
    private LocalDate purchaseDate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return Id == invoice.Id &&
                customerId == invoice.customerId &&
                purchaseDate.equals(invoice.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, customerId, purchaseDate);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Id=" + Id +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}

