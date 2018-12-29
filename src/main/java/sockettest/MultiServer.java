package sockettest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiServer {
	public static double area=0;
	public MultiServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{

			System.out.println("服务器启动了");
			ServerSocket serverSocket = new ServerSocket(12345);
			Socket connectToClient = null;
			while(true){//这是一个无限循环
				//等待客户请求
				connectToClient = serverSocket.accept();
				//
				new ServerThread(connectToClient);
			}
		}catch(IOException e){
			e.printStackTrace();
		}   
	}

}








































