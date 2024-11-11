package com.propvuebrand.product_management.controllers;

import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "API по управлению продуктами")
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
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @Valid @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
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
