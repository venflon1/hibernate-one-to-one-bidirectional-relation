# Delete database named "hb-01-one-to-one-uni" if it exist
DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

# Create a database named "hb-01-one-to-one-uni"
CREATE SCHEMA `hb-01-one-to-one-uni`;

# Setting database named "hb-01-one-to-one-uni" to use for follow operations
use `hb-01-one-to-one-uni`;

SET FOREIGN_KEY_CHECKS = 0;

# Delete db_table "instructor_detail" if it exist
DROP TABLE IF EXISTS `instructor_detail`;

# Create db_table named "instructor_detail"
CREATE TABLE `instructor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# Delete db_table "instructor" if it exist
DROP TABLE IF EXISTS `instructor`;

# Create db_table named "instructor"
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int(11) DEFAULT NULL,
 
  PRIMARY KEY (`id`), 
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
