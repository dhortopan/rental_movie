DROP TABLE IF EXISTS users;


CREATE TABLE users
(
    user_id      int primary Key auto_increment,
    name         varchar(50),
    age          int,
    password     varchar(50),
    phone_number varchar(50),
    address      varchar(100),
    email        varchar(100),
    enabled      BOOLEAN,
    user_locked  BOOLEAN,
    user_role    varchar(25),
    employee_id  int,
    rental_id    int
--     FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);

