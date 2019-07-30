package com.trilogyed.AdminAPI.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {
    private int Id;
    private String productName;
    private String productDescription;
    private BigDecimal listPrince;
    private BigDecimal unitCost;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getListPrince() {
        return listPrince;
    }

    public void setListPrince(BigDecimal listPrince) {
        this.listPrince = listPrince;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Id == product.Id &&
                productName.equals(product.productName) &&
                productDescription.equals(product.productDescription) &&
                listPrince.equals(product.listPrince) &&
                unitCost.equals(product.unitCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, productName, productDescription, listPrince, unitCost);
    }
}

