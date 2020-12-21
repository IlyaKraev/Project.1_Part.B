-- SELECT ALL COURSES ----------------------------------------------------------------------
SELECT	id 'Course ID',
		`title` 'Title',
        `stream` 'Stream',
        `type` 'Type',
        `start_date` 'Start Date',
        `end_date` 'End Date'
FROM courses
ORDER BY `id`;

-- SELECT ALL STUDENTS ----------------------------------------------------------------------
SELECT	id 'Student ID',
	concat (first_name, ' ', last_name) 'Full Name',
        `date_of_birth` 'Birthdate',
        `tuition_fees` 'Tution fees'
FROM students
ORDER BY `id`;

-- SELECT ALL TRAINERS ----------------------------------------------------------------------
SELECT	id 'Trainer ID',
	concat (first_name, ' ', last_name) 'Full Name',
        `subject` 'Subject'
FROM trainers
ORDER BY `id`;

-- SELECT ALL ASSIGNMENTS --------------------------------------------------------------------
SELECT	id "Assignment ID",
		`title` "Title",
        `description` "Description",
		`sub_date` "Submission Date",
        `total_mark` "Total Mark",
        `oral_mark` "Oral Mark"
FROM assignments
ORDER BY id;

-- SELECT STUDENTS PER COURSE -----------------------------------------------------------------
SELECT	`title` "Course Title",
        `stream` "Stream",
        `type` "Type",
		concat(first_name, ' ', last_name) 'Full Name'
FROM students
	INNER JOIN students_courses ON students.id = students_courses.st_id
		INNER JOIN courses ON courses.id = students_courses.c_id
ORDER BY courses.type, stream, first_name;

-- SELECT TRAINERS PER COURSE -------------------------------------------------------------------
SELECT	`title` "Course Title",
        `stream` "Stream",
        `type` "Type",
		concat(first_name, ' ', last_name) 'Full Name',
        `subject` 'Subject'
FROM trainers
	INNER JOIN trainers_courses ON trainers.id = trainers_courses.t_id
		INNER JOIN courses ON courses.id = trainers_courses.c_id
ORDER BY courses.type, stream, first_name;

-- SELECT ASSIGNMENTS PER COURSE -----------------------------------------------------------------
SELECT	courses.title "Course Title",
        stream "Stream",
        type "Type",
		assignments.title "Title",
		description "Description"
FROM assignments
	INNER JOIN assignments_courses ON assignments.id = assignments_courses.a_id
		INNER JOIN courses ON courses.id = assignments_courses.c_id
ORDER BY courses.title, stream, type;

-- SELECT ASSIGNMENT PER COURSE PER STUDENT -------------------------------------------------------
SELECT	courses.title 'Course Title',
        stream Stream,
        type Type,
        assignments.title "Assignment Title",
        assignments.description 'Description',
		concat(first_name, ' ', last_name) 'Full Name',
        assignments_students_courses.oral_mark "Oral Mark",
        assignments_students_courses.total_mark "Total Mark"
FROM assignments_students_courses
	INNER JOIN assignments ON assignments.id = assignments_students_courses.a_id
		INNER JOIN courses ON courses.id = assignments_students_courses.c_id
			INNER JOIN students ON students.id = assignments_students_courses.st_id
ORDER BY assignments.title, courses.title, stream, type;

-- SELECT STUDENTS IN MORE THAN ONE COURSE --------------------------------------------------------
SELECT	concat(first_name, ' ', last_name) 'Full Name',
		title 'Course Title',
		stream Stream,
		type Type
FROM students
	INNER JOIN students_courses ON students.id = students_courses.st_id
		INNER JOIN courses ON courses.id = students_courses.c_id
where students.id in	(SELECT st_id 
						 FROM students_courses
						 GROUP BY st_id 
						 HAVING COUNT(st_id) > 1)
ORDER BY first_name;