package eagz;

import java.util.ArrayList;

public class ThreadHolder extends Thread {
	ArrayList<Client> pool;
	public static int a = 20;
	public static int b = 5;
	public static int y = 49;
	private static long ftime, stime, time;
	public Client c = null;
	
	public ThreadHolder(){
		pool = new ArrayList<Client>();
	}
	
	//start
	
	public void run(){
		stime = System.currentTimeMillis();
		try {
			while(true){	
				if(pool.size()< a && pool.size() < y){	
					poolHelper();
				}
				
				else if(pool.size() == a){
					Thread.sleep(100);
					System.out.println("----------------------------------");
					System.out.println("Pool capacity -> " + a);
					a = a+b;
					System.err.println("Increased pool cap by 5, reached max cap -> " + a);
				}	
				
				else if(pool.size() == y) {
					System.out.println("----------------------------------");
					System.err.println("Database is busy, please try again in a second.");	
					deleteClient(c);
					System.out.println("Pool -> "+pool.size() + ".");
				}	
			Thread.sleep(300);
			ftime = System.currentTimeMillis();
			time = (ftime - stime)/1000 ;
			System.out.println("Time established -> " + time + " sec");
			}	
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//functions
	public void poolHelper(){
		obtainClient(c);
		addClient(c);
		System.out.println("Pool -> "+pool.size() + ".");
	}
	
	public void obtainClient(Client c){
		c = new Client(this);
		c.start();
	}
	
	public void addClient(Client c){
        pool.add(c);
    }
	
	public void deleteClient(Client c){
		pool.remove(c);
		Conexion.Disconnection();
		System.out.println("Client Disconnected");
	}
}