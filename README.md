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
