# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.20)
# Database: VTDT
# Generation Time: 2014-11-20 18:11:28 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bars
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bars`;

CREATE TABLE `bars` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '',
  `address` varchar(128) DEFAULT NULL,
  `phone_number` varchar(128) DEFAULT NULL,
  `website` varchar(128) DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `bars` WRITE;
/*!40000 ALTER TABLE `bars` DISABLE KEYS */;

INSERT INTO `bars` (`id`, `name`, `address`, `phone_number`, `website`, `latitude`, `longitude`)
VALUES
	(1,'Top of the Stairs','217 College Avenue','(540) 953-2837','http://www.topofthestairs.com/',37.2297,-80.4164),
	(2,'Hokie House','322 North Main Street','(540) 552-0280','http://www.hokiehouse.com/',37.231398,-80.415395);

/*!40000 ALTER TABLE `bars` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table friends
# ------------------------------------------------------------

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(128) NOT NULL DEFAULT '',
  `friend` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;

INSERT INTO `friends` (`id`, `user`, `friend`)
VALUES
	(1,'10152362398270868','10152362398270870'),
	(2,'10152362398270868','10152362398270871'),
	(3,'10152362398270868','10152362398270872');

/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table newsfeed
# ------------------------------------------------------------

DROP TABLE IF EXISTS `newsfeed`;

CREATE TABLE `newsfeed` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  `message` varchar(128) NOT NULL DEFAULT '',
  `time_posted` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bar` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `newsfeed` WRITE;
/*!40000 ALTER TABLE `newsfeed` DISABLE KEYS */;

INSERT INTO `newsfeed` (`id`, `username`, `message`, `time_posted`, `bar`)
VALUES
	(1,'10152362398270868','TEST','2014-10-24 10:03:02',1),
	(2,'10152362398270868','TEST2','2014-10-24 10:03:04',2),
	(3,'10152362398270870','TEST1','2014-10-24 10:05:33',1),
	(4,'10152362398270870','TESTING','2014-10-24 10:05:37',1),
	(5,'10152362398270868','Hey this is a test message','2014-10-24 10:03:07',1),
	(6,'10152362398270868','POSTING','2014-10-24 10:13:02',1),
	(7,'10152362398270868','Test','2014-10-30 10:19:02',2),
	(8,'10152362398270868','testtesttest','2014-10-30 10:19:02',2),
	(9,'10152362398270871','71 posted','2014-10-30 23:15:59',1),
	(10,'10152362398270872','72 posted','2014-10-30 23:15:57',1),
	(11,'10152362398270871','71 posted again','2014-10-30 23:21:11',2),
	(12,'10152362398270871','again','2014-10-30 23:21:31',1),
	(13,'10152362398270871','again2','2014-10-30 23:22:11',1);

/*!40000 ALTER TABLE `newsfeed` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table specials
# ------------------------------------------------------------

DROP TABLE IF EXISTS `specials`;

CREATE TABLE `specials` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `menu_item` varchar(128) NOT NULL DEFAULT '',
  `price` double unsigned NOT NULL,
  `days` varchar(128) NOT NULL DEFAULT '',
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `bar` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bar` (`bar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `specials` WRITE;
/*!40000 ALTER TABLE `specials` DISABLE KEYS */;

INSERT INTO `specials` (`id`, `menu_item`, `price`, `days`, `start_time`, `end_time`, `bar`)
VALUES
	(1,'Single Highballs',1.75,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(2,'Doubles',3.5,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(3,'Domestic Bottles',1.25,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(4,'16 oz Budweiser/Miller Lite',1,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(5,'24 oz Budweiser/Miller Lite',1.5,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(6,'Pitcher Budweiser/Miller Lite',3.5,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(7,'16 oz Magic Hat #9/Seasonal',2,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(8,'24 oz Magic Hat #9/Seasonal',2.5,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(9,'Pitcher Magic Hat #9/Seasonal',6,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(10,'16 oz Shiner Boch',1.25,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(11,'24 oz Shiner Boch',1.75,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(12,'Pitcher Shiner Boch',4,'Mon,Tue,Wed,Thu,Fri','16:00:00','21:00:00',1),
	(13,'Maroon and Orange Effect',10,'Mon,Tue,Wed,Thu,Fri','17:00:00','21:00:00',2),
	(14,'Fatty Mug - Bud Light, Miller Lite, Natural Light, PBR, Yuengling, and Coors',2,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','17:00:00','21:00:00',2),
	(15,'Fatty Mugs of Everything Else on Tap',3,'Mon,Tue,Wed,Thu,Fri,Sat','17:00:00','21:00:00',2),
	(16,'Singles',1,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','17:00:00','21:00:00',2),
	(17,'Doubles',2,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','17:00:00','21:00:00',2),
	(18,'Jumbo\'s (Triple - any rail plus one mixer)',3,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','17:00:00','21:00:00',2),
	(19,'All other Rail Drinks',4,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','17:00:00','21:00:00',2),
	(20,'Budwieser, Bud Light, Miller Lite, Coors Light, Natural Light and PBR Bottles',1,'Tue,Sun','17:00:00','21:00:00',2),
	(21,'Bud Light, Miller Lite, Coors Light, Natural Light, PBR, Yuengling and Coors Pitchers',4.5,'Wed,Sat','17:00:00','21:00:00',2),
	(22,'Pitchers of Everything Else on Tap',7.5,'Wed,Sat','17:00:00','21:00:00',2);

/*!40000 ALTER TABLE `specials` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  `profile_picture` blob,
  `checked_in_bar` int(11) unsigned DEFAULT '0',
  `name` varchar(128) DEFAULT '',
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `username`, `profile_picture`, `checked_in_bar`, `name`, `admin`)
VALUES
	(1,'10152416543790868',NULL,1,'Sanchit Chadha',1),
	(2,'10152362398270870',NULL,1,'Sanchit Chadha2',0),
	(3,'10152362398270871',NULL,2,'Ragan Walker',0),
	(4,'10152362398270872',NULL,1,'Rohan Elwadhi',0);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
