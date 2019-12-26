CREATE DATABASE IF NOT EXISTS `guestbook`  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `guestbook`

CREATE TABLE IF NOT EXISTS `board` (`id` int NOT NULL PRIMARY KEY auto_increment, `email` varchar(50) NOT NULL, `password` varchar(20) NOT NULL, `content` text, `createdAt` datetime, `updatedAt` datetime, `deleted` int unsigned);

INSERT INTO `board`(`email`, `password`, `content`, `createdAt`, `updatedAt`, `deleted`) VALUES("test@test.com", "1234", "test", NOW(), NOW(), 1);
INSERT INTO `BOARD`(`email`, `password`, `content`, `createdAt`, `updatedAt`, `deleted`) VALUES("test@test.com", "1234", "test", NOW(), NOW(), 1);