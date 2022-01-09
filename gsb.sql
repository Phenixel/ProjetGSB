-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 09 jan. 2022 à 22:52
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gsb`
--

-- --------------------------------------------------------

--
-- Structure de la table `dosage`
--

CREATE TABLE `dosage` (
  `DOS_CODE` int(11) NOT NULL,
  `DOS_QUANTITE` varchar(255) DEFAULT NULL,
  `DOS_UNITE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dosage`
--

INSERT INTO `dosage` (`DOS_CODE`, `DOS_QUANTITE`, `DOS_UNITE`) VALUES
(1, '2 Pillules', '3 fois par jours'),
(2, '2 pillules', '2 fois par jours'),
(3, '1 comprimé', '3 fois par jours'),
(4, '1 cuillère à café', '2 fois par jours'),
(5, '10 cl', '1 fois par jour'),
(6, '1 sachet', 'autant que nécessaire'),
(7, '1 ampoule', '2 fois par jours'),
(8, '1 seringue', 'autant que nécessaire');

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `FAM_CODE` int(11) NOT NULL,
  `FAM_LIBELLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`FAM_CODE`, `FAM_LIBELLE`) VALUES
(1, 'antalgique'),
(2, 'analgésique'),
(3, 'antidépresseur'),
(4, 'anxiolytiques'),
(5, 'antibiotique');

-- --------------------------------------------------------

--
-- Structure de la table `interagis`
--

CREATE TABLE `interagis` (
  `MED_PERTURBATEUR` int(11) NOT NULL,
  `MED_MED_PERTURBE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `interagis`
--

INSERT INTO `interagis` (`MED_PERTURBATEUR`, `MED_MED_PERTURBE`) VALUES
(1, 2),
(3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `MED_DEPOTLEGAL` int(11) NOT NULL,
  `MED_NOMCOMMERCIAL` varchar(255) DEFAULT NULL,
  `FAM_CODE` int(11) NOT NULL,
  `MED_COMPOSITION` varchar(255) DEFAULT NULL,
  `MED_EFFETS` varchar(255) DEFAULT NULL,
  `MED_CONTREINDIC` varchar(255) DEFAULT NULL,
  `MED_PRIXECHANTILLON` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `FAM_CODE`, `MED_COMPOSITION`, `MED_EFFETS`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`) VALUES
(1, 'DOLIPRANE 100 mg - Sachet dose', 1, 'Pour un sachet-dose de 540 mg > paracétamol 100 mg', 'Soulage la douleur et/ou la fièvre, d\'état grippal, de douleurs dentaires, de courbatures, de règles douloureuses.', 'maladie grave du foie, intolérence au gluten', 2.18),
(2, 'LYSOPAÏNE AMBROXOL 17,86 mg/ml', 1, 'Chlorhydrate d\'ambroxol - 2,5 mg/p pulv', 'Soulagement des maux de gorge aigus chez les adultes et enfants de plus de 12 ans.', 'Patients présentant une intolérance au fructose', 6.9),
(3, 'CLARADOL CODEINE 500 mg/20 mg, comprimé', 2, 'Pour un comprimé : paracétamol 500 mg, phosphate de codéine anhydre 20 mg, sous forme de : phosphate de codéine hémihydraté 20,5 mg', 'Soulage la douleur, lorsque celle-ci n\'est pas déjà soulagée par d\'autres antalgiques utilisés seuls.', 'maladie grave du foie, asthme et insuffisance respiratoire, personne connue comme étant métaboliseur ultrarapide, enfant de moins de 15 ans, allaitement', 1.72),
(4, 'PAROXETINE BIOGARAN 20 mg - Comprimé pelliculé sécable', 3, 'Comprimé : paroxétine base 20,00 mg, sous forme de : chlorhydrate de paroxétine hémihydraté', 'Traitement des états dépressifs, des troubles obsessionnels compulsifs, des attaques de panique, de certaines manifestations de l\'anxiété', 'Ne doit pas être utilisé en association avec les IMAO ou les médicaments contenant du pimozide', 2.3),
(5, 'PROZAC 20 mg, comprimé dispersible sécable', 3, 'Pour un comprimé : fluoxétine base 20 mg, sous forme de : chlorhydrate de fluoxétine', 'Traitement : des états dépressifs, des troubles obsessionnels compulsifs, de la boulimie, Il est également utilisé, en association avec une psychothérapie, dans le traitement des états dépressifs chez l\'enfant de plus de 8 ans en cas de réponse insuffisan', 'Antécédent d\'allergie à la fluoxétine, en association avec les IMAO non sélectifs et les médicaments contenant du métoprolol utilisés dans l\'insuffisance cardiaque', 8.39),
(6, 'SERESTA 10 mg cp', 4, 'Oxazépam 10 mg/p cp', 'Traitement symptomatique des manifestations anxieuses sévères et/ou invalidantes. ; Prévention et traitement du delirium tremens et des autres manifestations du sevrage alcoolique.', 'Insuffisance hépatique grave, insuffisance respiratoire grave, syndrome d\'apnée du sommeil,myasthénie.', 1.25),
(7, 'XANAX 1 mg - Comprimé sécable', 4, 'Pour un comprimé : alprazolam 1 mg', 'Il est utilisé dans le traitement de l\'anxiété lorsque celle-ci s\'accompagne de troubles gênants (anxiété généralisée, crise d\'angoisse...) et dans le cadre d\'un sevrage alcoolique.', 'Insuffisance hépatique grave, insuffisance respiratoire grave, syndrome d\'apnée du sommeil, myasthénie, mineur.', 2.25),
(8, 'FUCIDINE', 5, 'Pour un comprimé > sodium (fusidate de) 250 mg', 'Fucidine est indiqué dans le traitement des infections staphylococciques notamment dans leurs localisations cutanées, osseuses et articulaires.', 'Insuffisance hépatique, en association avec les médicaments de la famille des statines.', 6.92),
(9, 'PENICILLINE G PANPHARMA 5 MUI', 5, 'Pour un flacon : benzylpénicilline sodique 5 MUI', 'Traitement des infection respiratoire, Infection ORL, Infection stomatologique, Infection cutanée, Infection rénale, Infection urogénitale, Infection gynécologique, Infection digestive, Infection biliaire, Infection méningée, Infection septicémique, Endoc', 'Hypersensibilité à la substance active, aux antibiotiques du groupe des bêta-lactamines (pénicillines, céphalosporines) ou à l\'un des excipients', 24.77),
(10, 'PYOSTACINE', 5, 'Pour un comprimé > pristinamycine 250 mg', 'Exacerbations aiguës de bronchites chroniques ; pneumonies communautaires de gravité légère à modérée; infections de la peau et des tissus mous.', 'Allergie aux synergistines (pristinamycine, virginiamycine) ; antécédent d\'éruption cutanée liée à la prise de pristinamycine ; en association avec les médicaments contenant de la colchicine ; allaitement.', 9.56);

-- --------------------------------------------------------

--
-- Structure de la table `prescrire`
--

CREATE TABLE `prescrire` (
  `MED_DEPOTLEGAL` int(11) NOT NULL,
  `TIN_CODE` int(11) NOT NULL,
  `DOS_CODE` int(11) NOT NULL,
  `PRE_POSOLOGIE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prescrire`
--

INSERT INTO `prescrire` (`MED_DEPOTLEGAL`, `TIN_CODE`, `DOS_CODE`, `PRE_POSOLOGIE`) VALUES
(1, 3, 2, '1 ou 2 comprimés par prise, à renouveler si nécessaire toutes les 6 heures, sans dépasser 6 comprimés par jour.'),
(2, 1, 3, '1 comprimés par prise, à renouveler si nécessaire toutes les 12 heures, sans dépasser 2 comprimés par jour'),
(2, 3, 2, 'Une cuillére avant chaque repas.'),
(3, 1, 3, '2 ou 3 comprimés par prise, à renouveler si nécessaire toutes les 3 Jours.'),
(4, 2, 1, 'Un sachet le matin et un le soir.'),
(4, 4, 2, '1 comprimé par prise, à renouveler si nécessaire toutes les 6 heures, sans dépasser 3 comprimés par jour'),
(5, 2, 1, '1 à 3 comprimés par prise, à renouveler si nécessaire toutes les 5 heures, sans dépasser 7 comprimés par jour'),
(8, 5, 2, '3 pillles tous les matins.'),
(9, 3, 4, 'Un comprimé tous les midis.'),
(10, 2, 3, 'Un verre doseur tous les soirs.');

-- --------------------------------------------------------

--
-- Structure de la table `type_individu`
--

CREATE TABLE `type_individu` (
  `TIN_CODE` int(11) NOT NULL,
  `TIN_LIBELLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_individu`
--

INSERT INTO `type_individu` (`TIN_CODE`, `TIN_LIBELLE`) VALUES
(1, 'Femme enceinte'),
(2, 'Adulte'),
(3, 'Enfant'),
(4, 'Adolecent'),
(5, 'Comorbidité');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUser` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUser`, `login`, `mdp`) VALUES
(1, 'admin', 'admin'),
(2, 'user', 'user');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `dosage`
--
ALTER TABLE `dosage`
  ADD PRIMARY KEY (`DOS_CODE`);

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`FAM_CODE`);

--
-- Index pour la table `interagis`
--
ALTER TABLE `interagis`
  ADD PRIMARY KEY (`MED_PERTURBATEUR`,`MED_MED_PERTURBE`),
  ADD KEY `MED_MED_PERTURBE` (`MED_MED_PERTURBE`),
  ADD KEY `MED_PERTURBATEUR` (`MED_PERTURBATEUR`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`MED_DEPOTLEGAL`),
  ADD KEY `FAM_CODE` (`FAM_CODE`);

--
-- Index pour la table `prescrire`
--
ALTER TABLE `prescrire`
  ADD PRIMARY KEY (`MED_DEPOTLEGAL`,`TIN_CODE`,`DOS_CODE`),
  ADD KEY `TIN_CODE` (`TIN_CODE`),
  ADD KEY `DOS_CODE` (`DOS_CODE`),
  ADD KEY `MED_DEPOTLEGAL` (`MED_DEPOTLEGAL`);

--
-- Index pour la table `type_individu`
--
ALTER TABLE `type_individu`
  ADD PRIMARY KEY (`TIN_CODE`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `dosage`
--
ALTER TABLE `dosage`
  MODIFY `DOS_CODE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `famille`
--
ALTER TABLE `famille`
  MODIFY `FAM_CODE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `MED_DEPOTLEGAL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `type_individu`
--
ALTER TABLE `type_individu`
  MODIFY `TIN_CODE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `interagis`
--
ALTER TABLE `interagis`
  ADD CONSTRAINT `interagis_ibfk_1` FOREIGN KEY (`MED_PERTURBATEUR`) REFERENCES `medicament` (`MED_DEPOTLEGAL`),
  ADD CONSTRAINT `interagis_ibfk_2` FOREIGN KEY (`MED_MED_PERTURBE`) REFERENCES `medicament` (`MED_DEPOTLEGAL`);

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `medicament_ibfk_1` FOREIGN KEY (`FAM_CODE`) REFERENCES `famille` (`FAM_CODE`);

--
-- Contraintes pour la table `prescrire`
--
ALTER TABLE `prescrire`
  ADD CONSTRAINT `prescrire_ibfk_1` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `medicament` (`MED_DEPOTLEGAL`),
  ADD CONSTRAINT `prescrire_ibfk_2` FOREIGN KEY (`TIN_CODE`) REFERENCES `type_individu` (`TIN_CODE`),
  ADD CONSTRAINT `prescrire_ibfk_3` FOREIGN KEY (`DOS_CODE`) REFERENCES `dosage` (`DOS_CODE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
