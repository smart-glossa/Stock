# Stock
Database:storesoft;
CREATE TABLE `stock` (
  `companyId` int(11) NOT NULL auto_increment,
  `companyName` varchar(200) default NULL,
  `address` varchar(200) default NULL,
  `tinNo` int(11) default NULL,
  `proprictor` varchar(200) default NULL,
  PRIMARY KEY  (`companyId`),
  UNIQUE KEY `tinNo` (`tinNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `product` (
  `productId` varchar(200) NOT NULL,
  `productName` varchar(200) default NULL,
  `tinNo` int(11) default NULL,
  PRIMARY KEY  (`productId`),
  KEY `tinNo` (`tinNo`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`tinNo`) REFERENCES `stock` (`tinNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `productbrand` (
  `brandId` int(11) NOT NULL auto_increment,
  `brandName` varchar(200) default NULL,
  `productId` varchar(200) default NULL,
  PRIMARY KEY  (`brandId`),
  KEY `productId` (`productId`),
  CONSTRAINT `productbrand_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
