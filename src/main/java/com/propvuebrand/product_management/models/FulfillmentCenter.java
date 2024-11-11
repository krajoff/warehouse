package com.propvuebrand.product_management.models;

import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее центры выполнения,
 * в котором находится продукт (например, fc5, fc3).
 */
@RequiredArgsConstructor
public enum FulfillmentCenter {

    fc1("FULFILLMENT_CENTER_FC1"),
    fc2("FULFILLMENT_CENTER_FC2"),
    fc3("FULFILLMENT_CENTER_FC3"),
    fc4("FULFILLMENT_CENTER_FC4"),
    fc5("FULFILLMENT_CENTER_FC5");

    private final String fulfillmentCenter;

    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }

}
