# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Create a new image with a minimal JRE
FROM adoptopenjdk/openjdk11:jre-11.0.13_8-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage to the current directory
COPY --from=builder /app/target/jshERP.jar .

# Expose the port that the application listens on
EXPOSE 9999

# Set the command to run the application
CMD ["java", "-jar", "jshERP.jar"]