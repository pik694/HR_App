FROM recruit-me-template:1.0

ARG JAR_FILE

ADD target/${JAR_FILE} /usr/share/recruit-me/recruit-me.jar
ADD target/web_app/ /var/www/html/
ADD nginx.conf /etc/nginx/

EXPOSE 80 8080

ENTRYPOINT sh -c 'nginx & java -jar -Dspring.profiles.active=prod /usr/share/recruit-me/recruit-me.jar && fg'