# Use an official Maven image to build the application
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory
WORKDIR /library

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the Maven project
RUN mvn clean package -DskipTests

# Use the official Tomcat image
FROM tomcat:9.0-jdk11

# Copy the WAR file from the local project directory to Tomcat's webapps directory in the container
COPY --from=build /library/target/library.war /usr/local/tomcat/webapps/

# Expose port 8080 for Tomcat
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
