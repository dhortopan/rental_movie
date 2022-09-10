insert into user_roles(userType)
values("ROLE_ADMIN"), ("ROLE_USER");


insert into movies(director, title, launch_date, category,borrowed,rental_id)
values('Adam Miller','Butterfly','2021-06-28','Thriller',1,1),
      ('Adam Miller','My friend','2019-03-01','Romance',FALSE,1);


insert into rental (rental_date,return_date,returned,penalty,user_id,movie_id)
values ('2022-05-28', '2022-06-10', 1, 0.00,1,1);


insert into users
(username,password,enabled,expired,locked,credentials,movie_id,role_id,rental_id)
values ('Popescu Mihai', '789!@#', 1, 0, 0, 1, 1, 1, 1);