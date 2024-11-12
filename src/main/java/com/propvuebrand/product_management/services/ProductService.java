package com.propvuebrand.product_management.services;

import com.propvuebrand.product_management.models.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * Сервис для управления товарами.
 */
@Tag(name = "Product Service", description = "Операции для управления товарами")
public interface ProductService {

    /**
     * Получить список всех товаров.
     *
     * @return список всех товаров
     */
    @Operation(summary = "Получить все товары", description = "Возвращает список всех товаров")
    List<Product> getAllProducts();

    /**
     * Создать новый товар.
     *
     * @param product объект товара для создания
     * @return созданный товар
     */
    @Operation(summary = "Создать товар", description = "Создает новый товар")
    Product createProduct(Product product);

    /**
     * Получить товар по уникальному идентификатору.
     *
     * @param id идентификатор товара
     * @return товар с заданным идентификатором
     */
    @Operation(summary = "Получить товар по ID",
            description = "Возвращает товар по его идентификатору")
    Product getProductById(Long id);

    /**
     * Обновить существующий товар.
     *
     * @param id идентификатор товара для обновления
     * @param product обновленные данные товара
     * @return обновленный товар
     */
    @Operation(summary = "Обновить товар",
            description = "Обновляет существующий товар по идентификатору")
    Product updateProduct(Long id, Product product);

    /**
     * Удалить товар по идентификатору.
     *
     * @param id идентификатор товара для удаления
     */
    @Operation(summary = "Удалить товар",
            description = "Удаляет товар по его идентификатору")
    void deleteProduct(Long id);

    /**
     * Получить товары по статусу.
     *
     * @param status статус товара
     * @return список товаров с заданным статусом
     */
    @Operation(summary = "Получить товары по статусу",
            description = "Возвращает товары на основе статуса")
    List<Product> getProductsByStatus(String status);

    /**
     * Получить общую стоимость товаров со статусом "доступен для продажи".
     *
     * @return общая стоимость товаров, доступных для продажи
     */
    @Operation(summary = "Общая стоимость продаваемых товаров",
            description = "Вычисляет общую стоимость товаров, доступных для продажи")
    Double getTotalValueForSellableProducts();

    /**
     * Получить общую стоимость товаров по центру исполнения.
     *
     * @param fulfillmentCenter центр исполнения
     * @return общая стоимость товаров в указанном центре исполнения
     */
    @Operation(summary = "Общая стоимость товаров по центру исполнения",
            description = "Вычисляет общую стоимость товаров в указанном центре исполнения")
    Double getTotalValueByFulfillmentCenter(String fulfillmentCenter);

}
