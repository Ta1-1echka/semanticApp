CREATE SCHEMA IF NOT EXISTS `userDocumentDB` DEFAULT CHARACTER SET utf8 ;
USE `userDocumentDB` ;

-- -----------------------------------------------------
-- Table `userDocumentDB`.`Profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userDocumentDB`.`Profile` (
  `idProfile` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NULL,
  `lastname` VARCHAR(255) NULL,
  `birth` DATE NULL,
  `email` VARCHAR(255) NULL,
  `sex` VARCHAR(1) NULL,
  PRIMARY KEY (`idProfile`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `userDocumentDB`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userDocumentDB`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `idProfile` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_User_Profile1_idx` (`idProfile` ASC),
  CONSTRAINT `fk_User_Profile1`
    FOREIGN KEY (`idProfile`)
    REFERENCES `userDocumentDB`.`Profile` (`idProfile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `userDocumentDB`.`Document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userDocumentDB`.`Document` (
  `idDocument` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idDocument`),
  INDEX `fk_Document_User1_idx` (`idUser` ASC),
  CONSTRAINT `fk_Document_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `userDocumentDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `userDocumentDB`.`User_has_Document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userDocumentDB`.`User_has_Document` (
  `idUser` INT NOT NULL,
  `idDocument` INT NOT NULL,
  PRIMARY KEY (`idUser`, `idDocument`),
  INDEX `fk_User_has_Document_Document1_idx` (`idDocument` ASC),
  INDEX `fk_User_has_Document_User1_idx` (`idUser` ASC),
  CONSTRAINT `fk_User_has_Document_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `userDocumentDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Document_Document1`
    FOREIGN KEY (`idDocument`)
    REFERENCES `userDocumentDB`.`Document` (`idDocument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

