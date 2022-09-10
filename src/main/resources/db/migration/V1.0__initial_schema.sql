CREATE TABLE IF NOT EXISTS User_Roles(
                                         id bigint PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
                                         userType varchar(20)
    );


CREATE TABLE IF NOT EXISTS Movies(
                                     id bigint  PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
                                     director varchar(50),
    title varchar(100),
    launch_date date,
    category varchar(100),
    borrowed boolean,
    rental_id bigint
    );

CREATE TABLE IF NOT EXISTS Rental(
                                     id bigint PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
                                     rental_date date,
                                     return_date date,
                                     returned boolean,
                                     penalty float,
                                     user_id bigint,
                                     movie_id bigint,
                                     FOREIGN KEY (movie_id) REFERENCES Movies(id)
    );

CREATE TABLE IF NOT EXISTS Users(
                                    id bigint PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
                                    username varchar(25),
    password varchar(25),
    enabled boolean,
    expired boolean,
    locked boolean,
    credentials boolean,
    movie_id bigint,
    role_id bigint,
    rental_id bigint,
    FOREIGN KEY (movie_id) REFERENCES Movies(id),
    FOREIGN KEY (role_id) REFERENCES User_Roles(id)
    );


