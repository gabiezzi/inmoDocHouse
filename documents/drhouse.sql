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
CREATE TABLE IF NOT EXISTS `drhousee`.`users` (
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
  `user_id` INT NOT NULL,
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
    REFERENCES `drhousee`.`property` (`id`),
  CONSTRAINT `FKhu6lhu322bx3sk8q6w3ker5q1`
    FOREIGN KEY (`client_id`)
    REFERENCES `drhousee`.`users` (`id`))
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
    REFERENCES `drhousee`.`users` (`id`),
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