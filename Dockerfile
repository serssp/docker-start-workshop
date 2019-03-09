FROM openjdk:8u181-jdk-stretch

EXPOSE 8080

COPY target/app.jar /app/

ENTRYPOINT exec java -jar /app/app.jar /data
