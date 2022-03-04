CREATE TABLE person (
    id UUID NOT NULL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    d_o_b VARCHAR(100) NOT NULL,
    gender VARCHAR(15) NOT NULL,
    university_email VARCHAR(100) NOT NULL,
    university_name VARCHAR(100) NOT NULL,
    program VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    nationality VARCHAR(100) NOT NULL,
    dietary VARCHAR(100) NOT NULL,
    language VARCHAR(100) NOT NULL,
    shared_occupancy VARCHAR(10) NOT NULL,
    pet_preference VARCHAR(10) NOT NULL,
    smoking_habit VARCHAR(10) NOT NULL,
    drinking_habit VARCHAR(10) NOT NULL
);