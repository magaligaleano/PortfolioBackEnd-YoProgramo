FROM amazoncorretto:17-alpine-jdk
COPY target/mg-0.0.1-SNAPSHOT.jar  mg-app.jar
ENTRYPOINT ["java", "-jar", "/mg-app.jar"]
