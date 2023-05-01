# Cafe_microservices
This project is a collection of three microservices built using Spring Cloud. The microservices are designed to interact with each other and are deployed on a Docker container. Two of the microservices are built using MongoDB and PostgreSQL as the databases, respectively. The microservices communicate with each other through RabbitMQ, which is also launched using Docker. Several endpoints are protected by OAuth2 using Keycloak, which is also launched using Docker. The entire project is launched using an API Gateway and a Eureka server.

Once the Docker containers are up and running, you can access the API Gateway using the following URL:

API Gateway: http://localhost:8890

To create meal you should use this path:
http://localhost:8890/api/meal | POST | Request Body - Meal

Example of body:

![Untitled](https://user-images.githubusercontent.com/54581698/235479204-d0cf18ff-83ff-49ed-8cad-d97509033200.png)

To create orderMeal you should use this path:
http://localhost:8890/api/orderMeal | POST | Request Body - OrderMeal

Example of body:

![Untitledasdad](https://user-images.githubusercontent.com/54581698/235478002-fdf83ac3-00fb-48c9-a5a3-46b8741ffae9.png)

If you want to get notification, then you need to log in by keycloack, because notification's api are secured by OAuth 2.
