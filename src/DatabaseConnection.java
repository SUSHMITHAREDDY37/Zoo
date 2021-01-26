

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public  Connection connection()  {
		Connection con = null;
		try {
	           
            Class.forName("com.mysql.cj.jdbc.Driver");
       // Step 2: Establish the connection to the database.
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/visit","root","root");
          System.out.println("connection established");
		}
		catch(SQLException e) {
			
		}
		catch(ClassNotFoundException ee) {
			
		}
		return con;
		
	}

}



