-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.18-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema waterdb
--

CREATE DATABASE IF NOT EXISTS waterdb;
USE waterdb;

--
-- Definition of table `case_attachment`
--

DROP TABLE IF EXISTS `case_attachment`;
CREATE TABLE `case_attachment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `case_attachment`
--

/*!40000 ALTER TABLE `case_attachment` DISABLE KEYS */;
INSERT INTO `case_attachment` (`id`,`case_id`,`title`,`path`,`deleted`) VALUES 
 (16,47,'qwe','http://cinfysystems.com/digilibrary/WATER/CASE_ATTACHMENTS/1562565207019_img-14.jpg',0),
 (17,47,'asd','http://cinfysystems.com/digilibrary/WATER/CASE_ATTACHMENTS/1562563021348_a.jpg',NULL),
 (18,47,'jeet','http://cinfysystems.com/digilibrary/WATER/CASE_ATTACHMENTS/1562563024543_img-15.jpg',NULL),
 (19,47,'asdsasda','http://cinfysystems.com/digilibrary/WATER/CASE_ATTACHMENTS/1562564426300_img-20.jpg',NULL),
 (22,47,'niraj','http://cinfysystems.com/digilibrary/WATER/CASE_ATTACHMENTS/1562565174375_img-567.jpg',NULL),
 (23,NULL,'',NULL,NULL),
 (24,NULL,'',NULL,NULL);
/*!40000 ALTER TABLE `case_attachment` ENABLE KEYS */;


--
-- Definition of table `case_registration`
--

DROP TABLE IF EXISTS `case_registration`;
CREATE TABLE `case_registration` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `case_type_id` int(10) unsigned DEFAULT NULL,
  `case_no` int(10) unsigned DEFAULT NULL,
  `case_year` int(10) unsigned DEFAULT NULL,
  `court_name_id` int(10) unsigned DEFAULT NULL,
  `division_id` int(10) unsigned DEFAULT NULL,
  `zone_id` int(10) unsigned DEFAULT NULL,
  `petition_date` date DEFAULT NULL,
  `petition_details` text,
  `oic` int(10) unsigned DEFAULT NULL,
  `respons_hearing_date_id` int(10) unsigned DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_details` text,
  `advocate_opinion` text,
  `action_taken` text,
  `others` varchar(500) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `updated_by` int(10) unsigned DEFAULT NULL,
  `circle_id` int(10) unsigned DEFAULT NULL,
  `case_status` varchar(45) DEFAULT NULL,
  `no_of_petitioner` int(10) unsigned DEFAULT NULL,
  `no_of_defendant` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_case_type_1` (`case_type_id`),
  KEY `FK_case_court_name` (`court_name_id`),
  KEY `FK_case_division` (`division_id`),
  KEY `FK_case_zone` (`zone_id`),
  KEY `FK_case_oic` (`oic`),
  KEY `FK_case_hearing` (`respons_hearing_date_id`),
  KEY `FK_case_updatedby` (`updated_by`),
  CONSTRAINT `FK_case_court_name` FOREIGN KEY (`court_name_id`) REFERENCES `m_court_name` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_case_division` FOREIGN KEY (`division_id`) REFERENCES `m_division` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_case_hearing` FOREIGN KEY (`respons_hearing_date_id`) REFERENCES `respons_hearing_date` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_case_oic` FOREIGN KEY (`oic`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_case_type_1` FOREIGN KEY (`case_type_id`) REFERENCES `m_case_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_case_updatedby` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_case_zone` FOREIGN KEY (`zone_id`) REFERENCES `m_zone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `case_registration`
--

/*!40000 ALTER TABLE `case_registration` DISABLE KEYS */;
INSERT INTO `case_registration` (`id`,`case_type_id`,`case_no`,`case_year`,`court_name_id`,`division_id`,`zone_id`,`petition_date`,`petition_details`,`oic`,`respons_hearing_date_id`,`order_date`,`order_details`,`advocate_opinion`,`action_taken`,`others`,`created_date`,`created_by`,`updated_date`,`updated_by`,`circle_id`,`case_status`,`no_of_petitioner`,`no_of_defendant`) VALUES 
 (1,1,6545,2011,3,64,2,NULL,'hjghj,kjhjk,jhghjgkhjghj',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL),
 (2,1,9893,2011,1,44,1,NULL,'hjghj,ggggg,jjjjj',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),
 (3,2,7854,2011,2,45,1,NULL,'hjghj,er,we',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),
 (4,2,1234,2011,2,46,1,NULL,'hjghj,qweqwe,1244',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),
 (5,1,1234,2010,2,45,1,NULL,'hjghj,asdasdasd,sadasdasd',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),
 (7,1,9893,2011,2,13,1,NULL,'hjghj,qwqeqwe,qweqwe',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL),
 (8,1,1234,2016,2,16,1,'2019-07-12','hari,sdfsfsdf,sdfsfs',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),
 (16,1,3332,2018,2,46,1,'2019-07-19','hjghj,hhj,asasd',2,NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-03 13:34:14',1,'2019-07-03 13:34:14',1,2,NULL,NULL,NULL),
 (17,1,3332,2017,2,47,1,'2019-07-13','hari,asdasdas,asdasd',1,NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-03 13:39:18',1,'2019-07-03 13:39:18',1,2,NULL,NULL,NULL),
 (22,1,9893,2010,2,45,1,'2019-07-13','asdasd,asdasd',1,1,'2019-07-19 00:00:00','dasdasd','asdasddas','asdas',NULL,'2019-07-03 16:57:06',1,'2019-07-03 16:57:06',1,2,NULL,NULL,NULL),
 (23,1,9893,2007,1,45,1,'2019-07-11','asas',1,2,'2019-07-18 00:00:00','asd','asd','asd','asd','2019-07-05 12:48:04',1,'2019-07-05 12:48:04',1,2,'Running',NULL,NULL),
 (24,1,9893,2010,2,65,2,'2019-07-11','asdad',2,3,'2019-07-11 00:00:00','asd','asd','sa','asd','2019-07-05 12:51:50',1,'2019-07-05 12:51:50',1,4,'Running',NULL,NULL),
 (25,2,9893,2010,2,46,1,'2019-07-12','assdasd',1,4,'2019-07-12 00:00:00','asd','asd','asd','asd','2019-07-05 12:53:06',1,'2019-07-05 12:53:06',1,2,'Running',NULL,NULL),
 (31,1,7854,2002,2,46,1,'2019-07-12','kjhg',1,10,'2019-07-12 00:00:00',';kjkj','lkopkl','kjhjlhbl','kljk','2019-07-05 13:55:01',1,'2019-07-05 13:55:01',1,2,'Running',NULL,NULL),
 (32,1,9893,2018,2,45,1,'2019-07-12','jhghjghj',1,11,'2019-07-18 00:00:00','kjhjk','lknkl','kjhj','njk','2019-07-05 14:02:19',1,'2019-07-05 14:02:19',1,2,'Running',NULL,NULL),
 (33,1,9893,2006,1,47,1,'2019-07-13','sad',2,12,'2019-07-13 00:00:00','asd','sad','sad','asd','2019-07-05 14:05:39',1,'2019-07-05 14:05:39',1,2,'Running',NULL,NULL),
 (34,1,6545,2005,1,46,1,'2019-07-11','ssadda',1,13,'2019-07-25 00:00:00','asd','sad','asd','asd','2019-07-05 14:58:19',1,'2019-07-05 14:58:19',1,2,'Running',NULL,NULL),
 (35,1,7854,2005,2,47,1,'2019-07-12','asd',3,14,'2019-07-26 00:00:00','asdas','dasdsad','asd','asd','2019-07-05 15:00:39',1,'2019-07-05 15:00:39',1,2,'Running',NULL,NULL),
 (36,1,9893,2019,2,46,1,'2019-07-12','asd',1,15,'2019-07-13 00:00:00','sad','sad','sa','ad','2019-07-05 15:52:34',1,'2019-07-05 15:52:34',1,2,'Running',NULL,NULL),
 (37,1,9893,2019,2,45,1,'2019-07-12','sdasdasd',1,16,'2019-07-05 00:00:00','asdasd','asdasdasd','asasd','asdasd','2019-07-05 17:59:48',1,'2019-07-05 17:59:48',1,2,'Running',NULL,NULL),
 (38,1,9893,2019,2,45,1,'2019-07-12','asdasd',1,17,'2019-07-12 00:00:00','asd','asd','asd','sd','2019-07-06 15:02:06',1,'2019-07-06 15:02:06',1,2,'Running',NULL,NULL),
 (39,1,9893,2018,2,14,1,'2019-07-12','asdas',1,18,'2019-07-05 00:00:00','asd','asd','asd','asd','2019-07-06 15:09:46',1,'2019-07-06 15:09:46',1,2,'Running',NULL,NULL),
 (40,1,6545,2018,2,45,1,'2019-07-01','awdwqeqwe',1,19,'2019-07-01 00:00:00','qwe','qwe','qwe','qwe','2019-07-06 15:14:20',1,'2019-07-06 15:14:20',1,2,'Running',NULL,NULL),
 (41,1,9893,2018,2,24,1,'2019-07-09','sad',1,20,'2019-07-05 00:00:00','ads','asd','asd','asd','2019-07-06 15:21:13',1,'2019-07-06 15:21:13',1,2,'Running',NULL,NULL),
 (42,2,1234,2017,2,46,1,'2019-07-31','sdsfs',1,23,'2019-07-28 00:00:00','sdfdsf','sdfsdf','sddsf','dsf','2019-07-06 16:54:27',1,'2019-07-06 16:54:27',1,2,'Running',NULL,NULL),
 (43,1,3265,2009,2,47,1,'2019-07-10','sadadasd',1,25,'2019-07-06 00:00:00','sdasd','dasdasdasd','asdasd','asdas','2019-07-07 17:20:28',1,'2019-07-07 17:20:28',1,2,'Running',NULL,NULL),
 (44,2,8523,2019,2,47,1,'2019-07-13','asdasdsad',1,26,'2019-07-06 00:00:00','asdasdsad','asdasdsad','sdasdad','asdasd','2019-07-07 17:54:17',1,'2019-07-07 17:54:17',1,2,'Running',NULL,NULL),
 (45,1,1233,2019,2,14,1,'2019-07-18','asd',1,27,'2019-07-06 00:00:00','asdas','asd','dasd','asd','2019-07-07 18:04:35',1,'2019-07-07 18:04:35',1,2,'Running',NULL,NULL),
 (46,1,9893,2007,2,47,1,'2019-07-10','asdasdasd',1,28,'2019-07-06 00:00:00','asdsad','asdasdasd','dasd','asdasd','2019-07-08 10:11:16',1,'2019-07-08 10:11:16',1,2,'Running',NULL,NULL),
 (47,1,9893,2006,2,46,1,'2019-07-04','asdasd',1,41,'2019-07-13 00:00:00','asdsad','dasdasd','asdas','dsadas','2019-07-08 15:58:36',1,'2019-07-08 15:58:36',1,2,'Running',NULL,NULL);
/*!40000 ALTER TABLE `case_registration` ENABLE KEYS */;


--
-- Definition of table `defendant_name`
--

DROP TABLE IF EXISTS `defendant_name`;
CREATE TABLE `defendant_name` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `defendant_id` int(10) unsigned DEFAULT NULL,
  `case_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_defendant_name_case` (`case_id`),
  KEY `FK_defendant_name_defendant` (`defendant_id`),
  CONSTRAINT `FK_defendant_name_case` FOREIGN KEY (`case_id`) REFERENCES `case_registration` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_defendant_name_defendant` FOREIGN KEY (`defendant_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `defendant_name`
--

/*!40000 ALTER TABLE `defendant_name` DISABLE KEYS */;
INSERT INTO `defendant_name` (`id`,`defendant_id`,`case_id`) VALUES 
 (2,2,35),
 (3,1,36),
 (4,1,37),
 (5,2,37),
 (6,1,39),
 (7,1,40),
 (8,1,41),
 (9,2,41),
 (10,3,41),
 (11,3,42),
 (12,2,42),
 (13,1,42),
 (14,1,43),
 (15,2,43),
 (16,1,44),
 (17,2,44),
 (18,1,45),
 (19,1,46),
 (20,2,47);
/*!40000 ALTER TABLE `defendant_name` ENABLE KEYS */;


--
-- Definition of table `m_case_type`
--

DROP TABLE IF EXISTS `m_case_type`;
CREATE TABLE `m_case_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `case_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_case_type`
--

/*!40000 ALTER TABLE `m_case_type` DISABLE KEYS */;
INSERT INTO `m_case_type` (`id`,`case_type`) VALUES 
 (1,'WP'),
 (2,'LLP'),
 (3,'WA');
/*!40000 ALTER TABLE `m_case_type` ENABLE KEYS */;


--
-- Definition of table `m_circle`
--

DROP TABLE IF EXISTS `m_circle`;
CREATE TABLE `m_circle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state_id` int(10) unsigned DEFAULT NULL,
  `zone_id` int(10) unsigned DEFAULT NULL,
  `circle_code` int(10) unsigned DEFAULT NULL,
  `name_english` varchar(45) DEFAULT NULL,
  `name_hindi` varchar(45) DEFAULT NULL,
  `circle_type_id` int(10) unsigned DEFAULT NULL,
  `circle_hq` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_state` (`state_id`),
  KEY `FK_m_zone` (`zone_id`),
  KEY `FK_m_circle_type` (`circle_type_id`),
  CONSTRAINT `FK_m_circle_type` FOREIGN KEY (`circle_type_id`) REFERENCES `m_circle_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_state` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_zone` FOREIGN KEY (`zone_id`) REFERENCES `m_zone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_circle`
--

/*!40000 ALTER TABLE `m_circle` DISABLE KEYS */;
INSERT INTO `m_circle` (`id`,`state_id`,`zone_id`,`circle_code`,`name_english`,`name_hindi`,`circle_type_id`,`circle_hq`) VALUES 
 (1,17,1,1,'Bhopal','भोपाल',1,'Bhopal'),
 (2,17,1,2,'Hoshangabad Narmadapuram ','नर्मदापुरम',1,'Hoshanagabad'),
 (3,17,1,3,'Bhopal Narmada Project','भोपाल नर्मदा परियोज़ना',2,'Bhopal'),
 (4,17,2,1,'Indore','इंदोर',1,'Indore'),
 (5,17,2,2,'Ujjain','उज्जैन',1,'Ujjain'),
 (6,17,2,3,'Indore Project ','इंदोर परियोज़ना',2,'Indore'),
 (7,17,3,1,'Gwalior','ग्वालियर',1,'Gwalior'),
 (8,17,3,2,'Sagar','सागर',1,'Sagar'),
 (9,17,3,3,'Chambal Circle Murena','चम्बल',1,'Murena'),
 (10,17,4,1,'Jabalpur','जबलपुर',1,'Jabalpur'),
 (11,17,4,2,'Rewa','रीवा',1,'Rewa'),
 (12,17,4,3,'Shahdol','शह्डोल',1,'Shahdol'),
 (13,17,4,4,'Chhindwara Project ','छिंद्वाडा परियोज़ना',1,'Chhindwara'),
 (99,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `m_circle` ENABLE KEYS */;


--
-- Definition of table `m_circle_type`
--

DROP TABLE IF EXISTS `m_circle_type`;
CREATE TABLE `m_circle_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_english` varchar(45) NOT NULL,
  `name_hindi` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_circle_type`
--

/*!40000 ALTER TABLE `m_circle_type` DISABLE KEYS */;
INSERT INTO `m_circle_type` (`id`,`name_english`,`name_hindi`) VALUES 
 (1,'Regular Circle',''),
 (2,'Project Circle',''),
 (3,'E&M Circle','');
/*!40000 ALTER TABLE `m_circle_type` ENABLE KEYS */;


--
-- Definition of table `m_court_name`
--

DROP TABLE IF EXISTS `m_court_name`;
CREATE TABLE `m_court_name` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `court_name` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_court_name`
--

/*!40000 ALTER TABLE `m_court_name` DISABLE KEYS */;
INSERT INTO `m_court_name` (`id`,`court_name`) VALUES 
 (1,'Indore'),
 (2,'Bhopal'),
 (3,'Jabalpur'),
 (4,'Gwalior');
/*!40000 ALTER TABLE `m_court_name` ENABLE KEYS */;


--
-- Definition of table `m_designation`
--

DROP TABLE IF EXISTS `m_designation`;
CREATE TABLE `m_designation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_designation`
--

/*!40000 ALTER TABLE `m_designation` DISABLE KEYS */;
INSERT INTO `m_designation` (`id`,`name`) VALUES 
 (1,'Engineer in chief'),
 (2,'Chief engineer'),
 (3,'Superintendent engineer'),
 (4,'Executive engineer'),
 (5,'Assistant engineer'),
 (6,'Sub Engineer'),
 (7,'Law assistant');
/*!40000 ALTER TABLE `m_designation` ENABLE KEYS */;


--
-- Definition of table `m_division`
--

DROP TABLE IF EXISTS `m_division`;
CREATE TABLE `m_division` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state_id` int(10) unsigned DEFAULT NULL,
  `circle_id` int(10) unsigned DEFAULT NULL,
  `division_code` int(10) unsigned DEFAULT NULL,
  `name_english` varchar(100) DEFAULT NULL,
  `name_hindi` varchar(200) DEFAULT NULL,
  `division_type_id` int(10) unsigned DEFAULT NULL,
  `division_hq` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_division_state` (`state_id`),
  KEY `FK_m_division_circle` (`circle_id`),
  KEY `FK_m_division_type` (`division_type_id`),
  CONSTRAINT `FK_m_division_circle` FOREIGN KEY (`circle_id`) REFERENCES `m_circle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_division_state` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_division_type` FOREIGN KEY (`division_type_id`) REFERENCES `m_division_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_division`
--

/*!40000 ALTER TABLE `m_division` DISABLE KEYS */;
INSERT INTO `m_division` (`id`,`state_id`,`circle_id`,`division_code`,`name_english`,`name_hindi`,`division_type_id`,`division_hq`) VALUES 
 (1,17,1,1,'Bhopal','भोपाल',1,'Bhopal'),
 (2,17,1,2,'Raisen','रायसेन',1,'Raisen'),
 (3,17,1,3,'Rajgarh','राजगढ़',1,'Rajgarh'),
 (4,17,1,4,'Sehore','सीहोर',1,'Sehore'),
 (5,17,1,5,'Vidisha','विदिशा ',1,'Vidisha'),
 (6,17,1,6,'Bhopal Capital Pr. II','भोपाल राजधानी परियोजना खण्ड क्रमांक II',2,'Bhopal'),
 (7,17,1,7,'Quality Control Unit  Bhopal','गुणवत्ता नियंत्रण इकाई खण्ड भोपाल',4,'Bhopal'),
 (8,17,1,8,'Bhopal Maintenance  Division ','भोपाल संधारण खण्ड ',5,'Bhopal'),
 (9,17,1,9,'Bhopal Project Division No. I','भोपाल परियोजना खण्ड क्रमांक I',7,'Bhopal'),
 (10,17,3,2,'Narmada Project  Dn No II','नर्मदा परियोजना खण्ड क्रमांक II',7,'Sehore'),
 (11,17,3,1,'Narmada Project  Dn No I','नर्मदा परियोजना खण्ड क्रमांक I',6,'Bhopal'),
 (12,17,2,1,'Betul','बेतूल',1,'Betul'),
 (13,17,2,2,'Harda','हरदा',1,'Harda'),
 (14,17,2,3,'Hoshangabad','होशंगाबाद',1,'Hoshangabad'),
 (15,17,1,1,'Alirajpur','अलीराजपुर',1,'Alirajpur'),
 (16,17,1,2,'Badwani','बड़वानी',1,'Badwani'),
 (17,17,1,3,'Burhanpur','बुरहानपुर',1,'Burhanpur'),
 (18,17,1,4,'Dhar','धार',1,'Dhar'),
 (19,17,1,5,'Indore','इंदौर',1,'Indore'),
 (20,17,1,6,'Jhabua','झाबुआ',1,'Jhabua'),
 (21,17,1,7,'Khandwa','खंडवा',1,'Khandwa'),
 (22,17,1,8,'Khargone','खरगौन',1,'Khargone'),
 (23,17,1,9,'Quality Control Unit  Sardarpur','गुणवत्ता नियंत्रण इकाई सरदारपुर',4,'Dhar'),
 (24,17,2,1,'Agar','आगर',1,'Agar'),
 (25,17,2,2,'Dewas','देवास',1,'Dewas'),
 (26,17,2,3,'Mandsour','मंदसौर',1,'Mandsour'),
 (27,17,2,4,'Neemuch','नीमच',1,'Neemuch'),
 (28,17,2,5,'Ratlam','रतलाम',1,'Ratlam'),
 (29,17,2,6,'Shajapur','शाजापुर',1,'Shajapur'),
 (30,17,2,7,'Ujjain','उज्जैन',1,'Ujjain'),
 (31,17,2,8,'Ujjain Project ','उज्जैन परियोज़ना ',2,'Ujjain'),
 (32,17,2,9,'Maintenance Ujjain','संधारण उज्जैन ',5,'Ujjain'),
 (33,17,3,1,'Maintenance Indore','संधारण इंदौर',5,'Indore'),
 (34,17,3,2,'Mandeleshwar ','मंडलेश्वर',6,'Khargone'),
 (35,17,1,1,'Ashoknagar','अशोकनगर',1,'Ashoknagar'),
 (36,17,1,2,'Datia','दतिया',1,'Datia'),
 (37,17,1,3,'Guna','गुना',1,'Guna'),
 (38,17,1,4,'Gwalior','ग्वालियर',1,'Gwalior'),
 (39,17,1,5,'Shivpuri','शिवपुरी',1,'Shivpuri'),
 (40,17,1,6,'Project Gwalior','परियोजना ग्वालियर',2,'Gwalior'),
 (41,17,1,7,'Maintenance I  Gwalior','संधारण I ग्वालियर',5,'Gwalior'),
 (42,17,1,8,'Maintenance II  Gwalior','संधारण II ग्वालियर',5,'Gwalior'),
 (43,17,2,1,'Chhatarpur','छतरपुर',1,'Chhatarpur'),
 (44,17,2,2,'Damoh','दमोह',1,'Damoh'),
 (45,17,2,3,'Panna','पन्ना',1,'Panna'),
 (46,17,2,4,'Sagar','सागर',1,'Sagar'),
 (47,17,2,5,'Tikamgarh','टीकमगढ़',1,'Tikamgarh'),
 (48,17,3,1,'Bhind','भिण्ड',1,'Bhind'),
 (49,17,3,2,'Murena','मुरैना',1,'Murena'),
 (50,17,3,3,'Sheopur','श्यौपुर',1,'Sheopur'),
 (51,17,1,1,'Dindori','डिंडोरी',1,'Dindori'),
 (52,17,1,2,'Jabalpur','जबलपुर',1,'Jabalpur'),
 (53,17,1,3,'Katni','कटनी',1,'Katni'),
 (54,17,1,4,'Mandla','मंडला',1,'Mandla'),
 (55,17,1,5,'Narsinghpur','नरसिंहपुर',1,'Narsinghpur'),
 (56,17,2,1,'Rewa','रीवा',1,'Rewa'),
 (57,17,2,2,'Satna','सतना',1,'Satna'),
 (58,17,2,3,'Sidhi','सीधी',1,'Sidhi'),
 (59,17,2,4,'Singroli','सिंगरोली',1,'Singroli'),
 (60,17,3,1,'Anooppur','अनूपपुर',1,'Anooppur'),
 (61,17,3,2,'Shahdol','शहडौल',1,'Shahdol'),
 (62,17,3,3,'Umariya','उमरिया',1,'Umariya'),
 (63,17,4,1,'Balaghat','बालाघाट',1,'Balaghat'),
 (64,17,4,2,'Chhindwara','छिन्दवाड़ा',1,'Chhindwara'),
 (65,17,4,3,'Seoni','सिवनी',1,'Seoni'),
 (66,17,4,4,'Chhindwara Project ','छिन्दवाड़ा परियोजना ',2,'Chhindwara '),
 (67,17,99,1,'Bhopal E&M','भोपाल (वि./यां)',3,'Bhopal'),
 (68,17,99,2,'Gwalior E&M','ग्वालियर (वि./यां)',3,'Gwalior'),
 (69,17,99,3,'Indore E&M','इंदौर  (वि./यां)',3,'Indore'),
 (70,17,99,4,'Jabalpur E&M','जबलपुर  (वि./यां)',3,'Jabalpur'),
 (71,17,99,5,'Rewa E&M','रीवा (वि./यां)',3,'Rewa'),
 (72,17,99,6,'Sagar E&M','सागर  (वि./यां)',3,'Sagar'),
 (73,17,99,7,'Ujjain E&M','उज्जैन  (वि./यां)',3,'Ujjain');
/*!40000 ALTER TABLE `m_division` ENABLE KEYS */;


--
-- Definition of table `m_division_type`
--

DROP TABLE IF EXISTS `m_division_type`;
CREATE TABLE `m_division_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_english` varchar(45) NOT NULL,
  `name_hindi` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_division_type`
--

/*!40000 ALTER TABLE `m_division_type` DISABLE KEYS */;
INSERT INTO `m_division_type` (`id`,`name_english`,`name_hindi`) VALUES 
 (1,'Regular',''),
 (2,'Project',''),
 (3,'E & M',''),
 (4,'Quality Control Unit',''),
 (5,'Maintenance Civil',''),
 (6,'Maintenance E&M',''),
 (7,'MC Project Civil',''),
 (8,'MC Project E&M','');
/*!40000 ALTER TABLE `m_division_type` ENABLE KEYS */;


--
-- Definition of table `m_role`
--

DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_role`
--

/*!40000 ALTER TABLE `m_role` DISABLE KEYS */;
INSERT INTO `m_role` (`id`,`role`) VALUES 
 (1,'Admin'),
 (2,'User');
/*!40000 ALTER TABLE `m_role` ENABLE KEYS */;


--
-- Definition of table `m_sub_division`
--

DROP TABLE IF EXISTS `m_sub_division`;
CREATE TABLE `m_sub_division` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `division_unit_id` int(10) unsigned DEFAULT NULL,
  `state_id` int(10) unsigned DEFAULT NULL,
  `division_id` int(10) unsigned DEFAULT NULL,
  `sub_division_code` int(10) unsigned DEFAULT NULL,
  `name_english` varchar(300) DEFAULT NULL,
  `name_hindi` varchar(300) DEFAULT NULL,
  `sub_division_type_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_sub_division_state` (`state_id`),
  KEY `FK_m_sub_division_div` (`division_id`),
  KEY `FK_m_sub_division_5` (`sub_division_type_id`),
  CONSTRAINT `FK_m_sub_division_5` FOREIGN KEY (`sub_division_type_id`) REFERENCES `m_sub_division_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_sub_division_div` FOREIGN KEY (`division_id`) REFERENCES `m_division` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_sub_division_state` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_sub_division`
--

/*!40000 ALTER TABLE `m_sub_division` DISABLE KEYS */;
INSERT INTO `m_sub_division` (`id`,`division_unit_id`,`state_id`,`division_id`,`sub_division_code`,`name_english`,`name_hindi`,`sub_division_type_id`) VALUES 
 (1,1,17,1,1,'Berasia','',1),
 (2,1,17,1,2,'Bhopal ','',2),
 (3,2,17,2,1,'Badi ','',3),
 (4,2,17,2,2,'Bagumgunj ','',4),
 (5,2,17,2,3,'Obedullaganj ','',5),
 (6,2,17,2,4,'Raisen','',6),
 (7,3,17,3,1,'Khilchipur  ','',7),
 (8,3,17,3,2,'Narsingarh ','',8),
 (9,3,17,3,3,'Rajgarh ','',9),
 (10,4,17,4,1,'Astha ','',10),
 (11,4,17,4,2,'Budni ','',11),
 (12,4,17,4,3,'Nasurallaganj','',12),
 (13,4,17,4,4,'Sehore ','',13),
 (14,5,17,5,1,'Ganj Basoda','',14),
 (15,5,17,5,2,'Gyaraspur ','',15),
 (16,5,17,5,3,'Vidisha','',16),
 (17,5,17,5,4,'Sironj ','',17),
 (18,6,17,6,1,'Capital Pr.Sub Dn No. 5 Bhopal','',2),
 (19,6,17,6,2,'Capital Pr.Sub Dn No. 6 Bhopal','',2),
 (20,6,17,6,3,'Capital Pr.Sub Dn No. 8, Bhopal','',2),
 (21,7,17,7,1,'Quality Control Unit  Sub Dn No. 2  Bhopal','',4),
 (22,8,17,8,1,'Maintenance Sub Dn No. 1  Bhopal','',5),
 (23,8,17,8,2,'Maintenance Sub Dn No. 2  Bhopal','',5),
 (24,8,17,8,3,'Maintenance E&M Sub Dn No. 3  Bhopal ','',6),
 (25,8,17,8,4,'Maintenance Sub Dn No. 4. Bhopal','',5),
 (26,9,17,9,1,'Project Sub Dn No. 1. Bhopal','',7),
 (27,9,17,9,2,'Project E&M Sub Dn No. 2. Bhopal ','',8),
 (28,9,17,9,3,'Project Sub Dn No. 3  Bhopal','',7),
 (29,11,17,1,1,'Narmada Project Sub Dn No 3 Bhopal','',2),
 (30,11,17,1,2,'Narmada Project Sub Dn No I Shahganj','',7),
 (31,10,17,2,1,'Narmada Project Sub Dn No 2 Shahganj','',7),
 (32,10,17,2,2,'Narmada Project E&M Sub Dn No 3 Shahganj ','',8),
 (33,12,17,1,1,'Betul ','',1),
 (34,12,17,1,2,'Bhesdehi','',1),
 (35,12,17,1,3,'Chicholi','',1),
 (36,12,17,1,4,'Multai ','',1),
 (37,12,17,1,5,'Shahpur','',1),
 (38,13,17,2,1,'Harda','',1),
 (39,14,17,3,1,'Hoshangabad','',1),
 (40,14,17,3,2,'Pipariya ','',1),
 (41,14,17,3,3,'Seoni Malwa','',1),
 (42,14,17,3,4,'Sohagpur','',1),
 (43,15,17,1,1,'Alirajpur','',1),
 (44,15,17,1,2,'Bhamara,','',1),
 (45,15,17,1,3,'Flourisis Prj Sub Dn.No. 1 Alirajpur','',2),
 (46,15,17,1,4,'Jobat','',1),
 (47,16,17,2,1,'Badwani,','',1),
 (48,17,17,2,2,'Sendhwa, ','',1),
 (49,17,17,3,1,'Burhanpur','',1),
 (50,17,17,3,2,'Nepanagar','',1),
 (51,18,17,4,1,'Dhar,','',1),
 (52,18,17,4,5,'Dharampuri','',1),
 (53,18,17,4,2,'Manawar','',1),
 (54,18,17,4,3,'Nisarpur,','',1),
 (55,18,17,4,4,'Sardarpur, ','',1),
 (56,19,17,5,1,'Indore ','',1),
 (57,19,17,5,2,'Moho ','',1),
 (58,20,17,6,1,'Jhabua','',1),
 (59,20,17,6,2,'Thandla','',1),
 (60,21,17,7,1,'Harsood ','',1),
 (61,21,17,7,2,'Khandwa','',1),
 (62,21,17,7,3,'Pandhana','',1),
 (63,22,17,8,1,'Badhwaha','',1),
 (64,22,17,8,2,'Bhikangaon','',1),
 (65,22,17,8,3,'Kasarawad ','',1),
 (66,22,17,8,4,'Khargone','',1),
 (67,23,17,9,1,'Quality Control Unit  Sub Dn. Kukshi','',4),
 (68,23,17,9,2,'Quality Control Unit  Sub Dn. Petlawad','',4),
 (69,23,17,9,3,'Quality Control Unit  Sub Dn. Sardarpur','',4),
 (70,24,17,1,1,'Agar','',1),
 (71,25,17,2,1,'Bagali','',1),
 (72,25,17,2,2,'Dewas','',1),
 (73,25,17,2,3,'Kannod','',1),
 (74,25,17,2,4,'Maintenance Bank Note Press  Sub Dn. Dewas ','',5),
 (75,26,17,3,1,'Bhanpura','',1),
 (76,26,17,3,2,'Mandsour','',1),
 (77,27,17,4,1,'Manasa','',1),
 (78,27,17,4,2,'Neemuch','',1),
 (79,28,17,5,1,'Jawara','',1),
 (80,28,17,5,2,'Maintenance  E&M Sub Dn. Ratlam','',6),
 (81,28,17,5,3,'Ratlam','',1),
 (82,28,17,5,4,'Salana','',1),
 (83,29,17,6,1,'Shajapur','',1),
 (84,29,17,6,2,'Shujalpur','',1),
 (85,30,17,7,1,'Khachrod','',1),
 (86,30,17,7,2,'Tarana','',1),
 (87,30,17,7,3,'Ujjain','',1),
 (88,31,17,8,1,'Ujjain Project, Sub Dn Ujjain','',2),
 (89,32,17,9,1,'Maintenance Sub Dn No. 1, Ujjain','',5),
 (90,32,17,9,2,'Maintenance Sub Dn No. 2, Ujjain','',5),
 (91,32,17,9,3,'Maintenance Sub Dn No. 3, Ujjain','',5),
 (92,33,17,1,1,'Maintenance Sub Dn No. 4, Moho','',5),
 (93,33,17,1,2,'Maintenance Sub Dn No. 5, Indore','',5),
 (94,33,17,1,3,'Maintenance Sub Dn No. 6, Indore','',5),
 (95,33,17,1,4,'Maintenance Sub Dn No. 7, Indore','',5),
 (96,33,17,1,5,'Maintenance Sub Dn No. 8, Indore','',5),
 (97,34,17,2,1,'Maintenance  (E&M)  Sub Dn No1.Mandleshwar','',6),
 (98,34,17,2,2,'Maintenance  (E&M)  Sub Dn No2. Mandleshwar','',6),
 (99,34,17,2,3,'Maintenance Sub Dn No3. Mandleshwar','',5),
 (100,35,17,1,1,'Ashoknagar','',1),
 (101,35,17,1,2,'Mungawali,i','',1),
 (102,35,17,1,3,'Project Sub Dn. Chanderi','',2),
 (103,36,17,2,1,'Datiya ','',1),
 (104,37,17,3,1,'Guna','',1),
 (105,37,17,3,2,'Raghogarh','',1),
 (106,38,17,4,1,'Dabra','',1),
 (107,38,17,4,2,'Gwalior','',1),
 (108,39,17,5,1,'Karera ','',1),
 (109,39,17,5,2,'Kolaras','',1),
 (110,39,17,5,3,'Pichhore','',1),
 (111,39,17,5,4,'Project Sub Dn. Shivpuri','',2),
 (112,39,17,5,5,'Shivpuri','',1),
 (113,40,17,6,1,'Project Sub Dn.No. 2 Gwalior','',2),
 (114,40,17,6,2,'Project Sub Dn.No. 3 Drainage  Gwalior','',2),
 (115,41,17,7,1,'Maintenance  Sub Dn.No 4  Gwalior Noorganj','',5),
 (116,41,17,7,2,'Maintenance  Sub Dn.No.1  Gwalior','',5),
 (117,41,17,7,3,'Maintenance  Sub Dn.No.2 Gwalior Lashkar','',5),
 (118,41,17,7,4,'Maintenance  Sub Dn.No.3  Gwalior Murar','',5),
 (119,41,17,8,1,'Maintenance  E&M  Sub Dn.Motijheel   Gwalior','',6),
 (120,42,17,8,2,'Maintenance  Sub Dn.Motijheel   Gwalior','',5),
 (121,43,17,1,1,'Bada Malahara','',1),
 (122,43,17,1,2,'Chhatarpur','',1),
 (123,43,17,1,3,'Loundi','',1),
 (124,43,17,1,4,'Now gaon','',1),
 (125,44,17,2,1,'Damoh','',1),
 (126,44,17,2,2,'Hata','',1),
 (127,44,17,2,3,'Tendukheda','',1),
 (128,45,17,3,1,'Panna','',1),
 (129,45,17,3,2,'Pawai','',1),
 (130,46,17,4,1,'Banda','',1),
 (131,46,17,4,2,'Deori','',1),
 (132,46,17,4,3,'Khurai','',1),
 (133,47,17,4,6,'Project Sub Dn. Sagar','',2),
 (134,46,17,4,4,'Rahatgarh','',1),
 (135,46,17,4,5,'Sagar','',1),
 (136,47,17,5,1,'Jatara','',1),
 (137,47,17,5,2,'Niwari','',1),
 (138,47,17,5,3,'Tikamgarh','',1),
 (139,48,17,1,1,'Bhind','',1),
 (140,48,17,1,2,'Gohad','',1),
 (141,48,17,1,3,'Lahar','',1),
 (142,49,17,2,1,'Ambaha','',1),
 (143,49,17,2,2,'Morena','',1),
 (144,49,17,2,3,'Sabalgarh','',1),
 (145,50,17,3,1,'Sheopur','',1),
 (146,50,17,3,2,'Vijaypur','',1),
 (147,51,17,1,1,'Dindori ','',1),
 (148,51,17,1,2,'Samanapur','',1),
 (149,51,17,1,3,'Shahpur ','',1),
 (150,52,17,2,1,'Jabalpur','',1),
 (151,52,17,2,2,'Kundam','',1),
 (152,52,17,2,3,'Maintenance   E&M Sub Dn. No.1 Jabalpur','',6),
 (153,52,17,2,4,'Project  Sub Dn. No.3 Jabalpur','',2),
 (154,52,17,2,5,'Sihora','',1),
 (155,53,17,3,2,'Katni','',1),
 (156,53,17,3,3,'Slimnabad','',1),
 (157,53,17,3,1,'Vijay Raghogarh','',1),
 (158,54,17,4,1,'Mandla','',1),
 (159,54,17,4,2,'Nainpur','',1),
 (160,54,17,4,3,'Narayan ganj','',1),
 (161,54,17,4,4,'Niwas','',1),
 (162,55,17,5,1,'Gadarwara','',1),
 (163,55,17,5,2,'Kareli ','',1),
 (164,55,17,5,3,'Narsinghpur','',1),
 (165,56,17,1,1,'Huzur','',1),
 (166,56,17,1,2,'Mauganj','',1),
 (167,56,17,1,3,'Project Sub Dn. Rewa','',2),
 (168,56,17,1,4,'Rewa','',1),
 (169,56,17,1,5,'Sirmor','',1),
 (170,56,17,1,6,'Teonthar','',1),
 (171,57,17,2,1,'Amarpatan','',1),
 (172,57,17,2,2,'Maihar','',1),
 (173,57,17,2,3,'Maintenance','',5),
 (174,57,17,2,4,'Majhgawa','',1),
 (175,57,17,2,5,'Satna','',1),
 (176,58,17,3,1,'Churhat','',1),
 (177,58,17,3,2,'Majholi','',1),
 (178,58,17,3,3,'Sidhi','',1),
 (179,59,17,4,1,'Badhan','',1),
 (180,59,17,4,2,'Deosar','',1),
 (181,60,17,1,1,'Anooppur','',1),
 (182,60,17,1,2,'Rajendragrm','',1),
 (183,61,17,2,1,'Beohari','',1),
 (184,61,17,2,2,'Budhar','',1),
 (185,61,17,2,3,'Shahdol','',1),
 (186,62,17,3,1,'Umaria','',1),
 (187,63,17,1,2,'Baihar','',1),
 (188,63,17,1,3,'Balaghat','',1),
 (189,63,17,1,4,'Bara seoni','',1),
 (190,63,17,1,5,'Katangi','',1),
 (191,63,17,1,6,'Langi','',1),
 (192,63,17,1,1,' Lalbarra Project, Sub Dn. Balaghat','',2),
 (193,64,17,2,2,'Amarwada','',1),
 (194,64,17,2,3,'Chhindwara','',1),
 (195,64,17,2,1,'Chourai','',1),
 (196,64,17,2,4,'Jamai','',1),
 (197,64,17,2,5,'Parasia','',1),
 (198,64,17,2,6,'Sonsar','',1),
 (199,65,17,3,1,'Chapaara','',1),
 (200,65,17,3,2,'Kewalari','',1),
 (201,65,17,3,3,'Lakhanadon','',1),
 (202,65,17,3,4,'Seoni','',1),
 (203,66,17,4,1,'Project Sub Dn. No. 1 Chhindwara','',2),
 (204,66,17,4,2,'Project Sub Dn. No. 2 Chhindwara','',2),
 (205,67,17,1,1,'Betul E&M  ','',3),
 (206,67,17,1,2,'Bhopal E&M  ','',3),
 (207,67,17,1,3,'Harda E&M  ','',3),
 (208,67,17,1,4,'Hoshangabad E&M  ','',3),
 (209,67,17,1,5,'Raisen E&M  ','',3),
 (210,67,17,1,6,'Rajgarh E&M  ','',3),
 (211,67,17,1,7,'Sehore E&M  ','',3),
 (212,67,17,1,8,'Vidisha E&M  ','',3),
 (213,68,17,2,1,'Bhind E&M  ','',3),
 (214,68,17,2,2,'Datia E&M  ','',3),
 (215,68,17,2,3,'Guna E&M  ','',3),
 (216,68,17,2,4,'Gwalior E&M  ','',3),
 (217,68,17,2,5,'Murena E&M  ','',3),
 (218,68,17,2,6,'Sheopur E&M  ','',3),
 (219,68,17,2,7,'Shivpuri E&M  ','',3),
 (220,69,17,3,1,'Badwani E&M  ','',3),
 (221,69,17,3,2,'Dhar E&M  ','',3),
 (222,69,17,3,3,'Indore E&M  ','',3),
 (223,69,17,3,4,'Jhabua E&M  ','',3),
 (224,69,17,3,5,'Khandwa E&M  ','',3),
 (225,69,17,3,6,'Khargone E&M  ','',3),
 (226,70,17,4,1,'Balaghat E&M  ','',3),
 (227,70,17,4,2,'Chhindwara E&M  ','',3),
 (228,70,17,4,3,'Dindori E&M  ','',3),
 (229,70,17,4,4,'Jabalpur E&M  ','',3),
 (230,70,17,4,5,'Katni E&M  ','',3),
 (231,70,17,4,6,'Mandla E&M  ','',3),
 (232,70,17,4,7,'Narsinghpur E&M  ','',3),
 (233,70,17,4,8,'Seoni E&M  ','',3),
 (234,71,17,5,1,'Rewa E&M  ','',3),
 (235,71,17,5,2,'Satna E&M  ','',3),
 (236,71,17,5,3,'Shahdol E&M  ','',3),
 (237,71,17,5,4,'Sidhi E&M  ','',3),
 (238,71,17,5,5,'Singroli E&M  ','',3),
 (239,71,17,5,6,'Umariya E&M  ','',3),
 (240,72,17,6,1,'Chhatarpur E&M  ','',3),
 (241,72,17,6,2,'Damoh E&M  ','',3),
 (242,72,17,6,3,'Panna E&M  ','',3),
 (243,72,17,6,4,'Sagar E&M  ','',3),
 (244,72,17,6,5,'Tikamgarh E&M  ','',3),
 (245,73,17,7,1,'Dewas E&M  ','',3),
 (246,73,17,7,2,'Mandsour E&M  ','',3),
 (247,73,17,7,3,'Neemuch E&M  ','',3),
 (248,73,17,7,4,'Ratlam E&M  ','',3),
 (249,73,17,7,5,'Shajapur E&M  ','',3),
 (250,73,17,7,6,'Ujjain E&M  ','',3);
/*!40000 ALTER TABLE `m_sub_division` ENABLE KEYS */;


--
-- Definition of table `m_sub_division_type`
--

DROP TABLE IF EXISTS `m_sub_division_type`;
CREATE TABLE `m_sub_division_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_english` varchar(100) DEFAULT NULL,
  `name_hindi` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_sub_division_type`
--

/*!40000 ALTER TABLE `m_sub_division_type` DISABLE KEYS */;
INSERT INTO `m_sub_division_type` (`id`,`name_english`,`name_hindi`) VALUES 
 (1,'Regular',''),
 (2,'Project',''),
 (3,'E & M',''),
 (4,'Quality Control Unit',''),
 (5,'Maintenance Civil',''),
 (6,'Maintenance E&M',''),
 (7,'MC Project Civil',''),
 (8,'MC Project E&M',''),
 (9,NULL,NULL),
 (10,NULL,NULL),
 (11,NULL,NULL),
 (12,NULL,NULL),
 (13,NULL,NULL),
 (14,NULL,NULL),
 (15,NULL,NULL),
 (16,NULL,NULL),
 (17,NULL,NULL);
/*!40000 ALTER TABLE `m_sub_division_type` ENABLE KEYS */;


--
-- Definition of table `m_user_lavel`
--

DROP TABLE IF EXISTS `m_user_lavel`;
CREATE TABLE `m_user_lavel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_type` varchar(100) DEFAULT NULL,
  `level` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_user_lavel`
--

/*!40000 ALTER TABLE `m_user_lavel` DISABLE KEYS */;
INSERT INTO `m_user_lavel` (`id`,`user_type`,`level`) VALUES 
 (1,'secretary',1),
 (2,'Engineer in chief',2),
 (3,'zone',3),
 (4,'circle',4),
 (5,'division',5),
 (6,'sub division',6);
/*!40000 ALTER TABLE `m_user_lavel` ENABLE KEYS */;


--
-- Definition of table `m_zone`
--

DROP TABLE IF EXISTS `m_zone`;
CREATE TABLE `m_zone` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state_id` int(10) unsigned DEFAULT NULL,
  `name_english` varchar(45) DEFAULT NULL,
  `name_hindi` varchar(45) DEFAULT NULL,
  `zone_type_id` int(10) unsigned DEFAULT NULL,
  `zone_hq` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_zone_state` (`state_id`),
  KEY `FK_m_zone_type` (`zone_type_id`),
  CONSTRAINT `FK_m_zone_state` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_m_zone_type` FOREIGN KEY (`zone_type_id`) REFERENCES `m_zone_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_zone`
--

/*!40000 ALTER TABLE `m_zone` DISABLE KEYS */;
INSERT INTO `m_zone` (`id`,`state_id`,`name_english`,`name_hindi`,`zone_type_id`,`zone_hq`) VALUES 
 (1,17,'Bhopal','भोपाल',1,'Bhopal'),
 (2,17,'Indore','इंदोर',1,'Indore'),
 (3,17,'Gwalior','ग्वालियर',1,'Gwalior'),
 (4,17,'Jabalpur','जबलपुर',1,'Jabalpur'),
 (5,17,'Bhopal E & M','भोपाल वि.यां.',2,'Bhopal');
/*!40000 ALTER TABLE `m_zone` ENABLE KEYS */;


--
-- Definition of table `m_zone_type`
--

DROP TABLE IF EXISTS `m_zone_type`;
CREATE TABLE `m_zone_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_english` varchar(45) NOT NULL,
  `name_hindi` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `m_zone_type`
--

/*!40000 ALTER TABLE `m_zone_type` DISABLE KEYS */;
INSERT INTO `m_zone_type` (`id`,`name_english`,`name_hindi`) VALUES 
 (1,'Regular',''),
 (2,'E & M','');
/*!40000 ALTER TABLE `m_zone_type` ENABLE KEYS */;


--
-- Definition of table `petitioner_name`
--

DROP TABLE IF EXISTS `petitioner_name`;
CREATE TABLE `petitioner_name` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` int(10) unsigned DEFAULT NULL,
  `petitioner_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_petitioner_name_case` (`case_id`),
  CONSTRAINT `FK_petitioner_name_case` FOREIGN KEY (`case_id`) REFERENCES `case_registration` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `petitioner_name`
--

/*!40000 ALTER TABLE `petitioner_name` DISABLE KEYS */;
INSERT INTO `petitioner_name` (`id`,`case_id`,`petitioner_name`) VALUES 
 (4,33,'nitesh'),
 (5,36,'hameediya'),
 (6,37,'golu1'),
 (7,37,'golu2'),
 (8,38,'dinesh'),
 (9,38,'rajiv'),
 (10,38,'ravi'),
 (11,39,'jeet'),
 (12,39,'jitu'),
 (13,39,'jeetendra'),
 (14,40,'a'),
 (15,40,'b'),
 (16,40,'c'),
 (17,41,'q'),
 (18,41,'w'),
 (19,41,'e'),
 (20,42,'ram ji'),
 (21,42,'shyam ji'),
 (22,42,'shyam ji'),
 (23,43,'Arvindra'),
 (24,43,'Ramesh'),
 (25,44,'rj'),
 (26,44,'kj'),
 (27,45,'asdasd'),
 (28,46,'asdasd'),
 (29,47,'asd');
/*!40000 ALTER TABLE `petitioner_name` ENABLE KEYS */;


--
-- Definition of table `respons_hearing_date`
--

DROP TABLE IF EXISTS `respons_hearing_date`;
CREATE TABLE `respons_hearing_date` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `respons_date` date DEFAULT NULL,
  `hearing_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `respons_hearing_date`
--

/*!40000 ALTER TABLE `respons_hearing_date` DISABLE KEYS */;
INSERT INTO `respons_hearing_date` (`id`,`respons_date`,`hearing_date`) VALUES 
 (1,'2019-07-10','2019-07-12'),
 (2,'2019-07-18','2019-07-24'),
 (3,'2019-07-19','2019-07-19'),
 (4,'2019-07-25','2019-07-12'),
 (10,'2019-07-06','2019-07-19'),
 (11,'2019-07-18','2019-07-11'),
 (12,'2019-07-19','2019-07-27'),
 (13,'2019-07-19','2019-07-23'),
 (14,'2019-07-26','2019-07-25'),
 (15,'2019-07-05','2019-07-06'),
 (16,'2019-07-04','2019-07-12'),
 (17,'2019-07-06','2019-07-07'),
 (18,'2019-07-05','2019-07-06'),
 (19,'2019-07-01','2019-07-02'),
 (20,'2019-07-05','2019-07-06'),
 (21,'2019-07-30','2019-07-29'),
 (22,'2019-07-30','2019-07-29'),
 (23,'2019-07-30','2019-07-29'),
 (24,'2019-07-05','2019-07-05'),
 (25,'2019-07-05','2019-07-05'),
 (26,'2019-07-05','2019-07-06'),
 (27,'2019-07-06','2019-07-13'),
 (28,'2019-07-05','2019-07-06'),
 (29,'2019-07-05','2019-07-06'),
 (30,'2019-07-05','2019-07-06'),
 (31,'2019-07-05','2019-07-06'),
 (32,'2019-07-05','2019-07-06'),
 (33,'2019-07-05','2019-07-06'),
 (34,'2019-07-05','2019-07-06'),
 (35,'2019-07-05','2019-07-06'),
 (36,'2019-07-05','2019-07-06'),
 (37,'2019-07-05','2019-07-06'),
 (38,'2019-07-05','2019-07-06'),
 (39,'2019-07-05','2019-07-06'),
 (40,'2019-07-05','2019-07-06'),
 (41,'2019-07-05','2019-07-06');
/*!40000 ALTER TABLE `respons_hearing_date` ENABLE KEYS */;


--
-- Definition of table `respons_hearing_date_old`
--

DROP TABLE IF EXISTS `respons_hearing_date_old`;
CREATE TABLE `respons_hearing_date_old` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `respons_date` date DEFAULT NULL,
  `hearing_date` date DEFAULT NULL,
  `case_id` int(10) unsigned DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `respons_hearing_date_old`
--

/*!40000 ALTER TABLE `respons_hearing_date_old` DISABLE KEYS */;
INSERT INTO `respons_hearing_date_old` (`id`,`respons_date`,`hearing_date`,`case_id`,`updated_date`) VALUES 
 (1,'2019-07-30','2019-07-29',42,'2019-07-06 16:52:09'),
 (2,'2019-07-30','2019-07-29',42,'2019-07-06 16:54:27'),
 (3,'2019-07-05','2019-07-05',43,'2019-07-07 17:15:34'),
 (4,'2019-07-05','2019-07-05',43,'2019-07-07 17:20:28'),
 (5,'2019-07-05','2019-07-06',44,'2019-07-07 17:54:17'),
 (6,'2019-07-06','2019-07-13',45,'2019-07-07 18:04:35'),
 (7,'2019-07-05','2019-07-06',46,'2019-07-08 10:11:16'),
 (8,'2019-07-05','2019-07-06',47,'2019-07-08 10:14:10'),
 (9,'2019-07-05','2019-07-06',47,'2019-07-08 10:24:27'),
 (10,'2019-07-05','2019-07-06',47,'2019-07-08 10:32:20'),
 (11,'2019-07-05','2019-07-06',47,'2019-07-08 10:34:46'),
 (12,'2019-07-05','2019-07-06',47,'2019-07-08 10:44:17'),
 (13,'2019-07-05','2019-07-06',47,'2019-07-08 10:47:06'),
 (14,'2019-07-05','2019-07-06',47,'2019-07-08 11:10:28'),
 (15,'2019-07-05','2019-07-06',47,'2019-07-08 11:13:25'),
 (16,'2019-07-05','2019-07-06',47,'2019-07-08 11:22:26'),
 (17,'2019-07-05','2019-07-06',47,'2019-07-08 11:22:56'),
 (18,'2019-07-05','2019-07-06',47,'2019-07-08 11:23:28'),
 (19,'2019-07-05','2019-07-06',47,'2019-07-08 15:55:50'),
 (20,'2019-07-05','2019-07-06',47,'2019-07-08 15:58:36');
/*!40000 ALTER TABLE `respons_hearing_date_old` ENABLE KEYS */;


--
-- Definition of table `state`
--

DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `state`
--

/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`id`,`name`) VALUES 
 (17,'madhya pradesh');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;


--
-- Definition of table `systems_admin_type`
--

DROP TABLE IF EXISTS `systems_admin_type`;
CREATE TABLE `systems_admin_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systems_admin_type`
--

/*!40000 ALTER TABLE `systems_admin_type` DISABLE KEYS */;
INSERT INTO `systems_admin_type` (`id`,`type`) VALUES 
 (1,'secretary'),
 (2,'Engineer in chief');
/*!40000 ALTER TABLE `systems_admin_type` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(300) DEFAULT NULL,
  `user_id` varchar(300) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `lavel_id` int(10) unsigned DEFAULT NULL,
  `role` int(10) unsigned DEFAULT NULL,
  `zone_id` int(10) unsigned DEFAULT NULL,
  `circle_id` int(10) unsigned DEFAULT NULL,
  `division_id` int(10) unsigned DEFAULT NULL,
  `sub_division_id` int(10) unsigned DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `parent_id` int(10) unsigned DEFAULT NULL,
  `supervisor_id` int(10) unsigned DEFAULT NULL,
  `designation_id` int(10) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `updated_by` int(10) unsigned DEFAULT NULL,
  `systems_admin_type_id` int(10) unsigned DEFAULT NULL,
  `path` text,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_lavel` (`lavel_id`),
  KEY `FK_user_role` (`role`),
  KEY `FK_user_zone` (`zone_id`),
  KEY `FK_user_circle` (`circle_id`),
  KEY `FK_user_division` (`division_id`),
  KEY `FK_user_sub_div` (`sub_division_id`),
  KEY `FK_user_parent` (`parent_id`),
  KEY `FK_user_supervisor` (`supervisor_id`),
  KEY `FK_user_designation` (`designation_id`),
  KEY `FK_user_sysadmin` (`systems_admin_type_id`),
  CONSTRAINT `FK_user_circle` FOREIGN KEY (`circle_id`) REFERENCES `m_circle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_designation` FOREIGN KEY (`designation_id`) REFERENCES `m_designation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_division` FOREIGN KEY (`division_id`) REFERENCES `m_division` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_lavel` FOREIGN KEY (`lavel_id`) REFERENCES `m_user_lavel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_parent` FOREIGN KEY (`parent_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_role` FOREIGN KEY (`role`) REFERENCES `m_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_sub_div` FOREIGN KEY (`sub_division_id`) REFERENCES `m_sub_division` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_supervisor` FOREIGN KEY (`supervisor_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_sysadmin` FOREIGN KEY (`systems_admin_type_id`) REFERENCES `systems_admin_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_zone` FOREIGN KEY (`zone_id`) REFERENCES `m_zone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`user_name`,`user_id`,`password`,`lavel_id`,`role`,`zone_id`,`circle_id`,`division_id`,`sub_division_id`,`mobile`,`parent_id`,`supervisor_id`,`designation_id`,`created_date`,`updated_date`,`created_by`,`updated_by`,`systems_admin_type_id`,`path`,`deleted`) VALUES 
 (1,'admin','admin@gmail.com','MTIzNDU=',1,1,NULL,NULL,NULL,NULL,'9893452352',2,2,1,NULL,NULL,NULL,NULL,1,'http://cinfysystems.com/digilibrary/WATER/PROFILE_IMAGE/1562574920099_a.jpg',0),
 (2,'admin2','admin2@gmail.com','MTIzNDU=',2,1,1,1,1,1,'9893452351',1,1,1,NULL,NULL,NULL,NULL,1,'http://cinfysystems.com/digilibrary/WATER/PROFILE_IMAGE/1562574920099_a.jpg',0),
 (3,'jeet','jeetendra.pathak.88@gmail.com','MTIzNDU=',2,1,1,1,5,14,'9074586074',1,2,1,NULL,'2019-07-08 14:05:18',NULL,NULL,2,'http://cinfysystems.com/digilibrary/WATER/PROFILE_IMAGE/1562574920099_a.jpg',0),
 (6,'jeetendra pathak','jeet@gmail.com','SmVldEAxMjM=',3,2,2,NULL,NULL,NULL,'9074586033',1,2,3,'2019-07-09 12:00:03','2019-07-09 12:00:03',1,1,2,'http://cinfysystems.com/digilibrary/WATER/PROFILE_IMAGE/1562653804741_img-16.jpg',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
