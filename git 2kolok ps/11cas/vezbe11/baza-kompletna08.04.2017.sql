/*
SQLyog Community v12.08 (32 bit)
MySQL - 5.6.12-log : Database - partnerid3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`partnerid3` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `partnerid3`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(11070,'Novi Beograd'),(21000,'Novi Sad'),(35230,'Cuprija');

/*Table structure for table `poslovnipartner` */

DROP TABLE IF EXISTS `poslovnipartner`;

CREATE TABLE `poslovnipartner` (
  `maticniBroj` varchar(13) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `pib` varchar(9) DEFAULT NULL,
  `ulica` varchar(30) DEFAULT NULL,
  `broj` varchar(10) DEFAULT NULL,
  `mesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`maticniBroj`),
  KEY `fk_partner_mesto` (`mesto`),
  CONSTRAINT `fk_partner_mesto` FOREIGN KEY (`mesto`) REFERENCES `mesto` (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `poslovnipartner` */

insert  into `poslovnipartner`(`maticniBroj`,`naziv`,`pib`,`ulica`,`broj`,`mesto`) values ('0000121','FON','1231231','Jove Ilica','154',11000),('11111','Ravanica','1231','M.Cenic','134',35230),('22222','SOKO STARK','121212','V.Stepe','100',11000);

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `sifra` int(11) NOT NULL,
  `naziv` varchar(30) DEFAULT NULL,
  `cena` double DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proizvod` */

insert  into `proizvod`(`sifra`,`naziv`,`cena`) values (1,'smoki',30),(2,'Milka cokolada 300g',300),(3,'Sok Nectar Malina',176);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `brojRacuna` int(11) NOT NULL,
  `datum` date DEFAULT NULL,
  `ukupno` double DEFAULT NULL,
  `maticniBroj` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`brojRacuna`),
  KEY `fk_racun_partner` (`maticniBroj`),
  CONSTRAINT `fk_racun_partner` FOREIGN KEY (`maticniBroj`) REFERENCES `poslovnipartner` (`maticniBroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `racun` */

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `brojRacuna` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `kolicina` double DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  `proizvod` int(11) DEFAULT NULL,
  PRIMARY KEY (`brojRacuna`,`rb`),
  KEY `fk_stavka_proizvod` (`proizvod`),
  CONSTRAINT `fk_stavka_proizvod` FOREIGN KEY (`proizvod`) REFERENCES `proizvod` (`sifra`),
  CONSTRAINT `fk_stavka_racun` FOREIGN KEY (`brojRacuna`) REFERENCES `racun` (`brojRacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavkaracuna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
