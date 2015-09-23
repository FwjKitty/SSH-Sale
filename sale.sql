/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.28 : Database - sale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sale` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sale1`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `address_line1` varchar(100) DEFAULT NULL,
  `address_line2` varchar(100) DEFAULT NULL,
  `postcode` varchar(15) NOT NULL,
  `port_of_destination` varchar(20) NOT NULL,
  `shipping_mark` varchar(100) NOT NULL,
  `status` varchar(15) NOT NULL DEFAULT '待确认',
  `inactive_date` date DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `address` */


/*Table structure for table `contactors` */

DROP TABLE IF EXISTS `contactors`;

CREATE TABLE `contactors` (
  `contactors_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `MailFrom` varchar(50) DEFAULT NULL,
  `PrePO_MailTo` varchar(200) DEFAULT NULL,
  `PO_MailTo` varchar(200) DEFAULT NULL,
  `OCPI_MailTo` varchar(200) DEFAULT NULL,
  `INV_Pklist_mailto` varchar(200) DEFAULT NULL,
  `customer_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`contactors_id`),
  KEY `fk_contactors_custom` (`customer_id`),
  CONSTRAINT `fk_contactors_custom` FOREIGN KEY (`customer_id`) REFERENCES `customers_info` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contactors` */

/*Table structure for table `customers_info` */

DROP TABLE IF EXISTS `customers_info`;

CREATE TABLE `customers_info` (
  `customer_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_code` varchar(10) NOT NULL,
  `customer_name` varchar(120) NOT NULL,
  `type` varchar(8) NOT NULL,
  `group_company` varchar(10) DEFAULT NULL,
  `corporation` varchar(10) DEFAULT NULL,
  `address_id` int(11) unsigned NOT NULL,
  `organization_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_customers_info_address` (`address_id`),
  KEY `fk_customers_info_origanization` (`organization_id`),
  CONSTRAINT `fk_customers_info_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_customers_info_origanization` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `customers_info` */


/*Table structure for table `discount_applied_records` */

DROP TABLE IF EXISTS `discount_applied_records`;

CREATE TABLE `discount_applied_records` (
  `record_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `discount_id` int(11) unsigned NOT NULL,
  `discount_name` varchar(30) NOT NULL,
  `customer_code` varchar(10) NOT NULL,
  `adn_identify_num` varchar(30) NOT NULL,
  `applied_amount` decimal(10,0) NOT NULL,
  `applied_date` date NOT NULL,
  `cancel` int(11) DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `fk_discount_applied_records_special_discount` (`discount_id`),
  CONSTRAINT `fk_discount_applied_records_special_discount` FOREIGN KEY (`discount_id`) REFERENCES `special_discount` (`discount_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `discount_applied_records` */


/*Table structure for table `normal_discount` */

DROP TABLE IF EXISTS `normal_discount`;

CREATE TABLE `normal_discount` (
  `normal_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `discount_base` varchar(8) NOT NULL,
  `Base_qty` int(11) DEFAULT NULL,
  `discount_rate` decimal(11,2) NOT NULL,
  `activity` varchar(8) DEFAULT '是',
  PRIMARY KEY (`normal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `normal_discount` */



/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `organization_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `market_area` varchar(10) NOT NULL,
  `business_manager` varchar(15) NOT NULL,
  `business_assistant` varchar(15) NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `organization` */


/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `payment_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `invoice_group` varchar(20) DEFAULT NULL,
  `currency` varchar(3) NOT NULL,
  `payment_term` varchar(120) NOT NULL,
  `price_term1` varchar(100) DEFAULT NULL,
  `price_term2` varchar(100) DEFAULT NULL,
  `price_term3` varchar(100) DEFAULT NULL,
  `markup_name` varchar(20) NOT NULL,
  `discount_name` varchar(20) NOT NULL,
  `customer_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `fk_pay_customer` (`customer_id`),
  CONSTRAINT `fk_pay_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers_info` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payment` */

/*Table structure for table `price_list` */

DROP TABLE IF EXISTS `price_list`;

CREATE TABLE `price_list` (
  `price_list_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL,
  `type` varchar(8),
  `hy_item` varchar(20) NOT NULL,
  `effective_date_from` date DEFAULT NULL,
  `effective_date_to` date DEFAULT NULL,
  `user_def1` varchar(20) DEFAULT NULL,
  `user_def2` varchar(20) DEFAULT NULL,
  `user_def3` varchar(20) DEFAULT NULL,
  `user_def4` varchar(20) DEFAULT NULL,
  `user_def5` varchar(20) DEFAULT NULL,
  `user_def6` varchar(20) DEFAULT NULL,
  `user_def7` varchar(20) DEFAULT NULL,
  `user_def8` varchar(20) DEFAULT NULL,
  `user_def9` varchar(20) DEFAULT NULL,
  `user_def10` varchar(20) DEFAULT NULL,
  `user_def11` varchar(20) DEFAULT NULL,
  `user_def12` varchar(20) DEFAULT NULL,
  `user_def13` varchar(20) DEFAULT NULL,
  `user_def14` varchar(20) DEFAULT NULL,
  `user_def15` varchar(20) DEFAULT NULL,
  `user_def16` varchar(20) DEFAULT NULL,
  `user_def17` varchar(20) DEFAULT NULL,
  `user_def18` varchar(20) DEFAULT NULL,
  `user_def19` varchar(20) DEFAULT NULL,
  `user_def20` varchar(20) DEFAULT NULL,
  `user_def21` varchar(20) DEFAULT NULL,
  `user_def22` varchar(20) DEFAULT NULL,
  `user_def23` varchar(20) DEFAULT NULL,
  `user_def24` varchar(20) DEFAULT NULL,
  `user_def25` varchar(20) DEFAULT NULL,
  `user_def26` varchar(20) DEFAULT NULL,
  `user_def27` varchar(20) DEFAULT NULL,
  `user_def28` varchar(20) DEFAULT NULL,
  `user_def29` varchar(20) DEFAULT NULL,
  `user_def30` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`price_list_id`),
  KEY `fk_price_list_customers_info` (`customer_id`),
  CONSTRAINT `fk_price_list_customers_info` FOREIGN KEY (`customer_id`) REFERENCES `customers_info` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `price_list` */

/*Table structure for table `price_list_config` */

DROP TABLE IF EXISTS `price_list_config`;

CREATE TABLE `price_list_config` (
  `price_list_config_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL,
  `type` varchar(8),
  `display_name` varchar(20) DEFAULT NULL,
  `price_list_col` varchar(30) NOT NULL,
  `excel_col` int(3) DEFAULT NULL,
  `activity` enum('否','是') NOT NULL,
  PRIMARY KEY (`price_list_config_id`),
  KEY `fk_price_list_config_customers_info` (`customer_id`),
  CONSTRAINT `fk_price_list_config_customers_info` FOREIGN KEY (`customer_id`) REFERENCES `customers_info` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `price_list_config` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */



/*Table structure for table `special_discount` */

DROP TABLE IF EXISTS `special_discount`;

CREATE TABLE `special_discount` (
  `discount_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL,
  `discount_name` varchar(30) DEFAULT NULL,
  `customer_code` varchar(10) NOT NULL,
  `amount` varchar(15) NOT NULL,
  `applied_amount` decimal(15,0) NOT NULL,
  `balance` decimal(15,0) NOT NULL,
  `activity` varchar(2) DEFAULT '是',
  PRIMARY KEY (`discount_id`),
  KEY `fk_special_discount_customers_info` (`customer_id`),
  CONSTRAINT `fk_special_discount_customers_info` FOREIGN KEY (`customer_id`) REFERENCES `customers_info` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `special_discount` */



/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_rolename_name` (`role_id`),
  CONSTRAINT `fk_rolename_name` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
