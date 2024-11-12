package com.propvuebrand.product_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения для управления продуктами.
 * Этот класс запускает Spring Boot приложение, используя аннотацию {@link SpringBootApplication}.
 * Приложение управляет информацией о продуктах, их статусами, количеством и стоимостью.
 *
 * <p>Для запуска приложения вызовется метод {@link #main(String[])}, который
 * инициирует контекст Spring и начинает обработку запросов.</p>
 *
 * <p>Пример запуска приложения:</p>
 * <pre>
 * public static void main(String[] args) {
 *     SpringApplication.run(ProductManagementApplication.class, args);
 * }
 * </pre>
 *
 * @version 1.0
 */
@SpringBootApplication
public class ProductManagementApplication {

	/**
	 * Главный метод приложения, который запускает Spring Boot.
	 * Этот метод инициализирует контекст Spring и начинает прослушивание HTTP-запросов.
	 *
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
