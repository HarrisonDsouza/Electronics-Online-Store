# Use the latest Ubuntu image as the base for the build stage
FROM ubuntu:latest AS build

# Update the package lists
RUN apt-get update

# Install OpenJDK 21 and Maven
RUN apt-get install openjdk-21-jdk maven -y

# Copy the project files into the container
COPY . .

# Build the project using Maven
RUN mvn clean package

# Use a lightweight OpenJDK 21 image for the final stage
FROM openjdk:21-jdk-slim

# Expose the port the application runs on
EXPOSE 8080

# Copy the built JAR file from the build stage to the final image
COPY --from=build /target/personalprojectharrisondsouza-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
