FROM openjdk:11
MAINTAINER nraovuppala@gmail.com
ARG FIL_NAME=target/*.jar
ENV profile_name $profile_name
COPY target/*.jar app.jar
ENV  server.port=8081
EXPOSE 8081
ENTRYPOINT ["java", "-jar -Dspring.profiles.active=${profile_name}", "app.jar"]