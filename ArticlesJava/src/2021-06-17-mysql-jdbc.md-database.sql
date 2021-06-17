-- use this code to reproduce the example.

DROP TABLE IF EXISTS `passenger`;

CREATE TABLE `passenger` (
  `passengerid` int NOT NULL AUTO_INCREMENT,
  `passengername` varchar(40) DEFAULT NULL,
  `passengerorigin` varchar(40) DEFAULT NULL,
  `passengerdestination` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`passengerid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `passenger` VALUES (1,'Paul Müller','Berlin, Germany','New York, USA'),
(2,'Léo Martin','Paris, France','Barcelona, Spain'),
(3,'John Doe','Boston, USA','Chicago, USA'),
(4,'Mario Rossi','Rome, Italy','Liverpool, UK'),
(5,'Agata Wòjcik','Warsaw, Poland','Cracovia, Poland');
