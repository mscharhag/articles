title | categories | date | author
--- | --- | --- | ---
Working with JDBC and MySQL | java | 2021-06-16 23:56:14 +1000 | Edoardo Fiorini  

###### Introduction

---

The Java Database Connectivity (JDBC) is the standard way of accessing databases in Java. 

This tutorial covers how to instantiate a connection, perform queries, and generally interact with a simulated data collection. The software used here is MySQL, an open source relational database. You should have some knowledge of Java and a basic understanding of databases.

The JDBC Application Programming Interface (API) is composed by 4 main interfaces:

+ Driver: Sets up a connection to the database
+ Connection: Sends query to the database
+ PreparedStatement: Executes SQL of a query
+ ResultSet: Provides results of a query

These interfaces help us to execute fundamental procedures regarding databases.

## Initial Setup And Example

For this tutorial we are going to make use a practical example: the monitoring of entrances of an airplane.

The MySQL table is called "passenger", inside the database "flights", and consists of 4 fields:

+ passengerid (The ID of the passenger)
+ passengername (The name of the passenger)
+ passengerorigin (The place passenger's airplane left)
+ passengerdestination (The place passenger is going to)

Using this SQL code you can reproduce all database part of the example:

```sql
CREATE DATABASE `flights`;

CREATE TABLE `passenger` (
  `passengerid` int NOT NULL AUTO_INCREMENT,
  `passengername` varchar(40) DEFAULT NULL,
  `passengerorigin` varchar(40) DEFAULT NULL,
  `passengerdestination` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`passengerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `passenger` VALUES (1,'Paul Müller','Berlin, Germany','New York, USA'),(2,'Léo Martin','Paris, France','Barcelona, Spain'),(3,'John Doe','Boston, USA','Chicago, USA'),(4,'Mario Rossi','Rome, Italy','Liverpool, UK'),(5,'Agata Wòjcik','Warsaw, Poland','Cracovia, Poland');

```

Please note that to use MySQL in your project your need to add to the build path the MySQL connector JAR, downloadble visiting [This Link](https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.25/mysql-connector-java-8.0.25.jar).

###### Interacting With Database

---

## Step 1: Establishing Database Collection

Now that our data is ready, we only need to use them. Create a class called "JDBCExample.java" inside your java project's source folder and set up a connection this way:

```java
import java.sql.*;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {

		    String databaseUsername = "root";
		    
		    String databasePassword = "yourPassword";
        
        String jdbcURL = "jdbc:mysql://localhost:3306/flights";
		
			  Connection connection = 
        DriverManager.getConnection(jdbcURL, databaseUsername,  databasePassword);
			
        System.out.println("connection established successfully");
      
	}

}
```

Remember to change the "databasePassword" variable with your database password.

At this point run the java program and the connection will be established successfully. If you received this error message:
```java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/mysql``` check that you have written all the connection fields right.

## Step 2: Executing Query To Retrieve Data

Now let's get data from our passenger table with a query. The query simply selects all data from the aforementioned table.

Paste this code in the program:

```java
    String selectQuery = "SELECT * FROM passenger";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(selectQuery);

		while (resultSet.next()) {

			int passengerId = resultSet.getInt("passengerid");

			String passengerName = resultSet.getString("passengername");

			String passengerOrigin = resultSet.getString("passengerorigin");

			String passengerDestination = resultSet.getString("passengerdestination");
			
			System.out.println("\nPassenger Id: " + passengerId);
			
			System.out.println("Passenger Name: " + passengerName);
			
			System.out.println("Passenger Origin: " + passengerOrigin);
			
			System.out.println("Passenger Destination: " + passengerDestination);
			
		}
```

This code defines a query to select all data from the table, executes it, loops through it and finally prints all the received fields. 

## Step 3: Executing Query To Add Data

The last step is using JDBC to insert information to the table. To protect our application from SQL Injection attacks we are going to use a PreparedStatement to accomplish our needs. This code will perform an insert query.

```java
		PreparedStatement preparedStatement = connection.prepareStatement(inserQuery);
		preparedStatement.setString(1, "Martina Garcià");
		preparedStatement.setString(2, "Valencia, Spain");
		preparedStatement.setString(3, "Lyon, France"); 

		preparedStatement.execute();
```

We have successfully added a new member to the list of passengers.

###### Conclusion

---

In this tutorial we learned how to strategially interact with a database in the Java language through a concrete example.
