FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw install

CMD ["./mvnw", "spring-boot:run"]