import java.net.Socket;

public class ServerGameThread extends Thread{
	Socket socket;
	
	public ServerGameThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		System.out.println("Welcome to he game \"TicTakToe\"");
	}
}
