package com.propvuebrand.product_management.controllers;

import com.propvuebrand.product_management.models.FulfillmentCenter;
import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.models.Status;
import com.propvuebrand.product_management.services.ProductService;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    private final static long ID = 1L;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void getProductById() {
        final Product product = mock(Product.class);
        when(productService.getProductById(ID)).thenReturn(product);

        final Product actual = productController.getProductById(ID);

        assertNotNull(actual);
        assertEquals(product, actual);
        verify(productService).getProductById(ID);
    }

    @Test
    void createProduct() {
        final Product product = mock(Product.class);

        productController.createProduct(product);

        verify(productService).createProduct(product);
    }

    @Test
    void updateProduct() {
        Product product = new Product();

        product.setProductId("p10");
        product.setFulfillmentCenter(FulfillmentCenter.fc2);
        product.setStatus(Status.Sellable);
        product.setQuantity(10);
        product.setValue(5);

        Product updatedProduct = new Product();
        updatedProduct.setProductId("p1");
        updatedProduct.setQuantity(100);

        when(productService.updateProduct(ID, product)).thenReturn(updatedProduct);

        Product actual = productController.updateProduct(ID, product);

        assertNotNull(actual);
        assertEquals(updatedProduct, actual);
        verify(productService).updateProduct(ID, product);
    }

}