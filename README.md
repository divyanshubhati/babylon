# babylon

#Setup Postgres
## Run container 

sudo docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5433:5432 postgres:alpine

sudo docker exec -it <container id> /bin/bash

psql -U postgres

create database babylon

# API

## Add Person
POST : localhost:8080/api/v1/person
REQUEST BODY :
{
"name": "Bugs bunny",
"first_name": "Bugs",
"last_name": "Bunny",
"d_o_b": "22/02/1996",
"gender": "Male",
"university_email": "bunny@uci.edu",
"university_name": "UCI",
"program": "MSC",
"password": "password",
"nationality" : "Indian",
"dietary": "Vegan",
"language": "English",
"shared_occupancy": "YES",
"pet_preference": "YES",
"smoking_habit": "NO",
"drinking_habit": "NO"

}

## Authenticate
PUT: localhost:8080/api/v1/person/authentication

REQUEST BODY:
{
"university_email": "bunny@uci.edu",
"password": "password"
}

## SEARCH
PUT: localhost:8080/api/v1/person/search

REQUEST BODY:
{
"nationality": "Indian",
"dietary": "Vegan",
"language": "English"
}