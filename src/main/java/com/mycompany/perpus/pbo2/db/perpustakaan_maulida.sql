-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2022 at 07:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan_maulida`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `idjenisbuku` int(11) NOT NULL,
  `namabuku` varchar(200) NOT NULL,
  `biaya` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `idjenisbuku`, `namabuku`, `biaya`) VALUES
(1, 2, 'Buku Matematika', 12000),
(2, 2, 'Buku IPA', 12000),
(3, 6, 'Buku Cerita Rakyat', 5000),
(4, 9, 'Ensiklopedia Umum', 15000),
(7, 5, 'Kamus Besar Bahasa Jepang', 10000),
(8, 5, 'Kamus Besar Bahasa Inggris', 10000),
(9, 5, 'Kamus Besar Bahasa Indonesia', 10000),
(10, 7, 'Majalah Kartini', 8000);

-- --------------------------------------------------------

--
-- Table structure for table `detailpeminjaman`
--

CREATE TABLE `detailpeminjaman` (
  `id` int(11) NOT NULL,
  `idpeminjaman` int(11) NOT NULL,
  `idbuku` int(11) NOT NULL,
  `hargapinjam` double NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detailpeminjaman`
--

INSERT INTO `detailpeminjaman` (`id`, `idpeminjaman`, `idbuku`, `hargapinjam`, `jumlah`) VALUES
(1, 1, 1, 12000, 1),
(2, 2, 4, 15000, 1),
(3, 3, 9, 10000, 1),
(4, 4, 7, 10000, 1),
(5, 5, 3, 10000, 2),
(6, 6, 2, 12000, 1),
(7, 7, 4, 15000, 1),
(8, 8, 7, 10000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `jenisbuku`
--

CREATE TABLE `jenisbuku` (
  `id` int(11) NOT NULL,
  `namajenisbuku` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenisbuku`
--

INSERT INTO `jenisbuku` (`id`, `namajenisbuku`) VALUES
(1, 'Buku Novel'),
(2, 'Buku Pelajaran'),
(3, 'Buku Komik'),
(4, 'Buku Antologi'),
(5, 'Buku Kamus'),
(6, 'Buku Anak'),
(7, 'Majalah'),
(8, 'Buku Nomik'),
(10, 'Buku Cergam');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `idpengguna` int(11) NOT NULL,
  `status` enum('PINJAM','SELESAI') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `tanggal`, `idpengguna`, `status`) VALUES
(1, '2020-12-01', 2, 'PINJAM'),
(2, '2020-12-01', 2, 'SELESAI'),
(3, '2021-01-02', 3, 'PINJAM'),
(4, '2021-01-03', 3, 'SELESAI'),
(5, '2021-02-01', 3, 'SELESAI'),
(6, '2021-02-03', 2, 'PINJAM'),
(7, '2021-03-05', 2, 'SELESAI'),
(8, '2021-03-05', 3, 'PINJAM');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(200) NOT NULL,
  `namalengkap` varchar(200) NOT NULL,
  `isadmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `username`, `password`, `namalengkap`, `isadmin`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Nama Admin', 1),
(2, 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'Nama User', 0),
(3, 'Maulida Riska', '57d04a9803aaf339f2153e87dfaf9f6c', 'Maulida Riska', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detailpeminjaman`
--
ALTER TABLE `detailpeminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jenisbuku`
--
ALTER TABLE `jenisbuku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `detailpeminjaman`
--
ALTER TABLE `detailpeminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `jenisbuku`
--
ALTER TABLE `jenisbuku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
