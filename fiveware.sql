-- MySQL Script generated by MySQL Workbench
-- Dom 06 Mar 2016 17:28:20 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fiveware
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fiveware
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fiveware` DEFAULT CHARACTER SET utf8 ;
USE `fiveware` ;

-- -----------------------------------------------------
-- Table `fiveware`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiveware`.`user` ;

CREATE TABLE IF NOT EXISTS `fiveware`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(80) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `gender_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fiveware`.`interest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiveware`.`interest` ;

CREATE TABLE IF NOT EXISTS `fiveware`.`interest` (
  `interest_id` BIGINT NOT NULL AUTO_INCREMENT,
  `interest_description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`interest_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fiveware`.`user_interest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiveware`.`user_interest` ;

CREATE TABLE IF NOT EXISTS `fiveware`.`user_interest` (
  `user_id` BIGINT NOT NULL,
  `interest_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `interest_id`),
  INDEX `fk_user_has_interest_interest1_idx` (`interest_id` ASC),
  INDEX `fk_user_has_interest_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_interest_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `fiveware`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_interest_interest1`
    FOREIGN KEY (`interest_id`)
    REFERENCES `fiveware`.`interest` (`interest_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
CREATE USER 'fiveware' IDENTIFIED BY 'fiveware';
GRANT ALL ON `fiveware`.* TO 'fiveware';

GRANT USAGE ON *.* TO fiveware;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `fiveware`.`interest`
-- -----------------------------------------------------
START TRANSACTION;
USE `fiveware`;
INSERT INTO `fiveware`.`interest` (`interest_id`, `interest_description`) VALUES (1, 'Compras');
INSERT INTO `fiveware`.`interest` (`interest_id`, `interest_description`) VALUES (2, 'Vendas');
INSERT INTO `fiveware`.`interest` (`interest_id`, `interest_description`) VALUES (3, 'Informática');
INSERT INTO `fiveware`.`interest` (`interest_id`, `interest_description`) VALUES (4, 'Cultura');
INSERT INTO `fiveware`.`interest` (`interest_id`, `interest_description`) VALUES (5, 'Cinema');

COMMIT;
