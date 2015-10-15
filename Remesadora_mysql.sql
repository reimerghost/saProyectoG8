-- MySQL Script generated by MySQL Workbench
-- 10/15/15 11:09:32
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema remesadorag8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema remesadorag8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `remesadorag8` DEFAULT CHARACTER SET latin1 ;
USE `remesadorag8` ;

-- -----------------------------------------------------
-- Table `remesadorag8`.`remesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `remesadorag8`.`remesa` (
  `id_remesa` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_emisor` VARCHAR(50) NULL DEFAULT NULL,
  `nombre_receptor` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_agregado` VARCHAR(50) NULL DEFAULT NULL,
  `tipo_remesa` VARCHAR(50) NULL DEFAULT NULL,
  `monto` DECIMAL(20,2) NOT NULL,
  `id_cuenta` INT(11) NOT NULL,
  PRIMARY KEY (`id_remesa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `remesadorag8`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `remesadorag8`.`historial` (
  `id_historial` INT(11) NOT NULL AUTO_INCREMENT,
  `id_remesa` INT(11) NOT NULL,
  `estado` VARCHAR(50) NOT NULL,
  `fecha` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_historial`),
  INDEX `id_remesa` (`id_remesa` ASC),
  CONSTRAINT `historial_ibfk_1`
    FOREIGN KEY (`id_remesa`)
    REFERENCES `remesadorag8`.`remesa` (`id_remesa`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

