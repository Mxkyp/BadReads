FROM postgres:14.18

WORKDIR /db/

COPY test .
COPY start.sh .
RUN chmod +x ./start.sh

ENTRYPOINT [ "/bin/sh", "./start.sh" ]


