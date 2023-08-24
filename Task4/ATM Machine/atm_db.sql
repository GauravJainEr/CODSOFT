-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Aug 24, 2023 at 10:29 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminpannel`
--

CREATE TABLE `adminpannel` (
  `AccNo` int(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Father_name` varchar(50) NOT NULL,
  `Mobile_No` int(50) NOT NULL,
  `DOB` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Occupation` varchar(50) NOT NULL,
  `Acc_type` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Pin_no` int(20) NOT NULL,
  `balance` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminpannel`
--

INSERT INTO `adminpannel` (`AccNo`, `Name`, `Father_name`, `Mobile_No`, `DOB`, `Address`, `Occupation`, `Acc_type`, `Gender`, `Pin_no`, `balance`) VALUES
(1212, 'zz', 'aa', 888888, 'Tue Aug 01 00:00:00 IST 2023', 'hh', 'kk', 'Saving', 'Male', 123, 700),
(12345, 'Gaurav Jain', 'zzzz', 99999999, 'Wed Aug 09 00:00:00 IST 2023', 'hathras', 'student', 'Current', 'Male', 245, 200),
(77777, 'kk', 'mm', 88877, 'Sat Aug 05 16:00:22 IST 2023', 'lucknow', 'nn', 'Saving', 'Male', 8998, 1000),
(99990078, 'rishi', 'ryhyrxyzz', 54477784, 'Sun Aug 13 14:09:45 IST 2023', 'thgfhfdhfh', 'businessman', 'Saving', 'Male', 5555, 100),
(999991234, 'null', 'null', 0, 'null', 'null', 'null', 'null', 'null', 8877990, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminpannel`
--
ALTER TABLE `adminpannel`
  ADD PRIMARY KEY (`AccNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
