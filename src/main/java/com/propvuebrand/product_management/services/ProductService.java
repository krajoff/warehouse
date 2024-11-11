package com.propvuebrand.product_management.services;

import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductId(productDetails.getProductId());
        product.setStatus(productDetails.getStatus());
        product.setFulfillmentCenter(productDetails.getFulfillmentCenter());
        product.setQuantity(productDetails.getQuantity());
        product.setValue(productDetails.getValue());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByStatus(String status) {
        return productRepository.findByStatus(status);
    }

    public Double getTotalValueForSellableProducts() {
        return productRepository.getTotalValueForSellableProducts();
    }

    public Double getTotalValueByFulfillmentCenter(String fulfillmentCenter) {
        return productRepository.getTotalValueByFulfillmentCenter(fulfillmentCenter);
    }
}
