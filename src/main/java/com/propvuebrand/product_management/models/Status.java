package com.propvuebrand.product_management.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее возможные статусы.
 */
@RequiredArgsConstructor
public enum Status {

    /**
     * Статус товара, который доступен для продажи.
     */
    @Schema(description = "Товар доступен для продажи")
    Sellable("Status_Sellable"),

    /**
     * Статус товара, который не может быть исполнен.
     */
    @Schema(description = "Товар не может быть исполнен")
    Unfulfillable("Status_Unfulfillable"),

    /**
     * Статус товара, который находится в пути.
     */
    @Schema(description = "Товар находится в пути")
    Inbound("Status_Inbound");

    /**
     * Внутреннее значение статуса товара.
     */
    private final String status;

    /**
     * Получить строковое значение статуса.
     *
     * @return строковое представление статуса
     */
    public String getStatus() {
        return status;
    }
}
