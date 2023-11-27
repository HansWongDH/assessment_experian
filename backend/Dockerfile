FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw package

COPY target/backend-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar"]