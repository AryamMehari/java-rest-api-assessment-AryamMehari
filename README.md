# **Java API Assessment**

## **Introduction**
The Portfolio Project is a Java-based application that utilizes the Spring Boot framework. It allows users to create, read, update, and delete portfolios, each containing information about various stocks.

## Features

- Create a new portfolio
- Add stocks to a portfolio
- Update stock details
- View all portfolios
- View details of a specific portfolio
- Delete a portfolio

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)
- Maven build tool installed
- IDE (Integrated Development Environment) such as VScode (https://code.visualstudio.com/Download)
- Git for version control (https://git-scm.com/downloads)

Also make sure you have accounts for the following:

- [GitHub](https://github.com/signup)

## Getting Started

1. Clone the repository:

```bash
git clone [REPO_URL]
cd [REPO_NAME]

mvn clean install
```

## Usage

Once the application is running, you can interact with it through a RESTful API. Use your preferred API testing tool (e.g., Postman) or integrate the API into your front-end application.

## API Endpoints

- GET /api/portfolios: Get all portfolios
- GET /api/portfolios/{id}: Get details of a specific portfolio
- POST /api/portfolios: Create a new portfolio
- PUT /api/portfolios/{id}: Update a portfolio
- DELETE /api/portfolios/{id}: Delete a portfolio

## Testing

The project includes unit tests to ensure the functionality of its components. Run the tests using the following command:

```bash
mvn test
```