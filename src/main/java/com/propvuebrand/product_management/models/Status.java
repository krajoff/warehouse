package com.propvuebrand.product_management.models;

import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее возможные статусы.
 */
@RequiredArgsConstructor
public enum Status {

    Sellable("Status_Sellable"),
    Unfulfillable("Status_Unfulfillable"),
    Inbound("Status_Inbound");

    private final String status;

    public String getStatus() {
        return status;
    }
}
