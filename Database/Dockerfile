FROM mysql

MAINTAINER Daniel Bigos <D.Bigos@stud.elka.pw.edu.pl>

ENV MYSQL_DATABASE=RECRUIT_ME \
    MYSQL_ROOT_PASSWORD=dupa \
    MYSQL_USER=test \
    MYSQL_PASSWORD=test6969

ADD db_script.sql /docker-entrypoint-initdb.d

EXPOSE 3306