FROM maven:alpine as build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17-jdk-alpine3.13
COPY --from=build /usr/src/app/target/containerevaluation-1.0-SNAPSHOT.jar /usr/app/containerevaluation-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/containerevaluation-1.0-SNAPSHOT.jar"]