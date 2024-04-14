FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/customer-0.0.1-SNAPSHOT.jar customer-service.jar
ENTRYPOINT ["java","-jar","/app/customer-service.jar"]
