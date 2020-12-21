FROM openjdk:11
ADD target/docker-spring-boot.jar docker-spring-boot.jar
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]


