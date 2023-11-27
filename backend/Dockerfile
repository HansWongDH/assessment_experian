# Build stage
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src/ src
RUN ./mvnw package -Dmaven.test.skip=true

# Run stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar"]