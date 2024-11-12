package com.propvuebrand.product_management.controllers;

import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-контроллер для управления продуктами.
 */
@RestController
@Tag(name = "API по управлению продуктами",
        description = "Методы для управления товарами, включая создание, " +
                "обновление и удаление.")
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    /**
     * Конструктор контроллера с внедрением зависимости ProductService.
     *
     * @param productService сервис для работы с продуктами
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Получить список всех товаров.
     *
     * @return список товаров
     */
    @GetMapping
    @Operation(summary = "Получить все товары",
            description = "Возвращает список всех товаров.")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Создать новый товар.
     *
     * @param product объект товара для создания
     * @return созданный товар
     */
    @PostMapping
    @Operation(summary = "Создать товар",
            description = "Создает новый товар и возвращает его.")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Получить товар по идентификатору.
     *
     * @param id идентификатор товара
     * @return товар с заданным идентификатором
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить товар по ID",
            description = "Возвращает товар по его идентификатору.")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Обновить товар по идентификатору.
     *
     * @param id идентификатор товара
     * @param productDetails обновленные данные товара
     * @return обновленный товар
     */
    @PutMapping("/{id}")
    @Operation(summary = "Обновить товар",
            description = "Обновляет существующий товар по его идентификатору.")
    public Product updateProduct(@PathVariable Long id,
                                 @Valid @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    /**
     * Удалить товар по идентификатору.
     *
     * @param id идентификатор товара
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар",
            description = "Удаляет товар по его идентификатору.")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    /**
     * Получить товары по статусу.
     *
     * @param status статус товара
     * @return список товаров с указанным статусом
     */
    @GetMapping("/status/{status}")
    @Operation(summary = "Получить товары по статусу",
            description = "Возвращает список товаров с указанным статусом.")
    public List<Product> getProductsByStatus(@PathVariable String status) {
        return productService.getProductsByStatus(status);
    }

    /**
     * Получить общую стоимость товаров, доступных для продажи.
     *
     * @return общая стоимость продаваемых товаров
     */
    @GetMapping("/sellable/value")
    @Operation(summary = "Общая стоимость продаваемых товаров",
            description = "Возвращает общую стоимость товаров, доступных для продажи.")
    public Double getTotalValueForSellableProducts() {
        return productService.getTotalValueForSellableProducts();
    }

    /**
     * Получить общую стоимость товаров в указанном центре исполнения.
     *
     * @param fulfillmentCenter центр исполнения
     * @return общая стоимость товаров в указанном центре исполнения
     */
    @GetMapping("/center/{fulfillmentCenter}/value")
    @Operation(summary = "Общая стоимость товаров по центру исполнения",
            description = "Возвращает общую стоимость товаров в указанном центре исполнения.")
    public Double getTotalValueByFulfillmentCenter(@PathVariable String fulfillmentCenter) {
        return productService.getTotalValueByFulfillmentCenter(fulfillmentCenter);
    }
}
