FROM openjdk:8-jre

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/recruit-me/recruit-me.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/recruit-me/recruit-me.jar"]

EXPOSE 8081