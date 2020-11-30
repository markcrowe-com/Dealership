-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dealership
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dealership` ;

-- -----------------------------------------------------
-- Schema dealership
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dealership` DEFAULT CHARACTER SET utf8 ;
USE `dealership` ;

-- -----------------------------------------------------
-- Table `dealership`.`Color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dealership`.`Color` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dealership`.`CarMaker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dealership`.`CarMaker` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dealership`.`BodyType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dealership`.`BodyType` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dealership`.`CarModel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dealership`.`CarModel` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Color` INT NOT NULL,
  `CarMaker` INT NOT NULL,
  `Price` DOUBLE NULL,
  `Name` VARCHAR(45) NULL,
  `BodyType` INT NOT NULL,
  `EngineLitres` DOUBLE NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Car_Color_idx` (`Color` ASC) VISIBLE,
  INDEX `fk_CarModel_CarMaker1_idx` (`CarMaker` ASC) VISIBLE,
  INDEX `fk_CarModel_BodyType1_idx` (`BodyType` ASC) VISIBLE,
  CONSTRAINT `fk_Car_Color`
    FOREIGN KEY (`Color`)
    REFERENCES `dealership`.`Color` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CarModel_CarMaker1`
    FOREIGN KEY (`CarMaker`)
    REFERENCES `dealership`.`CarMaker` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CarModel_BodyType1`
    FOREIGN KEY (`BodyType`)
    REFERENCES `dealership`.`BodyType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `dealership`.`Color`
-- -----------------------------------------------------
START TRANSACTION;
USE `dealership`;
INSERT INTO `dealership`.`Color` (`Id`, `Name`) VALUES (1, 'Blue');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dealership`.`CarMaker`
-- -----------------------------------------------------
START TRANSACTION;
USE `dealership`;
INSERT INTO `dealership`.`CarMaker` (`Id`, `Name`) VALUES (1, 'BMW');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dealership`.`BodyType`
-- -----------------------------------------------------
START TRANSACTION;
USE `dealership`;
INSERT INTO `dealership`.`BodyType` (`Id`, `Name`) VALUES (1, 'Hatchback');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dealership`.`CarModel`
-- -----------------------------------------------------
START TRANSACTION;
USE `dealership`;
INSERT INTO `dealership`.`CarModel` (`Id`, `Color`, `CarMaker`, `Price`, `Name`, `BodyType`, `EngineLitres`) VALUES (1, 1, 1, 35000, '3 Series', 1, 2);
INSERT INTO `dealership`.`CarModel` (`Id`, `Color`, `CarMaker`, `Price`, `Name`, `BodyType`, `EngineLitres`) VALUES (2, 1, 1, 25000, '2 Series', 1, 1.8);

COMMIT;

