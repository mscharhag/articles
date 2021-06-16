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

The MySQL table consists of X fields:

+ 
