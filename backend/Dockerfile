# Stage 1: Build Stage
FROM maven:3.9.4-eclipse-temurin-17 as build

# Set working directory inside the container
WORKDIR /app

# Copy the parent POM
COPY pom.xml .

# Copy all module directories
COPY github-service github-service
COPY web-api web-api

# Build the modules
RUN mvn -f pom.xml clean install -DskipTests

# Stage 2: Runtime Stage
FROM eclipse-temurin:17-jdk-jammy as runtime

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/web-api/target/web-api-*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
