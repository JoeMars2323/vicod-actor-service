FROM openjdk:8
ADD target/*.jar app.jar
EXPOSE 8085
VOLUME /tmp
ENTRYPOINT ["java","-jar", "/app.jar"]
