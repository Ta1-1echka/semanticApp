DROP SCHEMA IF EXISTS `userdocumentdb`;
CREATE SCHEMA IF NOT EXISTS `userdocumentdb` DEFAULT CHARACTER SET utf8 ;
USE `userdocumentdb` ;
CREATE TABLE IF NOT EXISTS `userdocumentdb`.`user` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idUser`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `userdocumentdb`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userdocumentdb`.`document` (
  `idDocument` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `idUser` INT(11) NOT NULL,
  PRIMARY KEY (`idDocument`),
  INDEX `fk_Document_User1_idx` (`idUser` ASC),
  CONSTRAINT `fk_Document_User1`
  FOREIGN KEY (`idUser`)
  REFERENCES `userdocumentdb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `userdocumentdb`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userdocumentdb`.`profile` (
  `idUser` INT(11) NOT NULL,
  `firstname` VARCHAR(255) NULL DEFAULT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `sex` VARCHAR(6) NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_profile_user1_idx` (`idUser` ASC),
  CONSTRAINT `fk_profile_user1`
  FOREIGN KEY (`idUser`)
  REFERENCES `userdocumentdb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `userdocumentdb`.`user_has_document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `userdocumentdb`.`user_has_document` (
  `idUser` INT(11) NOT NULL,
  `idDocument` INT(11) NOT NULL,
  PRIMARY KEY (`idUser`, `idDocument`),
  INDEX `fk_User_has_Document_Document1_idx` (`idDocument` ASC),
  INDEX `fk_User_has_Document_User1_idx` (`idUser` ASC),
  CONSTRAINT `fk_User_has_Document_Document1`
  FOREIGN KEY (`idDocument`)
  REFERENCES `userdocumentdb`.`document` (`idDocument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Document_User1`
  FOREIGN KEY (`idUser`)
  REFERENCES `userdocumentdb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `userdocumentdb`.`persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;