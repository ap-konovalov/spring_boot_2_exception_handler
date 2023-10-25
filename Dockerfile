# https://github.com/netology-code/jd-homeworks/blob/master/docker/task1/README.md
FROM openjdk:17.0.1-jdk-slim
EXPOSE 8083
ADD build/libs/2_auth_service-0.0.1-SNAPSHOT.jar app.jar
CMD ["java" , "-jar", "app.jar"]