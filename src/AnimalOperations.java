import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimalOperations implements AnimalInterface{
	DatabaseConnection db= new DatabaseConnection();
	Connection con= db.connection();
	PreparedStatement statement;
	@Override
	public void add(Animal anmlObj) {
		// TODO Auto-generated method stub
try {
	
	

			statement= con.prepareStatement("INSERT INTO animal ( animalid, animalage, animalcategory, animalweight, zooid) VALUES (?, ?, ?, ?, ?)");
			statement.setInt(1, anmlObj.getAid());
			statement.setInt(2,  anmlObj.getAage());
			statement.setString(3, anmlObj.getAcategory());
			statement.setInt(4, anmlObj.getAweight());
			statement.setInt(5, anmlObj.getZooId());
			
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0)
				System.out.println("Animal inserted");
			
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	@Override
	public void update(Animal anmlObj) {
		// TODO Auto-generated method stub
		try {
			statement= con.prepareStatement("UPDATE animal SET animalage=?, animalcategory=?, animalweight=?, zooid=? WHERE animalid=?");
			statement.setInt(1, anmlObj.getAage());
			statement.setString(2,anmlObj.getAcategory());
			statement.setInt(3, anmlObj.getAweight());
			statement.setInt(4, anmlObj.getZooId());
			statement.setInt(5, anmlObj.getAid());
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0)
				System.out.println("Animal Table Updated");
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	@Override
	public void retrieve() {
		// TODO Auto-generated method stub
		ArrayList<Animal> animallist = new ArrayList<>();	
		try {
			 Statement statement = con.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM animal");
	            while (rs.next()) {
	            	Animal aobj = new Animal();
	            	aobj.setAid(rs.getInt("animalid"));
	            	aobj.setAage(rs.getInt("animalage"));
	            	aobj.setAcategory(rs.getString("animalcategory"));
	            	aobj.setAweight(rs.getInt("animalweight"));
	            	aobj.setZooId(rs.getInt("zooid"));
	            	animallist.add(aobj);
	            }
	             
	            for(Animal obj : animallist) {
	            	 System.out.println("animal id:" +obj.getAid() +"\t Animal Age :" +obj.getAage()+ " \tAnimal Category:"+obj.getAcategory()+ "\t Animal Weight :" +obj.getAweight()+ "\t Zooid :" +obj.getZooId() );
	            	
	            }
	            
	          
		}catch(SQLException ex) {
			ex.getMessage();
		}	
		
	}
	@Override
	public void delete(Animal anmlObj) {
		// TODO Auto-generated method stub
		try {
			statement= con.prepareStatement("DELETE FROM animal WHERE zooid=?\"");
			statement.setInt(1, anmlObj.getAid());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Animal  deleted successfully!");
			}
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	@Override
	public void twotables()  {
		// TODO Auto-generated method stub
		 Statement stmt;
		try {
			stmt = con.createStatement();
			// String query ="SELECT animalid, animalage from animal inner join zoo ON animal.ZOOID= zoo.ZOOID";
		  String query=  "SELECT Zoo.numofanimals, Animal.AnimalId,Animal.animalcategory, Zoo.ZooLocation FROM Zoo INNER JOIN Animal ON Zoo.ZooID=Animal.ZooID";
			ResultSet rs = stmt.executeQuery(query);
		     // System.out.println("Zooid  animalid	zoolocation   ");
		      System.out.println("number of animals  animalid	zoolocation  AnimalCategory "); 
		      while (rs.next()) {
		        // int  animalid = rs.getInt("animalid");
		       // int animalage = rs.getInt("animalage");
		    	  int  numofanimals = rs.getInt("numofanimals");
			      int AnimalId = rs.getInt("AnimalId");
			      String animalcategory= rs.getString("animalcategory");
			      String ZooLocation=rs.getString("ZooLocation");
			       
		         System.out.println(numofanimals + "\t \t " + AnimalId+"\t\t   "+ZooLocation+"\t"+animalcategory+"");
		      }
		      System.out.println();
		      System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	
}