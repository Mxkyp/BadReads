#!/bin/sh

su - postgres
psql
CREATE ROLE ROOT SUPERUSER CREATEDB LOGIN
exit
exit
createdb -T template0 testDB
psql testDB <./test
