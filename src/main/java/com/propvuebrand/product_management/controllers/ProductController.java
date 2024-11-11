package com.propvuebrand.product_management.controllers;
import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public List<Product> getProductsByStatus(@PathVariable String status) {
        return productService.getProductsByStatus(status);
    }

    @GetMapping("/sellable/value")
    public Double getTotalValueForSellableProducts() {
        return productService.getTotalValueForSellableProducts();
    }

    @GetMapping("/center/{fulfillmentCenter}/value")
    public Double getTotalValueByFulfillmentCenter(@PathVariable String fulfillmentCenter) {
        return productService.getTotalValueByFulfillmentCenter(fulfillmentCenter);
    }
}
