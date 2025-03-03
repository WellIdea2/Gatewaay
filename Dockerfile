# Stage 1: Maven build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Remove unnecessary files from the build stage
RUN rm -rf /root/.m2

# Stage 2: Run the application
FROM eclipse-temurin:21.0.2_13-jre
WORKDIR /app
COPY --from=build /app/target/gateway-1.0.0.jar /app/application-service.jar
CMD ["java", "-jar", "application-service.jar"]