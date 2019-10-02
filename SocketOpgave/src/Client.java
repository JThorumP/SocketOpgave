import java.io.*;
import java.net.*;

class Client
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String conIP = inFromUser.readLine();
        InetAddress IPAddress = InetAddress.getByName(conIP);
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5555);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}