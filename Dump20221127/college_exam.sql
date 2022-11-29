-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: college
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `sem` int DEFAULT NULL,
  `date` varchar(225) DEFAULT NULL,
  `syllabus` varchar(255) DEFAULT 'full syllabus',
  `status` varchar(255) DEFAULT 'upcoming',
  `subject_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`subject_id`),
  KEY `exam_ibfk_1` (`sem`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`sem`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'1/12/2022','full syllabus','upcoming',1),(1,'6/12/2022','full syllabus','upcoming',2),(1,'12/12/2022','full syllabus','upcoming',3),(2,'1/12/2022','full syllabus','upcoming',4),(2,'6/12/2022','full syllabus','upcoming',5),(2,'12/12/2022','full syllabus','upcoming',6),(3,'1/12/2022','full syllabus','upcoming',7),(3,'6/12/2022','full syllabus','upcoming',8),(3,'12/12/2022','full syllabus','upcoming',9),(1,'1/10/2022','half syllabus','completed',10),(1,'6/10/2022','half syllabus','completed',11),(1,'12/10/2022','half syllabus','completed',12),(2,'1/10/2022','half syllabus','completed',13),(2,'6/10/2022','half syllabus','completed',14),(2,'12/10/2022','half syllabus','completed',15),(3,'1/10/2022','half syllabus','completed',16),(3,'6/10/2022','half syllabus','completed',17),(3,'12/10/2022','half syllabus','completed',18);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-27 13:12:16
