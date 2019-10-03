FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV URL = "http://example.com/"
COPY target/springboot-hello-world-0.0.1-SNAPSHOT.jar /tmp/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/app.jar", "${URL}"]
