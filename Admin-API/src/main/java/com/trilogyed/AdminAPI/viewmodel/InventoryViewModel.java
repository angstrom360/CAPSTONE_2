package com.trilogyed.AdminAPI.viewmodel;

import com.trilogyed.AdminAPI.model.Product;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class InventoryViewModel {
    @NotNull
    private int inventoryId;
    @NotNull
    private List<Product> products;
    @NotNull
    private int quantity;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getQuanitity() {
        return quantity;
    }

    public void setQuanitity(int quanitity) {
        this.quantity = quanitity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryViewModel that = (InventoryViewModel) o;
        return inventoryId == that.inventoryId &&
                quantity == that.quantity &&
                products.equals(that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, products, quantity);
    }
}
