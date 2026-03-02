# Use official Maven image with Java 21
FROM maven:3.9-eclipse-temurin-21

WORKDIR /app

# Copy POM first so Maven can cache dependencies as a separate layer
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copy source code
COPY src ./src

# Run tests when the container starts (also generates JaCoCo report)
CMD ["mvn", "clean", "test"]
