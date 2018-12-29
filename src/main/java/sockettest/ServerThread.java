package sockettest;

import java.io.*;
import java.net.Socket;


public class ServerThread extends Thread {
    private Socket connectToClient;//声名套接字
    private DataInputStream inFromClient;//声名数据输入流
    private DataOutputStream outToClient;//声名数据输出流
    //private double area=0;
    private BufferedReader reader;

    public ServerThread(Socket socket) throws IOException {
        // TODO Auto-generated constructor stub
        super();
        connectToClient = socket;
        inFromClient = new DataInputStream(connectToClient.getInputStream());
        outToClient = new DataOutputStream(connectToClient.getOutputStream());
        start();//启动run()方法
    }

    @Override
    public void run() {
        super.run();

        System.out.println("有客户端连接到服务器了");
        try {
            String input = inputStream2String(inFromClient);
            System.out.println("接收到数据：" + input);
            inFromClient.close();
            outToClient.writeUTF("接收到数据");
            outToClient.flush();
            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//	public void run(){
//		String str;
//		double radius=0;//area=0;
//		boolean goon = true;
//		try{
//
//			System.out.println("有客户端连接到服务器了");
//
//			while(goon){
//				str = inFromClient.readUTF();
//				if(!str.equals("bye")){
//					if(str.equals("接受")){
//						str = inFromClient.readUTF();
//						radius = Double.parseDouble(str);
//						System.out.println("接收到的半径值为：" +radius);
//						MultiServer.area = radius*radius*Math.PI;
//						str = Double.toString(MultiServer.area);
//						System.out.println("圆面积是"+str);
//						outToClient.writeUTF("我已经准备好了，快来接收吧");
//						outToClient.flush();
//						System.out.println("连接服务器成功了");
//					}
//					//str = inFromClient.readUTF();
//					else if(str.equals("发送")){
//
//						System.out.println("要发送的圆面积是：" +MultiServer.area);
//						str = Double.toString(MultiServer.area);
//						outToClient.writeUTF(str);
//						outToClient.flush();
//						System.out.println("圆面积"+str+"已经发送");
//						System.out.println("连接服务器成功了");
//
//					}
//				}else{
//					goon = false;
//					outToClient.writeUTF("bye");
//					outToClient.flush();
//					System.out.println("连接服务器结束了");
//				}
//
//
//
//			}
//			inFromClient.close();
//			outToClient.close();
//			connectToClient.close();
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//	}

    public ServerThread(Runnable target) {
        super(target);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(ThreadGroup group, Runnable target) {
        super(group, target);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(ThreadGroup group, String name) {
        super(group, name);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(Runnable target, String name) {
        super(target, name);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        // TODO Auto-generated constructor stub
    }

    public ServerThread(ThreadGroup group, Runnable target, String name,
                        long stackSize) {
        super(group, target, name, stackSize);
        // TODO Auto-generated constructor stub
    }

    public String inputStream2String(InputStream in) throws IOException {

        ///////////////////////////
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[1024];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }

        return out.toString();
    }
}
