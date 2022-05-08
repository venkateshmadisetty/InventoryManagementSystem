CREATE DATABASE  IF NOT EXISTS `inventorymanagementappication`;
USE `inventorymanagementappication`;

DROP TABLE IF EXISTS `inventory_customer_tbl`;

CREATE TABLE `inventory_customer_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  --`customer_id` int(11) NOT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone2` int(11) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `inventory_customer_tbl` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` bigint(20) NOT NULL,
  `total_price` bigint(20) NOT NULL,
  `unit_price` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `item` WRITE;
INSERT INTO `item` VALUES (1,'Great','sandeep',1,10,5,4516,126),(2,'Great','Virat',12,10,54,4516,126);
UNLOCK TABLES;
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_stock` bigint(20) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` int(11) DEFAULT NULL,
  `purchase_id` int(11) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `sale_date` bigint(20) DEFAULT NULL,
  `total_cost` bigint(20) DEFAULT NULL,
  `unity_price` bigint(20) DEFAULT NULL,
  `vendor_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `purchase` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `discount` bigint(20) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` int(11) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `sale_date` bigint(20) DEFAULT NULL,
  `sale_id` int(11) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `total_stock` bigint(20) DEFAULT NULL,
  `unity_price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

LOCK TABLES `sales` WRITE;
INSERT INTO `sales` VALUES (1,0,NULL,10,NULL,0,100,0,0,0,0,0);
UNLOCK TABLES;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'rishabh','123456','rish'),(2,'pratik','123456','pratik1'),(3,'ravi','123456','ravi1');
UNLOCK TABLES;

select * from users;
select * from item;