# Microservices Project

This project is a sample application that demonstrates the use of Docker containers, Apache Kafka, and microservices architecture. The application consists of two services, a producer service called "Marketer" and a consumer service called "Customer." The services communicate with each other through Apache Kafka, and data is stored in a MySQL database.

## Dockerfile

The Dockerfile is used to build the Docker image for each service. It includes instructions for the base image, copying necessary files, setting environment variables, and specifying the entry point and default command for running the container.

## Producer Service - Marketer

The Marketer service is responsible for producing data and sending it to the Kafka topic. It provides the following functionalities:

- Controller POST: Handles the HTTP POST requests to create new offers.
- Controller DELETE: Handles the HTTP DELETE requests to delete existing offers.
- Model classes (e.g., Offer): Defines the structure and attributes of the data model used by the service.
- Kafka Producer: Sends the produced data to the Kafka topic for consumption by the consumer service.

## Consumer Service - Customer

The Customer service consumes data from the Kafka topic and performs various operations. It includes the following features:

- Controller GET (get by ID): Handles the HTTP GET requests to retrieve a specific offer by its ID.
- Controller GET (get all): Handles the HTTP GET requests to retrieve all available offers.
- CRUD operations to DB: Performs the necessary create, read, update, and delete operations on the MySQL database.
- Model classes (e.g., Offer): Defines the structure and attributes of the data model used by the service.

## Run Containers

To run the application, you can use either scripts or Docker Compose. The following containers need to be running:

- Producer service (Marketer): Runs the Marketer service container.
- Consumer service (Customer): Runs the Customer service container.
- Database service (MySQL): Runs the MySQL database container.
- Apache Kafka service: Runs the Kafka service container.

Ensure that all necessary dependencies are installed and properly configured for running the containers.

Please refer to the provided scripts or Docker Compose file for the specific commands required to start the containers.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository.
1. Install dependencies and configure the necessary environment variables.
1. Build the Docker images for the producer and consumer services.
1. Run the containers using either the provided scripts or Docker Compose.
1. Access the services through their respective API endpoints.

Make sure you have the required permissions and access rights to run Docker containers and execute the necessary commands.
