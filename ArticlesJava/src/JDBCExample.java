import java.sql.*;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {

		String databaseUsername = "root";

		String databasePassword = "yourPassword";

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flights", databaseUsername,
				databasePassword);

		System.out.println("connection established successfully");

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

		String insertQuery = "INSERT INTO passenger (passengername, passengerorigin, passengerdestination) VALUES  (?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, "Martina Garcià");
		preparedStatement.setString(2, "Valencia, Spain");
		preparedStatement.setString(3, "Lyon, France"); 

		preparedStatement.execute();

	}

}
