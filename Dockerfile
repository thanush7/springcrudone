FROM maven:openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/sb101-0.0.1-SNAPSHOT.jar sb101.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sb101.jar"]
