FROM adoptopenjdk/openjdk8:jdk8u272-b10
MAINTAINER tonyhernandezdelcid@gmail.com
RUN apt-get update && apt-get install -y iputils-ping && apt-get install -y net-tools && apt-get install -y less  && apt-get install -y nano
ADD sacod_reporteguias-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]