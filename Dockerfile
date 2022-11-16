FROM openjdk:11
MAINTAINER nraovuppala@gmail.com
ARG FIL_NAME=target/*.jar
COPY target/*.jar app.jar
ENV  server.port=8081
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]