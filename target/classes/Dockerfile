FROM mysql
ENV MYSQL_DATABASE=learndeploywithdocker \
    MYSQL_ROOT_PASSWORD=root
ADD dump.sql /docker-entrypoint-initdb.d
