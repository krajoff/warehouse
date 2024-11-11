package com.propvuebrand.product_management.models;

import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее возможные статусы.
 */
@RequiredArgsConstructor
public enum Status {

    STATUS_SELLABLE("SELLABLE"),
    STATUS_UNFULFILLABLE("UNFULFILLABLE"),
    STATUS_INBOUND("INBOUND");

    private final String status;

    public String getStatus() {
        return status;
    }
}
