FROM postgres:15-alpine
FROM openjdk:17
WORKDIR /app
COPY target/web-application-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "web-application-0.0.1-SNAPSHOT.jar"]