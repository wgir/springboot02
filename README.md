![alt text](https://img.shields.io/badge/springboot-2.5.5-green)
![alt text](https://img.shields.io/badge/version-1.0.0-blue) **Coding Challenge - Funds Transfer**

# Funds Transfer (funds-transfer)

This is a project to demostrate tha adquired capabilities to develop an Api with the best practices using the 
framework Spring boot 2.5.5. and h2 database. 


# Table of Contents
1. [Swagger endpoint](#swagger)
2. [Packages](#packages)
3. [Database](#database)
4. [Run](#run)
5. [Diagrams](#diagrams)
6. [Postman](#postman)

## Swagger endpoint <a name="swagger"></a>

[Api doc] (http://localhost:8080/swagger-ui.html)


## Application packages <a name="packages"></a>

1. com.example.fundstransfer.controller: All endpoints to manage web request.
2. com.example.fundstransfer.dto: Data transform objects, used to map the client requests to entities. And map entities to dto for client responses.
3. com.example.fundstransfer.entities: Data access objects. Classes for persistence data. 
4. com.example.fundstransfer.exceptions: Package where is allocated all exceptions
5. com.example.fundstransfer.integration: Package where is allocated all posibles integrations, Rest integrations, Queue messages integrations. etc.
6. com.example.fundstransfer.repository: Package where is allocated all repositories.
6. com.example.fundstransfer.repository: Package where is allocated all bussines services.


## Database <a name="database"></a>

The application just hand two tables:

1.Account: Table to store accounts  

id | accountNumber | currency | balance
------------- | -------------|------------
1  | 12345 | USD | 100


2.Transfer: Table to store transfer between accounts. 

id | amount | description | originAccount | destinationAccount | taxCollected
------------- | -------------|------------
1  | 50 | transfer | 12345 | 54321 | 0.1


## Run application <a name="run"></a>

`/funds-transfer$ mvn clean install`
`/funds-transfer$ mvn spring-boot:run`



## Postman <a name="postman"></a>

The collection to test the api is allocated on funds-transfer/docs/funds-transfer.postman_collection.json
