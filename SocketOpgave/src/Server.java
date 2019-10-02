import java.io.*;
import java.net.*;
import java.util.*;

class Server
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(5555);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        List<String> usernames = new ArrayList<>();

        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String userName = new String(receivePacket.getData());
            System.out.println("Username received: " + userName);
            System.out.println(usernames);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}