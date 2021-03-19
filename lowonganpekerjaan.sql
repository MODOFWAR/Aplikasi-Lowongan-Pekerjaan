-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2019 at 04:33 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lowonganpekerjaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `berkas`
--

CREATE TABLE `berkas` (
  `ID_Berkas` varchar(60) NOT NULL,
  `Nama` varchar(60) NOT NULL,
  `Jenis` varchar(60) NOT NULL,
  `Tanggal_Masuk` varchar(60) NOT NULL,
  `ID_Perusahaan` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `berkas`
--

INSERT INTO `berkas` (`ID_Berkas`, `Nama`, `Jenis`, `Tanggal_Masuk`, `ID_Perusahaan`) VALUES
('S1', 'SHINTIA', 'Img', '20 MARET 2019', 12),
('U1', 'UTIT', 'Doc', '1 NOVEMBER 2019', 8);

-- --------------------------------------------------------

--
-- Table structure for table `berkasmasuk`
--

CREATE TABLE `berkasmasuk` (
  `Nama` varchar(60) NOT NULL,
  `File_ID` varchar(60) NOT NULL,
  `Company` varchar(60) NOT NULL,
  `Job` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `berkasmasuk`
--

INSERT INTO `berkasmasuk` (`Nama`, `File_ID`, `Company`, `Job`) VALUES
('LOLO', '123', 'Hindia', 'BUYER'),
('SHINTIA', 'S1', 'TELKOM UNIVERSITY', 'DOSEN'),
('UTIT', 'U1', 'GOJEK', 'DRIVER');

-- --------------------------------------------------------

--
-- Table structure for table `lowongan`
--

CREATE TABLE `lowongan` (
  `Company` varchar(60) NOT NULL,
  `Job_Vacancy` varchar(60) NOT NULL,
  `VacancyID` varchar(60) NOT NULL,
  `Deadline` varchar(60) NOT NULL,
  `Work_Hour` int(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lowongan`
--

INSERT INTO `lowongan` (`Company`, `Job_Vacancy`, `VacancyID`, `Deadline`, `Work_Hour`) VALUES
('GOJEK', 'ADMIN', 'AD01', '1 JANUARI 2020', 10),
('GOJEK', 'DRIVER', 'DR01', '1 DESEMBER 2019', 19),
('TELKOM UNIVERSITY', 'REKTOR', 'R1TELU', '1 JANUARI 2020', 10);

-- --------------------------------------------------------

--
-- Table structure for table `pelamar`
--

CREATE TABLE `pelamar` (
  `No_ID` varchar(60) NOT NULL,
  `Nama` varchar(60) NOT NULL,
  `No_HP` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelamar`
--

INSERT INTO `pelamar` (`No_ID`, `Nama`, `No_HP`, `Email`) VALUES
('29', 'SHINTIA', '085210666789', 'Shintia@gmail.com'),
('JB001', 'EDGAR VIG0', '085219370436', 'edgarvigogames@gmail.com'),
('JB002', 'UTIT', '080808', 'utit@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `perusahaan`
--

CREATE TABLE `perusahaan` (
  `ID_Perusahaan` int(30) NOT NULL,
  `Owner` varchar(60) NOT NULL,
  `Perusahaan` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `perusahaan`
--

INSERT INTO `perusahaan` (`ID_Perusahaan`, `Owner`, `Perusahaan`) VALUES
(8, 'NADIM', 'GOJEK'),
(12, 'TELKOM', 'TELKOM UNIVERSITY');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `berkas`
--
ALTER TABLE `berkas`
  ADD PRIMARY KEY (`ID_Berkas`);

--
-- Indexes for table `lowongan`
--
ALTER TABLE `lowongan`
  ADD PRIMARY KEY (`VacancyID`);

--
-- Indexes for table `pelamar`
--
ALTER TABLE `pelamar`
  ADD PRIMARY KEY (`No_ID`);

--
-- Indexes for table `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD PRIMARY KEY (`ID_Perusahaan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `perusahaan`
--
ALTER TABLE `perusahaan`
  MODIFY `ID_Perusahaan` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
