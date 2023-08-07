-- Создание базы данных
CREATE DATABASE client_centre;

-- Переключение на базу данных client_centre
\c client_centre;

-- Создание таблицы клиентов
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         email VARCHAR(255)
);

-- Создание таблицы заказов
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        client_id INT REFERENCES clients(id),
                        order_date DATE,
                        total_amount DECIMAL(10, 2)
);

-- Добавление начальных данных
INSERT INTO clients (first_name, last_name, email)
VALUES
    ('John', 'Doe', 'john@example.com'),
    ('Jane', 'Smith', 'jane@example.com');

INSERT INTO orders (client_id, order_date, total_amount)
VALUES
    (1, '2023-08-08', 150.00),
    (2, '2023-08-09', 220.50);
