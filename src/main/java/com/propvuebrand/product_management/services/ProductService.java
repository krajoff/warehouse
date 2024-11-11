package com.propvuebrand.product_management.services;

import com.propvuebrand.product_management.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getProductsByStatus(String status);

    Double getTotalValueForSellableProducts();

    Double getTotalValueByFulfillmentCenter(String fulfillmentCenter);

}
