-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.6.26 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para mitocode
CREATE DATABASE IF NOT EXISTS `mitocode` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mitocode`;


-- Volcando estructura para tabla mitocode.detalleventa
CREATE TABLE IF NOT EXISTS `detalleventa` (
  `codigo` int(11) NOT NULL,
  `codventa` int(11) NOT NULL,
  `codproducto` int(11) NOT NULL,
  `cantidad` tinyint(4) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mitocode.detalleventa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;


-- Volcando estructura para tabla mitocode.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `codigo` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `sexo` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mitocode.persona: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`codigo`, `nombre`, `sexo`) VALUES
	(1, 'raul', 'm'),
	(2, 'paula', 'f'),
	(3, 'pedro', 'm'),
	(4, 'ronald', 'm'),
	(5, 'wwwww', 'm'),
	(6, 'alberto', 'm'),
	(7, 'juan cominges', 'm'),
	(8, 'jhkkjhjhk', 'm'),
	(9, 'roger federer', 'm'),
	(10, 'roger federer456465', 'm'),
	(11, '879789789789789', 'm'),
	(12, 'miriam alejo', 'f');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


-- Volcando estructura para tabla mitocode.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL DEFAULT '0',
  `precio` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mitocode.producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


-- Volcando estructura para tabla mitocode.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `codpersona` tinyint(4) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mitocode.venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
