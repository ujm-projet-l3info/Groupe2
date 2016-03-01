-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 01 Mars 2016 à 15:58
-- Version du serveur :  5.6.28-0ubuntu0.15.10.1
-- Version de PHP :  5.6.11-1ubuntu3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `application_android_projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `Cle`
--

CREATE TABLE IF NOT EXISTS `Cle` (
  `id_cle` int(11) NOT NULL,
  `libelle` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Information`
--

CREATE TABLE IF NOT EXISTS `Information` (
  `id` int(11) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `cle` int(11) NOT NULL,
  `valeur` varchar(32) NOT NULL,
  `lien_url` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Cle`
--
ALTER TABLE `Cle`
  ADD PRIMARY KEY (`id_cle`);

--
-- Index pour la table `Information`
--
ALTER TABLE `Information`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Information` (`cle`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Cle`
--
ALTER TABLE `Cle`
  MODIFY `id_cle` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Information`
--
ALTER TABLE `Information`
  ADD CONSTRAINT `Information_ibfk_1` FOREIGN KEY (`cle`) REFERENCES `Cle` (`id_cle`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
