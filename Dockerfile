FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=demo/target/docker-spring-boot.jar
COPY ${JAR_FILE} docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
