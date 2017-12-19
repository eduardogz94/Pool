package eagz;

public class Client extends Thread{
	Conexion c;
	
	public Client(ThreadHolder th){
		try{
			c = new Conexion();
			c.start();
			System.out.println("----------------------------------");
		} catch(Exception e){e.printStackTrace(); } 
	}
}
