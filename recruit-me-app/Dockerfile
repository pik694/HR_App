FROM java:8
#FROM nginx

ARG JAR_FILE

RUN apt-get update
RUN apt-get -y install nginx

ADD target/${JAR_FILE} /usr/share/recruit-me/recruit-me.jar
ADD target/web_app/ /var/www/html/
RUN rm -v /etc/nginx/nginx.conf
ADD nginx.conf /etc/nginx/

EXPOSE 80 8080

ENTRYPOINT sh -c 'nginx & java -jar /usr/share/recruit-me/recruit-me.jar && fg'