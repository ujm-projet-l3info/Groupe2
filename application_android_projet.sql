-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 17 Mars 2016 à 16:56
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `application_android_projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `cle`
--

CREATE TABLE IF NOT EXISTS `cle` (
  `id_cle` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(32) NOT NULL,
  PRIMARY KEY (`id_cle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Contenu de la table `cle`
--

INSERT INTO `cle` (`id_cle`, `libelle`) VALUES
(1, 'amenity'),
(2, 'building'),
(3, 'historic'),
(4, 'leisure'),
(5, 'nature'),
(6, 'shop'),
(7, 'sport'),
(8, 'tourism'),
(9, 'waterway'),
(10, 'name'),
(11, 'addr:street'),
(12, 'addr:housenumber'),
(13, 'addr:city'),
(14, 'addr:postcode'),
(15, 'opening_hours'),
(16, 'website'),
(17, 'addr:country'),
(18, 'information'),
(19, 'wikipedia'),
(20, 'image'),
(21, 'cuisine'),
(22, 'religion'),
(23, 'source'),
(24, 'building:levels'),
(25, 'height');

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

CREATE TABLE IF NOT EXISTS `information` (
  `id` int(11) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
  `id_info` int(11) NOT NULL,
  `id_cle` int(11) NOT NULL,
  `valeur` varchar(100) NOT NULL,
  PRIMARY KEY (`id_info`,`id_cle`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
