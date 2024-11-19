# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .  
COPY src ./src  
RUN mvn clean package -DskipTests  

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/Health-monitor-spring-0.0.1-SNAPSHOT.jar health_monitor_spring.jar  
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "health_monitor_spring.jar"]
