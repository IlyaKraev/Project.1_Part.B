INSERT INTO psms.courses (`id`, `title`, `stream`, `type`, `start_date`, `end_date`)
VALUES	(DEFAULT, "CB12", "Java", "Full Time", "2020-10-19", "2021-01-28"),
        (DEFAULT, "CB12", "Java", "Part Time", "2020-10-05", "2021-04-28"),
        (DEFAULT, "CB12", "C#", "Full Time", "2020-10-19", "2021-01-28"),
        (DEFAULT, "CB12", "C#", "Part Time", "2020-10-05", "2021-04-28");
-- ----------------------------------------------------------------------------------------------------
        
INSERT INTO psms.students (`id`, `first_name`, `last_name`, `date_of_birth`, `tuition_fees`)
VALUES	(DEFAULT, "Christos", "Christoglou", "1983-01-16", 2500),
		(DEFAULT, "Manolis", "Magas", "1982-04-13", 2500),
		(DEFAULT, "Vasilis", "Ilioglou", "1985-03-17", 2500),
        (DEFAULT, "Nikos", "Nikoglou", "1990-05-21", 2500),
        (DEFAULT, "John", "Doe", "1982-10-12", 2500),
        (DEFAULT, "Duke", "Nukem", "1985-03-11", 2500),
        (DEFAULT, "John", "Cena", "1984-08-01", 2500),
        (DEFAULT, "Maso", "Chist", "1983-10-04", 2500),
        (DEFAULT, "Richard", "Hard", "1983-01-26", 2500),        
        (DEFAULT, "Jane", "Plain", "1983-12-04", 2500),
        (DEFAULT, "Katherine", "Jackson", "1988-10-27", 2500),
        (DEFAULT, "Christos", "Panopoulos", "1977-04-19", 2500);
-- ----------------------------------------------------------------------------------------------------
  
INSERT INTO psms.trainers (`id`, `first_name`, `last_name`, `subject`)
VALUES	(DEFAULT, "Vicheslav", "Dragunov", "Software Engineer"),
        (DEFAULT, "Marios", "Papadopoulos", "Software Engineer"),
        (DEFAULT, "Akis", "Kostoglou", "Database Engineer"),
        (DEFAULT, "Diana", "Dawson", "Front End Programmer"),
        (DEFAULT, "Stanley", "Smith","Software Enginner");
-- ----------------------------------------------------------------------------------------------------
        
INSERT INTO psms.assignments (`id`, `title`, `description`, `sub_date`, `oral_mark`, `total_mark`)
VALUES	(DEFAULT, "A:1", "Make a private school management system", "2020-12-06", 20, 80),
		(DEFAULT, "A:2", "Make a database with connetions to backend", "2020-12-06", 20, 80),
        (DEFAULT, "A:3", "Create a website for an eshop", "2020-01-28", 20, 80),
        (DEFAULT, "A:4", "Create a web app", "2019-04-15", 20, 80);
-- ----------------------------------------------------------------------------------------------------

INSERT INTO psms.students_courses (`st_id`, `c_id`)
VALUES	(1,1),
		(2,1),
        (3,3),
        (4,2),
        (5,2),
        (6,2),
        (7,1),
        (7,2),
        (8,3),
        (8,4),
        (9,3),
        (10,3),
        (11,4),
        (12,4);
-- ----------------------------------------------------------------------------------------------------

INSERT INTO psms.trainers_courses (`t_id`, `c_id`)
VALUES	(1, 1),
		(2, 2),
        (3, 3),
        (4, 4),
        (5, 1);
-- -----------------------------------------------------------------------------------------------------

INSERT INTO psms.assignments_courses (`a_id`, `c_id`)
VALUES	(1, 1),
		(2, 2),
		(3, 3),
        (4, 4);  
-- -----------------------------------------------------------------------------------------------------

INSERT INTO psms.assignments_students_courses (`a_id`, `c_id`, `st_id`, oral_mark, total_mark) 
VALUES	(1, 1, 1, 15, 75),
		(1, 1, 2, 20, 80),
		(1, 1, 3, 19, 70),
        (2, 2, 4, 16, 66),
        (2, 2, 5, 15, 70),
        (2, 2, 6, 14, 69),
        (1, 1, 7, 20, 80),
        (2, 2, 7, 10, 40),
        (3, 3, 8, 14, 66),
        (4, 4, 8, 18, 55),
        (3, 3, 9, 16, 77),
        (3, 3, 10, 15, 75),
        (4, 4, 11, 10, 80),
        (4, 4, 12, 19, 79);
