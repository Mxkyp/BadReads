#!/bin/sh

psql -U postgres -d postgres -c 'CREATE ROLE ROOT SUPERUSER CREATEDB LOGIN'
createdb -T template0 badReadsDB
psql badReadsDB < /docker-entrypoint-initdb.d/test.sql
