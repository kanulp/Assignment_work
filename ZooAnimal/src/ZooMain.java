//Name :
//ID :
//Submission Date : 
import java.sql.*;  
import java.util.*;

public class ZooMain {

	public static void main(String[] args) {
		 HashMap<String, Integer> hmap = new HashMap<String,Integer>();

	      hmap.put("Elephant",15);
	      hmap.put("Giraffe",9);
	      hmap.put("Horse",5);
	      hmap.put("Zebra",5);
	      hmap.put("Deer",3);
	      
	      Scanner in = new Scanner(System.in);
	      int stock=0;
	      
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ZooDB","root","");  
			Statement stmt=con.createStatement();  
			int n=0;
			
			System.out.print("Enter How many animals you need to feed: ");
			n = in.nextInt();
			
			for(int i=0;i<n;i++) {
				
			}
			
			/*
			ResultSet rs=stmt.executeQuery("select * from FeedingData");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			*/
			}catch(Exception e){
				System.out.println(e);
			}  
		}
	
		public static void DepositFood() {
			
		}
		
	}
