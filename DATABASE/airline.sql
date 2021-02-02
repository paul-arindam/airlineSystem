-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `dob` date NOT NULL,
  `country` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (20,'Arindam','Paul','paul45@gmail.com','8896574515','1997-05-28','India'),(21,'Dormie','Gogoi','gogo40@gmail.com','7985486972','1992-05-19','India'),(22,'Anjana','Paul','anjana4566@gmail.com','8975675456','1966-12-17','india'),(23,'Karl','Willson','karl568@gmail.com','786531546','2003-02-12','India'),(24,'Karl','Willson','karl568@gmail.com','786531546','2003-02-12','India');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `flightid` int(11) NOT NULL,
  `flightname` varchar(30) DEFAULT NULL,
  `source` varchar(30) DEFAULT NULL,
  `destination` varchar(30) DEFAULT NULL,
  `departure` varchar(30) DEFAULT NULL,
  `arrival` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`flightid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (156,'K7-LR','Bangalore','Guwahati','07:15:20','09:50:20','2018-12-13',14,5580),(183,'AK-Y6','Bangalore','Chennai','15:45:10','06:15:30','2018-12-14',30,1000),(259,'BR-9K','Goa','Guwahati','13:25:20','15:45:50','2018-12-13',10,5780),(294,'CV-G5','Bangalore','Chennai','15:45:10','06:15:30','2018-12-11',1,1000),(346,'AP-E8','Chennai','Mumbai','03:20:00','04:00:00','2018-12-12',2,1305),(386,'AP-E8','Chennai','Mumbai','03:20:00','04:00:00','2018-12-17',22,1305),(418,'ZS-88','Bangalore','Goa','05:35:10','05:50:30','2018-12-14',13,5580),(421,'FR-66','Chennai','Bangalore','12:10:10','12:45:40','2018-12-11',24,995),(457,'GT-Y6','Chennai','Guwahati','08:45:00','10:15:00','2002-11-14',47,3370),(521,'BL-8U','Goa','Guwahati','13:25:20','15:45:50','2018-12-09',25,5780),(628,'KK-yR','Bangalore','Guwahati','07:15:20','09:50:20','2018-12-10',25,5580),(649,'BG-3K','Chennai','Goa','01:30:10','02:05:00','2018-12-12',22,1195),(657,'Ar-6E','Bangalore','Mumbai','18:30:00','19:00:00','2002-11-08',25,1799),(699,'BG-3K','Chennai','Goa','01:30:10','02:05:00','2018-12-16',32,1195),(861,'TT-P7','Goa','Bangalore','08:15:20','08:45:50','2018-12-07',15,980),(864,'BL-8U','Chennai','Bangalore','12:10:10','12:45:40','2018-12-15',20,995),(911,'RA-L4','Bangalore','Goa','05:35:10','05:50:30','2018-12-10',23,5580),(961,'UT-P7','Goa','Mumbai','03:35:20','04:05:50','2018-12-08',59,1080),(975,'AP-K9','Goa','Chennai','16:10:00','16:35:00','2002-11-21',0,1280);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('gogo',1234),('paul',2254),('Karl',12345),('anjana',89743);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `passenger` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `tier` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address1` varchar(30) DEFAULT NULL,
  `address2` varchar(30) DEFAULT NULL,
  `address3` varchar(30) DEFAULT NULL,
  `cardno` bigint(20) unsigned DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `holder` varchar(30) NOT NULL,
  `cvv` int(3) unsigned DEFAULT NULL,
  `paid` int(11) DEFAULT NULL,
  `flightid` int(11) DEFAULT NULL,
  `pnr` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `flightid` (`flightid`),
  CONSTRAINT `passenger_ibfk_1` FOREIGN KEY (`flightid`) REFERENCES `flight` (`flightid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (5,'mark','harper','mark567@gmail.com','7896542321','M',1,'Economy','1998-09-28','lotus layout','chikkagubbi','bangalore',78954231564,'2020-06-15','mark harper',456,1799,657,NULL),(6,'Arindam','paul','arindam678@gmail.com','9856743245','M',3,'Business','1997-07-18','vvit boys hostel','doddagubbi post','bangalore',7845923592,'2023-04-13','arindam paul',943,3599,657,NULL),(7,'rachel','green','rachelg345@gmail.com','7789654232','F',2,'Economy','1996-12-06','apt-443','cottonpet','bangalore',45987632156,'2019-03-29','rachel green',817,1799,657,NULL),(8,'xyz','abc','hhhhhjkk','79745313213','M',1,'Business','1997-11-06','khgkj','kjasdf','sacac',456546423131,'2021-06-12','xyz',342,3599,657,'VA6UB4'),(9,'Arindam','Paul','www.cashisv2@gmail.com','9486257135','M',1,'Business','1997-06-13','vvit boys hostel','chikkagubbi','bangalore',659874325648,'2021-05-16','Arindam',957,5170,457,'P92B4N'),(10,'David','carter','carter298@gmail.com','9458763152','M',2,'Economy','1997-02-23','apt no.124','hennur','bangalore',78915463258,'2021-07-03','david',825,1799,657,'TFYBGY'),(11,'dddd','rrr','dferst','198765432','M',1,'Economy','1996-11-13','ghty','hgty','',7945685642,'2020-11-13','dddd',649,1799,657,'28MZVR'),(12,'dfh','','iohi','','M',1,'Economy','2018-11-21','pouj','','',456864,'2018-11-14','',459,1799,657,'OJNGID'),(13,'hju','jhuy','kkji','4552','M',1,'Economy','2018-11-07','lkihg','kjhh','lki',458552,'2018-11-03','ghh',432,3370,457,'KSIUTP'),(14,'jkiu','kjku','jkloi','456','M',1,'Economy','2018-11-11','yuhj','jkkm','ijkko',4525222,'2018-11-01','jkio',156,1799,657,'XDMFIW'),(15,'jkol','hgyu','hjkou','4625953','M',1,'Economy','2018-11-16','kloy','fgyhn','ghujk',4593233,'2018-11-30','asdrg',765,1799,657,'QIIXPJ'),(16,'Dormie','Gogoi','Dromie46@gmail.com','9863257415','F',1,'Business','2018-11-22','VVIT Girls Hostel','Hennur-Bagalur Road','Bangalore',79564128356596,'2023-05-16','Dormie',654,3599,657,'GOUY4X'),(17,'adsf','jkb','asf','4657461654','M',1,'Business','2018-11-08','asf','','',4654682225,'2018-11-09','ghvh',456,3599,657,'FQCLNS'),(18,'gg','g','ff','57652','F',1,'Economy','2018-11-01','gg','','',780900,'2018-11-16','fsaf',774,1799,657,'OLUIP6'),(19,'Arindam','paul','paul@gmail.com','8974563214','M',1,'Economy','1997-08-12','bangalore','','',897456325,'2020-12-11','Arindam',529,1280,975,'9MZ35Q'),(20,'Anjana','Paul','anjana4567@gmail.com','8657906753','F',1,'Business','1966-12-17','lumding','assam','',2346436546,'2024-01-17','anjana',567,2795,421,'VUH338'),(21,'Karl','Willson','karl876@gmail.com','78654446','M',1,'Economy','1998-02-10','Electronic city','Bangalore','Karnataka',45645121132,'2021-02-11','Karl Willson',456,5580,156,'DBJI55');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-02 11:51:27
