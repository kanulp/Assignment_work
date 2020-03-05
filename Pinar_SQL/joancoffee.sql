-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 01, 2020 at 06:18 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joancoffee`
--

-- --------------------------------------------------------

--
-- Table structure for table `blendtype`
--

DROP TABLE IF EXISTS `blendtype`;
CREATE TABLE IF NOT EXISTS `blendtype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blendtype`
--

INSERT INTO `blendtype` (`Id`, `Name`) VALUES
(1, 'Dark'),
(2, 'Light');

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

DROP TABLE IF EXISTS `checkout`;
CREATE TABLE IF NOT EXISTS `checkout` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(11) NOT NULL,
  `CoffeeTypeId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`Id`, `CustomerId`, `CoffeeTypeId`, `quantity`, `Amount`) VALUES
(1, 1, 1, 2, 40),
(2, 1, 3, 4, 60),
(3, 2, 2, 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `coffeetype`
--

DROP TABLE IF EXISTS `coffeetype`;
CREATE TABLE IF NOT EXISTS `coffeetype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `BlendTypeId` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coffeetype`
--

INSERT INTO `coffeetype` (`Id`, `Name`, `BlendTypeId`, `Price`) VALUES
(1, 'French Roast', 1, 20),
(2, 'Italian Roast', 1, 15),
(3, 'Cinnamon Roast', 2, 20),
(4, 'Italian Roast', 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Address` text NOT NULL,
  `City` varchar(100) NOT NULL,
  `State` varchar(100) NOT NULL,
  `Zip` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Name`, `Email`, `Telephone`, `Address`, `City`, `State`, `Zip`) VALUES
(1, 'John', 'john@gmail.com', 234345456, 'City hall', 'Toronto', 'Ontario', 'M5H 2N1'),
(2, 'Jack', 'jack@gmail.com', 789678567, 'Queen road', 'Toronto', 'Ontatio', 'M5H 2N2');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
