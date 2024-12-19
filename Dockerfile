FROM maven:3.8.5-openjdk-17-slim
WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package
CMD mvn test spring-boot:run