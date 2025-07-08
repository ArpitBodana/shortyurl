FROM amazoncorretto:17

LABEL version="1.0"

WORKDIR /app

COPY target/shortyurl-0.0.1-SNAPSHOT.jar /app/shortyurl.jar

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar", "shortyurl.jar"]