package com.propvuebrand.product_management.repositories;

import com.propvuebrand.product_management.models.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с сущностями Product.
 * Содержит методы для поиска продуктов по статусу,
 * суммарной стоимости продуктов и получения данных по центрам исполнения.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Поиск продуктов по статусу с игнорированием регистра.
     *
     * @param status Статус продуктов для поиска.
     * @return Список продуктов, соответствующих статусу.
     */
    @Operation(summary = "Поиск продуктов по статусу",
            description = "Ищет все продукты, у которых " +
                    "статус совпадает с указанным, игнорируя регистр.")
    @Query("SELECT p FROM Product p WHERE LOWER(p.status) = LOWER(:status)")
    List<Product> findByStatusIgnoreCase(
            @Parameter(description = "Статус продукта")
            @Param("status") String status);

    /**
     * Получение общей стоимости продуктов с статусом 'Sellable'.
     *
     * @return Сумма стоимости всех продуктов с количеством, умноженным на цену.
     */
    @Operation(summary = "Получить общую стоимость продуктов с статусом 'Sellable'",
            description = "Возвращает общую стоимость всех продуктов с статусом 'Sellable'.")
    @Query("SELECT SUM(p.value * p.quantity) FROM Product p WHERE p.status = 'Sellable'")
    Double getTotalValueForSellableProducts();

    /**
     * Получение общей стоимости продуктов для указанного центра исполнения.
     *
     * @param fulfillmentCenter Центр исполнения для фильтрации продуктов.
     * @return Сумма стоимости всех продуктов для указанного центра исполнения.
     */
    @Operation(summary = "Получить общую стоимость продуктов для центра исполнения",
            description = "Возвращает общую стоимость всех продуктов для указанного центра исполнения.")
    @Query("SELECT SUM(p.value * p.quantity) FROM Product p " +
            "WHERE LOWER(p.fulfillmentCenter) = LOWER(:fulfillmentCenter)")
    Double getTotalValueByFulfillmentCenter(
            @Parameter(description = "Центр исполнения для фильтрации продуктов")
            @Param("fulfillmentCenter")
            String fulfillmentCenter);
}