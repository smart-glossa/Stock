# Stock
Database:storesoft;

<p>
1. CREATE TABLE `company` (
  `companyId` int(11) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `tinNumber` varchar(255) NOT NULL,
  `proprietor` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`companyId`),
  UNIQUE KEY `tinNumber` (`tinNumber`)
)
</p>
<p>
2.CREATE TABLE `product` (
  `productId` varchar(255) NOT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `parentProductId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productId`)
)
</p>
<p>
3. CREATE TABLE `productPrice` (
  `priceId` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `buyPrice` float DEFAULT NULL,
  `sellPrice` float DEFAULT NULL,
  PRIMARY KEY (`priceId`),
  CONSTRAINT `productPriceDetail_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
)
</p>
<p>
4.CREATE TABLE `companyProduct` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NOT NULL,
  `priceId` int(11) DEFAULT NOT NULL,
  PRIMARY KEY (`linkId`),
  CONSTRAINT `companyProduct_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`companyId`)
  CONSTRAINT `companyProduct_ibfk_1` FOREIGN KEY (`priceId`) REFERENCES `productPrice` (`priceId`)
)
</p>






