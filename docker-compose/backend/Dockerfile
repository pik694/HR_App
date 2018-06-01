FROM openjdk:8-jre-alpine

ARG JAR_FILE

ADD ${JAR_FILE} /usr/share/recruit-me/recruit-me.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/usr/share/recruit-me/recruit-me.jar"]