-- MySQL dump 10.16  Distrib 10.2.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: examenes_idiomas
-- ------------------------------------------------------
-- Server version	10.2.17-MariaDB

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
-- Table structure for table `aplicador`
--

DROP TABLE IF EXISTS `aplicador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aplicador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `CEDULA_PROFESIONAL` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicador`
--

LOCK TABLES `aplicador` WRITE;
/*!40000 ALTER TABLE `aplicador` DISABLE KEYS */;
/*!40000 ALTER TABLE `aplicador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracion_usuario`
--

DROP TABLE IF EXISTS `configuracion_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracion_usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `HORARIO` tinyint(4) NOT NULL DEFAULT 0,
  `SALON` tinyint(4) NOT NULL DEFAULT 0,
  `IDIOMA` tinyint(4) NOT NULL DEFAULT 0,
  `EXAMEN` tinyint(4) NOT NULL DEFAULT 0,
  `APLICADOR` tinyint(4) NOT NULL DEFAULT 0,
  `GRUPOS` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracion_usuario`
--

LOCK TABLES `configuracion_usuario` WRITE;
/*!40000 ALTER TABLE `configuracion_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuracion_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NIVEL` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `SALON` int(11) NOT NULL DEFAULT 0,
  `IDIOMA_ID` int(11) NOT NULL DEFAULT 0,
  `HORARIO_ID` int(11) NOT NULL DEFAULT 0,
  `APLICADOR_ID` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `FK_ID_IDIOMA_ID` (`IDIOMA_ID`),
  KEY `FK_ID_HORARIO_ID` (`HORARIO_ID`),
  KEY `FK_ID_APLICADOR_ID` (`APLICADOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_usuario`
--

DROP TABLE IF EXISTS `historial_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO_ID` int(11) NOT NULL DEFAULT 0,
  `FECHA_APLICACION` date DEFAULT NULL,
  `IDIOMA` int(11) NOT NULL DEFAULT 0,
  `NIVEL` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `ESTATUS_EXAMEN` float NOT NULL DEFAULT 0,
  `CALIFICACION` float NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `FK_ID_USUARIO_ID` (`USUARIO_ID`),
  CONSTRAINT `FK_ID_USUARIO_ID` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_usuario`
--

LOCK TABLES `historial_usuario` WRITE;
/*!40000 ALTER TABLE `historial_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` date NOT NULL,
  `HORARIO_INICIO` time NOT NULL,
  `HORARIO_FINAL` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idioma` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDIOMA` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `CLAVE` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CLAVE` (`CLAVE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idioma`
--

LOCK TABLES `idioma` WRITE;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` text COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `TIPO` varchar(20) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `NUMERO_CUENTA` varchar(20) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `CORREO` varchar(90) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `CONTRASENA` varchar(20) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `NIVEL_ACTUAL` varchar(20) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `CONFIGURACION_ID` int(11) NOT NULL DEFAULT 0,
  `VALIDADO` varchar(10) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMERO_CUENTA` (`NUMERO_CUENTA`),
  KEY `FK_ID_CONFIGURACION_ID` (`CONFIGURACION_ID`),
  CONSTRAINT `FK_ID_CONFIGURACION_ID` FOREIGN KEY (`CONFIGURACION_ID`) REFERENCES `configuracion_usuario` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-29 23:51:57
