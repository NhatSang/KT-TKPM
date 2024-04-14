FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/*.jar product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]
