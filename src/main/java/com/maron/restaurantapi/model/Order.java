package com.maron.restaurantapi.model;

public class Order {
    private Long id;
    private Long dishId;
    private String customerName;

    public Order() {} // חובה עבור JSON

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
