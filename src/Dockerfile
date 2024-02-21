FROM openjdk:17-oracle

WORKDIR /app

COPY target/students-0.0.1-SNAPSHOT.jar app.jar

ENV STARTUP_INIT=true

CMD ["java", "-jar", "app.jar"]