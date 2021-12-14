package com.unistore.server.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class OrderRequest {
    private Set<ProductQuantity> product;

    private int quantity;

    private Double total;

    public Set<ProductQuantity> getProduct() {
        return product;
    }

    public void setProduct(Set<ProductQuantity> product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
