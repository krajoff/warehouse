package com.propvuebrand.product_management.services;

import com.propvuebrand.product_management.exceptions.ProductNotFoundException;
import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.models.Status;
import com.propvuebrand.product_management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для управления продуктами.
 * Этот класс предоставляет бизнес-логику для работы с продуктами,
 * включая создание, обновление, удаление и получение данных о продуктах.
 * Он использует {@link ProductRepository} для взаимодействия с базой данных.
 * <p>Методы, представленные в этом сервисе, предназначены для работы с
 * продуктами в рамках бизнес-логики приложения.</p>
 *
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Конструктор, инициализирующий сервис с {@link ProductRepository}.
     *
     * @param productRepository репозиторий для взаимодействия с базой данных продуктов
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Получает все продукты.
     *
     * @return список всех продуктов в базе данных
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Создает новый продукт.
     *
     * @param product продукт, который будет создан
     * @return созданный продукт
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Получает продукт по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор продукта
     * @return продукт с указанным идентификатором
     * @throws ProductNotFoundException если продукт не найден
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    /**
     * Обновляет существующий продукт.
     *
     * @param id             уникальный идентификатор продукта, который нужно обновить
     * @param productDetails новые данные продукта
     * @return обновленный продукт
     * @throws ProductNotFoundException если продукт с
     *                                  указанным идентификатором не найден
     */
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        product.setProductId(productDetails.getProductId());
        product.setStatus(productDetails.getStatus());
        product.setFulfillmentCenter(productDetails.getFulfillmentCenter());
        product.setQuantity(productDetails.getQuantity());
        product.setValue(productDetails.getValue());
        return productRepository.save(product);
    }

    /**
     * Удаляет продукт по уникальному идентификатору.
     *
     * @param id уникальный идентификатор продукта, который нужно удалить
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Получает список продуктов по статусу.
     *
     * @param status статус, по которому нужно отфильтровать продукты
     * @return список продуктов с указанным статусом
     */
    public List<Product> getProductsByStatus(String status) {
        return productRepository.findByStatusIgnoreCase(status);
    }

    /**
     * Рассчитывает общую стоимость продуктов со статусом "Sellable".
     *
     * @return общая стоимость продуктов со статусом "Sellable"
     */
    public Double getTotalValueForSellableProducts() {
        return productRepository.getTotalValueForSellableProducts();
    }

    /**
     * Рассчитывает общую стоимость продуктов для указанного центра выполнения.
     *
     * @param fulfillmentCenter центр выполнения, для которого нужно рассчитать стоимость
     * @return общая стоимость продуктов для указанного центра выполнения
     */
    public Double getTotalValueByFulfillmentCenter(String fulfillmentCenter) {
        return productRepository.getTotalValueByFulfillmentCenter(fulfillmentCenter);
    }
}
