# Stock
Database:storesoft;


1. CREATE TABLE `companyDetail` (
  `companyId` int(11) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `tinNumber` varchar(255) NOT NULL,
  `proprietor` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`companyId`),
  UNIQUE KEY `tinNumber` (`tinNumber`)
)


2.CREATE TABLE `product` (
  `productId` varchar(255) NOT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `companyDetail` (`companyId`)
)



3.CREATE TABLE `productBrand` (
  `brandId` int(11) NOT NULL AUTO_INCREMENT,
  `brandName` varchar(255) DEFAULT NULL,
  `productId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brandId`),
  KEY `productId` (`productId`),
  CONSTRAINT `productBrand_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
)



4. CREATE TABLE `productPriceDetail` (
  `priceId` int(11) NOT NULL AUTO_INCREMENT,
  `brandId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `costPrice` float DEFAULT NULL,
  `sellingPrice` float DEFAULT NULL,
  `modelName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`priceId`),
  KEY `brandId` (`brandId`),
  CONSTRAINT `productPriceDetail_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `productBrand` (`brandId`)
)



