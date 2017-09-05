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
	
	public void run(){
		stime = System.currentTimeMillis();
		try {
			while(true){	
				if(pool.size()< a && pool.size() < y){	
					poolHelper();
				}
				
				else if(pool.size() == a){
					Thread.sleep(800);
					a = a+b;
					System.out.println("Increased pool cap by 5, reached max cap -> " + a);
					poolHelper();
				}	
				
				else if(pool.size() == y) {
					System.out.println("----------------------------------");
					System.out.println("Database is busy, please try again in a second.");	
					deleteClient(c);
					System.out.println("Pool -> "+pool.size() + ".");
				}	
			Thread.sleep(400);
			ftime = System.currentTimeMillis();
			time = (ftime - stime)/1000 ;
			System.out.println("Time established -> " + time + " sec");
			}	
		}catch(Exception e) {e.printStackTrace();}
	}
	
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
		System.out.println("Client Disconnected");
	}
}