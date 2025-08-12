FROM postgres:14.18

WORKDIR /db/

COPY test.sql /docker-entrypoint-initdb.d/test.sql
COPY start.sh /docker-entrypoint-initdb.d/start.sh
RUN chmod +x /docker-entrypoint-initdb.d/start.sh


