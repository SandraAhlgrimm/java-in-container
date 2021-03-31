# java-in-container
Testing Java and Docker memory handling, GPU allocation etc.

## plain Hello World Java

Multi stage jre-slim build.

```bash
cd plain-java-in-containers
docker build -t plainjava .
docker run plainjava
```

```bash
docker build -f Dockerfile.traditional -t traditionalcontainter .
docker run traditionalcontainter
```


## Check Container Statistics

```bash
docker system df -v
```
