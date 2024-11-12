package com.propvuebrand.product_management.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее центры выполнения,
 * в котором находится продукт (например, fc5, fc3).
 */
@RequiredArgsConstructor
@Schema(description = "Перечисление, представляющее различные центры")
public enum FulfillmentCenter {

    /**
     * Центр исполнения FC1.
     */
    @Schema(description = "Центр исполнения FC1")
    fc1("FULFILLMENT_CENTER_FC1"),

    /**
     * Центр исполнения FC2.
     */
    @Schema(description = "Центр исполнения FC2")
    fc2("FULFILLMENT_CENTER_FC2"),

    /**
     * Центр исполнения FC3.
     */
    @Schema(description = "Центр исполнения FC3")
    fc3("FULFILLMENT_CENTER_FC3"),

    /**
     * Центр исполнения FC4.
     */
    @Schema(description = "Центр исполнения FC4")
    fc4("FULFILLMENT_CENTER_FC4"),

    /**
     * Центр исполнения FC5.
     */
    @Schema(description = "Центр исполнения FC5")
    fc5("FULFILLMENT_CENTER_FC5");


    /**
     * Уникальный идентификатор центра.
     */
    @Schema(description = "Уникальный идентификатор центра")
    private final String fulfillmentCenter;

    /**
     * Получить строковое значение.
     *
     * @return строковое представление
     */
    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }

}
