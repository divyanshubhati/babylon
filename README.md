# babylon

#Setup Postgres
## Run container 

sudo docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5433:5432 postgres:alpine

sudo docker exec -it <container id> /bin/bash

psql -U postgres

create database babylon