-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.39 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.21.0.7344
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database kft_db
DROP DATABASE IF EXISTS `kft_db`;
CREATE DATABASE IF NOT EXISTS `kft_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kft_db`;

-- Dump della struttura di tabella kft_db.elementi
DROP TABLE IF EXISTS `elementi`;
CREATE TABLE IF NOT EXISTS `elementi` (
  `id_prodottoK` int NOT NULL,
  `id_ordineK` int NOT NULL,
  `n_elementi` int NOT NULL DEFAULT '1',
  `tot_parziale` double NOT NULL DEFAULT (0),
  PRIMARY KEY (`id_prodottoK`,`id_ordineK`) USING BTREE,
  KEY `id_ordineK` (`id_ordineK`),
  CONSTRAINT `FK_elementi_ordine` FOREIGN KEY (`id_ordineK`) REFERENCES `ordine` (`id_ordine`),
  CONSTRAINT `FK_elementi_prodotto` FOREIGN KEY (`id_prodottoK`) REFERENCES `prodotto` (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella kft_db.elementi: ~0 rows (circa)
DELETE FROM `elementi`;

-- Dump della struttura di tabella kft_db.m_pagamento
DROP TABLE IF EXISTS `m_pagamento`;
CREATE TABLE IF NOT EXISTS `m_pagamento` (
  `id_metodo` int NOT NULL AUTO_INCREMENT,
  `iD_Cliente` int NOT NULL,
  `tipo` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `username` char(50) DEFAULT NULL,
  `passward` char(64) DEFAULT NULL COMMENT 'non in chiaro',
  `nome_int` char(50) DEFAULT NULL COMMENT 'nome intestatario',
  `cognome_int` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'cognome intestatario',
  `id_carta` int DEFAULT NULL COMMENT 'solo numeri non in chiaro',
  `cvc` int DEFAULT NULL COMMENT 'non in chiaro, solo numerico',
  `scadenza_mese` int DEFAULT NULL,
  `scadenza_anno` int DEFAULT NULL,
  PRIMARY KEY (`id_metodo`),
  KEY `Indice 2` (`iD_Cliente`) USING BTREE,
  CONSTRAINT `FK_m_pagamento_cliente` FOREIGN KEY (`iD_Cliente`) REFERENCES `utente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella kft_db.m_pagamento: ~0 rows (circa)
DELETE FROM `m_pagamento`;

-- Dump della struttura di tabella kft_db.ordine
DROP TABLE IF EXISTS `ordine`;
CREATE TABLE IF NOT EXISTS `ordine` (
  `id_ordine` int NOT NULL AUTO_INCREMENT,
  `id_clienteKK` int NOT NULL,
  `data` date NOT NULL,
  `totale` double NOT NULL COMMENT 'inserire espressione',
  PRIMARY KEY (`id_ordine`),
  KEY `FK_ordine_cliente` (`id_clienteKK`) USING BTREE,
  CONSTRAINT `FK_ordine_cliente` FOREIGN KEY (`id_clienteKK`) REFERENCES `utente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella kft_db.ordine: ~0 rows (circa)
DELETE FROM `ordine`;

-- Dump della struttura di tabella kft_db.prodotto
DROP TABLE IF EXISTS `prodotto`;
CREATE TABLE IF NOT EXISTS `prodotto` (
  `id_prodotto` int NOT NULL AUTO_INCREMENT,
  `nome_p` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
  `foto` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'da modificare',
  `prezzo` double NOT NULL DEFAULT '0',
  `disponibile` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella kft_db.prodotto: ~0 rows (circa)
DELETE FROM `prodotto`;

-- Dump della struttura di tabella kft_db.utente
DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(64) NOT NULL COMMENT 'non riportata in chiareo',
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `ruolo` int NOT NULL DEFAULT (0),
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `unico` (`username`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella kft_db.utente: ~0 rows (circa)
DELETE FROM `utente`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
