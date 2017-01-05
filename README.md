# Stock
Database:storesoft;
CREATE TABLE `stocks` (
  `companyId` int(11) NOT NULL default '0',
  `companyName` varchar(100) default NULL,
  `address` varchar(100) default NULL,
  `tinNo` int(11) default NULL,
  `proprietor` varchar(100) default NULL,
  PRIMARY KEY  (`companyId`),
  UNIQUE KEY `tinNo` (`tinNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `products` (
  `productId` varchar(100) NOT NULL default '',
  `productName` varchar(100) default NULL,
  `tinNos` int(11) default NULL,
  PRIMARY KEY  (`productId`),
  UNIQUE KEY `tinNoss` (`tinNos`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`tinNos`) REFERENCES `stocks` (`tinNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1



CREATE TABLE `productbrand` (
  `brandId` int(11) NOT NULL auto_increment,
  `brandName` varchar(200) default NULL,
  `productId` varchar(200) default NULL,
  PRIMARY KEY  (`brandId`),
  KEY `productId` (`productId`),
  CONSTRAINT `productbrand_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `productprice` (
  `Id` int(11) NOT NULL auto_increment,
  `brandId` int(11) default NULL,
  `quantity` int(11) default NULL,
  `costprice` float default NULL,
  `sellprice` float default NULL,
  PRIMARY KEY  (`Id`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `productprice_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `productbrand` (`brandId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `productweight` (
  `Id` int(11) NOT NULL auto_increment,
  `costPerkg` float default NULL,
  `totalWeight` float default NULL,
  `brandId` int(11) default NULL,
  PRIMARY KEY  (`Id`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `productweight_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `productbrand` (`brandId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
