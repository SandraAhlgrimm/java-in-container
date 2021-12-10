FROM openjdk:11 as build
COPY src/com/example/HelloWorld.java HelloWorld.java
RUN javac HelloWorld.java

FROM openjdk:11.0.10-jre-slim-buster
COPY --from=build HelloWorld.class com/example/HelloWorld.class
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "com.example.HelloWorld"]\