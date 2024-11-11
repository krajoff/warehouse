package com.propvuebrand.product_management.services;

import com.propvuebrand.product_management.exceptions.ProductNotFoundException;
import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.models.Status;
import com.propvuebrand.product_management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

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

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByStatus(String status) {

        Status enumStatus = Status.valueOf(status);
        return productRepository.findByStatusIgnoreCase(enumStatus);
    }

    public Double getTotalValueForSellableProducts() {
        return productRepository.getTotalValueForSellableProducts();
    }

    public Double getTotalValueByFulfillmentCenter(String fulfillmentCenter) {
        return productRepository.getTotalValueByFulfillmentCenter(fulfillmentCenter);
    }
}
