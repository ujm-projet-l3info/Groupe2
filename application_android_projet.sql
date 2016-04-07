-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 07 Avril 2016 à 15:29
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

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
-- Structure de la table `cle`
--

CREATE TABLE `cle` (
  `id_cle` int(11) NOT NULL,
  `libelle` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `information` (
  `id` bigint(20) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `information`
--

INSERT INTO `information` (`id`, `latitude`, `longitude`) VALUES
(403182651, 45.434, 4.38811),
(634553043, 45.4302, 4.38952),
(634553056, 45.4282, 4.39042),
(661339900, 45.4313, 4.38782),
(661339906, 45.4328, 4.38776),
(661339914, 45.4337, 4.38819),
(661339916, 45.4338, 4.38815),
(661339931, 45.4343, 4.38845),
(661339941, 45.4353, 4.38729),
(664567527, 45.427, 4.38928),
(664567532, 45.4285, 4.3892),
(667288053, 45.4297, 4.38973),
(667529402, 45.4274, 4.39247),
(668966684, 45.4278, 4.38795),
(685755962, 45.4275, 4.38616),
(703830765, 45.4297, 4.39385),
(703830768, 45.428, 4.39353),
(703830771, 45.4278, 4.39331),
(703830773, 45.4289, 4.39317),
(705006186, 45.4277, 4.39287),
(728919525, 45.4264, 4.39737),
(741053765, 45.4268, 4.40266),
(741053774, 45.4267, 4.40275),
(793516217, 45.4277, 4.39155),
(926536380, 45.4278, 4.39023),
(926536386, 45.428, 4.39021),
(926536389, 45.4279, 4.3902),
(926536402, 45.4281, 4.39017),
(926586803, 45.4277, 4.39027),
(926586808, 45.4277, 4.39029),
(926586822, 45.4278, 4.39025),
(926606430, 45.4322, 4.38854),
(936978823, 45.4275, 4.38363),
(937222914, 45.4306, 4.38537),
(1013129410, 45.4337, 4.39814),
(1353845038, 45.4315, 4.39382),
(1461955451, 45.4337, 4.39771),
(1586061673, 45.4281, 4.39431),
(1586108070, 45.4261, 4.3899),
(1810314455, 45.4353, 4.38884),
(1971541305, 45.4277, 4.40302),
(1971780851, 45.4281, 4.40214),
(2093411032, 45.4263, 4.39046),
(2093412724, 45.4282, 4.39016),
(2205713857, 45.4326, 4.40127),
(2296312528, 45.4264, 4.3895),
(2323233350, 45.4337, 4.39644),
(2327037831, 45.4282, 4.38413),
(2386403586, 45.429, 4.40207),
(2408843696, 45.4311, 4.39607),
(2438502018, 45.4288, 4.40191),
(2468999832, 45.4325, 4.39438),
(2477666565, 45.4314, 4.39388),
(2477695116, 45.432, 4.38907),
(2481954492, 45.4299, 4.39468),
(2500911483, 45.4322, 4.38774),
(2507025767, 45.4272, 4.39042),
(2517188834, 45.4298, 4.38996),
(2517232295, 45.4291, 4.39019),
(2517232296, 45.4289, 4.39022),
(2517232310, 45.4285, 4.39008),
(2517232311, 45.4299, 4.3897),
(2517254815, 45.4332, 4.38861),
(2517254821, 45.4332, 4.38848),
(2517664034, 45.4345, 4.38966),
(2630904116, 45.4333, 4.39831),
(2640805848, 45.4351, 4.3918),
(2640805852, 45.4349, 4.39164),
(2640805853, 45.4349, 4.39151),
(2641008171, 45.4317, 4.39498),
(2641243679, 45.4313, 4.38782),
(2648251680, 45.4343, 4.39281),
(2648251703, 45.4338, 4.3934),
(2648380933, 45.4339, 4.39435),
(2650563993, 45.4323, 4.39045),
(2678573667, 45.4345, 4.38616),
(2683655977, 45.4324, 4.39396),
(2705478408, 45.4331, 4.38822),
(2706028558, 45.4296, 4.3825),
(2873145342, 45.4324, 4.39328),
(2985905945, 45.4331, 4.39002),
(3047459842, 45.4341, 4.38762),
(3047483205, 45.4341, 4.38753),
(3334472762, 45.4331, 4.38832),
(3461475112, 45.433, 4.38902),
(3461566937, 45.4324, 4.3892),
(3461579508, 45.4347, 4.39094),
(3490818495, 45.4283, 4.39011),
(3490828815, 45.4348, 4.38635),
(3496635711, 45.4325, 4.39037),
(3496714835, 45.4346, 4.38666),
(3590521246, 45.433, 4.39029),
(3590564781, 45.4278, 4.38902),
(3609094794, 45.4328, 4.38909),
(3617601168, 45.4354, 4.3872),
(3618380368, 45.4337, 4.3878),
(3809720335, 45.4335, 4.39283),
(3809720336, 45.4334, 4.39288),
(3809720337, 45.4327, 4.39313),
(3817645811, 45.4329, 4.38884),
(3896877100, 45.4324, 4.39387),
(3900155241, 45.4355, 4.38933),
(3900155243, 45.4349, 4.38976),
(3900155249, 45.4348, 4.38955),
(3900155251, 45.4349, 4.38953),
(3901194311, 45.4325, 4.39045),
(3901874605, 45.4348, 4.38853),
(3901874607, 45.4347, 4.38982),
(3901874608, 45.4347, 4.38958),
(3901874610, 45.4354, 4.38939),
(3906827679, 45.4321, 4.39034),
(3916746657, 45.4345, 4.38761),
(3920286860, 45.4337, 4.38883),
(3920351205, 45.4339, 4.3888),
(3920351206, 45.4342, 4.38848),
(3920351207, 45.4341, 4.38878),
(3928604963, 45.4348, 4.38751),
(3928604967, 45.435, 4.38745),
(3928604972, 45.4346, 4.38758),
(3928604973, 45.4343, 4.38803),
(3939256137, 45.4353, 4.38841),
(3997775705, 45.4325, 4.38918),
(3997775709, 45.4324, 4.38919);

-- --------------------------------------------------------

--
-- Structure de la table `tag`
--

CREATE TABLE `tag` (
  `id_info` bigint(20) NOT NULL,
  `id_cle` int(11) NOT NULL,
  `valeur` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `tag`
--

INSERT INTO `tag` (`id_info`, `id_cle`, `valeur`) VALUES
(403182651, 1, 'restaurant'),
(403182651, 21, 'regional'),
(403182651, 10, 'L\'Escargot d\'Or'),
(403182651, 23, 'cadastre-dgi-fr source : Direction Générale des Impôts - Cadastre ; mise à jour : 2008'),
(634553043, 10, 'Carrefour City'),
(634553043, 15, 'Mo-Sa 07:00-22:00; Su 09:00-13:00'),
(634553043, 6, 'supermarket'),
(661339931, 10, 'Les Opticiens Mutualistes'),
(661339931, 6, 'optician'),
(661339916, 1, 'pub'),
(661339916, 10, 'La Taverne'),
(661339941, 10, 'Kookai'),
(661339941, 6, 'clothes'),
(664567532, 1, 'pub'),
(664567532, 21, 'sandwich'),
(664567532, 10, 'Le Fief'),
(667288053, 6, 'clothes'),
(667529402, 1, 'library'),
(667529402, 10, 'Bibliothèque Universitaire Droit Lettres'),
(667529402, 15, 'Mo-Fr 08:30-18:30; Sa 09:00-17:00'),
(668966684, 6, 'car_repair'),
(703830771, 12, '10'),
(703830771, 14, '42100'),
(703830771, 11, 'Rue Édouard Vaillant'),
(703830771, 6, 'vacant'),
(703830768, 1, 'bar'),
(703830768, 10, 'Le Bleu'),
(703830765, 10, 'A. V. Creveys'),
(703830765, 6, 'bakery'),
(728919525, 3, 'memorial'),
(741053765, 1, 'fast_food'),
(741053765, 21, 'sandwich'),
(741053765, 10, 'Pain ch\'O'),
(661339906, 1, 'restaurant'),
(661339906, 10, 'Le Bistrot Gaga'),
(741053774, 10, 'Casino'),
(741053774, 6, 'convenience'),
(661339900, 10, 'Sphinx'),
(661339900, 8, 'artwork'),
(634553056, 10, 'Pharmacie de l\'Université'),
(634553056, 6, 'chemist'),
(703830773, 1, 'restaurant'),
(703830773, 21, 'pizza'),
(703830773, 10, 'Pizzeria Zapi'),
(705006186, 12, '6 bis'),
(705006186, 14, '42100'),
(705006186, 11, 'Rue Édouard Vaillant'),
(705006186, 1, 'library'),
(705006186, 2, 'yes'),
(705006186, 10, 'Médiathèque Municipale de Tréfilerie'),
(705006186, 15, 'Tu 13:00-18:30; We 09:00-12:00,13:30-18:30; Fr 13:00-18:30; Sa 09:00-13:00'),
(705006186, 23, 'cadastre-dgi-fr source : Direction Générale des Impôts - Cadastre. Mise à jour : 2010'),
(705006186, 16, 'http://www.bm-st-etienne.fr'),
(685755962, 10, 'Pharmacie de Tardy'),
(685755962, 6, 'chemist'),
(664567527, 10, 'Tardy Automobiles'),
(664567527, 6, 'car_repair'),
(661339914, 1, 'bar'),
(793516217, 1, 'bar'),
(793516217, 10, 'Le Voltaire'),
(1013129410, 1, 'theatre'),
(1013129410, 10, 'Théatre Copeau'),
(926586803, 1, 'bar'),
(926586803, 10, 'Le Chantier'),
(926586808, 1, 'cafe'),
(926586808, 10, 'Méli Mélo'),
(926586822, 1, 'bar'),
(926586822, 10, 'Le Road Runner'),
(926536386, 6, 'bakery'),
(926536389, 1, 'restaurant'),
(926536389, 21, 'italian'),
(926536389, 10, 'La CasaDella Pasta'),
(926536402, 1, 'bar'),
(926536402, 10, 'Le D\'Rap'),
(936978823, 3, 'memorial'),
(937222914, 10, 'La Passementière'),
(937222914, 8, 'guest_house'),
(1461955451, 1, 'theatre'),
(1461955451, 10, 'Grand Théâtre Massenet'),
(1586061673, 1, 'pub'),
(1586061673, 10, 'Le Misanthrope'),
(926536380, 10, 'Touche et Retouche'),
(926536380, 6, 'clothes'),
(1353845038, 1, 'nightclub'),
(1353845038, 10, 'Sanaka'),
(1586108070, 1, 'pub'),
(1586108070, 10, 'Le Remue-méninges'),
(1586108070, 15, 'Mo-Fr 11:30-21:00;Aug off;PH off'),
(1586108070, 16, 'http://remue-meninges.com/'),
(926606430, 13, 'saint-etienne'),
(926606430, 12, '25'),
(926606430, 14, '42000'),
(926606430, 11, 'Cours Victor Hugo'),
(926606430, 10, 'La Vie Claire'),
(926606430, 6, 'convenience'),
(1810314455, 10, 'Musée du vieux Saint-Etienne'),
(1810314455, 8, 'museum'),
(1810314455, 19, 'fr:Musée du vieux Saint-Étienne'),
(2296312528, 1, 'theatre'),
(2296312528, 10, 'Théatre libre'),
(1971541305, 8, 'artwork'),
(1971780851, 8, 'artwork'),
(2323233350, 1, 'swimming_pool'),
(2323233350, 10, 'Piscine Villebœuf'),
(2323233350, 7, 'swimming'),
(2323233350, 16, 'http://www.saint-etienne.fr/sports/piscines'),
(2327037831, 1, 'theatre'),
(2327037831, 10, 'Salle de Tardy'),
(2093412724, 1, 'fast_food'),
(2093412724, 21, 'pizza'),
(2093412724, 10, 'Pizza Riv\''),
(2093411032, 1, 'pub'),
(2093411032, 10, 'Dirty Old Town'),
(2205713857, 7, 'tennis'),
(2386403586, 6, 'chemist'),
(2408843696, 1, 'restaurant'),
(2408843696, 21, 'french'),
(2408843696, 10, 'À la Table des Lys'),
(2408843696, 16, 'http://www.latabledeslys.fr'),
(2438502018, 6, 'newsagent'),
(2477695116, 1, 'fountain'),
(2481954492, 10, 'Evidenza'),
(2481954492, 6, 'hairdresser'),
(2477666565, 10, 'Muse de l\'artisanat'),
(2477666565, 8, 'artwork'),
(2468999832, 12, '2'),
(2468999832, 11, 'Place Villebœuf'),
(2468999832, 10, 'Après la Pluie'),
(2468999832, 15, 'Mo 15:00-19:00;Tu-Sa 09:00-12:30,14:30-19:00'),
(2468999832, 6, 'convenience'),
(2468999832, 16, 'http://biomonde42.fr'),
(2500911483, 1, 'bar'),
(2500911483, 10, 'Slag Heaps'),
(2507025767, 1, 'restaurant'),
(2507025767, 21, 'french'),
(2507025767, 10, 'Les Bleuets'),
(2517188834, 10, 'La Banque du Livre'),
(2517188834, 6, 'books'),
(2517232310, 10, 'Rasmey Apsara'),
(2517232310, 6, 'convenience'),
(2517232311, 10, 'Ruissier'),
(2517232311, 6, 'hunting'),
(2517232311, 16, 'http://www.poirsonarmurerie.fr/'),
(2517232296, 6, 'yes'),
(2517254821, 10, 'Sixty\'s Coiffure'),
(2517254821, 6, 'hairdresser'),
(2517254815, 10, 'L\'Étrange Rendez-Vous'),
(2517254815, 6, 'books'),
(2517664034, 10, 'Au Bouquiniste'),
(2517664034, 6, 'books'),
(2630904116, 3, 'memorial'),
(2630904116, 10, 'À la mémoire de Francis Garnier'),
(2630904116, 8, 'artwork'),
(2640805852, 10, 'Génération Tattoo'),
(2640805852, 6, 'tattoo'),
(2640805853, 6, 'greengrocer'),
(2640805848, 13, 'Saint-Etienne'),
(2640805848, 12, '29'),
(2640805848, 14, '42000'),
(2640805848, 11, 'Rue Léon Nautin'),
(2640805848, 10, 'Carrefour City'),
(2640805848, 6, 'supermarket'),
(2641008171, 10, 'Videofutur'),
(2641008171, 6, 'video'),
(2641008171, 16, 'http://www.videofutur.fr'),
(2641243679, 1, 'fountain'),
(2641243679, 10, 'L\'Égyptienne'),
(2641243679, 8, 'artwork'),
(2517232295, 10, 'Des Bulles et des Hommes'),
(2517232295, 6, 'books'),
(3334472762, 10, 'Making Of'),
(3334472762, 6, 'hairdresser'),
(2648251680, 10, 'Bus Stop'),
(2648251680, 6, 'newsagent'),
(2648251703, 10, 'Les Limbes'),
(2648251703, 8, 'gallery'),
(2648251703, 16, 'http://leslimbes.wordpress.com'),
(2648380933, 1, 'theatre'),
(2648380933, 10, 'Salle Jeanne d\'Arc'),
(2650563993, 3, 'memorial'),
(2650563993, 10, 'Monument des Arméniens'),
(2650563993, 8, 'artwork'),
(2678573667, 12, '22'),
(2678573667, 11, 'Rue Henri Gonnard'),
(2678573667, 1, 'library'),
(2678573667, 10, 'Bibliothèque d\'Art'),
(2678573667, 16, 'http://www.musee-art-industrie.saint-etienne.fr/centre-de-documentation'),
(2683655977, 1, 'arts_centre'),
(2683655977, 10, 'Le Local'),
(2683655977, 6, 'art'),
(2706028558, 1, 'theatre'),
(2706028558, 10, 'La Cour'),
(2873145342, 10, 'Les Objets Trouvés'),
(2873145342, 15, 'Mo-Sa 14:00-19:00'),
(2873145342, 6, 'antiques'),
(2985905945, 10, 'Archiduchesse'),
(2985905945, 6, 'clothes'),
(3047483205, 13, 'Saint-Étienne'),
(3047483205, 12, '2'),
(3047483205, 14, '42000'),
(3047483205, 11, 'Cours Victor Hugo'),
(3047483205, 1, 'restaurant'),
(3047483205, 21, 'belgian'),
(3047483205, 10, 'Brussel Corner'),
(3047459842, 13, 'Saint-Étienne'),
(3047459842, 12, '2'),
(3047459842, 14, '42000'),
(3047459842, 11, 'Cours Victor Hugo'),
(3047459842, 1, 'pub'),
(3047459842, 10, 'BXL'),
(3461475112, 12, '25'),
(3461475112, 11, 'Rue Gambetta'),
(3461475112, 10, 'Nature Conseil - Au grain de blé'),
(3461475112, 6, 'convenience'),
(3461566937, 12, '31'),
(3461566937, 11, 'Rue Gambetta'),
(3461566937, 10, 'Aux 4 coins du monde'),
(3461566937, 6, 'fairtrade'),
(3461579508, 12, '13'),
(3461579508, 11, 'Rue Pointe Cadet'),
(3461579508, 1, 'restaurant'),
(3461579508, 10, 'Entre 2 po...'),
(3490818495, 1, 'restaurant'),
(3490818495, 21, 'mediterranean'),
(3490818495, 10, 'Le Byblos'),
(3490828815, 1, 'arts_centre'),
(3490828815, 10, 'La Serre'),
(3496635711, 18, 'board'),
(3496635711, 10, 'L\'immeuble moderne'),
(3496635711, 8, 'information'),
(3496714835, 8, 'viewpoint'),
(2705478408, 18, 'board'),
(2705478408, 10, 'La Bourse du Travail'),
(2705478408, 8, 'information'),
(2705478408, 19, 'fr:Bourse du travail de Saint-Étienne'),
(3590521246, 18, 'board'),
(3590521246, 10, 'L\'établissement administratif des Hospices Civils'),
(3590521246, 8, 'information'),
(3590564781, 10, 'Maison Funéraire'),
(3590564781, 6, 'funeral_directors'),
(3609094794, 10, 'Coif\'Maz'),
(3609094794, 6, 'hairdresser'),
(3617601168, 10, 'Mango'),
(3617601168, 6, 'clothes'),
(3618380368, 10, 'Leader Price Express'),
(3618380368, 6, 'convenience'),
(3809720335, 10, 'Atelier Couleurs du Sud'),
(3809720335, 6, 'antiques'),
(3809720336, 1, 'nightclub'),
(3809720336, 10, 'Le Tribeca'),
(3809720337, 6, 'second_hand'),
(3817645811, 10, 'La Houblonnerie'),
(3817645811, 6, 'alcohol'),
(3896877100, 1, 'theatre'),
(3896877100, 10, 'Théâtre de poche des Brankignols'),
(3900155243, 10, 'Lacoste'),
(3900155243, 6, 'clothes'),
(3900155251, 10, 'Scrapcooking'),
(3900155251, 6, 'yes'),
(3900155241, 10, 'Bérénice'),
(3900155241, 6, 'clothes'),
(3901194311, 10, 'Le Magasin'),
(3901194311, 6, 'charity'),
(3901874605, 10, 'C\'est 2 Euros'),
(3901874605, 6, 'variety_store'),
(3901874607, 10, 'Coursol'),
(3901874607, 6, 'interior_decoration'),
(3901874608, 10, 'Estelle H'),
(3901874608, 6, 'clothes'),
(3901874610, 10, 'Parfums d\'Orient'),
(3901874610, 6, 'beauty'),
(3900155249, 10, 'Papillote'),
(3900155249, 6, 'toys'),
(3906827679, 1, 'theatre'),
(3906827679, 10, 'Metamorphosis'),
(3916746657, 13, 'Saint-Étienne'),
(3916746657, 12, '22'),
(3916746657, 14, '42000'),
(3916746657, 11, 'Place des Ursules'),
(3916746657, 10, 'Audio 2000'),
(3916746657, 15, 'Mo-Fr 14:00-18:00'),
(3916746657, 6, 'photo'),
(3916746657, 16, 'www.audition-jeanluc-lyonnet.fr'),
(3920286860, 10, 'La Civette'),
(3920286860, 6, 'newsagent'),
(3920351205, 10, 'Adagio'),
(3920351205, 8, 'hotel'),
(3920351206, 10, 'BIMP'),
(3920351206, 6, 'computer'),
(3920351207, 10, 'H&M'),
(3920351207, 6, 'clothes'),
(3928604963, 1, 'fast_food'),
(3928604963, 21, 'sandwich'),
(3928604963, 10, 'Bagelstein'),
(3928604967, 10, 'Damart'),
(3928604967, 6, 'clothes'),
(3928604972, 10, 'Lynx Optique'),
(3928604972, 6, 'optician'),
(3928604973, 10, 'MG Galerie'),
(3928604973, 8, 'gallery'),
(3939256137, 10, 'Arthur & Aston'),
(3939256137, 6, 'clothes'),
(3997775705, 10, 'Le Balto'),
(3997775705, 6, 'newsagent'),
(3997775709, 1, 'restaurant'),
(3997775709, 21, 'pizza'),
(3997775709, 10, 'Pizz\'A L\'ancienne');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cle`
--
ALTER TABLE `cle`
  ADD PRIMARY KEY (`id_cle`);

--
-- Index pour la table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id_info`,`id_cle`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cle`
--
ALTER TABLE `cle`
  MODIFY `id_cle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;