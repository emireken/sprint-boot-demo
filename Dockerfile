# Using oficial java 11 as base docker image.
FROM adoptopenjdk/openjdk11:alpine-jre

# Maintainer of this dockerfile.
MAINTAINER Emir Gokberk Eken (emirgokberk.eken@gmail.com)

# Copy built jar to image.
COPY target/docker-spring-boot.jar /opt/app/docker-spring-boot.jar

WORKDIR /opt/app

#ARG JAR_FILE=demo/target/docker-spring-boot.jar
#COPY ${JAR_FILE} docker-spring-boot.jar

EXPOSE 8080

#ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]

# Start
CMD java -jar spring-boot-docker.jar