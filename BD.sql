-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 27 déc. 2021 à 21:51
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `codev`
--

-- --------------------------------------------------------
--
-- Structure de la table `car`
--

CREATE TABLE `car` (
  `id` int(4) NOT NULL,
  `modele` varchar(40) DEFAULT NULL,
  `marque` varchar(40) DEFAULT NULL,
  `carburant` varchar(20) DEFAULT NULL,
  `annee` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `car`
--

INSERT INTO `car` (`id`, `modele`, `marque`, `carburant`, `annee`) VALUES
(1, 'Audi A6', 'Audi', 'Essence', 2017),
(2, 'Scénic', 'Citroen', 'Diesel', 2012);

-- --------------------------------------------------------

--
-- Structure de la table `place`
--

CREATE TABLE `place` (
  `id` int(4) NOT NULL,
  `address` varchar(100) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `place`
--

INSERT INTO `place` (`id`, `address`, `latitude`, `longitude`) VALUES
(1, 'Le Puy', 45.0429, 3.88462),
(2, 'Lyon', 45.7792, 4.86834);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(4) NOT NULL,
  `name` varchar(40) NOT NULL,
  `firstname` varchar(40) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `role` varchar(5) NOT NULL,
  `code` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `name`, `firstname`, `username`, `password`, `role`, `code`) VALUES
(1, 'bresson', 'aurelien', 'aure', 'password', 'admin', uuid()),
(2, 'mang', 'quentin', 'quentin', 'password', 'user', uuid()),
(3, 'vandervalle', 'basile', 'basile', 'password', 'user', uuid());

-- --------------------------------------------------------

--
-- Structure de la table `user_car`
--

CREATE TABLE `user_car` (
  `user_id` int(4) NOT NULL,
  `car_id` int(4) NOT NULL,
  `favorite` varchar(3) NOT NULL,
  `date_research` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_car`
--

INSERT INTO `user_car` (`user_id`, `car_id`, `favorite`, `date_research`) VALUES
(1, 1, 'yes', now()),
(2, 2, 'no', now()),
(3, 2, 'yes', now()),
(1, 2, 'no', now()),
(2, 1, 'yes', now()),
(3, 1, 'no', now());

-- --------------------------------------------------------

--
-- Structure de la table `user_place`
--

CREATE TABLE `user_place` (
  `user_id` int(4) NOT NULL,
  `place_id` int(4) NOT NULL,
  `favorite` varchar(3) NOT NULL,
  `date_research` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_place`
--

INSERT INTO `user_place` (`user_id`, `place_id`, `favorite`, `date_research`) VALUES
(1, 1, 'yes', now()),
(2, 2, 'no', now()),
(3, 2, 'yes', now()),
(1, 2, 'no', now()),
(2, 1, 'yes', now()),
(3, 1, 'no', now());

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `car`
--
ALTER TABLE `car`
  ADD KEY `id` (`id`);

--
-- Index pour la table `place`
--
ALTER TABLE `place`
  ADD KEY `id` (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `user_car`
--
ALTER TABLE `user_car`
  ADD KEY `user_car_ibfk_1` (`user_id`),
  ADD KEY `user_car_ibfk_2` (`car_id`);

--
-- Index pour la table `user_place`
--
ALTER TABLE `user_place`
  ADD KEY `user_place_ibfk_1` (`place_id`),
  ADD KEY `user_place_ibfk_2` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `car`
--
ALTER TABLE `car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `place`
--
ALTER TABLE `place`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `user_car`
--
ALTER TABLE `user_car`
  ADD CONSTRAINT `user_car_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_car_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `user_place`
--
ALTER TABLE `user_place`
  ADD CONSTRAINT `user_place_ibfk_1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_place_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
