package eagz;

public class Server extends Thread {
	public static ThreadHolder th = new ThreadHolder();
	
	public Server(){
		System.out.println("CONNECTION POOL EAGZ 2017-B");
		th.start();
	}
	
	public static void main(String[] args) {
		 new Server();
	}
}