-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 21 Apr 2017 pada 01.32
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kelayakanmustahiq`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `derajat_fuzzy`
--

CREATE TABLE `derajat_fuzzy` (
  `id_derajat` int(11) NOT NULL,
  `nama_mustahiq` varchar(50) DEFAULT NULL,
  `tanggungan_sedikit` float DEFAULT NULL,
  `tanggungan_banyak` float DEFAULT NULL,
  `tempattinggal_buruk` float DEFAULT NULL,
  `tempattinggal_baik` float DEFAULT NULL,
  `pendapatan_kurang` float DEFAULT NULL,
  `pendapatan_cukup` float DEFAULT NULL,
  `attitude_kurangbaik` float DEFAULT NULL,
  `attitude_baik` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `derajat_fuzzy`
--

INSERT INTO `derajat_fuzzy` (`id_derajat`, `nama_mustahiq`, `tanggungan_sedikit`, `tanggungan_banyak`, `tempattinggal_buruk`, `tempattinggal_baik`, `pendapatan_kurang`, `pendapatan_cukup`, `attitude_kurangbaik`, `attitude_baik`) VALUES
(1, 'Rudi', 0.43, 0.57, 0.66, 0.34, 0.75, 0.25, 0.12, 0.88),
(2, 'Hendra', 1, 0, 0.1, 0.9, 0.3, 0.7, 0.35, 0.65),
(3, 'Ferdy', 0.29, 0.71, 0.8, 0.2, 0.1, 0.9, 0.45, 0.55),
(4, 'Supratman', 0.57, 0.43, 0.87, 0.13, 0.5, 0.5, 0.24, 0.76),
(5, 'Gugun', 0.71, 0.29, 0.78, 0.22, 0.6, 0.4, 0.17, 0.83),
(7, 'Hidayat', 0.86, 0.14, 0.57, 0.43, 0.48, 0.52, 0.21, 0.79),
(8, 'Ghofar', 1, 0, 0.57, 0.43, 0.17, 0.82, 0.01, 0.99),
(9, 'Ade', 0.14, 0.86, 0.31, 0.69, 0.9, 0.1, 0.15, 0.85),
(10, 'Fajri', 0.57, 0.43, 0.74, 0.26, 0.09, 0.91, 0.24, 0.76),
(11, 'Zaki', 0.71, 0.29, 0.33, 0.67, 0.3, 0.7, 0.85, 0.15),
(12, 'Irhas', 0.43, 0.57, 0.22, 0.78, 0.2, 0.8, 0.33, 0.67),
(13, 'Yanto', 0.86, 0.14, 0.73, 0.27, 1, 0, 0.25, 0.75),
(14, 'Sutisna', 1, 0, 0.76, 0.24, 0.66, 0.34, 0.26, 0.74),
(15, 'Wahyono', 0.71, 0.29, 0.56, 0.44, 0, 1, 0.19, 0.81),
(16, 'Ponaryo', 0.86, 0.14, 0.36, 0.64, 0.77, 0.23, 0.24, 0.76),
(17, 'Cecep', 1, 0, 0.22, 0.78, 0.23, 0.77, 0.34, 0.66),
(18, 'Kosim', 0.71, 0.29, 0.12, 0.88, 0, 1, 0.12, 0.88),
(19, 'Okim', 0.57, 0.43, 0.77, 0.23, 0.7, 0.3, 0.5, 0.5),
(20, 'Jaka', 0.86, 0.14, 0.02, 0.98, 0, 1, 0.24, 0.76),
(21, 'Budiman', 1, 0, 0.4, 0.6, 0.3, 0.7, 0.45, 0.55),
(22, 'Dedi', 0.71, 0.29, 0.66, 0.34, 0.31, 0.69, 0.33, 0.67),
(23, 'Sakir', 0.86, 0.14, 0.23, 0.77, 1, 0, 0.67, 0.33),
(24, 'Gono', 0.14, 0.86, 0.45, 0.55, 0.06, 0.94, 0.55, 0.45),
(25, 'Soleh', 0.43, 0.57, 0.85, 0.15, 0.2, 0.8, 0.12, 0.88),
(26, 'Bintang', 0, 1, 0.39, 0.61, 0, 1, 0.24, 0.76),
(27, 'Hari', 1, 0, 0.28, 0.72, 0.89, 0.11, 0.4, 0.6),
(28, 'Eko', 0.57, 0.43, 0.45, 0.55, 0.99, 0.01, 0.18, 0.82),
(29, 'Jono', 0.86, 0.14, 0.11, 0.89, 0.2, 0.8, 0.55, 0.45),
(30, 'Bahrun', 0.29, 0.71, 0.64, 0.36, 0.58, 0.42, 0.13, 0.87),
(31, 'Rendri', 0, 1, 0.47, 0.53, 0.1, 0.9, 0.25, 0.75);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mustahiq`
--

CREATE TABLE `mustahiq` (
  `id_mustahiq` int(11) NOT NULL,
  `nama_mustahiq` varchar(50) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jumlah_pendapatan` int(11) DEFAULT NULL,
  `jumlah_tanggungan` int(11) DEFAULT NULL,
  `kualitas_tempattinggal` int(11) DEFAULT NULL,
  `attitude` int(11) DEFAULT NULL,
  `kelayakan` float DEFAULT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mustahiq`
--

INSERT INTO `mustahiq` (`id_mustahiq`, `nama_mustahiq`, `alamat`, `jumlah_pendapatan`, `jumlah_tanggungan`, `kualitas_tempattinggal`, `attitude`, `kelayakan`, `status`) VALUES
(1, 'Rudi', '', 750000, 7, 34, 88, 70.15, 'Layak'),
(2, 'Hendra', '', 1200000, 3, 90, 65, 57.75, 'Tidak Layak'),
(3, 'Ferdy', '', 1400000, 8, 20, 55, 66.25, 'Layak'),
(4, 'Supratman', '', 1000000, 6, 13, 76, 66.44, 'Layak'),
(5, 'Gugun', '', 900000, 5, 22, 83, 70.82, 'Layak'),
(7, 'Hidayat', '', 1020000, 4, 43, 79, 65.35, 'Layak'),
(8, 'Ghofar', '', 1325000, 2, 43, 99, 50.71, 'Tidak Layak'),
(9, 'Ade', '', 600000, 9, 69, 85, 62.62, 'Layak'),
(10, 'Fajri', '', 1410000, 6, 26, 76, 66.01, 'Layak'),
(11, 'Zaki', '', 1200000, 5, 67, 15, 63.03, 'Layak'),
(12, 'Irhas', '', 1300000, 7, 78, 67, 64.22, 'Layak'),
(13, 'Yanto', '', 450000, 4, 27, 75, 72.13, 'Layak'),
(14, 'Sutisna', '', 840000, 3, 24, 74, 71.55, 'Layak'),
(15, 'Wahyono', '', 1523000, 5, 44, 81, 64.97, 'Layak'),
(16, 'Ponaryo', '', 730000, 4, 64, 76, 65.22, 'Layak'),
(17, 'Cecep', '', 1270000, 2, 78, 66, 58.38, 'Tidak Layak'),
(18, 'Kosim', '', 1500000, 5, 88, 88, 60.78, 'Layak'),
(19, 'Okim', '', 800000, 6, 23, 50, 65.04, 'Layak'),
(20, 'Jaka', '', 1550000, 4, 98, 76, 50.29, 'Tidak Layak'),
(21, 'Budiman', '', 1200000, 2, 60, 55, 56.5, 'Tidak Layak'),
(22, 'Dedi', '', 1190000, 5, 34, 67, 60.43, 'Layak'),
(23, 'Sakir', '', 500000, 4, 77, 33, 52.13, 'Tidak Layak'),
(24, 'Gono', '', 1435000, 9, 55, 45, 61.81, 'Layak'),
(25, 'Soleh', '', 1300000, 7, 15, 88, 65.03, 'Layak'),
(26, 'Bintang', '', 1500000, 10, 61, 76, 56.8, 'Tidak Layak'),
(27, 'Hari', '', 610000, 3, 72, 60, 57.28, 'Tidak Layak'),
(28, 'Eko', '', 510000, 6, 55, 82, 58.26, 'Tidak Layak'),
(29, 'Jono', '', 1300000, 4, 89, 45, 67.19, 'Layak'),
(30, 'Bahrun', '', 921000, 8, 36, 87, 67.54, 'Layak'),
(31, 'Rendri', '', 1396000, 10, 53, 75, 60.69, 'Layak');

-- --------------------------------------------------------

--
-- Struktur dari tabel `variabel_fuzzy`
--

CREATE TABLE `variabel_fuzzy` (
  `id_variabel` int(11) NOT NULL,
  `nama_variabel` varchar(30) DEFAULT NULL,
  `domain_min` int(11) DEFAULT NULL,
  `domain_max` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `variabel_fuzzy`
--

INSERT INTO `variabel_fuzzy` (`id_variabel`, `nama_variabel`, `domain_min`, `domain_max`) VALUES
(1, 'Tanggungan', 3, 10),
(2, 'Tempat Tinggal', 0, 100),
(3, 'Pendapatan', 500000, 1500000),
(4, 'Attitude', 0, 100),
(5, 'Kelayakan', 0, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `derajat_fuzzy`
--
ALTER TABLE `derajat_fuzzy`
  ADD PRIMARY KEY (`id_derajat`);

--
-- Indexes for table `mustahiq`
--
ALTER TABLE `mustahiq`
  ADD PRIMARY KEY (`id_mustahiq`);

--
-- Indexes for table `variabel_fuzzy`
--
ALTER TABLE `variabel_fuzzy`
  ADD PRIMARY KEY (`id_variabel`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
