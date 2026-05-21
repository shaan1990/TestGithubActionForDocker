FROM eclipse-temurin:21
COPY target/testdocker-1.0.1-SNAPSHOT.jar testdocker-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]