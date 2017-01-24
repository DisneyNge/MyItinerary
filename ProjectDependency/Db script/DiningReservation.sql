CREATE TABLE `DiningReservation` (
  `ReservationID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CustomerID` bigint(20) NOT NULL,
  `DiningType` varchar(45) NOT NULL,
  `ArrivalDate` date NOT NULL,
  `ArrivalTime` varchar(45) NOT NULL,
  `NoOfPeople` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `CreatedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ReservationID`),
  UNIQUE KEY `ReservationID_UNIQUE` (`ReservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
