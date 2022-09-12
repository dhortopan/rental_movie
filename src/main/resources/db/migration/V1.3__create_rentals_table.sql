DROP TABLE IF EXISTS rentals;

CREATE TABLE rentals
(
    rental_id    int primary Key auto_increment,
    rental_date  date,
    return_date  date,
    rental_cost  double,
    returned  BOOLEAN,
    user_id      int,
    movie_id     int,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
);

