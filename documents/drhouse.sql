-- MySQL Workbench Forward Engineering

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
-- Schema drhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `drhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `drhouse` ;

-- -----------------------------------------------------
-- Table `drhouse`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`appointment` (
  `id_appointment` INT NOT NULL AUTO_INCREMENT,
  `date_appointment` DATETIME NULL DEFAULT NULL,
  `date_creation` DATETIME NULL DEFAULT NULL,
  `id_client` INT NOT NULL,
  `id_ente` INT NOT NULL,
  `id_property` INT NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id_appointment`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhouse`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`offer` (
  `id_offer` INT NOT NULL AUTO_INCREMENT,
  `date_message` DATETIME NULL DEFAULT NULL,
  `id_client` INT NOT NULL,
  `id_ente` INT NOT NULL,
  `id_propery` INT NOT NULL,
  `price_offer` DOUBLE NOT NULL,
  PRIMARY KEY (`id_offer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhouse`.`property`
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
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhouse`.`rol`
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
-- Table `drhouse`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drhouse`.`users` (
  `dtype` VARCHAR(31) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `id_oferta` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKlgkd7iin2rkv9xkrkvdf6do2v` (`username` ASC) VISIBLE,
  UNIQUE INDEX `UK6j5t70rd2eub907qysjvvd76n` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drhouse`.`user_roles`
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


INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('2', 'ROLE_USER');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('3', 'ROLE_CLIENT');
INSERT INTO `drhouse`.`rol` (`id`, `rol_type`) VALUES ('4', 'ROLE_ENTE');


INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('UserEntity', '1', 'admin@admin.com', '$2a$10$vNyCEpM/Wrc2Q1YXbbUVgutfe6hkjo5ewtz4qN.yZurjmRGkQkRRi', 'admin');
INSERT INTO `drhouse`.`users` (`dtype`, `id`, `email`, `password`, `username`) VALUES ('UserEntity', '2', 'user@user.com', '$2a$10$vNyCEpM/Wrc2Q1YXbbUVgutfe6hkjo5ewtz4qN.yZurjmRGkQkRRi', 'user');

INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('1', '1');
INSERT INTO `drhouse`.`user_roles` (`users_id`, `rol_id`) VALUES ('2', '2');
