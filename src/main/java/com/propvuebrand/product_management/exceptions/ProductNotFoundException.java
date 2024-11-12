package com.propvuebrand.product_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, указывающее, что товар не найден.
 * Возвращает статус HTTP 404 Not Found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    /**
     * Создает исключение с указанным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public ProductNotFoundException(String message) {
        super(message);
    }

    /**
     * Создает исключение с сообщением по умолчанию.
     */
    public ProductNotFoundException() {
        super("[Product] Товар не найден");
    }
}
