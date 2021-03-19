-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: helpdesk_app
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chamado`
--

DROP TABLE IF EXISTS `chamado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chamado` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `status` varchar(2) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `dt_inclusao` date NOT NULL,
  `dt_conclusao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chamado`
--

LOCK TABLES `chamado` WRITE;
/*!40000 ALTER TABLE `chamado` DISABLE KEYS */;
INSERT INTO `chamado` VALUES (1,'titulo 1 teste','FE','chamado de teste para API','2021-03-08','2021-03-19'),(2,'titulo 1 teste','FE','chamado de teste para API','2021-03-10','2021-03-19'),(3,'teste de inclusao','AB','teste do serviço de inclusao','2021-03-14',NULL),(4,'teste de inclusao 2','AB','teste do serviço de inclusao 2','2021-03-14',NULL),(5,'teste de retorno inclusao ','AB','teste do serviço de inclusao com retorno do id gerado','2021-03-14',NULL),(6,'teste de retorno inclusao 2 ','AB','teste do serviço de inclusao com retorno do id gerado 2','2021-03-18',NULL),(7,'teste de tela','AB','testando a tela de chamados','2021-03-19',NULL),(8,'segundo teste','AB','mais um teste de tela','2021-03-19',NULL),(9,'teste de tela 3','AB','terceiro teste de tela','2021-03-19',NULL);
/*!40000 ALTER TABLE `chamado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `id_chamado` int(12) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `dt_inclusao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_chamado` (`id_chamado`),
  CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_chamado`) REFERENCES `chamado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,1,'comentario teste de API','2021-03-11'),(2,1,'comentario teste de API','2021-03-11'),(3,2,'teste de inclusão de comentario via serviço','2021-03-14'),(4,5,'teste de inclusão de comentario via serviço para o chamado 5','2021-03-14'),(5,1,'mais um teste de inclusao de comentario','2021-03-19'),(6,1,'testando','2021-03-19'),(7,1,'teste mais um','2021-03-19'),(8,1,'comentario','2021-03-19'),(9,1,'comentario 6','2021-03-19'),(10,1,'comentario 8','2021-03-19'),(11,1,'comentario 9','2021-03-19');
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-19  5:31:11
