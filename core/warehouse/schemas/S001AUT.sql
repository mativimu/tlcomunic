-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema aut
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aut` ;

-- -----------------------------------------------------
-- Schema aut
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aut` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `aut` ;

-- -----------------------------------------------------
-- Table `aut`.`_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aut`.`_user` ;

CREATE TABLE IF NOT EXISTS `aut`.`_user` (
  `id` BIGINT NOT NULL,
  `account_non_expired` BIT(1) NULL DEFAULT NULL,
  `account_non_locked` BIT(1) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `credentials_non_expired` BIT(1) NULL DEFAULT NULL,
  `email` VARCHAR(64) NOT NULL,
  `enable` BIT(1) NOT NULL,
  `first_name` VARCHAR(25) NOT NULL,
  `last_name` VARCHAR(25) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `UK_k11y3pdtsrjgy8w9b6q4bjwrx` ON `aut`.`_user` (`email` ASC) VISIBLE;

CREATE UNIQUE INDEX `UK_je57did4is5jj3ri55obme5au` ON `aut`.`_user` (`password` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `aut`.`uid_sequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aut`.`uid_sequence` ;

CREATE TABLE IF NOT EXISTS `aut`.`uid_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
