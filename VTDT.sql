# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: jupiter.cs.vt.edu (MySQL 5.6.21)
# Database: VTDT
# Generation Time: 2014-12-08 21:58:41 +0000
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
	(2,'Hokie House','322 North Main Street','(540) 552-0280','http://www.hokiehouse.com/',37.231398,-80.415395),
	(3,'Champs','111 N Main St','(540) 951-2222','www.champssportsbar.com/',37.230449,-80.414187),
	(4,'Big Al\'s','201 N Main St','(540) 951-3300','www.bigalssportsbar.com/',37.230907,-80.414705),
	(5,'Sycamore','211 Draper Rd SW','(540) 951-9817','www.sycamoredeli.com/',37.23058,-80.41627),
	(6,'Cellar','302 N Main St','(540) 953-0651','www.the-cellar.com/',37.231829,-80.414703),
	(7,'PK\'s','432 N Main St','(540) 552-1577','www.pksbarandgrill.com/',37.232163,-80.416175),
	(8,'Underground','112 N Main St','(540) 552-9044','www.lugpub.com/',37.229662,-80.414123),
	(9,'River Mill','212 Draper Rd NW','(540) 951-2483','www.rivermill.com',37.229858,-80.415984),
	(10,'622 North','622 N Main St','(540) 951-1033','www.622north.com/',37.234403,-80.419544);

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
	(4,'1375619979396299','10152362398270868'),
	(7,'10155367846795377','1375619979396299'),
	(9,'10152362398270868','10155367846795377'),
	(10,'10152362398270868','10204260071074685'),
	(11,'10152362398270868','10152859315504283'),
	(12,'10204260071074685','10152362398270868'),
	(15,'10204260071074685','1375619979396299'),
	(16,'10155367846795377','10152851506779283'),
	(17,'10155367846795377','10152362398270868'),
	(22,'10204260071074685','10155367846795377'),
	(23,'1375619979396299','10155367846795377'),
	(25,'10152362398270868','1375619979396299'),
	(26,'1375619979396299','10152851506779283'),
	(27,'1375619979396299','10204260071074685'),
	(28,'10155367846795377','10204260071074685'),
	(29,'10152362398270868','10152851506779283');

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
	(5,'10152362398270868','Hey this is a test message','2014-10-24 10:03:07',1),
	(7,'10152362398270868','Test','2014-10-30 10:19:02',2),
	(8,'10152362398270868','testtesttest','2014-10-30 10:19:02',2),
	(14,'10152362398270868','test','2014-11-02 15:22:53',2),
	(15,'10152859315504283','test','2014-11-02 16:52:29',2),
	(17,'1375619979396299','Testing ANdroid POst','2014-11-02 21:10:02',1),
	(19,'10152362398270868','\"hi rohan\"','2014-11-03 18:44:11',2),
	(20,'1375619979396299','Posting from my actual Android Phone :)','2014-11-03 19:20:39',4),
	(21,'10155367846795377','we are almost done!','2014-11-03 19:22:54',1),
	(22,'10204260071074685','really really long post wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww','2014-11-03 19:08:20',1),
	(23,'10155367846795377','please give us an A+','2014-11-04 00:19:07',1),
	(24,'10155367846795377','we need a river mill post! i am the only person here apparently....','2014-11-04 00:19:43',9),
	(25,'10155367846795377','river mill is the shit! i love it. especially when i am the only one here.','2014-11-04 00:20:12',9),
	(26,'10204260071074685','i thought we were almost done...','2014-11-04 00:32:25',5),
	(28,'1375619979396299','Big Al\'s 40 Days tomorrow','2014-11-04 05:38:50',4),
	(29,'1375619979396299','test','2014-11-04 06:40:22',1),
	(30,'10152362398270868','So tired.....','2014-11-04 08:39:18',2),
	(31,'1375619979396299','Pizza!','2014-11-04 08:51:54',7),
	(32,'10152362398270868','test test test hi hi hi','2014-11-04 13:24:41',1),
	(33,'10155367846795377','showing my mom how cool vtdti is!','2014-11-08 21:37:59',2),
	(34,'10155367846795377','i\'m not really at hokie house right now.','2014-11-08 22:30:07',2),
	(35,'10155367846795377','hokie house is so cool! i love this place.','2014-11-12 19:23:27',2),
	(36,'10152362398270868','test','2014-11-14 15:41:15',1),
	(37,'10152362398270868','hello','2014-12-06 15:40:42',1);

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
	(29,'House Highballs',2,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',3),
	(30,'Select Draft Beers',1.25,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',3),
	(31,'Select Draft Pitchers',5.25,'Mon,Tue,Wed,Thu,Fri,Sat, Sun','11:00:00','21:00:00',3),
	(32,'PBR',0.5,'Mon','11:00:00','21:00:00',3),
	(33,'Bottled Beer Special',1,'Tue','11:00:00','21:00:00',3),
	(34,'Single',1,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(35,'Doubles',2,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(36,'PBR Bottles',1.5,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(37,'Natty Light Pitchers',4,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(38,'Bud Light Pitchers',5,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(39,'Corona Extra',2,'Mon,Tue,Wed,Thu,Fri,Sat,Sun','11:00:00','21:00:00',4),
	(40,'Miller Lite',1.25,'Tue, Wed','11:00:00','21:00:00',4),
	(42,'All Beer',2,'Tue','06:00:00','16:00:00',5),
	(43,'PBR Pitchers',2,'Wed','06:00:00','16:00:00',5),
	(44,'All Light Beer',1,'Thu','06:00:00','16:00:00',5),
	(45,'All Pitchers',5.55,'Fri','06:00:00','16:00:00',5),
	(46,'All Pitchers',6,'Sat','06:00:00','16:00:00',5),
	(47,'All Pitchers of Beer',7,'Mon,Tue,Wed,Thur,Sun','13:00:00','14:00:00',6),
	(48,'Luck of the Draw Bottled Beer',2,'Mon,Tue,Wed,Thur,Fri,Sat,Sun','06:00:00','21:00:00',6),
	(49,'House Highball Singles',1.5,'Mon,Tue,Wed,Thu,Fri','09:00:00','16:00:00',7),
	(50,'House Highball Doubles',3,'Mon,Tue,Wed,Thu,Fri','09:00:00','16:00:00',7),
	(51,'Long Islands, Green Dinos, Blue Motorcyces',4,'Mon,Tue,Wed,Thu,Fri','09:00:00','16:00:00',7),
	(52,'PBR Buckets (5 Bottles)',8,'Mon,Tue,Wed,Thu,Fri','09:00:00','16:00:00',7),
	(53,'Drafts',3,'Mon','09:00:00','16:00:00',10),
	(54,'Domestic Bottles',1.5,'Mon,Tue,Wed,Thu,Fri,Sun','09:00:00','16:00:00',10),
	(55,'Single',2,'Tue,Wed,Thu,Fri','09:00:00','16:00:00',10),
	(56,'Doubles',4,'Tue,Wed,Thu,Fri','09:00:00','16:00:00',10),
	(57,'Double Red Bull Vodka',6,'Wed','09:00:00','16:00:00',10),
	(58,'Dirty Karma and Red Bull',5,'Wed','09:00:00','16:00:00',10);

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
	(1,'10152362398270868',NULL,100,'Sanchit Chadha',0),
	(2,'10152851506779283',NULL,100,'Patrick Sherman',0),
	(4,'1375619979396299',NULL,2,'Rohan Elwadhi',0),
	(44,'10152859315504283',NULL,100,'Patrick Xavier Sherman',0),
	(45,'10155367846795377',NULL,1,'Ragan Walker',1),
	(139,'10204260071074685',NULL,6,'Tyler Wideman',0),
	(327,'1518000315112021',NULL,100,'Vtdt Vtdt',1),
	(354,'1518022565109796',NULL,100,'Vtdt Vtdt',1);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
