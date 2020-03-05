-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 24, 2020 at 03:29 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id7502305_mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `blendtype`
--

CREATE TABLE `blendtype` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

CREATE TABLE `checkout` (
  `Id` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `CoffeeTypeId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`Id`, `CustomerId`, `CoffeeTypeId`, `quantity`, `Amount`) VALUES
(1, 1, 1, 2, 40),
(2, 1, 3, 4, 60),
(3, 2, 2, 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `City`
--

CREATE TABLE `City` (
  `id` int(11) NOT NULL,
  `City` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `City`
--

INSERT INTO `City` (`id`, `City`) VALUES
(1, 'Toronto'),
(2, 'Vancouver'),
(3, 'London'),
(4, 'Hamilton');

-- --------------------------------------------------------

--
-- Table structure for table `coffeetype`
--

CREATE TABLE `coffeetype` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `BlendTypeId` int(11) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

CREATE TABLE `customer` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Address` text NOT NULL,
  `City` int(11) NOT NULL,
  `State` int(11) NOT NULL,
  `Zip` varchar(7) NOT NULL,
  `Wrong_login_Attempt` int(11) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `TimeStamp` timestamp NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Name`, `Email`, `Telephone`, `Address`, `City`, `State`, `Zip`, `Wrong_login_Attempt`, `Password`, `TimeStamp`) VALUES
(1, 'John', 'john@gmail.com', 234345456, 'City hall', 1, 1, 'M5H 2N1', 1, 'ejkfnkwen449023', '2020-02-08 04:04:21'),
(2, 'Jack', 'jack@gmail.com', 789678567, 'Queen road', 1, 1, 'M5H 2N2', 1, 'fndskjnc56468', '2020-02-08 04:04:21'),
(3, 'Pinar Ovali', 'pinar.ovali@gmail.com', 1234567890, '123 street', 1, 2, '00000', 1, 'pinar123', '2020-02-24 01:16:00'),
(4, 'Sara', 'Sara123@gmail.com', 987654321, '123 street', 2, 1, '000000', 2, 'sara123', '2020-02-24 01:16:00'),
(5, 'Maggie', 'maggi123@gmail.com', 1234567890, '2 streets', 3, 1, '111111', 2, 'maggi123', '2020-02-24 01:17:52'),
(6, 'kim', 'kim123@gmail.com', 1234567890, '2 streets', 2, 1, '777777', 1, 'kim123', '2020-02-24 01:17:52'),
(7, 'Taylor', 'Taylor123@gmail.com', 1234567890, '4 streets', 3, 1, 'k22222', 2, 'taylor123', '2020-02-24 01:19:26'),
(8, 'katy ', 'katy123@gmail.com', 1234567890, '5 street ', 1, 1, 'm0p p9o', 3, 'katy123', '2020-02-24 01:19:26'),
(9, 'Chester', 'chester123@gmail.com', 1234567890, '6 street', 2, 1, 'm9i 8i9', 4, 'chester123', '2020-02-24 01:21:15');

-- --------------------------------------------------------

--
-- Table structure for table `Sales`
--

CREATE TABLE `Sales` (
  `id` int(11) NOT NULL,
  `OrderDate` date NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `CoffeeID` int(11) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `Tracking#` varchar(45) NOT NULL,
  `Employee#` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Sales`
--

INSERT INTO `Sales` (`id`, `OrderDate`, `CustomerID`, `CoffeeID`, `Description`, `Tracking#`, `Employee#`, `Quantity`, `Total`) VALUES
(1, '2015-04-13', 1, 1, 'desc', '1234', 1, 2, 40);

-- --------------------------------------------------------

--
-- Table structure for table `States`
--

CREATE TABLE `States` (
  `Id` int(11) NOT NULL,
  `State` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `States`
--

INSERT INTO `States` (`Id`, `State`) VALUES
(1, 'ON'),
(2, 'BC'),
(3, 'AL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blendtype`
--
ALTER TABLE `blendtype`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `City`
--
ALTER TABLE `City`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coffeetype`
--
ALTER TABLE `coffeetype`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `Sales`
--
ALTER TABLE `Sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `States`
--
ALTER TABLE `States`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blendtype`
--
ALTER TABLE `blendtype`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `coffeetype`
--
ALTER TABLE `coffeetype`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `Sales`
--
ALTER TABLE `Sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
