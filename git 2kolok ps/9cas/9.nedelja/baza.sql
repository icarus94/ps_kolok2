/*
SQLyog Community v12.08 (32 bit)
MySQL - 5.6.12-log : Database - prosoft
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoft` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `prosoft`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` bigint(20) NOT NULL,
  `naziv` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(15000,'Sabac'),(31300,'Prijepolje');

/*Table structure for table `poslovni_partner` */

DROP TABLE IF EXISTS `poslovni_partner`;

CREATE TABLE `poslovni_partner` (
  `maticniBroj` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `pib` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ulica` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `broj` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ptt` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`maticniBroj`),
  KEY `sediste_firme_fk` (`ptt`),
  CONSTRAINT `sediste_firme_fk` FOREIGN KEY (`ptt`) REFERENCES `mesto` (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `poslovni_partner` */

insert  into `poslovni_partner`(`maticniBroj`,`pib`,`naziv`,`ulica`,`broj`,`ptt`) values ('1','545','nauiv','avs','545',11000),('12154','1','naksk','jbjhbjk','5454',11000),('2','2','22','2','2',11000),('3','3','3','3','3',11000),('6','6','6','6','6',11000);

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `sifra` int(11) NOT NULL,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cena` double DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `proizvod` */

insert  into `proizvod`(`sifra`,`naziv`,`cena`) values (1,'smoki',100),(2,'mleko',50),(3,'grisine',30);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `broj` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `datum` date DEFAULT NULL,
  `maticniBroj` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ukupanIznos` double DEFAULT NULL,
  PRIMARY KEY (`broj`),
  KEY `poslovniPartnerFK` (`maticniBroj`),
  CONSTRAINT `poslovniPartnerFK` FOREIGN KEY (`maticniBroj`) REFERENCES `poslovni_partner` (`maticniBroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun` */

/*Table structure for table `stavka_racuna` */

DROP TABLE IF EXISTS `stavka_racuna`;

CREATE TABLE `stavka_racuna` (
  `broj` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `rb` int(11) DEFAULT NULL,
  `sifra` int(11) DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  PRIMARY KEY (`broj`),
  KEY `sifra` (`sifra`),
  CONSTRAINT `stavka_racuna_ibfk_1` FOREIGN KEY (`sifra`) REFERENCES `proizvod` (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavka_racuna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
