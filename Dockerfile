FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/sb101-0.0.1-SNAPSHOT.jar sb101.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sb101.jar"]
