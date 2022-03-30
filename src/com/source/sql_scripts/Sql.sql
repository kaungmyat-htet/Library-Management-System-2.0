CREATE extension pgcrypto;

CREATE TABLE country (
id SMALLINT GENERATED ALWAYS AS IDENTITY,
name VARCHAR(60) NOT NULL,
iso_code VARCHAR(2) NOT NULL,
PRIMARY KEY (id));

SELECT * FROM country;

CREATE TABLE state (
id SMALLINT GENERATED ALWAYS AS IDENTITY,
name VARCHAR(60) NOT NULL,
country_id SMALLINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (country_id) REFERENCES country(id));


CREATE TABLE address (
id int GENERATED ALWAYS AS IDENTITY,
street VARCHAR(95) NOT NULL,
city VARCHAR(35) NOT NULL,
state_id int NOT NULL,
zipcode VARCHAR(5) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(state_id) REFERENCES state(id));

-- Debugging for states and countries
SELECT state.id, state.name, country.name FROM state INNER JOIN country on state.country_id = country.id;

CREATE TABLE users (
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
cid VARCHAR(12) NOT NULL,
dob DATE NOT NULL,
phone VARCHAR(15) NOT NULL,
address_id int NOT NULL,
PRIMARY KEY (cid),
UNIQUE(address_id),
FOREIGN KEY (address_id) REFERENCES address(id));

CREATE TABLE account_type (
    id SMALLINT GENERATED ALWAYS AS IDENTITY,
    type VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE account (
username VARCHAR(7),
cid VARCHAR(12) NOT NULL,
password TEXT NOT NULL,
status SMALLINT NOT NULL,
type SMALLINT NOT NULL,
PRIMARY KEY (username),
UNIQUE (cid),
FOREIGN KEY (cid) REFERENCES users(cid),
FOREIGN KEY (type) REFERENCES account_type(id));

-- Joining Five Tables to see the results.
    SELECT
        account.username,
        account.password,
        account.status,
        a.type AS type,
        users.first_name,
        users.last_name,
        users.cid,
        users.dob,
        users.phone,
        address.street,
        address.city,
        state.name AS state,
        country.name AS country
    FROM users
    JOIN address
        ON users.address_id = address.id
    JOIN account
        ON account.cid = users.cid
    JOIN state
        ON address.state_id = state.id
    JOIN country
        ON state.country_id = country.id
    JOIN account_type a
        ON account.type = a.id;


-- JOINING FOUR TABLES to see the person and address.

    SELECT
            users.first_name,
            users.last_name,
            users.cid,
            users.dob,
            users.phone,
            address.street,
            address.city,
            state.name AS state,
            country.name AS country
        FROM users
        JOIN address
            ON users.address_id = address.id
        JOIN state
            ON address.state_id = state.id
        JOIN country
            ON state.country_id = country.id;


-- Member
CREATE TABLE members (
username VARCHAR(7),
expire_date DATE NOT NULL,
number_of_books SMALLINT NOT NULL,
PRIMARY KEY (username),
FOREIGN KEY (username) REFERENCES account(username));

-- Subject
CREATE TABLE subject (
id SMALLINT GENERATED ALWAYS AS IDENTITY,
name VARCHAR(40) NOT NULL,
PRIMARY KEY (id),
UNIQUE (name));

-- Book Language Code
create table language_code(
    code varchar(6),
    language varchar(30) not null,
    primary key (code)
);

-- Book
CREATE TABLE book (
isbn VARCHAR(13),
title TEXT NOT NULL,
publisher TEXT NOT NULL,
language_code varchar(6) NOT NULL,
number_of_pages SMALLINT NOT NULL,
subject_id SMALLINT NOT NULL,
PRIMARY KEY (isbn),
FOREIGN KEY (subject_id) REFERENCES subject(id),
FOREIGN KEY (language_code) REFERENCES  language_code(code));

-- Author
CREATE TABLE author(
id SMALLINT GENERATED ALWAYS AS IDENTITY,
name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

-- Book Author
CREATE TABLE book_author(
book_isbn VARCHAR(13) NOT NULL ,
author_id SMALLINT NOT NULL ,
PRIMARY KEY (book_isbn, author_id),
FOREIGN KEY (book_isbn) REFERENCES book(isbn),
FOREIGN KEY (author_id) REFERENCES author(id)
);

-- Book Format
CREATE TABLE book_format(
    id SMALLINT GENERATED ALWAYS AS IDENTITY,
    format VARCHAR(30) NOT NULL ,
    PRIMARY KEY (id)
);

-- Book Status
CREATE TABLE book_status(
    id SMALLINT GENERATED ALWAYS AS IDENTITY,
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

-- Book Item
CREATE TABLE book_item(
    barcode VARCHAR(12),
    isbn VARCHAR(13) NOT NULL,
    is_reference bool not null,
    status_id SMALLINT NOT NULL,
    price SMALLINT NOT NULL,
    format_id SMALLINT NOT NULL,
    date_of_purchased DATE NOT NULL,
    publication_date DATE NOT NULL,
    PRIMARY KEY (barcode),
    FOREIGN KEY (isbn) REFERENCES book(isbn),
    FOREIGN KEY (format_id) REFERENCES book_format(id),
    FOREIGN KEY (status_id) REFERENCES book_status(id)
);


