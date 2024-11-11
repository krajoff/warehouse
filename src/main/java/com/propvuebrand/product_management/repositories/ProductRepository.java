package com.propvuebrand.product_management.repositories;

import com.propvuebrand.product_management.models.Product;
import com.propvuebrand.product_management.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatusIgnoreCase(Status status);

    @Query("SELECT SUM(p.value * p.quantity) FROM Product p WHERE p.status = 'Sellable'")
    Double getTotalValueForSellableProducts();

    @Query("SELECT SUM(p.value * p.quantity) FROM Product p WHERE p.fulfillmentCenter = :fulfillmentCenter")
    Double getTotalValueByFulfillmentCenter(String fulfillmentCenter);
}