# Stage 1: Build with Maven
FROM maven:3.9.4-amazoncorretto-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# Stage 2: Run with Amazon Corretto JRE
FROM amazoncorretto:17

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/shortyurl-0.0.1-SNAPSHOT.jar ./shortyurl.jar

# Expose port 8080 (syntax: EXPOSE <port>)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "shortyurl.jar"]
