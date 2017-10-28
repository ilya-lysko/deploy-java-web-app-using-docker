FROM openjdk:8-jdk-alpine
COPY target/LearnDeployingWithDocker-1.0-SNAPSHOT.jar usr/
WORKDIR usr/
CMD ["java", "-jar", "LearnDeployingWithDocker-1.0-SNAPSHOT.jar"]
EXPOSE 8080
