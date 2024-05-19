#Build
FROM maven:3-openjdk-17 as build
ENV HOME=/app
WORKDIR $HOME
COPY ./ $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml -DskipTests clean package

#Docker build
FROM openjdk:17-alpine
COPY --from=build /app/target/*.jar student-service.jar
ENV PORT=8080
EXPOSE $PORT
ENTRYPOINT ["java", "-jar","-Dserver.port","student-service.jar"]