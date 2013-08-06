-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Hoszt: 127.0.0.1
-- Létrehozás ideje: 2013. Aug 06. 11:38
-- Szerver verzió: 5.5.32
-- PHP verzió: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Adatbázis: `javamaster_dictionary`
--
CREATE DATABASE IF NOT EXISTS `javamaster_dictionary` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `javamaster_dictionary`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `eng_word`
--

CREATE TABLE IF NOT EXISTS `eng_word` (
  `eng_id` int(11) NOT NULL AUTO_INCREMENT,
  `eng_word` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eng_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hun_word`
--

CREATE TABLE IF NOT EXISTS `hun_word` (
  `hun_id` int(11) NOT NULL AUTO_INCREMENT,
  `hun_word` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `statistics`
--

CREATE TABLE IF NOT EXISTS `statistics` (
  `user_id` int(11) NOT NULL,
  `word_id` int(11) NOT NULL,
  `question_count` int(11) DEFAULT NULL,
  `correct_answer` int(11) DEFAULT NULL,
  `wrong_answer` int(11) DEFAULT NULL,
  `ratio` double DEFAULT NULL,
  PRIMARY KEY (`word_id`,`user_id`),
  KEY `fk_statistics_hun_word1_idx` (`word_id`),
  KEY `fk_statistics_users1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `question_count` int(11) DEFAULT NULL,
  `correct_answer` int(11) DEFAULT NULL,
  `wrong_answer` int(11) DEFAULT NULL,
  `ratio` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `words`
--

CREATE TABLE IF NOT EXISTS `words` (
  `hun_id` int(11) NOT NULL,
  `eng_id` int(11) NOT NULL,
  PRIMARY KEY (`hun_id`,`eng_id`),
  KEY `fk_words_hun_word_idx` (`hun_id`),
  KEY `fk_words_eng_word1_idx` (`eng_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `fk_statistics_hun_word1` FOREIGN KEY (`word_id`) REFERENCES `hun_word` (`hun_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_statistics_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `words`
--
ALTER TABLE `words`
  ADD CONSTRAINT `fk_words_hun_word` FOREIGN KEY (`hun_id`) REFERENCES `hun_word` (`hun_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_words_eng_word1` FOREIGN KEY (`eng_id`) REFERENCES `eng_word` (`eng_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
