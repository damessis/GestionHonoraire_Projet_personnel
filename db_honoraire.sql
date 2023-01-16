-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 16 jan. 2023 à 20:19
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_honoraire`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `dbUsernameAdmin` varchar(50) NOT NULL,
  `dbPasswordAdmin` varchar(25) NOT NULL,
  PRIMARY KEY (`idAdmin`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idAdmin`, `dbUsernameAdmin`, `dbPasswordAdmin`) VALUES
(1, 'admin1', '1111');

-- --------------------------------------------------------

--
-- Structure de la table `anneeacademique`
--

DROP TABLE IF EXISTS `anneeacademique`;
CREATE TABLE IF NOT EXISTS `anneeacademique` (
  `idAnnee` int(11) NOT NULL AUTO_INCREMENT,
  `NomAnnee` varchar(25) NOT NULL,
  PRIMARY KEY (`idAnnee`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptable`
--

DROP TABLE IF EXISTS `comptable`;
CREATE TABLE IF NOT EXISTS `comptable` (
  `idComptable` int(11) NOT NULL AUTO_INCREMENT,
  `dbUsername` varchar(50) NOT NULL,
  `dbPassword` varchar(50) NOT NULL,
  PRIMARY KEY (`idComptable`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptable`
--

INSERT INTO `comptable` (`idComptable`, `dbUsername`, `dbPassword`) VALUES
(1, 'compt1', '2222');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `idEnseignant` int(11) NOT NULL AUTO_INCREMENT,
  `NomEnseignant` varchar(50) NOT NULL,
  `PrenomE` varchar(50) NOT NULL,
  `Tel` varchar(50) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  PRIMARY KEY (`idEnseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseigner`
--

DROP TABLE IF EXISTS `enseigner`;
CREATE TABLE IF NOT EXISTS `enseigner` (
  `idEnseignant` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `idSemestre` int(11) NOT NULL,
  `HeureEcouler` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `idFiliere` int(11) NOT NULL AUTO_INCREMENT,
  `NomFiliere` varchar(50) NOT NULL,
  `SigleFiliere` int(25) NOT NULL,
  PRIMARY KEY (`idFiliere`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `idMatiere` int(11) NOT NULL AUTO_INCREMENT,
  `nomMatiere` varchar(50) NOT NULL,
  `heureInit` varchar(25) NOT NULL,
  PRIMARY KEY (`idMatiere`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

DROP TABLE IF EXISTS `parcours`;
CREATE TABLE IF NOT EXISTS `parcours` (
  `idParcours` int(11) NOT NULL AUTO_INCREMENT,
  `nomParcours` varchar(50) NOT NULL,
  `cout` double NOT NULL,
  PRIMARY KEY (`idParcours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `secretaire`
--

DROP TABLE IF EXISTS `secretaire`;
CREATE TABLE IF NOT EXISTS `secretaire` (
  `idSecre` int(11) NOT NULL AUTO_INCREMENT,
  `dbSecreUsername` varchar(50) NOT NULL,
  `dbSecrePassword` int(50) NOT NULL,
  PRIMARY KEY (`idSecre`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `secretaire`
--

INSERT INTO `secretaire` (`idSecre`, `dbSecreUsername`, `dbSecrePassword`) VALUES
(1, 'secre1', 3333);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `dbUsersName` varchar(50) NOT NULL,
  `idUsers` int(11) NOT NULL AUTO_INCREMENT,
  `dbUsersPassw` varchar(50) NOT NULL,
  PRIMARY KEY (`idUsers`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`dbUsersName`, `idUsers`, `dbUsersPassw`) VALUES
('test', 1, '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
