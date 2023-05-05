package redes.socketUDP;

import redes.util.BytesUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.Arrays;

public class ClientUDP {

    public static void main(String[] args) throws IOException {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData;
        byte[] receivedData = new byte[1024];

        System.out.println("Digite uma palavra para encontrar sua tradução para inglês: ");

        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 3333);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
        clientSocket.receive(receivePacket);

        String modifiedSentence = new String(BytesUtil.trim(receivePacket.getData()));
        System.out.println("TRADUÇÃO: " + modifiedSentence);
        clientSocket.close();

    }
}

