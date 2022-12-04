-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema drhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema drhousee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `drhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `drhouse` ;

-- -----------------------------------------------------
-- Table `drhousee`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`users` (
  `dtype` VARCHAR(31) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `dni` BIGINT NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `id_oferta` INT NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKlgkd7iin2rkv9xkrkvdf6do2v` (`username` ASC) VISIBLE,
  UNIQUE INDEX `UK6j5t70rd2eub907qysjvvd76n` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhousee`.`property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`property` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `expense` DOUBLE NOT NULL,
  `garage` BIT(1) NOT NULL,
  `m2` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `private_neighborhood` BIT(1) NULL DEFAULT NULL,
  `quantity_of_ambiences` INT NULL DEFAULT NULL,
  `quantity_of_bathrooms` INT NULL DEFAULT NULL,
  `type_operation` VARCHAR(255) NULL DEFAULT NULL,
  `ubication` VARCHAR(255) NULL DEFAULT NULL,
   `ente_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKryyr2l1d6gvl7jl13b3mkmp5n` (`ente_id` ASC) VISIBLE,
  CONSTRAINT `FKryyr2l1d6gvl7jl13b3mkmp5n`
    FOREIGN KEY (`ente_id`)
    REFERENCES `drhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhousee`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`appointment` (
  `id_appointment` INT NOT NULL AUTO_INCREMENT,
  `date_appointment` DATETIME NULL DEFAULT NULL,
  `date_creation` DATETIME NULL DEFAULT NULL,
  `id_client` INT NULL DEFAULT NULL,
  `id_ente` INT NULL DEFAULT NULL,
  `id_property` INT NULL DEFAULT NULL,
  `status` BIT(1) NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  `property_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_appointment`),
  INDEX `FKhu6lhu322bx3sk8q6w3ker5q1` (`client_id` ASC) VISIBLE,
  INDEX `FK3nn23n0bnccqx56jr2ucfjwy5` (`property_id` ASC) VISIBLE,
  CONSTRAINT `FK3nn23n0bnccqx56jr2ucfjwy5`
    FOREIGN KEY (`property_id`)
    REFERENCES `drhouse`.`property` (`id`),
  CONSTRAINT `FKhu6lhu322bx3sk8q6w3ker5q1`
    FOREIGN KEY (`client_id`)
    REFERENCES `drhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhousee`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol_type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhousee`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`user_roles` (
  `users_id` INT NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`users_id`, `rol_id`),
  INDEX `FKkr7yskpjcsflkxp58y6vb5u6k` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `FK3tnppipj0gxlgi8jugl8kb8ww`
    FOREIGN KEY (`users_id`)
    REFERENCES `drhouse`.`users` (`id`),
  CONSTRAINT `FKkr7yskpjcsflkxp58y6vb5u6k`
    FOREIGN KEY (`rol_id`)
    REFERENCES `drhouse`.`rol` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Roles
-- -----------------------------------------------------

INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('2', 'ROLE_USER');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('3', 'ROLE_CLIENT');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('4', 'ROLE_ENTE');

-- -----------------------------------------------------
-- USers
-- -----------------------------------------------------

INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('UserEntity', '1', 'admin@admin.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'admin');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('EnteEntity', '2', 'rodriguez@g.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'Ente Rodriguez');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('EnteEntity', '3', 'perez@g.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'Ente Perez');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('ClientEntity', '4', 'gab@g.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'Gabi Cliente');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('ClientEntity', '5', 'fer@g.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'Fer Cliente');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('ClientEntity', '6', 'leo@g.com', '$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq', 'Leo Cliente');

-- -----------------------------------------------------
-- Properties
-- -----------------------------------------------------

INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('1', '1');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('2', '4');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('3', '4');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('4', '3');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('5', '3');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('6', '3');

-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: drhouse
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id_appointment` int NOT NULL AUTO_INCREMENT,
  `date_appointment` datetime DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `id_client` int DEFAULT NULL,
  `id_ente` int DEFAULT NULL,
  `id_property` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  `property_id` int DEFAULT NULL,
  PRIMARY KEY (`id_appointment`),
  KEY `FKhu6lhu322bx3sk8q6w3ker5q1` (`client_id`),
  KEY `FK3nn23n0bnccqx56jr2ucfjwy5` (`property_id`),
  CONSTRAINT `FK3nn23n0bnccqx56jr2ucfjwy5` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  CONSTRAINT `FKhu6lhu322bx3sk8q6w3ker5q1` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (8,'2022-12-04 15:08:31','2022-12-04 22:27:23',NULL,NULL,NULL,_binary '\0',4,9);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `expense` double NOT NULL,
  `garage` bit(1) NOT NULL,
  `m2` double NOT NULL,
  `price` double NOT NULL,
  `private_neighborhood` bit(1) DEFAULT NULL,
  `quantity_of_ambiences` int DEFAULT NULL,
  `quantity_of_bathrooms` int DEFAULT NULL,
  `type_operation` varchar(255) DEFAULT NULL,
  `ubication` varchar(255) DEFAULT NULL,
  `ente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKryyr2l1d6gvl7jl13b3mkmp5n` (`ente_id`),
  CONSTRAINT `FKryyr2l1d6gvl7jl13b3mkmp5n` FOREIGN KEY (`ente_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (5,'Salta 1686',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',3),(6,'Av. San Martin 1686',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',2),(7,'Av.Belgrano 1686',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',NULL),(8,'Av.Belgrano 1506',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',2),(9,'Av. Juana Surduy 1506',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',2),(10,'Av. Palito Ortega 1506',1000,_binary '\0',10.5,10000,_binary '\0',2,1,'Sale','cordoba',3);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_CLIENT'),(4,'ROLE_ENTE');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `users_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`users_id`,`rol_id`),
  KEY `FKkr7yskpjcsflkxp58y6vb5u6k` (`rol_id`),
  CONSTRAINT `FK3tnppipj0gxlgi8jugl8kb8ww` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkr7yskpjcsflkxp58y6vb5u6k` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(4,3),(5,3),(6,3),(2,4),(3,4);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `dtype` varchar(31) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `dni` bigint DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `id_oferta` int DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlgkd7iin2rkv9xkrkvdf6do2v` (`username`),
  UNIQUE KEY `UK6j5t70rd2eub907qysjvvd76n` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('UserEntity',1,'admin@admin.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','admin',NULL,NULL,NULL,NULL,NULL,NULL),('EnteEntity',2,'rodriguez@g.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','Ente Rodriguez',NULL,NULL,NULL,NULL,NULL,NULL),('EnteEntity',3,'perez@g.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','Ente Perez',NULL,NULL,NULL,NULL,NULL,NULL),('ClientEntity',4,'gab@g.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','Gabi Cliente',NULL,NULL,NULL,NULL,NULL,NULL),('ClientEntity',5,'fer@g.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','Fer Cliente',NULL,NULL,NULL,NULL,NULL,NULL),('ClientEntity',6,'leo@g.com','$2a$10$XK6o0T95JDePrsaSmOEZVu.1XQ72kxrQrXuazWddBzlSyBo18H/dq','Leo Cliente',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 19:36:39


