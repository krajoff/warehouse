# Product Management API

## Описание

Product Management API - это REST API для управления продуктами в различных центрах выполнения (Fulfillment Centers) и
отслеживания их статуса и количества. API предоставляет возможности для выполнения CRUD-операций с продуктами,
фильтрации по статусу и расчета общей стоимости продуктов в зависимости от их статуса или центра выполнения.

## Основные технологии

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Springdoc OpenAPI (для документации)

## Установка и настройка

Клонируйте репозиторий:

```bash
  git clone https://github.com/krajoff/product-management.git
```

Создаем .env-файл c параметрами среды:

```env
# URL, имя пользователя, пароль и имя базы данных PostgreSQL
DB_URL = jdbc:postgresql://localhost:5432/product_management
DB_USERNAME = root
DB_PASSWORD = password
DB_NAME = product_management

# Адрес электронной почты, пароль, порт по умолчанию для доступа к pgAdmin
PGADMIN_DEFAULT_EMAIL = pgadmin@example.com
PGADMIN_DEFAULT_PASSWORD = admin
PGADMIN_PORT = 5050
```

Запускаем docker-контейнеры:

```bash
  docker-compose up 
```

## Документация API

Swagger-документация доступна по адресу:

```http
  http://localhost:8080/swagger-ui.html
```
- doc/ — сгенерированная документация Javadoc.

## PGAdmin
```http
  http://localhost:5050/browser/
```

## API endpoints

CRUD операции для продуктов

- GET /api/v1/products - получить список всех продуктов.
- POST /api/v1/products - добавить новый продукт:
```json
{
  "productId": "p1",
  "status": "Sellable",
  "fulfillmentCenter": "fc1",
  "quantity": 10,
  "value": 1000
}
```

- PUT /api/v1/products/{id} - обновить продукт по ID:
```json
{
  "productId": "p1",
  "status": "Unfulfillable",
  "fulfillmentCenter": "fc1",
  "quantity": 5,
  "value": 500
}
```

- DELETE /api/v1/products/{id} - удалить продукт по ID.
- GET /api/v1/products/status/{status} - получить продукты по статусу (Sellable, Unfulfillable, Inbound). Пример:
  /api/v1/products/status/Sellable
- GET /api/v1/products/sellable/value - получить общую стоимость всех продуктов со статусом "Sellable".
- GET /api/v1/products/center/{fulfillmentCenter}/value - получить общую стоимость всех продуктов для конкретного
  центра (Пример, /api/v1/products/center/fc1/value)
