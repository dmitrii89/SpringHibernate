DROP DATABASE  IF EXISTS `spring_security_custom_user_demo`;

CREATE DATABASE  IF NOT EXISTS `spring_security_custom_user_demo`;
USE `spring_security_custom_user_demo`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR (50) NOT NULL,
  `password` CHAR (80) NOT NULL,
  `first_name` VARCHAR (50) NOT NULL,
  `last_name` VARCHAR (50) NOT NULL,
  `email` VARCHAR (50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `USER`(username, password, first_name, last_name, email)
VALUES
('john', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'John', 'Doe', 'john@luv2code.com'),
('mary', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'Mary', ' PUBLIC ', 'mary@luv2code.com'),
('susan', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'Susan', 'Adams', 'susan@luv2code.com');

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `ROLE`;

CREATE TABLE `ROLE` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR (50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `ROLE` (NAME) VALUES ('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` INT (11) NOT NULL,
  `role_id` INT (11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `USER`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `ROLE` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id, role_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 3)