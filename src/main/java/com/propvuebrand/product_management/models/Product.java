package com.propvuebrand.product_management.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * Представляет продукт с идентификатором, статусом, количеством, стоимостью и информацией о центре исполнения.
 * Этот класс используется для хранения информации о продукте в базе данных.
 *
 * <p>Пример:</p>
 * <pre>
 * product.setProductId("p1");
 * product.setStatus("Sellable");
 * product.setQuantity(100);
 * product.setValue(10.0);
 * </pre>
 *
 * @version 1.0
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность продукта")
public class Product {

    /**
     * Уникальный идентификатор продукта в таблице.
     */
    @Schema(description = "Уникальный идентификатор продукта", example = "1")
    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long id;

    /**
     * Идентификатор продукта (например, p1, p2).
     */
    @Schema(description = "Идентификатор продукта", example = "p1")
    @Column(name = "product_id", nullable = false)
    private String productId;

    /**
     * Состояние продукта (например, Sellable, Unfulfillable).
     */
    @Schema(description = "Состояние продукта", example = "Sellable")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Центр выполнения, в котором находится продукт (например, fc5, fc3).
     */
    @Schema(description = "Центр выполнения, в котором находится продукт",
            example = "fc5")
    @Column(name = "fulfillment_center", nullable = false)
    @Enumerated(EnumType.STRING)
    private FulfillmentCenter fulfillmentCenter;

    /**
     * Количество единиц продукта.
     */
    @Schema(description = "Количество единиц продукта", example = "401")
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * Стоимость продукта за единицу.
     */
    @Schema(description = "Стоимость продукта за единицу", example = "10")
    @Column(name = "value", nullable = false)
    private double value;

    /**
     * Дата создания. Поле автоматически заполняется
     * при создании и не может быть обновлено.
     */
    @CreationTimestamp
    @JsonIgnore
    @Schema(description = "Дата создания", example = "2024-11-12T06:19:32.895Z")
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    /**
     * Дата последнего обновления. Поле автоматически обновляется
     * при каждом изменении записи.
     */
    @UpdateTimestamp
    @JsonIgnore
    @Schema(description = "Дата последнего обновления", example = "2024-11-12T06:19:32.895Z")
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * Версия.
     */
    @Version
    @JsonIgnore
    @Schema(description = "Версия", example = "1")
    @Column(name = "version")
    private Long version = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (Double.compare(getValue(), product.getValue()) != 0) return false;
        return getProductId() != null ? getProductId().equals(product.getProductId()) : product.getProductId() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getProductId() != null ? getProductId().hashCode() : 0;
        temp = Double.doubleToLongBits(getValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

