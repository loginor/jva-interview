# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your local machine to the container
COPY target/duration-formatter-0.0.1-SNAPSHOT.jar /app/duration-formatter-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "duration-formatter-0.0.1-SNAPSHOT.jar"]