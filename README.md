# java-in-container
Testing Java and Docker memory handling, GPU allocation etc.

## plain Hello World Java

Multi stage jre-slim build.

```bash
cd plain-java-in-containers
docker build -t plainjava .
docker run --name plainjava plainjava
```

```bash
docker build -f Dockerfile.traditional -t traditionalcontainer .
docker run --name traditionalcontainter traditionalcontainer
```

### Check Container Statistics

```bash
docker system df -v
```

Get Startup time with

```bash
sh benchmarks.sh
```

## Spring Boot

Build with maven.

```bash
mvn install
java -jar target/spring-in-container-0.0.1-SNAPSHOT.jar
```

Inside a docker container.

```bash
@TODO
```
