-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2019 at 09:29 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pdam`
--

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `nip` int(5) UNSIGNED ZEROFILL NOT NULL,
  `nama` varchar(45) NOT NULL,
  `jk` enum('Pria','Wanita','','') NOT NULL,
  `tempat_lahir` varchar(45) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` text NOT NULL,
  `level` enum('Kasir','Petugas Lapangan','Costumer Services','Manager') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`nip`, `nama`, `jk`, `tempat_lahir`, `tgl_lahir`, `alamat`, `no_telp`, `username`, `password`, `level`) VALUES
(00001, 'Mahmudah', 'Wanita', 'Medan', '1989-10-04', 'Jl. Mekar', '073248248274', 'kasir', 'de28f8f7998f23ab4194b51a6029416f', 'Kasir'),
(00002, 'Parno', 'Pria', 'Riau', '1985-10-24', 'Jl. Durian', '085363721813', 'ptl', 'be88a121b792ffc8264126f01f3c7143', 'Petugas Lapangan'),
(00003, 'Mumun', 'Wanita', 'Medan', '1992-06-18', 'Jl. Mekar', '085262832723', 'cs', '8551e0027ff3a8de9662eb3b8a16c23e', 'Costumer Services'),
(00006, 'Muhammad Arif Furqon', 'Pria', 'Magetan', '1999-06-15', 'Jl. Prasaja Tengah', '085749129219', 'manager', '0795151defba7a4b5dfa89170de46277', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `no_pel` int(6) UNSIGNED ZEROFILL NOT NULL,
  `nama_pel` varchar(45) NOT NULL,
  `jk` enum('Pria','Wanita','','') NOT NULL,
  `tempat_lahir` varchar(45) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `golongan` enum('Sosial','Rumah Tangga','Industri','') NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `stand_update` double DEFAULT NULL,
  `pembayaran_terakhir` date DEFAULT NULL,
  `update_terakhir` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no_rek` int(7) UNSIGNED ZEROFILL NOT NULL,
  `no_pel` int(6) UNSIGNED ZEROFILL NOT NULL,
  `nama_pel` varchar(45) NOT NULL,
  `golongan` enum('Sosial','Rumah Tangga','Industri','') NOT NULL,
  `alamat` text NOT NULL,
  `stand_awal` double NOT NULL,
  `stand_akhir` double NOT NULL,
  `update_stand` date NOT NULL,
  `pemakaian` double NOT NULL,
  `tagihan` double DEFAULT NULL,
  `b_admin` int(11) DEFAULT NULL,
  `tanggal_pembayaran` date DEFAULT NULL,
  `status_pembayaran` enum('tunggakan','lunas','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`nip`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`no_pel`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`no_rek`),
  ADD KEY `FK_pembayaran` (`no_pel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `nip` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `no_pel` int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `no_rek` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `FK_pembayaran` FOREIGN KEY (`no_pel`) REFERENCES `pelanggan` (`no_pel`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
