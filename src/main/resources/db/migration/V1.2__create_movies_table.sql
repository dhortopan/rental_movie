DROP TABLE IF EXISTS movies;

CREATE TABLE movies
(
    movie_id        int primary Key auto_increment,
    name            varchar(50),
    director        varchar(100),
    launched_year   int,
    category        varchar(50),
    borrowed        BOOLEAN,
    rental_id       int

);