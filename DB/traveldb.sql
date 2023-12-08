-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema traveldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `traveldb` ;

-- -----------------------------------------------------
-- Schema traveldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `traveldb` DEFAULT CHARACTER SET utf8 ;
USE `traveldb` ;

-- -----------------------------------------------------
-- Table `hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel` ;

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `star_rating` VARCHAR(45) NULL,
  `pool` TINYINT NULL,
  `fittness` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `groups` VARCHAR(45) NULL,
  `flight` VARCHAR(45) NULL,
  `hotel` VARCHAR(45) NULL,
  `enabled` TINYINT NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group` ;

CREATE TABLE IF NOT EXISTS `group` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `destination` VARCHAR(45) NULL,
  `members` VARCHAR(45) NULL,
  `schedule` VARCHAR(45) NULL COMMENT 'Start date \nEnd date',
  `events` VARCHAR(45) NULL,
  `hotel_info` VARCHAR(45) NULL COMMENT '(MtM/OtM with hotel) ←|Might be able to use indirect path to get info',
  `flights` VARCHAR(45) NULL COMMENT 'MTM with hotel',
  `user_id` VARCHAR(45) NULL COMMENT 'FK',
  `comment` VARCHAR(45) NULL,
  `likes` INT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`id`, `hotel_id`),
  INDEX `fk_group_hotel1_idx` (`hotel_id` ASC),
  CONSTRAINT `fk_group_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurant` ;

CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination` ;

CREATE TABLE IF NOT EXISTS `destination` (
  `name` INT NOT NULL,
  `location` VARCHAR(45) NULL COMMENT 'Lat/long',
  `activities` VARCHAR(45) NULL COMMENT 'MTM to activity',
  `sub_destination` VARCHAR(45) NULL COMMENT 'Link to self?',
  `restaurants` VARCHAR(45) NULL COMMENT 'OTM to restaurants',
  `hotels` VARCHAR(45) NULL COMMENT 'OTM to hotel',
  `hotel_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `destination_name` INT NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_destination_hotel1_idx` (`hotel_id` ASC),
  INDEX `fk_destination_restaurant1_idx` (`restaurant_id` ASC),
  INDEX `fk_destination_destination1_idx` (`destination_name` ASC),
  CONSTRAINT `fk_destination_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destination_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destination_destination1`
    FOREIGN KEY (`destination_name`)
    REFERENCES `destination` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filght`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filght` ;

CREATE TABLE IF NOT EXISTS `filght` (
  `id` INT NOT NULL,
  `airline` VARCHAR(45) NULL,
  `departure` DATETIME NULL,
  `arrival` DATETIME NULL,
  `flight_number` VARCHAR(45) NULL,
  `layover` TINYINT(1) NULL,
  `layover_airline` VARCHAR(45) NULL COMMENT 'Maybe assign layover id pointing to another flight?',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rental`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rental` ;

CREATE TABLE IF NOT EXISTS `rental` (
  `id` INT NOT NULL,
  `company` VARCHAR(45) NULL,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `number_of_passengers` INT NULL,
  `4wd` TINYINT(1) NULL,
  `pickup_time` DATETIME NULL,
  `dropoff_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cost`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cost` ;

CREATE TABLE IF NOT EXISTS `cost` (
  `flight_cost` DECIMAL(5,2) NULL,
  `hotel_cost` DECIMAL(5,2) NULL,
  `rental_cost` DECIMAL(5,2) NULL,
  `estimated_food_cost` DECIMAL(5,2) NULL,
  `estimated_activity_cost` DECIMAL(5,2) NULL,
  `filght_id` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  `rental_id` INT NOT NULL,
  INDEX `fk_cost_filght1_idx` (`filght_id` ASC),
  INDEX `fk_cost_hotel1_idx` (`hotel_id` ASC),
  INDEX `fk_cost_rental1_idx` (`rental_id` ASC),
  CONSTRAINT `fk_cost_filght1`
    FOREIGN KEY (`filght_id`)
    REFERENCES `filght` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cost_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cost_rental1`
    FOREIGN KEY (`rental_id`)
    REFERENCES `rental` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `activity` ;

CREATE TABLE IF NOT EXISTS `activity` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `description` VARCHAR(2000) NULL,
  `participants` VARCHAR(45) NULL COMMENT 'users',
  `estimated_time` DATETIME NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_activity` ;

CREATE TABLE IF NOT EXISTS `user_has_activity` (
  `user_id` INT NOT NULL,
  `activity_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `activity_id`),
  INDEX `fk_user_has_activity_activity1_idx` (`activity_id` ASC),
  INDEX `fk_user_has_activity_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_activity_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_activity_activity1`
    FOREIGN KEY (`activity_id`)
    REFERENCES `activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination_has_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination_has_activity` ;

CREATE TABLE IF NOT EXISTS `destination_has_activity` (
  `destination_name` INT NOT NULL,
  `activity_id` INT NOT NULL,
  PRIMARY KEY (`destination_name`, `activity_id`),
  INDEX `fk_destination_has_activity_activity1_idx` (`activity_id` ASC),
  INDEX `fk_destination_has_activity_destination1_idx` (`destination_name` ASC),
  CONSTRAINT `fk_destination_has_activity_destination1`
    FOREIGN KEY (`destination_name`)
    REFERENCES `destination` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destination_has_activity_activity1`
    FOREIGN KEY (`activity_id`)
    REFERENCES `activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `group_has_hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group_has_hotel` ;

CREATE TABLE IF NOT EXISTS `group_has_hotel` (
  `group_id` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`group_id`, `hotel_id`),
  INDEX `fk_group_has_hotel_hotel1_idx` (`hotel_id` ASC),
  INDEX `fk_group_has_hotel_group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_group_has_hotel_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_has_hotel_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `group_has_filght`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group_has_filght` ;

CREATE TABLE IF NOT EXISTS `group_has_filght` (
  `group_id` INT NOT NULL,
  `filght_id` INT NOT NULL,
  PRIMARY KEY (`group_id`, `filght_id`),
  INDEX `fk_group_has_filght_filght1_idx` (`filght_id` ASC),
  INDEX `fk_group_has_filght_group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_group_has_filght_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_has_filght_filght1`
    FOREIGN KEY (`filght_id`)
    REFERENCES `filght` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_group` ;

CREATE TABLE IF NOT EXISTS `user_has_group` (
  `user_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  `group_hotel_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `group_id`, `group_hotel_id`),
  INDEX `fk_user_has_group_group1_idx` (`group_id` ASC, `group_hotel_id` ASC),
  INDEX `fk_user_has_group_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_group_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_group_group1`
    FOREIGN KEY (`group_id` , `group_hotel_id`)
    REFERENCES `group` (`id` , `hotel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS traveluser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'traveluser'@'localhost' IDENTIFIED BY 'travellover';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'traveluser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `groups`, `flight`, `hotel`, `enabled`, `role`) VALUES (1, 'joe', 'snuffy', 'admin', '12345', NULL, NULL, NULL, 1, NULL);

COMMIT;

