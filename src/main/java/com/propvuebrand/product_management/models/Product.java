package com.propvuebrand.product_management.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * Уникальный идентификатор продукта в таблице.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Идентификатор продукта (например, p1, p2).
     */
    @Column(name = "product_id", nullable = false)
    private String productId;

    /**
     * Состояние продукта (например, Sellable, Unfulfillable).
     */
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Центр выполнения, в котором находится продукт (например, fc5, fc3).
     */
    @Column(name = "fulfillment_center", nullable = false)
    @Enumerated(EnumType.STRING)
    private FulfillmentCenter fulfillmentCenter;

    /**
     * Количество единиц продукта.
     */
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * Стоимость продукта за единицу.
     */
    @Column(name = "value", nullable = false)
    private double value;

    /**
     * Дата создания. Поле автоматически заполняется
     * при создании и не может быть обновлено.
     */
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    /**
     * Дата последнего обновления. Поле автоматически обновляется
     * при каждом изменении записи.
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * Версия.
     */
    @Version
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

