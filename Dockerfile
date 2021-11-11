# Using oficial java 11 as base docker image.
FROM adoptopenjdk/openjdk11:alpine-jre

# Maintainer of this dockerfile.
MAINTAINER Emir Gokberk Eken (emirgokberk.eken@gmail.com)

# Copy built jar to image.
COPY target/docker-spring-boot.jar /opt/app/docker-spring-boot.jar

WORKDIR /opt/app

ARG JAR_FILE=/target/docker-spring-boot.jar
COPY ${JAR_FILE} docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]

## pull official base image
#FROM node:alpine
#
## set working directory
#WORKDIR /app
#
## add `/app/node_modules/.bin` to $PATH
##ENV PATH /app/node_modules/.bin:$PATH
#
## install app dependencies
#COPY package.json ./
#COPY package-lock.json ./
#RUN npm install --silent
#RUN npm install react-scripts -g --silent
#
## add app
#COPY . ./
#
## start app
#EXPOSE 8080
#CMD ["npm", "start"]