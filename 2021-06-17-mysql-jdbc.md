title | categories | date | author
--- | --- | --- | ---
Working with JDBC and MySQL | java | 2021-06-16 23:56:14 +1000 | Edoardo Fiorini  

The Java Database Connectivity (JDBC) is the standard way of accessing databases in Java. 

This tutorial covers how to instantiate a connection, perform queries, interact with a simulated data collection. The software used here is MySQL, an open source relational database.

###### Introducing JDBC Usage

The JDBC Application Programming Interface (API) is composed by 4 main interfaces:

+ Driver: Sets up a connection to the database
+ Connection: Sends query to the database
+ PreparedStatement: Executes SQL of a query
+ ResultSet: Provides results of a query

These interfaces help us to execute fundamental procedures regarding databases.

###### The Example Used Here

For this tutorial we are going to make use a practical example: the monitoring of entrances in an airplane.

The MySQL table is called "passenger" and consists of 4 fields:

+ passengerid (The ID of the passenger)
+ passengername (The name of the passenger)
+ passengerorigin (The place passenger's airplane left)
+ passengerdestination (The place passenger is going to)

You can reproduce this table using the following SQL code:

```sql

CREATE DATABASE `flights`;

CREATE TABLE `passenger` (
  `passengerid` int NOT NULL,
  `passengername` varchar(40) DEFAULT NULL,
  `passengerorigin` varchar(40) DEFAULT NULL,
  `passengerdestination` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`passengerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `passenger` VALUES (1,'Paul Müller','Berlin, Germany','New York, USA'),(2,'Léo Martin','Paris, France','Barcelona, Spain'),(3,'John Doe','Boston, USA','Chicago, USA'),(4,'Mario Rossi','Rome, Italy','Liverpool, UK'),(5,'Agata Wòjcik','Warsaw, Poland','Cracovia, Poland');

```

