FROM sbtscala/scala-sbt:eclipse-temurin-21.0.8_9_1.12.9_3.8.3 AS build
WORKDIR /app

COPY build.sbt ./
COPY project ./project/
RUN sbt update

COPY src ./src/
RUN sbt assembly

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

COPY --from=build /app/target/scala-3.8.3/smart-traffic-simulator-backend-assembly-0.1.0-SNAPSHOT.jar ./app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]