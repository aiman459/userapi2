-- Donor Table
CREATE TABLE donor (
    donor_id serial PRIMARY KEY,
    name varchar(100),
    email varchar(100),
    phone varchar(20),
    blood_group varchar(5),
    city varchar(50),
    is_available boolean
);

-- Patient Request Table
CREATE TABLE patient_request (
    request_id serial PRIMARY KEY,
    patient_name varchar(100),
    blood_group varchar(5),
    city varchar(50),
    phone varchar(20),
    required_date date,
    status varchar(20)
);

-- Contact Log Table
CREATE TABLE contact_log (
    contact_id serial PRIMARY KEY,
    donor_id integer,
    request_id integer,
    contact_date date,
    message text
);

-- Blood Group Table
CREATE TABLE blood_group (
    blood_group_id serial PRIMARY KEY,
    blood_type varchar(5)
);