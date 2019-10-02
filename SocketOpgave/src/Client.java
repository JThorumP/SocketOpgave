import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client
{
    public static void main(String args[]) throws Exception
    {
        String conIP;
        int conPort;
        String userName;
        Scanner scan = new Scanner(System.in);
        String sentence;
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("Please enter the chatroom IP: 169.254.68.25");
        conIP = scan.nextLine();
        InetAddress IPAddress = InetAddress.getByName(conIP);
        System.out.println("Please enter port:");
        conPort = scan.nextInt();
        System.out.println("Please enter username:");
        scan.nextLine();
        userName = scan.nextLine();
        sendData = userName.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, conPort);
        clientSocket.send(sendPacket);
        sentence = scan.nextLine();
        if (sentence.equalsIgnoreCase("quit")) {
            clientSocket.close();
        }
        sendData = sentence.getBytes();
        sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, conPort);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
    }
}