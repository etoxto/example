FROM gradle:8.6.0-jdk17 as builder

COPY . /src
WORKDIR /src
RUN ["./gradlew", "build"]

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=builder /src/build/libs/example-0.0.1-SNAPSHOT.jar /example.jar

ENTRYPOINT ["java", "-jar", "/example.jar"]