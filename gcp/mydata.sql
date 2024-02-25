-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: tours
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `audit_logs`
--

DROP TABLE IF EXISTS `audit_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `log_details` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=993 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_logs`
--

LOCK TABLES `audit_logs` WRITE;
/*!40000 ALTER TABLE `audit_logs` DISABLE KEYS */;
INSERT INTO `audit_logs` VALUES (6,'IsabelN logged in at Dec 6, 2023, 3:47:22 PM.'),(9,'Bella logged in at Dec 6, 2023, 4:03:00 PM.'),(11,'IsabelN logged in at Dec 6, 2023, 4:09:25 PM.'),(18,'Emma logged in at Dec 7, 2023, 2:02:04 PM.'),(20,'Emma logged in at Dec 8, 2023, 1:44:44 PM.'),(23,'Emma logged in at Dec 9, 2023, 9:59:42 AM.'),(25,'Emma logged in at Dec 9, 2023, 10:04:04 AM.'),(27,'Emma logged in at Dec 9, 2023, 10:05:53 AM.'),(29,'Emma logged in at Dec 9, 2023, 1:57:26 PM.'),(31,'Emma logged in at Dec 9, 2023, 2:24:32 PM.'),(33,'Emma logged in at Dec 9, 2023, 2:33:42 PM.'),(35,'Emma logged in at Dec 9, 2023, 2:39:18 PM.'),(37,'Emma logged in at Dec 9, 2023, 2:55:38 PM.'),(39,'Emma logged in at Dec 9, 2023, 7:31:38 PM.'),(42,'Emma logged in at Dec 9, 2023, 9:52:09 PM.'),(45,'Emma logged in at Dec 10, 2023, 1:24:27 PM.'),(50,'Emma logged in at Dec 10, 2023, 5:59:20 PM.'),(52,'Emma logged in at Dec 10, 2023, 6:04:16 PM.'),(54,'Emma logged in at Dec 10, 2023, 6:10:04 PM.'),(57,'Emma logged in at Dec 10, 2023, 6:12:27 PM.'),(59,'Emma logged in at Dec 10, 2023, 6:28:19 PM.'),(61,'Emma logged in at Dec 10, 2023, 11:49:28 PM.'),(63,'Emma logged in at Dec 10, 2023, 11:57:21 PM.'),(65,'Emma logged in at Dec 11, 2023, 12:03:13 AM.'),(69,'mercy logged in at Dec 11, 2023, 12:05:51 AM.'),(72,'Emma logged in at Dec 11, 2023, 7:11:05 AM.'),(75,'Emma logged in at Dec 11, 2023, 7:13:57 AM.'),(78,'Emma logged in at Dec 11, 2023, 7:16:11 AM.'),(80,'Emma logged in at Dec 11, 2023, 7:18:42 AM.'),(83,'Emma logged in at Dec 11, 2023, 7:20:33 AM.'),(86,'Emma logged in at Dec 11, 2023, 7:23:57 AM.'),(89,'Emma logged in at Dec 11, 2023, 7:41:48 AM.'),(91,'Emma logged in at Dec 11, 2023, 7:42:02 AM.'),(94,'Emma logged in at Dec 11, 2023, 7:46:44 AM.'),(96,'Emma logged in at Dec 11, 2023, 10:20:29 AM.'),(99,'Emma logged in at Dec 11, 2023, 10:25:04 AM.'),(101,'Emma logged in at Dec 11, 2023, 10:27:59 AM.'),(104,'Emma logged in at Dec 11, 2023, 10:31:19 AM.'),(107,'Emma logged in at Dec 11, 2023, 10:33:30 AM.'),(110,'Emma logged in at Dec 11, 2023, 10:37:36 AM.'),(114,'Emma logged in at Dec 11, 2023, 11:14:41 AM.'),(116,'Emma logged in at Dec 11, 2023, 2:20:23 PM.'),(118,'Emma logged in at Dec 11, 2023, 3:26:12 PM.'),(120,'Emma logged in at Dec 11, 2023, 3:54:53 PM.'),(122,'Emma logged in at Dec 11, 2023, 3:57:04 PM.'),(125,'Emma logged in at Dec 11, 2023, 4:07:09 PM.'),(127,'Emma logged in at Dec 11, 2023, 4:12:51 PM.'),(130,'mercy logged in at Dec 11, 2023, 4:14:26 PM.'),(133,'Emma logged in at Dec 11, 2023, 5:24:58 PM.'),(135,'mercy logged in at Dec 11, 2023, 5:27:17 PM.'),(138,'Emma logged in at Dec 11, 2023, 5:31:16 PM.'),(140,'Emma logged in at Dec 11, 2023, 5:32:34 PM.'),(142,'Emma logged in at Dec 11, 2023, 5:34:15 PM.'),(145,'mercy logged in at Dec 11, 2023, 5:34:48 PM.'),(148,'Emma logged in at Dec 11, 2023, 5:35:35 PM.'),(150,'Emma logged in at Dec 11, 2023, 5:38:48 PM.'),(152,'Emma logged in at Dec 11, 2023, 5:56:58 PM.'),(154,'mercy logged in at Dec 11, 2023, 5:58:14 PM.'),(156,'Emma logged in at Dec 11, 2023, 6:02:20 PM.'),(158,'Emma logged in at Dec 11, 2023, 6:09:33 PM.'),(160,'Emma logged in at Dec 11, 2023, 6:12:19 PM.'),(162,'Emma logged in at Dec 11, 2023, 6:20:45 PM.'),(164,'Emma logged in at Dec 11, 2023, 6:34:58 PM.'),(167,'Emma logged in at Dec 11, 2023, 6:38:11 PM.'),(169,'Emma logged in at Dec 11, 2023, 6:44:18 PM.'),(171,'Emma logged in at Dec 11, 2023, 6:57:37 PM.'),(173,'Emma logged in at Dec 11, 2023, 7:29:54 PM.'),(175,'Emma logged in at Dec 11, 2023, 7:43:37 PM.'),(177,'Emma logged in at Dec 11, 2023, 7:44:59 PM.'),(179,'Emma logged in at Dec 11, 2023, 7:51:59 PM.'),(181,'Emma logged in at Dec 11, 2023, 8:07:45 PM.'),(183,'Emma logged in at Dec 11, 2023, 11:29:25 PM.'),(185,'Emma logged in at Dec 11, 2023, 11:46:00 PM.'),(188,'Emma logged in at Dec 12, 2023, 7:29:50 PM.'),(195,'Emma logged in at Dec 12, 2023, 8:42:25 PM.'),(199,'Emma logged in at Dec 13, 2023, 8:30:16 PM.'),(201,'Emma logged in at Dec 13, 2023, 10:43:06 PM.'),(203,'Emma logged in at Dec 13, 2023, 10:49:05 PM.'),(206,'Emma logged in at Dec 13, 2023, 10:58:50 PM.'),(208,'Emma logged in at Dec 13, 2023, 11:13:24 PM.'),(210,'Emma logged in at Dec 13, 2023, 11:38:48 PM.'),(212,'Emma logged in at Dec 13, 2023, 11:42:21 PM.'),(214,'Emma logged in at Dec 13, 2023, 11:46:14 PM.'),(216,'Emma logged in at Dec 13, 2023, 11:48:56 PM.'),(218,'Emma logged in at Dec 13, 2023, 11:53:07 PM.'),(220,'Emma logged in at Dec 13, 2023, 11:57:34 PM.'),(222,'Emma logged in at Dec 14, 2023, 12:08:20 AM.'),(224,'Emma logged in at Dec 14, 2023, 12:10:00 AM.'),(226,'Emma logged in at Dec 14, 2023, 12:14:31 AM.'),(228,'Emma logged in at Dec 14, 2023, 2:08:14 PM.'),(230,'Emma logged in at Dec 14, 2023, 11:03:16 PM.'),(232,'Emma logged in at Dec 14, 2023, 11:43:42 PM.'),(234,'Emma logged in at Dec 14, 2023, 11:54:18 PM.'),(236,'Emma logged in at Dec 14, 2023, 11:58:55 PM.'),(238,'Emma logged in at Dec 15, 2023, 12:02:41 AM.'),(241,'Emma logged in at Dec 15, 2023, 12:19:24 AM.'),(242,'Emma logged in at Dec 15, 2023, 12:19:26 AM.'),(243,'Emma logged in at Dec 15, 2023, 12:19:26 AM.'),(245,'Emma logged in at Dec 15, 2023, 12:19:28 AM.'),(249,'Emma logged in at Dec 15, 2023, 12:22:00 AM.'),(252,'Emma logged in at Dec 15, 2023, 12:24:34 AM.'),(254,'Emma logged in at Dec 15, 2023, 9:42:34 PM.'),(257,'Emma logged in at Dec 15, 2023, 10:11:03 PM.'),(262,'Emma logged in at Dec 15, 2023, 10:32:15 PM.'),(264,'Emma logged in at Dec 16, 2023, 12:06:42 PM.'),(266,'Emma logged in at Dec 16, 2023, 12:07:53 PM.'),(268,'Emma logged in at Dec 16, 2023, 12:13:45 PM.'),(270,'Emma logged in at Dec 16, 2023, 12:23:16 PM.'),(272,'Emma logged in at Dec 16, 2023, 12:27:36 PM.'),(274,'Emma logged in at Dec 16, 2023, 12:33:45 PM.'),(276,'Emma logged in at Dec 16, 2023, 12:36:20 PM.'),(278,'Emma logged in at Dec 16, 2023, 12:39:42 PM.'),(280,'Emma logged in at Dec 16, 2023, 12:43:21 PM.'),(282,'Emma logged in at Dec 16, 2023, 12:45:08 PM.'),(284,'Emma logged in at Dec 16, 2023, 12:46:27 PM.'),(286,'Emma logged in at Dec 16, 2023, 1:02:05 PM.'),(288,'Emma logged in at Dec 16, 2023, 3:22:28 PM.'),(291,'Emma logged in at Dec 16, 2023, 3:26:06 PM.'),(294,'Emma logged in at Dec 16, 2023, 3:28:10 PM.'),(296,'Emma logged in at Dec 16, 2023, 3:32:54 PM.'),(298,'Emma logged in at Dec 16, 2023, 3:39:14 PM.'),(302,'Emma logged in at Dec 16, 2023, 3:45:46 PM.'),(304,'Emma logged in at Dec 16, 2023, 3:48:52 PM.'),(306,'Emma logged in at Dec 16, 2023, 3:58:41 PM.'),(308,'Emma logged in at Dec 16, 2023, 4:05:57 PM.'),(312,'Emma logged in at Dec 16, 2023, 4:12:51 PM.'),(314,'Emma logged in at Dec 16, 2023, 4:23:08 PM.'),(316,'Emma logged in at Dec 16, 2023, 4:27:55 PM.'),(318,'Emma logged in at Dec 16, 2023, 4:39:23 PM.'),(322,'Emma logged in at Dec 16, 2023, 5:02:11 PM.'),(324,'Emma logged in at Dec 16, 2023, 5:04:54 PM.'),(326,'Emma logged in at Dec 16, 2023, 5:09:00 PM.'),(328,'Emma logged in at Dec 16, 2023, 5:33:05 PM.'),(330,'Emma logged in at Dec 16, 2023, 5:35:34 PM.'),(335,'Emma logged in at Dec 16, 2023, 7:37:39 PM.'),(337,'Emma logged in at Dec 16, 2023, 8:06:43 PM.'),(339,'Emma logged in at Dec 16, 2023, 8:09:48 PM.'),(341,'Emma logged in at Dec 16, 2023, 8:13:33 PM.'),(343,'Emma logged in at Dec 16, 2023, 8:25:25 PM.'),(345,'Emma logged in at Dec 16, 2023, 8:28:16 PM.'),(347,'Emma logged in at Dec 16, 2023, 8:30:37 PM.'),(348,'Emma logged in at Dec 16, 2023, 8:30:41 PM.'),(351,'Emma logged in at Dec 16, 2023, 8:33:26 PM.'),(353,'Emma logged in at Dec 16, 2023, 8:55:50 PM.'),(355,'Emma logged in at Dec 16, 2023, 8:59:20 PM.'),(357,'Emma logged in at Dec 16, 2023, 9:01:49 PM.'),(359,'Emma logged in at Dec 16, 2023, 9:05:35 PM.'),(361,'Emma logged in at Dec 16, 2023, 9:07:57 PM.'),(363,'Emma logged in at Dec 16, 2023, 9:29:18 PM.'),(365,'Emma logged in at Dec 16, 2023, 9:33:33 PM.'),(367,'Emma logged in at Dec 16, 2023, 9:45:49 PM.'),(369,'Emma logged in at Dec 16, 2023, 9:46:24 PM.'),(371,'Emma logged in at Dec 16, 2023, 9:55:02 PM.'),(373,'Emma logged in at Dec 16, 2023, 10:15:37 PM.'),(375,'Emma logged in at Dec 16, 2023, 10:20:07 PM.'),(377,'Emma logged in at Dec 16, 2023, 10:21:51 PM.'),(379,'Emma logged in at Dec 16, 2023, 10:24:42 PM.'),(381,'Emma logged in at Dec 16, 2023, 10:31:46 PM.'),(383,'Emma logged in at Dec 16, 2023, 10:34:31 PM.'),(385,'Emma logged in at Dec 16, 2023, 10:48:25 PM.'),(387,'Emma logged in at Dec 16, 2023, 10:49:57 PM.'),(389,'Emma logged in at Dec 16, 2023, 10:53:00 PM.'),(391,'Emma logged in at Dec 16, 2023, 10:54:12 PM.'),(393,'Emma logged in at Dec 16, 2023, 11:00:00 PM.'),(395,'Emma logged in at Dec 16, 2023, 11:01:41 PM.'),(397,'Emma logged in at Dec 16, 2023, 11:04:25 PM.'),(399,'Emma logged in at Dec 16, 2023, 11:06:06 PM.'),(401,'Emma logged in at Dec 16, 2023, 11:07:56 PM.'),(403,'Emma logged in at Dec 16, 2023, 11:08:02 PM.'),(405,'Emma logged in at Dec 16, 2023, 11:09:31 PM.'),(407,'Emma logged in at Dec 16, 2023, 11:12:44 PM.'),(409,'Emma logged in at Dec 16, 2023, 11:19:11 PM.'),(411,'Emma logged in at Dec 16, 2023, 11:22:53 PM.'),(413,'Emma logged in at Dec 16, 2023, 11:28:22 PM.'),(415,'Emma logged in at Dec 16, 2023, 11:51:20 PM.'),(417,'Emma logged in at Dec 16, 2023, 11:56:49 PM.'),(419,'Emma logged in at Dec 17, 2023, 12:00:14 AM.'),(421,'Emma logged in at Dec 17, 2023, 12:03:48 AM.'),(423,'Emma logged in at Dec 17, 2023, 12:09:17 AM.'),(425,'Emma logged in at Dec 17, 2023, 12:12:28 AM.'),(427,'Emma logged in at Dec 17, 2023, 12:15:14 AM.'),(429,'Emma logged in at Dec 17, 2023, 12:22:23 AM.'),(431,'Emma logged in at Dec 17, 2023, 12:27:16 AM.'),(433,'Emma logged in at Dec 17, 2023, 12:37:58 AM.'),(435,'Emma logged in at Dec 17, 2023, 12:40:35 AM.'),(437,'Emma logged in at Dec 17, 2023, 12:43:08 AM.'),(441,'Emma logged in at Dec 17, 2023, 12:50:19 AM.'),(443,'Emma logged in at Dec 17, 2023, 1:00:53 AM.'),(445,'Emma logged in at Dec 17, 2023, 1:27:41 AM.'),(450,'Emma logged in at Dec 17, 2023, 1:33:40 AM.'),(453,'Emma logged in at Dec 17, 2023, 1:42:27 AM.'),(455,'Emma logged in at Dec 17, 2023, 12:31:46 PM.'),(458,'Emma logged in at Dec 17, 2023, 12:39:32 PM.'),(460,'Emma logged in at Dec 17, 2023, 12:40:36 PM.'),(464,'Emma logged in at Dec 17, 2023, 1:14:34 PM.'),(467,'Emma logged in at Dec 17, 2023, 3:16:19 PM.'),(472,'Emma logged in at Dec 17, 2023, 3:22:11 PM.'),(474,'Emma logged in at Dec 17, 2023, 3:47:13 PM.'),(477,'Emma logged in at Dec 17, 2023, 3:55:26 PM.'),(481,'Emma logged in at Dec 17, 2023, 4:18:32 PM.'),(487,'Emma logged in at Dec 17, 2023, 4:59:52 PM.'),(493,'Emma logged in at Dec 17, 2023, 5:04:26 PM.'),(497,'Emma logged in at Dec 17, 2023, 5:29:24 PM.'),(498,'Emma logged in at Dec 17, 2023, 5:29:27 PM.'),(504,'Emma logged in at Dec 17, 2023, 5:34:27 PM.'),(506,'Emma logged in at Dec 17, 2023, 5:34:29 PM.'),(507,'Emma logged in at Dec 17, 2023, 5:34:32 PM.'),(512,'Emma logged in at Dec 17, 2023, 5:46:56 PM.'),(516,'Emma logged in at Dec 17, 2023, 5:55:17 PM.'),(519,'Emma logged in at Dec 17, 2023, 5:58:42 PM.'),(522,'Emma logged in at Dec 17, 2023, 6:01:27 PM.'),(524,'Emma logged in at Dec 17, 2023, 6:09:21 PM.'),(526,'Emma logged in at Dec 17, 2023, 6:12:32 PM.'),(529,'Emma logged in at Dec 17, 2023, 6:14:06 PM.'),(531,'Emma logged in at Dec 17, 2023, 6:14:08 PM.'),(532,'Emma logged in at Dec 17, 2023, 6:14:09 PM.'),(536,'Emma logged in at Dec 17, 2023, 6:15:57 PM.'),(539,'Emma logged in at Dec 17, 2023, 6:19:41 PM.'),(542,'Emma logged in at Dec 17, 2023, 6:22:46 PM.'),(546,'Emma logged in at Dec 17, 2023, 6:27:11 PM.'),(550,'Emma logged in at Dec 17, 2023, 6:32:39 PM.'),(552,'Emma logged in at Dec 17, 2023, 7:16:55 PM.'),(554,'Emma logged in at Dec 17, 2023, 7:20:09 PM.'),(556,'Emma logged in at Dec 17, 2023, 7:22:56 PM.'),(558,'Emma logged in at Dec 17, 2023, 7:24:25 PM.'),(560,'Emma logged in at Dec 17, 2023, 7:32:33 PM.'),(562,'Emma logged in at Dec 17, 2023, 7:35:28 PM.'),(564,'Emma logged in at Dec 17, 2023, 7:38:24 PM.'),(566,'Emma logged in at Dec 17, 2023, 7:47:26 PM.'),(568,'Emma logged in at Dec 17, 2023, 7:48:51 PM.'),(570,'Emma logged in at Dec 17, 2023, 7:50:35 PM.'),(572,'Emma logged in at Dec 17, 2023, 7:53:09 PM.'),(574,'Emma logged in at Dec 17, 2023, 7:55:45 PM.'),(576,'Emma logged in at Dec 17, 2023, 8:00:52 PM.'),(578,'Emma logged in at Dec 17, 2023, 8:03:42 PM.'),(580,'Emma logged in at Dec 17, 2023, 8:10:40 PM.'),(582,'Emma logged in at Dec 17, 2023, 8:14:46 PM.'),(584,'Emma logged in at Dec 17, 2023, 8:14:49 PM.'),(586,'Emma logged in at Dec 17, 2023, 8:16:13 PM.'),(588,'Emma logged in at Dec 17, 2023, 8:18:00 PM.'),(590,'Emma logged in at Dec 17, 2023, 8:20:15 PM.'),(592,'Emma logged in at Dec 17, 2023, 8:22:47 PM.'),(594,'Emma logged in at Dec 17, 2023, 8:28:09 PM.'),(596,'Emma logged in at Dec 17, 2023, 8:31:17 PM.'),(598,'Emma logged in at Dec 17, 2023, 8:34:17 PM.'),(600,'Emma logged in at Dec 17, 2023, 8:42:36 PM.'),(602,'Emma logged in at Dec 17, 2023, 8:48:55 PM.'),(604,'Emma logged in at Dec 17, 2023, 8:54:25 PM.'),(606,'Emma logged in at Dec 17, 2023, 9:01:18 PM.'),(608,'Emma logged in at Dec 17, 2023, 9:05:51 PM.'),(610,'Emma logged in at Dec 17, 2023, 9:11:42 PM.'),(612,'Emma logged in at Dec 17, 2023, 9:14:34 PM.'),(614,'Emma logged in at Dec 17, 2023, 9:20:01 PM.'),(616,'Emma logged in at Dec 17, 2023, 9:22:34 PM.'),(618,'Emma logged in at Dec 17, 2023, 9:25:15 PM.'),(620,'Emma logged in at Dec 17, 2023, 9:27:33 PM.'),(622,'Emma logged in at Dec 17, 2023, 9:33:39 PM.'),(624,'Emma logged in at Dec 17, 2023, 9:36:32 PM.'),(626,'Emma logged in at Dec 17, 2023, 9:37:55 PM.'),(628,'Emma logged in at Dec 17, 2023, 9:42:56 PM.'),(630,'Emma logged in at Dec 17, 2023, 9:44:23 PM.'),(632,'Emma logged in at Dec 17, 2023, 9:45:37 PM.'),(634,'Emma logged in at Dec 17, 2023, 9:47:51 PM.'),(636,'Emma logged in at Dec 17, 2023, 9:49:14 PM.'),(638,'Emma logged in at Dec 17, 2023, 9:50:41 PM.'),(640,'Emma logged in at Dec 17, 2023, 9:54:15 PM.'),(642,'Emma logged in at Dec 17, 2023, 10:02:56 PM.'),(644,'Emma logged in at Dec 17, 2023, 10:04:19 PM.'),(646,'Emma logged in at Dec 17, 2023, 10:06:53 PM.'),(648,'Emma logged in at Dec 17, 2023, 10:08:02 PM.'),(650,'Emma logged in at Dec 17, 2023, 10:09:40 PM.'),(652,'Emma logged in at Dec 17, 2023, 10:11:09 PM.'),(654,'Emma logged in at Dec 17, 2023, 10:29:20 PM.'),(656,'Emma logged in at Dec 17, 2023, 10:31:23 PM.'),(658,'Emma logged in at Dec 17, 2023, 10:35:31 PM.'),(660,'Emma logged in at Dec 17, 2023, 10:38:12 PM.'),(662,'Emma logged in at Dec 18, 2023, 12:04:23 AM.'),(675,'Emma logged in at Dec 18, 2023, 1:12:14 AM.'),(678,'Emma logged in at Dec 18, 2023, 1:17:21 AM.'),(681,'Emma logged in at Dec 18, 2023, 10:54:43 AM.'),(683,'Emma logged in at Dec 18, 2023, 10:57:18 AM.'),(686,'Emma logged in at Dec 18, 2023, 1:27:19 PM.'),(689,'Emma logged in at Dec 18, 2023, 1:31:48 PM.'),(691,'Emma logged in at Dec 18, 2023, 1:38:35 PM.'),(694,'Emma logged in at Dec 18, 2023, 1:45:06 PM.'),(697,'Emma logged in at Dec 18, 2023, 1:48:47 PM.'),(700,'Emma logged in at Dec 18, 2023, 1:54:45 PM.'),(703,'Emma logged in at Dec 18, 2023, 2:00:03 PM.'),(707,'Emma logged in at Dec 18, 2023, 2:58:08 PM.'),(710,'Emma logged in at Dec 18, 2023, 3:20:22 PM.'),(713,'Emma logged in at Dec 18, 2023, 5:55:12 PM.'),(715,'Emma logged in at Dec 18, 2023, 5:57:00 PM.'),(717,'Emma logged in at Dec 18, 2023, 6:01:34 PM.'),(719,'Emma logged in at Dec 18, 2023, 6:21:27 PM.'),(721,'Emma logged in at Dec 18, 2023, 6:36:17 PM.'),(724,'Emma logged in at Dec 18, 2023, 7:43:49 PM.'),(727,'Emma logged in at Dec 18, 2023, 7:50:07 PM.'),(729,'Emma logged in at Dec 18, 2023, 7:54:13 PM.'),(732,'Emma logged in at Dec 18, 2023, 8:00:48 PM.'),(736,'Emma logged in at Dec 18, 2023, 8:18:37 PM.'),(739,'Emma logged in at Dec 18, 2023, 8:19:33 PM.'),(742,'Emma logged in at Dec 18, 2023, 8:23:31 PM.'),(744,'Emma logged in at Dec 18, 2023, 8:27:21 PM.'),(746,'Emma logged in at Dec 18, 2023, 8:32:32 PM.'),(748,'Emma logged in at Dec 18, 2023, 8:53:27 PM.'),(750,'Emma logged in at Dec 18, 2023, 8:58:02 PM.'),(752,'Emma logged in at Dec 18, 2023, 9:09:18 PM.'),(754,'Emma logged in at Dec 18, 2023, 9:12:33 PM.'),(757,'Emma logged in at Dec 18, 2023, 9:22:54 PM.'),(760,'Emma logged in at Dec 18, 2023, 9:30:12 PM.'),(763,'Emma logged in at Dec 18, 2023, 9:32:39 PM.'),(766,'Emma logged in at Dec 18, 2023, 9:36:44 PM.'),(769,'Emma logged in at Dec 18, 2023, 9:40:01 PM.'),(772,'Emma logged in at Dec 18, 2023, 9:42:55 PM.'),(775,'Emma logged in at Dec 18, 2023, 9:45:18 PM.'),(777,'Emma logged in at Dec 18, 2023, 9:50:49 PM.'),(779,'Emma logged in at Dec 18, 2023, 9:52:46 PM.'),(781,'Emma logged in at Dec 18, 2023, 9:54:36 PM.'),(783,'Emma logged in at Dec 18, 2023, 9:58:52 PM.'),(785,'Emma logged in at Dec 18, 2023, 11:23:18 PM.'),(787,'Emma logged in at Dec 18, 2023, 11:37:27 PM.'),(789,'Emma logged in at Dec 18, 2023, 11:40:43 PM.'),(791,'Emma logged in at Dec 18, 2023, 11:42:26 PM.'),(793,'Emma logged in at Dec 19, 2023, 12:25:24 AM.'),(795,'Emma logged in at Dec 19, 2023, 12:27:46 AM.'),(797,'Emma logged in at Dec 19, 2023, 12:36:51 AM.'),(799,'Emma logged in at Dec 19, 2023, 12:54:35 AM.'),(802,'Emma logged in at Dec 19, 2023, 12:59:50 AM.'),(805,'Emma logged in at Dec 19, 2023, 1:58:38 AM.'),(808,'Humphrey logged in at Dec 19, 2023, 2:01:08 AM.'),(812,'Emma logged in at Dec 19, 2023, 2:07:23 AM.'),(815,'Emma logged in at Dec 19, 2023, 2:15:00 AM.'),(817,'Emma logged in at Dec 19, 2023, 2:17:55 AM.'),(819,'Emma logged in at Dec 19, 2023, 2:20:48 AM.'),(821,'Emma logged in at Dec 19, 2023, 2:36:38 AM.'),(824,'Emma logged in at Dec 19, 2023, 2:44:01 AM.'),(827,'Emma logged in at Dec 19, 2023, 2:47:17 AM.'),(830,'Emma logged in at Dec 19, 2023, 2:52:04 AM.'),(835,'Emma logged in at Dec 19, 2023, 2:56:49 AM.'),(838,'Emma logged in at Dec 19, 2023, 3:00:13 AM.'),(842,'Emma logged in at Dec 19, 2023, 3:02:45 AM.'),(846,'Emma logged in at Dec 19, 2023, 3:11:27 AM.'),(849,'Emma logged in at Dec 19, 2023, 3:14:30 AM.'),(852,'Emma logged in at Dec 19, 2023, 3:17:55 AM.'),(855,'Emma logged in at Dec 19, 2023, 3:18:46 AM.'),(858,'Emma logged in at Dec 19, 2023, 3:20:43 AM.'),(861,'Emma logged in at Dec 19, 2023, 3:22:26 AM.'),(865,'Emma logged in at Dec 19, 2023, 3:24:42 AM.'),(867,'Emma logged in at Dec 19, 2023, 3:35:58 AM.'),(873,'Emma logged in at Dec 19, 2023, 3:51:57 AM.'),(876,'Emma logged in at Dec 19, 2023, 4:04:01 AM.'),(878,'Emma logged in at Dec 19, 2023, 4:08:00 AM.'),(888,'Emma logged in at Dec 19, 2023, 4:22:27 AM.'),(890,'Emma logged in at Dec 19, 2023, 4:24:12 AM.'),(892,'Emma logged in at Dec 19, 2023, 4:27:00 AM.'),(894,'Emma logged in at Dec 19, 2023, 4:37:56 AM.'),(897,'Emma logged in at Dec 19, 2023, 5:01:26 AM.'),(899,'Emma logged in at Dec 19, 2023, 9:14:20 AM.'),(901,'Emma logged in at Dec 19, 2023, 9:24:56 AM.'),(904,'Emma logged in at Dec 19, 2023, 9:49:51 AM.'),(906,'Emma logged in at Dec 19, 2023, 9:55:28 AM.'),(908,'Emma logged in at Dec 19, 2023, 9:57:09 AM.'),(910,'Keziah logged in at Dec 19, 2023, 9:57:38 AM.'),(912,'Emma logged in at Dec 19, 2023, 9:58:05 AM.'),(917,'Emma logged in at Dec 19, 2023, 10:17:31 AM.'),(920,'Emma logged in at Dec 19, 2023, 10:21:05 AM.'),(926,'Moses logged in at Dec 19, 2023, 11:39:12 AM.'),(928,'Moses logged in at Dec 19, 2023, 11:39:17 AM.'),(930,'Moses logged in at Dec 19, 2023, 11:39:15 AM.'),(933,'Emma logged in at Dec 19, 2023, 11:41:59 AM.'),(939,'Moses logged in at Dec 19, 2023, 11:54:09 AM.'),(940,'Moses logged in at Dec 19, 2023, 11:54:13 AM.'),(942,'Moses logged in at Dec 19, 2023, 11:54:17 AM.'),(944,'Moses logged in at Dec 19, 2023, 11:54:15 AM.'),(946,'Emma logged in at Dec 19, 2023, 12:06:35 PM.'),(948,'Humphrey logged in at Jan 6, 2024, 3:58:21 PM.'),(954,'Humphrey logged in at Jan 6, 2024, 6:32:49 PM.'),(957,'Emma logged in at Jan 25, 2024, 10:53:44 AM.'),(959,'Emma logged in at Jan 25, 2024, 11:09:00 AM.'),(961,'Emma logged in at Jan 25, 2024, 11:26:55 AM.'),(963,'Emma logged in at Jan 25, 2024, 11:41:46 AM.'),(966,'Emma logged in at Jan 25, 2024, 12:05:12 PM.'),(968,'Emma logged in at Jan 25, 2024, 12:06:53 PM.'),(970,'Emma logged in at Jan 25, 2024, 12:08:30 PM.'),(972,'Emma logged in at Jan 25, 2024, 12:14:25 PM.'),(974,'Emma logged in at Jan 25, 2024, 12:16:38 PM.'),(976,'Emma logged in at Jan 25, 2024, 12:19:47 PM.'),(978,'Emma logged in at Jan 25, 2024, 12:22:24 PM.'),(981,'Emma logged in at Jan 25, 2024, 12:29:24 PM.'),(984,'Emma logged in at Jan 25, 2024, 12:35:12 PM.'),(986,'Emma logged in at Jan 25, 2024, 12:36:52 PM.'),(989,'Emma logged in at Jan 25, 2024, 3:10:13 PM.'),(992,'Emma logged in at Jan 25, 2024, 3:27:52 PM.');
/*!40000 ALTER TABLE `audit_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint NOT NULL,
  `booking_no` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `noOfPeople` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `totalPrice` decimal(19,2) DEFAULT NULL,
  `tour_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi21lisuytk5t7tlp7lv51ny2l` (`tour_id`),
  KEY `FKeyog2oic85xg7hsu2je2lx3s6` (`user_id`),
  CONSTRAINT `FKeyog2oic85xg7hsu2je2lx3s6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKi21lisuytk5t7tlp7lv51ny2l` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (881,'BN19/12/23-231','2023-12-19 04:09:08.466337',NULL,2,NULL,400.00,880,872),(902,'BN19/12/23-510','2023-12-19 09:27:48.356630',NULL,6,NULL,600.00,883,872),(918,'BN19/12/23-181','2023-12-19 10:18:27.568136',NULL,2,NULL,200.00,883,872),(955,'BN06/01/24-25','2024-01-06 18:33:17.405679',NULL,2,NULL,600.00,882,875),(964,'BN25/01/24-966','2024-01-25 11:55:14.283452',NULL,2,NULL,400.00,880,872),(979,'BN25/01/24-523','2024-01-25 12:22:54.431391',NULL,3,NULL,600.00,880,872),(982,'BN25/01/24-68','2024-01-25 12:31:09.180392',NULL,3,NULL,600.00,880,872),(987,'BN25/01/24-289','2024-01-25 12:37:59.826512',NULL,3,NULL,600.00,880,872),(990,'BN25/01/24-323','2024-01-25 15:10:40.790757',NULL,3,NULL,600.00,880,872);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',992);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` bigint NOT NULL,
  `paymentAmount` decimal(19,2) DEFAULT NULL,
  `paymentDate` datetime(6) DEFAULT NULL,
  `paymentNo` varchar(255) DEFAULT NULL,
  `paymentStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tours` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `tour_category` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (880,'2023-12-19 04:08:37.432554','2023-12-30','https://images.unsplash.com/photo-1695068546554-b12820bc827d?q=80&w=1494&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Amsterdam - Bruges Excursion',200.00,'2023-12-21',1),(882,'2023-12-19 04:11:13.234826','2023-12-28','https://images.unsplash.com/photo-1568849676085-51415703900f?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Historical Heritage Trail',300.00,'2023-12-29',2),(883,'2023-12-19 04:12:33.048945','2023-12-29','https://images.unsplash.com/photo-1528543606781-2f6e6857f318?q=80&w=1530&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Metropolitan Marvels Experience',100.00,'2023-12-21',2),(884,'2023-12-19 04:15:16.470150','2023-12-30','https://images.unsplash.com/photo-1682687220795-796d3f6f7000?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Floral Paradise Expedition',5800.00,'2023-12-21',2),(885,'2023-12-19 04:16:44.864821','2024-06-20','https://images.unsplash.com/photo-1507608616759-54f48f0af0ee?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Downtown Discovery Walk',700.00,'2023-12-29',4),(886,'2023-12-19 04:18:27.836501','2023-12-30','https://images.unsplash.com/photo-1505832018823-50331d70d237?q=80&w=1508&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Floral Paradise Expedition',300.00,'2023-12-21',2),(887,'2023-12-19 04:19:42.025608','2023-12-30','https://images.unsplash.com/photo-1502003148287-a82ef80a6abc?q=80&w=1376&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Birdwatcher\'s Haven Adventure',100.00,'2023-12-20',4),(921,'2023-12-19 10:53:25.598874','2023-12-29','https://images.unsplash.com/photo-1504609773096-104ff2c73ba4?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D','Mystical Pathways Expedition',900.00,'2023-12-23',2);
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_ipAddress`
--

DROP TABLE IF EXISTS `user_ipAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_ipAddress` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userIpAddress` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=992 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_ipAddress`
--

LOCK TABLES `user_ipAddress` WRITE;
/*!40000 ALTER TABLE `user_ipAddress` DISABLE KEYS */;
INSERT INTO `user_ipAddress` VALUES (1,'12234',NULL),(2,'12234',NULL),(3,'12234',NULL),(4,'12234',NULL),(7,'12234',NULL),(10,'12234',NULL),(12,'12234',NULL),(19,'12234',NULL),(21,'12234',NULL),(24,'12234',NULL),(26,'12234',NULL),(28,'12234',NULL),(30,'12234',NULL),(32,'12234',NULL),(34,'12234',NULL),(36,'12234',NULL),(38,'12234',NULL),(40,'12234',NULL),(43,'12234',NULL),(46,'12234',NULL),(51,'12234',NULL),(53,'12234',NULL),(55,'12234',NULL),(58,'12234',NULL),(60,'12234',NULL),(62,'12234',NULL),(64,'12234',NULL),(66,'12234',NULL),(70,'12234',NULL),(73,'12234',NULL),(76,'12234',NULL),(79,'12234',NULL),(81,'12234',NULL),(84,'12234',NULL),(87,'12234',NULL),(90,'12234',NULL),(92,'12234',NULL),(95,'12234',NULL),(97,'12234',NULL),(100,'12234',NULL),(102,'12234',NULL),(105,'12234',NULL),(108,'12234',NULL),(111,'12234',NULL),(115,'12234',NULL),(117,'12234',NULL),(119,'12234',NULL),(121,'12234',NULL),(123,'12234',NULL),(126,'12234',NULL),(128,'12234',NULL),(131,'12234',NULL),(134,'12234',NULL),(136,'12234',NULL),(139,'12234',NULL),(141,'12234',NULL),(143,'12234',NULL),(146,'12234',NULL),(149,'12234',NULL),(151,'12234',NULL),(153,'12234',NULL),(155,'12234',NULL),(157,'12234',NULL),(159,'12234',NULL),(161,'12234',NULL),(163,'12234',NULL),(165,'12234',NULL),(168,'12234',NULL),(170,'12234',NULL),(172,'12234',NULL),(174,'12234',NULL),(176,'12234',NULL),(178,'12234',NULL),(180,'12234',NULL),(182,'12234',NULL),(184,'12234',NULL),(186,'12234',NULL),(189,'12234',NULL),(196,'12234',NULL),(200,'12234',NULL),(202,'12234',NULL),(204,'12234',NULL),(207,'12234',NULL),(209,'12234',NULL),(211,'12234',NULL),(213,'12234',NULL),(215,'12234',NULL),(217,'12234',NULL),(219,'12234',NULL),(221,'12234',NULL),(223,'12234',NULL),(225,'12234',NULL),(227,'12234',NULL),(229,'12234',NULL),(231,'12234',NULL),(233,'12234',NULL),(235,'12234',NULL),(237,'12234',NULL),(239,'12234',NULL),(244,'12234',NULL),(246,'12234',NULL),(247,'12234',NULL),(248,'12234',NULL),(250,'12234',NULL),(253,'12234',NULL),(255,'12234',NULL),(258,'12234',NULL),(263,'12234',NULL),(265,'12234',NULL),(267,'12234',NULL),(269,'12234',NULL),(271,'12234',NULL),(273,'12234',NULL),(275,'12234',NULL),(277,'12234',NULL),(279,'12234',NULL),(281,'12234',NULL),(283,'12234',NULL),(285,'12234',NULL),(287,'12234',NULL),(289,'12234',NULL),(292,'12234',NULL),(295,'12234',NULL),(297,'12234',NULL),(299,'12234',NULL),(303,'12234',NULL),(305,'12234',NULL),(307,'12234',NULL),(309,'12234',NULL),(313,'12234',NULL),(315,'12234',NULL),(317,'12234',NULL),(319,'12234',NULL),(323,'12234',NULL),(325,'12234',NULL),(327,'12234',NULL),(329,'12234',NULL),(331,'12234',NULL),(336,'12234',NULL),(338,'12234',NULL),(340,'12234',NULL),(342,'12234',NULL),(344,'12234',NULL),(346,'12234',NULL),(349,'12234',NULL),(350,'12234',NULL),(352,'12234',NULL),(354,'12234',NULL),(356,'12234',NULL),(358,'12234',NULL),(360,'12234',NULL),(362,'12234',NULL),(364,'12234',NULL),(366,'12234',NULL),(368,'12234',NULL),(370,'12234',NULL),(372,'12234',NULL),(374,'12234',NULL),(376,'12234',NULL),(378,'12234',NULL),(380,'12234',NULL),(382,'12234',NULL),(384,'12234',NULL),(386,'12234',NULL),(388,'12234',NULL),(390,'12234',NULL),(392,'12234',NULL),(394,'12234',NULL),(396,'12234',NULL),(398,'12234',NULL),(400,'12234',NULL),(402,'12234',NULL),(404,'12234',NULL),(406,'12234',NULL),(408,'12234',NULL),(410,'12234',NULL),(412,'12234',NULL),(414,'12234',NULL),(416,'12234',NULL),(418,'12234',NULL),(420,'12234',NULL),(422,'12234',NULL),(424,'12234',NULL),(426,'12234',NULL),(428,'12234',NULL),(430,'12234',NULL),(432,'12234',NULL),(434,'12234',NULL),(436,'12234',NULL),(438,'12234',NULL),(442,'12234',NULL),(444,'12234',NULL),(446,'12234',NULL),(451,'12234',NULL),(454,'12234',NULL),(456,'12234',NULL),(459,'12234',NULL),(461,'12234',NULL),(465,'12234',NULL),(468,'12234',NULL),(473,'12234',NULL),(475,'12234',NULL),(478,'12234',NULL),(482,'12234',NULL),(488,'12234',NULL),(494,'12234',NULL),(499,'12234',NULL),(500,'12234',NULL),(505,'12234',NULL),(508,'12234',NULL),(509,'12234',NULL),(513,'12234',NULL),(517,'12234',NULL),(520,'12234',NULL),(523,'12234',NULL),(525,'12234',NULL),(527,'12234',NULL),(530,'12234',NULL),(533,'12234',NULL),(534,'12234',NULL),(537,'12234',NULL),(540,'12234',NULL),(543,'12234',NULL),(547,'12234',NULL),(551,'12234',NULL),(553,'12234',NULL),(555,'12234',NULL),(557,'12234',NULL),(559,'12234',NULL),(561,'12234',NULL),(563,'12234',NULL),(565,'12234',NULL),(567,'12234',NULL),(569,'12234',NULL),(571,'12234',NULL),(573,'12234',NULL),(575,'12234',NULL),(577,'12234',NULL),(579,'12234',NULL),(581,'12234',NULL),(583,'12234',NULL),(585,'12234',NULL),(587,'12234',NULL),(589,'12234',NULL),(591,'12234',NULL),(593,'12234',NULL),(595,'12234',NULL),(597,'12234',NULL),(599,'12234',NULL),(601,'12234',NULL),(603,'12234',NULL),(605,'12234',NULL),(607,'12234',NULL),(609,'12234',NULL),(611,'12234',NULL),(613,'12234',NULL),(615,'12234',NULL),(617,'12234',NULL),(619,'12234',NULL),(621,'12234',NULL),(623,'12234',NULL),(625,'12234',NULL),(627,'12234',NULL),(629,'12234',NULL),(631,'12234',NULL),(633,'12234',NULL),(635,'12234',NULL),(637,'12234',NULL),(639,'12234',NULL),(641,'12234',NULL),(643,'12234',NULL),(645,'12234',NULL),(647,'12234',NULL),(649,'12234',NULL),(651,'12234',NULL),(653,'12234',NULL),(655,'12234',NULL),(657,'12234',NULL),(659,'12234',NULL),(661,'12234',NULL),(663,'12234',NULL),(676,'12234',NULL),(679,'12234',NULL),(682,'12234',NULL),(684,'12234',NULL),(687,'12234',NULL),(690,'12234',NULL),(692,'12234',NULL),(695,'12234',NULL),(698,'12234',NULL),(701,'12234',NULL),(704,'12234',NULL),(708,'12234',NULL),(711,'12234',NULL),(714,'12234',NULL),(716,'12234',NULL),(718,'12234',NULL),(720,'12234',NULL),(722,'12234',NULL),(725,'12234',NULL),(728,'12234',NULL),(730,'12234',NULL),(733,'12234',NULL),(737,'12234',NULL),(740,'12234',NULL),(743,'12234',NULL),(745,'12234',NULL),(747,'12234',NULL),(749,'12234',NULL),(751,'12234',NULL),(753,'12234',NULL),(755,'12234',NULL),(758,'12234',NULL),(761,'12234',NULL),(764,'12234',NULL),(767,'12234',NULL),(770,'12234',NULL),(773,'12234',NULL),(776,'12234',NULL),(778,'12234',NULL),(780,'12234',NULL),(782,'12234',NULL),(784,'12234',NULL),(786,'12234',NULL),(788,'12234',NULL),(790,'12234',NULL),(792,'12234',NULL),(794,'12234',NULL),(796,'12234',NULL),(798,'12234',NULL),(800,'12234',NULL),(803,'12234',NULL),(806,'12234',NULL),(809,'12234',NULL),(813,'12234',NULL),(816,'12234',NULL),(818,'12234',NULL),(820,'12234',NULL),(822,'12234',NULL),(825,'12234',NULL),(828,'12234',NULL),(831,'12234',NULL),(836,'12234',NULL),(839,'12234',NULL),(843,'12234',NULL),(847,'12234',NULL),(850,'12234',NULL),(853,'12234',NULL),(856,'12234',NULL),(859,'12234',NULL),(862,'12234',NULL),(866,'12234',NULL),(868,'12234',NULL),(874,'12234',NULL),(877,'12234',NULL),(879,'12234',NULL),(889,'12234',NULL),(891,'12234',NULL),(893,'12234',NULL),(895,'12234',NULL),(896,'{  \"origin\": \"105.163.158.217\"}',NULL),(898,'{  \"origin\": \"105.161.156.78\"}',NULL),(900,'{  \"origin\": \"105.161.156.78\"}',NULL),(903,'{  \"origin\": \"197.232.158.142\"}',NULL),(905,'{  \"origin\": \"197.232.158.142\"}',NULL),(907,'{  \"origin\": \"197.232.158.142\"}',NULL),(909,'{  \"origin\": \"197.232.158.142\"}',NULL),(911,'{  \"origin\": \"197.232.158.142\"}',NULL),(916,'{  \"origin\": \"197.232.158.142\"}',NULL),(919,'{  \"origin\": \"197.232.158.142\"}',NULL),(925,'{  \"origin\": \"197.232.158.142\"}',NULL),(927,'{  \"origin\": \"197.232.158.142\"}',NULL),(929,'{  \"origin\": \"197.232.158.142\"}',NULL),(932,'{  \"origin\": \"197.232.158.142\"}',NULL),(937,'{  \"origin\": \"197.232.158.142\"}',NULL),(938,'{  \"origin\": \"197.232.158.142\"}',NULL),(941,'{  \"origin\": \"197.232.158.142\"}',NULL),(943,'{  \"origin\": \"197.232.158.142\"}',NULL),(945,'{  \"origin\": \"197.232.158.142\"}',NULL),(947,'{  \"origin\": \"105.163.158.112\"}',NULL),(953,'{  \"origin\": \"105.163.158.112\"}',NULL),(956,'{  \"origin\": \"197.232.158.142\"}',NULL),(958,'{  \"origin\": \"197.232.158.142\"}',NULL),(960,'{  \"origin\": \"197.232.158.142\"}',NULL),(962,'{  \"origin\": \"197.232.158.142\"}',NULL),(965,'{  \"origin\": \"197.232.158.142\"}',NULL),(967,'{  \"origin\": \"197.232.158.142\"}',NULL),(969,'{  \"origin\": \"197.232.158.142\"}',NULL),(971,'{  \"origin\": \"197.232.158.142\"}',NULL),(973,'{  \"origin\": \"197.232.158.142\"}',NULL),(975,'{  \"origin\": \"197.232.158.142\"}',NULL),(977,'{  \"origin\": \"197.232.158.142\"}',NULL),(980,'{  \"origin\": \"197.232.158.142\"}',NULL),(983,'{  \"origin\": \"197.232.158.142\"}',NULL),(985,'{  \"origin\": \"197.232.158.142\"}',NULL),(988,'{  \"origin\": \"197.232.158.142\"}',NULL),(991,'{  \"origin\": \"197.232.158.142\"}',NULL);
/*!40000 ALTER TABLE `user_ipAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (871,'kez@systech.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','GUIDES','Keziah'),(872,'emma@systech.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','ADMIN','Emma'),(875,'humphreynyaga2@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','ADMIN','Humphrey'),(913,'emily@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Emily'),(914,'bavomike@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Mike'),(915,'lenabett@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Lena'),(922,'halkanomalise@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Malise'),(923,'emilykamiti@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Emily'),(924,'moseg95@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0716354036','USER','Moses'),(936,'isabelkaindu@gmail.com','�e�Y B/�A~Hg��O��J?��~������z�','0742454034','USER','Winnie');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20  6:50:35
