CREATE DATABASE  IF NOT EXISTS `psms`;
USE `psms`;

--
-- Table structure for table `courses`
--
DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `stream` varchar(40) NOT NULL,
  `type` varchar(40) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  `tuition_fees` decimal(10,3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;

CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;

CREATE TABLE `assignments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(60) NOT NULL,
  `sub_date` date NOT NULL,
  `oral_mark` int NOT NULL,
  `total_mark` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `assignments_courses`
--

DROP TABLE IF EXISTS `assignments_courses`;

CREATE TABLE `assignments_courses` (
  `a_id` int NOT NULL,
  `c_id` int NOT NULL,
  PRIMARY KEY (`a_id`,`c_id`),
  KEY `fk_c_id_assignments_courses__id_courses_idx` (`c_id`),
  CONSTRAINT `fk_a_id_assignments_courses__id_assignments` FOREIGN KEY (`a_id`) REFERENCES `assignments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_c_id_assignments_courses__id_courses` FOREIGN KEY (`c_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `assignments_students_courses`
--

DROP TABLE IF EXISTS `assignments_students_courses`;

CREATE TABLE `assignments_students_courses` (
  `a_id` int NOT NULL,
  `st_id` int NOT NULL,
  `c_id` int NOT NULL,
  `oral_mark` int NOT NULL DEFAULT '0',
  `total_mark` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`a_id`,`st_id`,`c_id`),
  KEY `fk_st_id_a_s_c__id_students_idx` (`st_id`),
  KEY `fk_c_Id_a_st_c__id_courses_idx` (`c_id`),
  CONSTRAINT `fk_a_id_a_st_c__id_assignments` FOREIGN KEY (`a_id`) REFERENCES `assignments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_st_id_a_st_c__id_students` FOREIGN KEY (`st_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_t_Id_a_st_c__id_courses` FOREIGN KEY (`c_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `students_courses`
--

DROP TABLE IF EXISTS `students_courses`;

CREATE TABLE `students_courses` (
  `st_id` int NOT NULL,
  `c_id` int NOT NULL,
  PRIMARY KEY (`st_id`,`c_id`),
  KEY `fk_students_course_c_id__courses_id_idx` (`c_id`),
  CONSTRAINT `fk_students_course_c_id__courses_id` FOREIGN KEY (`c_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_students_course_st_id__students_id` FOREIGN KEY (`st_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `trainers_courses`
--

DROP TABLE IF EXISTS `trainers_courses`;

CREATE TABLE `trainers_courses` (
  `t_id` int NOT NULL,
  `c_id` int NOT NULL,
  PRIMARY KEY (`t_id`,`c_id`),
  KEY `fk_c_id_trainers_courses__id_courses_idx` (`c_id`),
  CONSTRAINT `fk_c_id_trainers_courses__id_courses` FOREIGN KEY (`c_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_t_id_trainers_courses__id_trainers` FOREIGN KEY (`t_id`) REFERENCES `trainers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
