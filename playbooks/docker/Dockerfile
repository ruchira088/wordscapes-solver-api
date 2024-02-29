FROM eclipse-temurin:21-jre

LABEL org.opencontainers.image.source=https://github.com/ruchira088/wordscapes-solver-api

WORKDIR /opt/wordscapes-solver-api

ADD web-app/target/web-app.jar web-app.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/wordscapes-solver-api/web-app.jar"]