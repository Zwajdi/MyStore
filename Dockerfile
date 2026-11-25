FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY MyStore/pom.xml MyStore/pom.xml
COPY MyStore/src MyStore/src
RUN mvn -B -f MyStore/pom.xml -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/MyStore/target/MyStore-0.0.1-SNAPSHOT.jar app.jar
COPY public/ ./public/
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
