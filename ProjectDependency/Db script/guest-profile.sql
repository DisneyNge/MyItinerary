CREATE TABLE `GuestProfile` (
  `CustomerID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMailID` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `PhoneNumber` varchar(15) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

