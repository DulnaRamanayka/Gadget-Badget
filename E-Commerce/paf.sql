-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 04:58 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `Buyer ID` int(11) NOT NULL,
  `Buyer Code` varchar(10) CHARACTER SET latin1 NOT NULL,
  `Buyer Name` varchar(30) CHARACTER SET latin1 NOT NULL,
  `Buyer Email` varchar(25) CHARACTER SET latin1 NOT NULL,
  `Buyer Contact Number` int(15) NOT NULL,
  `Buyer Address` varchar(40) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`Buyer ID`, `Buyer Code`, `Buyer Name`, `Buyer Email`, `Buyer Contact Number`, `Buyer Address`) VALUES
(5, 'C123', 'Chathura', 'chathura12@gmail.com', 713466734, 'court road,Kandy'),
(9, 'A123', 'Nihal', 'nihal123@gmail.com', 774528780, 'Galle Road,Colombo'),
(12, 'N101', 'Ama Fernando', 'ama98@gmail.com', 776207076, '1/56 B,Panagoda,Homagama');

-- --------------------------------------------------------

--
-- Table structure for table `fund_tt`
--

CREATE TABLE `fund_tt` (
  `fundID` int(11) NOT NULL,
  `fundTotalAmount` varchar(10) NOT NULL,
  `fundPrecentage` varchar(5) NOT NULL,
  `fundTime` varchar(5) NOT NULL,
  `fundDate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fund_tt`
--

INSERT INTO `fund_tt` (`fundID`, `fundTotalAmount`, `fundPrecentage`, `fundTime`, `fundDate`) VALUES
(2, '500$', '35%', '11.30', '21/04/24');

-- --------------------------------------------------------

--
-- Table structure for table `paydb`
--

CREATE TABLE `paydb` (
  `paymentID` int(10) NOT NULL,
  `amount` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `accountNo` int(10) NOT NULL,
  `paymentType` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paydb`
--

INSERT INTO `paydb` (`paymentID`, `amount`, `date`, `accountNo`, `paymentType`) VALUES
(969, '50000', '2021/2/25', 9862, 'credit'),
(254, '8000', '2021/4/13', 45896, 'cash'),
(5893, '4500', '2021/3/16', 5362, 'credit'),
(692, '12500', '2021/4/24', 25, 'cash'),
(0, '522', '2021/2/6', 541, 'cash');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `productCode` varchar(10) NOT NULL,
  `productName` varchar(30) NOT NULL,
  `productPrice` double NOT NULL,
  `productDesc` varchar(200) NOT NULL,
  `productRes` varchar(30) NOT NULL,
  `productType` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productCode`, `productName`, `productPrice`, `productDesc`, `productRes`, `productType`) VALUES
(2, 'MAD1010', 'Mobile Application', 35000, 'Mysql light and html', 'Madusha Ramanayaka', 'Incomplete'),
(3, 'Se1010', 'desktop application', 30000, 'C#.net', 'Binuka Paranagama', 'complete'),
(6, 'WB1020', 'web services', 65000, 'Python.Java. Ruby/Ruby', 'Ramanayaka D.Y', 'complete');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `reseacherID` int(10) NOT NULL,
  `researcherCode` varchar(30) NOT NULL,
  `researcherName` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `contactNo` int(10) NOT NULL,
  `projectCategory` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`reseacherID`, `researcherCode`, `researcherName`, `Email`, `contactNo`, `projectCategory`) VALUES
(3, 'rid0020', 'Mr.Amal Perera', 'perera98@gmail.com', 412256469, 'Gems and Jewelry'),
(5, 'rid5693', 'Mr.Sithum Nimantha', 'sithum@gmail.com', 775672342, 'Video Editing'),
(7, 'rid5406', 'Mr.Uthpala Samarakon', 'uthpalaS@gmail.com', 412250005, 'Robo Technology'),
(8, 'rid5368', 'Mr. Kalum Devanarayana', 'kalum28@gmail.com', 716782456, 'Electrical Products'),
(10, 'rid5522', 'Mr.Nadini Premadasa', 'nadiniP@gmail.com', 772117896, 'Hospital Management');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`Buyer ID`);

--
-- Indexes for table `fund_tt`
--
ALTER TABLE `fund_tt`
  ADD PRIMARY KEY (`fundID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`reseacherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
  MODIFY `Buyer ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `fund_tt`
--
ALTER TABLE `fund_tt`
  MODIFY `fundID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `reseacherID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
