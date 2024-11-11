package com.propvuebrand.product_management.models;

import lombok.RequiredArgsConstructor;

/**
 *  Перечисление, представляющее центры выполнения,
 *  в котором находится продукт (например, fc5, fc3).
 */
@RequiredArgsConstructor
public enum FulfillmentCenter {

    FULFILLMENT_CENTER_FC1("FC1"),
    FULFILLMENT_CENTER_FC2("FC2"),
    FULFILLMENT_CENTER_FC3("FC3"),
    FULFILLMENT_CENTER_FC4("FC4"),
    FULFILLMENT_CENTER_FC5("FC5");

    private final String fulfillmentCenter;

    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }
}
