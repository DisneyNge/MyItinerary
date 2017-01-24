CREATE TABLE `ResortReservation` (
  `ReservationID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CustomerID` bigint(20) NOT NULL,
  `RoomType` varchar(50) NOT NULL,
  `ArrivalDate` date NOT NULL,
  `DepartureDate` date NOT NULL,
  `NoOfPeople` int(11) NOT NULL,
  `NoOfNights` bigint(10) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ReservationID`),
  UNIQUE KEY `ReservationId_UNIQUE` (`ReservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
