# syntax = docker/dockerfile:1.2
#
# Build stage
FROM maven:3.8.6-openjdk-18 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/myapp-1.0-SNAPSHOT.jar /app/myapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-cp","/app/myapp.jar","ar.edu.utn.dds.k3003.app.WebApp"]
