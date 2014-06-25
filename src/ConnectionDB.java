import java.sql.*;

public class ConnectionDB {
	private Connection conn;
	private Statement stmt;

	 
	public ConnectionDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "asmae", "pro");
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}

	public void closeConnection() throws Exception {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception ex) {
				throw ex;
			}
		}
		if (conn != null) {
			try {

				conn.close();
				conn = null;
			} catch (Exception ex) {
				throw ex;
			}
		}
	}

	public ResultSet executeQuery(String query) throws Exception {
		if (conn != null) {
			return stmt.executeQuery(query);
		} else {
			throw new Exception(
					"Connexion non établie, impossible d'accéder à la base");
		}
	}

	public void executeUpdate(String query) throws Exception {
		if (conn != null) {
			stmt.executeUpdate(query);
		} else {
			throw new Exception(
					"Connexion non établie, impossible d'accéder à la base");
		}
	}
}