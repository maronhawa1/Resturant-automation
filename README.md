# 🍽️ Restaurant API - Spring Boot

A RESTful API for managing a restaurant system including employees, menu items, customers, and orders.  
Built with **Spring Boot**, using **Maven**, with support for **Postman testing**, **Selenium automation**, and **Allure reports**.

---

## 📦 Technologies Used

- Java 17
- Spring Boot
- Maven
- Lombok
- Postman (manual/automated API testing)
- TestNG (for Selenium)
- Allure (reporting)
- Jenkins (CI/CD pipeline)

---

## 📁 Project Structure

```bash
restaurant-api/
├── src/
│   ├── main/
│   │   ├── java/com/restaurant/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── RestaurantApiApplication.java
│   └── test/
│       └── java/com/restaurant/tests/
├── pom.xml
└── README.md

✅ Features
Manage Employees (/api/employees)

Manage Menu Items (/api/menu)

Manage Customers (/api/customers)

Manage Orders (/api/orders)

Full CRUD support

Input validation

Basic error handling

In-memory database for testing (H2)

Automated testing with TestNG + Allure

🚀 How to Run
1. Clone the Repository
bash

git clone https://github.com/your-username/restaurant-api.git
cd restaurant-api

. Run with Maven
bash

mvn clean install
mvn spring-boot:run

The app will run at:
📍 http://localhost:9090

 Testing the API
Postman:
Import the collection in Postman (restaurant-api.postman_collection.json)

Test endpoints: GET, POST, PUT, DELETE

Example Endpoint:
http

GET /api/employees
🧱 Jenkins Pipeline
Full CI/CD Pipeline:

Git clone

Build with Maven

Run Selenium + API Tests

Generate Allure report

📊 Allure Report
After tests, run:

bash

allure serve allure-results
🙋 Author
Maron Hawa
QA Automation Engineer



