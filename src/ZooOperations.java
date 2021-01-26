import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





public class ZooOperations implements ZooInterface{
	DatabaseConnection db= new DatabaseConnection();
	Connection con= db.connection();
	PreparedStatement  statement;
	@Override
	public void add(Zoo zooObj) {
		// TODO Auto-generated method stub
		try {
			
			statement= con.prepareStatement("INSERT INTO zoo ( zooid, zoolocation, numofanimals) VALUES (?, ?, ?)");
			statement.setInt(1, zooObj.getZooId());
			statement.setString(2, zooObj.getZooLocation());
			statement.setInt(3, zooObj.getNumOfAnimals());
			
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0)
				System.out.println("user inserted");
			
		}catch(SQLException e) {
			e.getMessage();
		}
	
	}

	@Override
	public void update(Zoo zooObj) {
		// TODO Auto-generated method stub
		try {
			statement= con.prepareStatement("UPDATE zoo SET zoolocation=?, numofanimals=? WHERE zooid=?");
			statement.setString(1,zooObj.getZooLocation() );
			statement.setInt(2, zooObj.getNumOfAnimals());
			statement.setInt(3, zooObj.getZooId());
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0)
				System.out.println("user inserted");
			
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	@Override
	public void retrieve() {
		// TODO Auto-generated method stub
		ArrayList<Zoo> zoolist = new ArrayList<>();	
		try {
			 Statement statement = con.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM zoo");
	            while (rs.next()) {
	            	Zoo zoo = new Zoo();
	            	zoo.setZooId(rs.getInt("zooid"));
	            	zoo.setZooLocation(rs.getString("zoolocation"));
	            	zoo.setNumOfAnimals(rs.getInt("numofanimals"));
	            	zoolist.add(zoo);
	            }
	            for(int i=0;i<10;i++)
	            {
	            	System.out.println("vlues"+i);
	            }
	             
	            for(Zoo obj : zoolist) {
	            	 System.out.println("zooid:" +obj.getZooId() +"\t ZooLocation :" +obj.getZooLocation()+ " \tNumber of animals in zoo:"+obj.getNumOfAnimals() );
	            	
	            }
	          
		}catch(SQLException ex) {
			ex.getMessage();
		}	
	}
	@Override
	public void delete(Zoo zooObj) {
		// TODO Auto-generated method stub
		try {
			statement= con.prepareStatement("DELETE FROM zoo WHERE zooid=?\"");
			statement.setInt(1, zooObj.getZooId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	}

	


