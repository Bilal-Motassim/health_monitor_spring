FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Health-monitor-spring-0.0.1-SNAPSHOT.jar health_monitor_spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "health_monitor_spring.jar"]
