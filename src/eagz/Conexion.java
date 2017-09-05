package eagz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public class Conexion extends Thread {
		public static Connection conexion;

	public void run(){
			Connection();
			executeQuery();
			Disconnection();
	}
	
	public synchronized void Connection(){
		try{
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pooling", "postgres", "eagzv.999");
			System.out.println("APP connected sucessfully!.");
		} catch(Exception e){	e.printStackTrace(); } 
	}

	public synchronized void Disconnection(){
		try{
			conexion.close();
		}catch(Exception e){ e.printStackTrace();}	
	}
	
	public synchronized void executeQuery(){
		try {
			PreparedStatement ps = conexion.prepareStatement(
			"INSERT INTO pool (pool1) VALUES (?)");
			String string = "askdnoauhguhegahguahjigfafiogyauotynqdrtyasdaupasu" + 
			"pasdhugfyigfiyasgfiahsdfghasjkdfgsfghsgfhshddfsgfh" +
			"askdnoauhguhegahguahjigfafddgyauotynqdrtyasdaupasu" + 
			"pasdhugfyigfiyasgfiahsdfghasjkddgsfghsgfhshddfsgfh" +
			"aksndjahnduabdihasdasdaggisdhhsadsdasdasdasdasdasd";

			for (int i = 0; i < 100; i++) {
		 		ps.setString(1, string);
            	ps.executeUpdate();  
        	}       
			ps.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
}