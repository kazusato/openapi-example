# Build

```
$ ./gradlew clean war
$ docker build -t kazusato/example-api:0.1.0 .
```

# Run

```
$ docker run -d --name example-api -p 8080:8080 kazusato/example-api:0.1.0
$ docker logs example-api -f
$ curl http://localhost:8080/example-api-0.1.0/booklist
```

# Retrieve an OpenAPI document

```
$ curl http://localhost:8080/openapi
```
