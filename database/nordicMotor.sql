-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: NordicMotorhomeRental
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_firstName` varchar(45) NOT NULL,
  `customer_lastName` varchar(45) NOT NULL,
  `customer_address` varchar(45) NOT NULL,
  `customer_city` varchar(45) NOT NULL,
  `customer_zip` int NOT NULL,
  `customer_phoneNo` varchar(45) NOT NULL,
  `customer_email` varchar(45) DEFAULT NULL,
  `customer_driver_licenseNo` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (14,'Ram','RAm','RAm','Ram',22,'33333','@yyyyy','393939393'),(15,'PGya','Chudal','Gladsaxe','Soeborg',43343434,'34343','yahoo@yahoo.com','343434343');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra`
--

DROP TABLE IF EXISTS `extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra` (
  `extra_id` int NOT NULL AUTO_INCREMENT,
  `extra_name` varchar(45) NOT NULL,
  `extra_price` int NOT NULL,
  PRIMARY KEY (`extra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra`
--

LOCK TABLES `extra` WRITE;
/*!40000 ALTER TABLE `extra` DISABLE KEYS */;
INSERT INTO `extra` VALUES (1,'Bike rack',10),(2,'Bed linen',15),(3,'Child seat',20),(4,'Picnic table',10),(5,'Picnic chair',5);
/*!40000 ALTER TABLE `extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorhome`
--

DROP TABLE IF EXISTS `motorhome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorhome` (
  `motorhome_id` int NOT NULL AUTO_INCREMENT,
  `motorhome_type` varchar(45) NOT NULL,
  `motorhome_brand` varchar(45) NOT NULL,
  `motorhome_model` varchar(45) NOT NULL,
  `motorhome_beds` varchar(45) NOT NULL,
  `motorhome_registration` varchar(45) NOT NULL,
  `motorhome_odometer` int NOT NULL,
  `motorhome_availability` varchar(45) NOT NULL,
  `motorhome_fuelType` varchar(45) NOT NULL,
  `motorhome_fuelAmount` int NOT NULL,
  `motorhome_price` int NOT NULL,
  PRIMARY KEY (`motorhome_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorhome`
--

LOCK TABLES `motorhome` WRITE;
/*!40000 ALTER TABLE `motorhome` DISABLE KEYS */;
INSERT INTO `motorhome` VALUES (3,'family','Entegra','Anthem','3','UH877I',2067,'no','diesel',100,50),(7,'luxury','vw','california','4','al 22400',2300,'no','petrol',25,2300),(8,'family','vw','california','4','al20202',2393939,'yes','petrol',25,2500);
/*!40000 ALTER TABLE `motorhome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentalContract`
--

DROP TABLE IF EXISTS `rentalContract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentalContract` (
  `rentalContract_id` int NOT NULL AUTO_INCREMENT,
  `rentalContract_startDate` varchar(45) NOT NULL,
  `rentalContract_endDate` varchar(45) NOT NULL,
  `customer_id` int NOT NULL,
  `motorhome_id` int NOT NULL,
  `extra_id` int NOT NULL,
  PRIMARY KEY (`rentalContract_id`),
  KEY `rentalContract_fk_customer` (`customer_id`),
  KEY `rentalContract_fk_extra` (`extra_id`),
  KEY `rentalContract_fk_motorhome` (`motorhome_id`),
  CONSTRAINT `rentalContract_fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE,
  CONSTRAINT `rentalContract_fk_extra` FOREIGN KEY (`extra_id`) REFERENCES `extra` (`extra_id`) ON DELETE CASCADE,
  CONSTRAINT `rentalContract_fk_motorhome` FOREIGN KEY (`motorhome_id`) REFERENCES `motorhome` (`motorhome_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentalContract`
--

LOCK TABLES `rentalContract` WRITE;
/*!40000 ALTER TABLE `rentalContract` DISABLE KEYS */;
/*!40000 ALTER TABLE `rentalContract` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-31  1:01:45
