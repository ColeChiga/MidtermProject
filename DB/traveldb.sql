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
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(200) NULL,
  `street2` VARCHAR(200) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
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
  `enabled` TINYINT NOT NULL,
  `role` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `about_me` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `family` ;

CREATE TABLE IF NOT EXISTS `family` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `user_id` INT NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_family_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_family_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination` ;

CREATE TABLE IF NOT EXISTS `destination` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `activity` ;

CREATE TABLE IF NOT EXISTS `activity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `estimated_time_hours` DOUBLE NULL,
  `estimated_cost` DECIMAL(7,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacation` ;

CREATE TABLE IF NOT EXISTS `vacation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `family_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vacation_group1_idx` (`family_id` ASC),
  INDEX `fk_vacation_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_vacation_group1`
    FOREIGN KEY (`family_id`)
    REFERENCES `family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location_category` ;

CREATE TABLE IF NOT EXISTS `location_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(200) NULL,
  `destination_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `location_category_id` INT NOT NULL,
  `estimated_cost` DECIMAL(7,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_destination1_idx` (`destination_id` ASC),
  INDEX `fk_location_address1_idx` (`address_id` ASC),
  INDEX `fk_location_location_category1_idx` (`location_category_id` ASC),
  CONSTRAINT `fk_location_destination1`
    FOREIGN KEY (`destination_id`)
    REFERENCES `destination` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_location_category1`
    FOREIGN KEY (`location_category_id`)
    REFERENCES `location_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `attendee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `attendee` ;

CREATE TABLE IF NOT EXISTS `attendee` (
  `vacation_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `join_date` DATETIME NULL,
  `confirmed` TINYINT NULL,
  `remarks` TEXT NULL,
  `hotel_id` INT NULL,
  PRIMARY KEY (`vacation_id`, `user_id`),
  INDEX `fk_vacation_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_vacation_has_user_vacation1_idx` (`vacation_id` ASC),
  INDEX `fk_attendee_location1_idx` (`hotel_id` ASC),
  CONSTRAINT `fk_vacation_has_user_vacation1`
    FOREIGN KEY (`vacation_id`)
    REFERENCES `vacation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attendee_location1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flight` ;

CREATE TABLE IF NOT EXISTS `flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `airline` VARCHAR(45) NULL,
  `departure` DATETIME NULL,
  `arrival` DATETIME NULL,
  `flight_number` VARCHAR(45) NULL,
  `layover` TINYINT NULL,
  `layover_airline` VARCHAR(45) NULL COMMENT 'Maybe assign layover id pointing to another flight?',
  `attendee_vacation_id` INT NOT NULL,
  `attendee_user_id` INT NOT NULL,
  `estimated_cost` DECIMAL(7,2) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `flight_number_UNIQUE` (`flight_number` ASC),
  INDEX `fk_filght_vacation_has_user1_idx` (`attendee_vacation_id` ASC, `attendee_user_id` ASC),
  CONSTRAINT `fk_filght_vacation_has_user1`
    FOREIGN KEY (`attendee_vacation_id` , `attendee_user_id`)
    REFERENCES `attendee` (`vacation_id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination_activity` ;

CREATE TABLE IF NOT EXISTS `destination_activity` (
  `destination_id` INT NOT NULL,
  `activity_id` INT NOT NULL,
  PRIMARY KEY (`destination_id`, `activity_id`),
  INDEX `fk_destination_has_activity_activity1_idx` (`activity_id` ASC),
  INDEX `fk_destination_has_activity_destination1_idx` (`destination_id` ASC),
  CONSTRAINT `fk_destination_has_activity_destination1`
    FOREIGN KEY (`destination_id`)
    REFERENCES `destination` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destination_has_activity_activity1`
    FOREIGN KEY (`activity_id`)
    REFERENCES `activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_family`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_family` ;

CREATE TABLE IF NOT EXISTS `user_family` (
  `user_id` INT NOT NULL,
  `family_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `family_id`),
  INDEX `fk_user_has_group_group1_idx` (`family_id` ASC),
  INDEX `fk_user_has_group_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_group_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_group_group1`
    FOREIGN KEY (`family_id`)
    REFERENCES `family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacation_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacation_comment` ;

CREATE TABLE IF NOT EXISTS `vacation_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment` TEXT NULL,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `vacation_id` INT NOT NULL,
  `reply_to_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_vacation_comment_vacation1_idx` (`vacation_id` ASC),
  INDEX `fk_vacation_comment_vacation_comment1_idx` (`reply_to_id` ASC),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_comment_vacation1`
    FOREIGN KEY (`vacation_id`)
    REFERENCES `vacation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_comment_vacation_comment1`
    FOREIGN KEY (`reply_to_id`)
    REFERENCES `vacation_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacation_destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacation_destination` ;

CREATE TABLE IF NOT EXISTS `vacation_destination` (
  `vacation_id` INT NOT NULL,
  `destination_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `remarks` TEXT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`vacation_id`, `destination_id`),
  INDEX `fk_vacation_has_destination_destination1_idx` (`destination_id` ASC),
  INDEX `fk_vacation_has_destination_vacation1_idx` (`vacation_id` ASC),
  INDEX `fk_vacation_has_destination_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_vacation_has_destination_vacation1`
    FOREIGN KEY (`vacation_id`)
    REFERENCES `vacation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_has_destination_destination1`
    FOREIGN KEY (`destination_id`)
    REFERENCES `destination` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_has_destination_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination_vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination_vote` ;

CREATE TABLE IF NOT EXISTS `destination_vote` (
  `attendee_vacation_id` INT NOT NULL,
  `attendee_user_id` INT NOT NULL,
  `destination_vacation_id` INT NOT NULL,
  `destination_destination_id` INT NOT NULL,
  `vote` TINYINT NULL,
  `vote_remarks` TEXT NULL,
  PRIMARY KEY (`attendee_vacation_id`, `attendee_user_id`, `destination_vacation_id`, `destination_destination_id`),
  INDEX `fk_vacation_attendee_has_vacation_destination_vacation_dest_idx` (`destination_vacation_id` ASC, `destination_destination_id` ASC),
  INDEX `fk_vacation_attendee_has_vacation_destination_vacation_atte_idx` (`attendee_vacation_id` ASC, `attendee_user_id` ASC),
  CONSTRAINT `fk_vacation_attendee_has_vacation_destination_vacation_attend1`
    FOREIGN KEY (`attendee_vacation_id` , `attendee_user_id`)
    REFERENCES `attendee` (`vacation_id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacation_attendee_has_vacation_destination_vacation_destin1`
    FOREIGN KEY (`destination_vacation_id` , `destination_destination_id`)
    REFERENCES `vacation_destination` (`vacation_id` , `destination_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nearby_destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nearby_destination` ;

CREATE TABLE IF NOT EXISTS `nearby_destination` (
  `destination_id` INT NOT NULL,
  `nearby_id` INT NOT NULL,
  PRIMARY KEY (`destination_id`, `nearby_id`),
  INDEX `fk_destination_has_destination_destination2_idx` (`nearby_id` ASC),
  INDEX `fk_destination_has_destination_destination1_idx` (`destination_id` ASC),
  CONSTRAINT `fk_destination_has_destination_destination1`
    FOREIGN KEY (`destination_id`)
    REFERENCES `destination` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destination_has_destination_destination2`
    FOREIGN KEY (`nearby_id`)
    REFERENCES `destination` (`id`)
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
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `postal_code`) VALUES (1, '123 fake st', NULL, 'Colorado Springs', 'CO', '80910');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `postal_code`) VALUES (2, '123 magic st', NULL, 'Bay Lake', 'FL', '34747');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `postal_code`) VALUES (3, '347 Don Shula Dr', NULL, 'Miami Gardens', 'FL', '33056');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `postal_code`) VALUES (4, '12 N Ocean Ave', NULL, 'Daytona Beach', 'FL', '32118');
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `postal_code`) VALUES (5, '742 Evergreen Terrace', NULL, 'Springfield', 'OR', '97477');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `enabled`, `role`, `address_id`, `create_date`, `last_update`, `image_url`, `about_me`) VALUES (1, 'joe', 'snuffy', 'admin', '12345', 1, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `enabled`, `role`, `address_id`, `create_date`, `last_update`, `image_url`, `about_me`) VALUES (2, 'homer', 'simpson', 'dntlvr', 'mmmmm', 1, NULL, 5, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `family`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `family` (`id`, `name`, `description`, `user_id`, `image_url`, `create_date`, `last_update`, `enabled`) VALUES (1, 'The Millers', NULL, 1, NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `destination`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country`) VALUES (1, 'Orlando', 'Florida', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Lake_Eola_Park_in_Orlando_02.jpg/2560px-Lake_Eola_Park_in_Orlando_02.jpg', 'United States');
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country`) VALUES (2, 'Miami', 'Florida', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg/2880px-Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg', 'United States');
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country`) VALUES (3, 'Daytona Beach', 'Florida', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Daytona_Beach_looking_north_from_pier.jpg/1920px-Daytona_Beach_looking_north_from_pier.jpg', 'United States');

COMMIT;


-- -----------------------------------------------------
-- Data for table `activity`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `activity` (`id`, `name`, `description`, `estimated_time_hours`, `estimated_cost`) VALUES (1, 'Disney World', 'Disney Fun at Theme Park', 14, 159.00);
INSERT INTO `activity` (`id`, `name`, `description`, `estimated_time_hours`, `estimated_cost`) VALUES (2, 'Miami Dolphins Game', 'Watch the Dolphins home game', 4, 162.00);
INSERT INTO `activity` (`id`, `name`, `description`, `estimated_time_hours`, `estimated_cost`) VALUES (3, 'Daytona Beach Boardwalk', 'Rides and games at an Amusement Center', 12, 50.00);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vacation`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `vacation` (`id`, `start_date`, `end_date`, `family_id`, `user_id`, `title`, `description`, `image_url`, `create_date`, `last_update`, `active`) VALUES (1, NULL, NULL, 1, 1, 'Dunston Checks In', 'Trip to Florida', NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `location_category` (`id`, `name`, `description`) VALUES (1, 'Hotel', NULL);
INSERT INTO `location_category` (`id`, `name`, `description`) VALUES (2, 'Restaurant', NULL);
INSERT INTO `location_category` (`id`, `name`, `description`) VALUES (3, 'Theme Park', NULL);
INSERT INTO `location_category` (`id`, `name`, `description`) VALUES (4, 'Amusement Park', NULL);
INSERT INTO `location_category` (`id`, `name`, `description`) VALUES (5, 'Sports Stadium', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `location` (`id`, `name`, `description`, `image_url`, `destination_id`, `address_id`, `location_category_id`, `estimated_cost`) VALUES (1, 'Disney World', 'Disney World ', NULL, 1, 2, 3, NULL);
INSERT INTO `location` (`id`, `name`, `description`, `image_url`, `destination_id`, `address_id`, `location_category_id`, `estimated_cost`) VALUES (2, 'Hard Rock Stadium ', 'Home of the Miami Dolphins', NULL, 2, 3, 5, NULL);
INSERT INTO `location` (`id`, `name`, `description`, `image_url`, `destination_id`, `address_id`, `location_category_id`, `estimated_cost`) VALUES (3, 'Daytona Beach Boardwalk Amusements', 'Amusement Park on a Pier', NULL, 3, 4, 4, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `attendee`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `attendee` (`vacation_id`, `user_id`, `join_date`, `confirmed`, `remarks`, `hotel_id`) VALUES (1, 1, NULL, 1, 'sure', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `flight`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `flight` (`id`, `airline`, `departure`, `arrival`, `flight_number`, `layover`, `layover_airline`, `attendee_vacation_id`, `attendee_user_id`, `estimated_cost`) VALUES (1, 'United', NULL, NULL, NULL, NULL, NULL, 1, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `destination_activity`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `destination_activity` (`destination_id`, `activity_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_family`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `user_family` (`user_id`, `family_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vacation_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `vacation_comment` (`id`, `comment`, `comment_date`, `user_id`, `vacation_id`, `reply_to_id`) VALUES (1, 'meh', NULL, 1, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vacation_destination`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `vacation_destination` (`vacation_id`, `destination_id`, `user_id`, `remarks`, `create_date`, `last_update`, `active`) VALUES (1, 1, 1, 'meh', NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `destination_vote`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `destination_vote` (`attendee_vacation_id`, `attendee_user_id`, `destination_vacation_id`, `destination_destination_id`, `vote`, `vote_remarks`) VALUES (1, 1, 1, 1, 1, 'yay');

COMMIT;


-- -----------------------------------------------------
-- Data for table `nearby_destination`
-- -----------------------------------------------------
START TRANSACTION;
USE `traveldb`;
INSERT INTO `nearby_destination` (`destination_id`, `nearby_id`) VALUES (1, 2);

COMMIT;

