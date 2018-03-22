FROM mysql:5.7

COPY ./setup.sql /tmp/setup.sql
COPY ./entrypoint.sh /tmp/entrypoint.sh

RUN chmod a+x /tmp/entrypoint.sh

ENTRYPOINT ["/tmp/entrypoint.sh"]

EXPOSE 3306
