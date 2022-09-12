DROP TABLE IF EXISTS employees;

CREATE TABLE employees
(
    employee_id         int primary Key auto_increment,
    name                varchar(50),
    age                 int,
    password            varchar(50),
    phone_number        varchar(50),
    address             varchar(100),
    email               varchar(100),
    employment_year      int,
    user_id              int,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)

);