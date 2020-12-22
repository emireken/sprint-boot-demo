# Using oficial java 11 as base docker image.
FROM openjdk:11

# Maintainer of this dockerfile.
MAINTAINER Emir Gokberk Eken (emirgokberk.eken@gmail.com)

ADD target/docker-spring-boot.jar docker-spring-boot.jar

EXPOSE 8080

#ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]

# Start
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]