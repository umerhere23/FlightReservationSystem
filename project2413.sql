-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2022 at 06:50 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project2413`
--

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `flightNumber` varchar(25) NOT NULL DEFAULT '',
  `flightDate` date DEFAULT NULL,
  `origin` varchar(25) NOT NULL DEFAULT '',
  `destination` varchar(25) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`flightNumber`, `flightDate`, `origin`, `destination`) VALUES
('AR2301', '2022-08-18', 'Vancouver', 'Los Angeles'),
('BH7683', '2022-09-21', 'Edmonton', 'Montreal'),
('CA0394', '2022-10-03', 'Vancouver', 'Miami'),
('GE4345', '2022-08-25', 'Toronto', 'Phoenix'),
('YG3127', '2022-09-01', 'Vancouver', 'Toronto');

-- --------------------------------------------------------

--
-- Table structure for table `fromflights`
--

CREATE TABLE `fromflights` (
  `FromID` varchar(25) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fromflights`
--

INSERT INTO `fromflights` (`FromID`) VALUES
('Calgary'),
('Seattle'),
('Vancouver');

-- --------------------------------------------------------

--
-- Table structure for table `systemuser`
--

CREATE TABLE `systemuser` (
  `userID` varchar(12) NOT NULL DEFAULT '',
  `pw` varchar(12) NOT NULL DEFAULT '',
  `fname` varchar(12) NOT NULL DEFAULT '',
  `lname` varchar(12) NOT NULL DEFAULT '',
  `phone` char(12) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticketID` varchar(25) NOT NULL DEFAULT '',
  `flightNumber` varchar(25) NOT NULL DEFAULT '',
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flightNumber`);

--
-- Indexes for table `fromflights`
--
ALTER TABLE `fromflights`
  ADD PRIMARY KEY (`FromID`);

--
-- Indexes for table `systemuser`
--
ALTER TABLE `systemuser`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticketID`),
  ADD KEY `flightNumber` (`flightNumber`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`flightNumber`) REFERENCES `flight` (`flightNumber`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
