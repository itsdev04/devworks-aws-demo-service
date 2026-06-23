# Use the official amazoncorretto:17 image from Docker Hub to execute build in AWS Container Registry (ECR)
FROM amazoncorretto:17
# Set working directory inside the container
WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/devworks-aws-demo-service.jar /app
# Expose the port the Spring Boot application will run on
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "devworks-aws-demo-service.jar"]