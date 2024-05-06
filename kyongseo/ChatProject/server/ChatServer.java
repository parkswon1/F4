package kyongseo.ChatProject.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345);) {
            System.out.println("서버가 준비되었습니다.");

            // 클라이언트의 정보를 넣을 객체
            // ==> 각 클라이언트의 닉네임, PrintWriter 저장
            Map<String, PrintWriter> clients = new HashMap<>();

            // 사용자에 해당하는 방 정보를 넣을 객체
            // => 각 클라이언트의 닉네임, 해당하는 방 번호 저장
            Map<String, Integer> userRooms = new HashMap<>();

            while (true) {
                // 클라이언트의 접속 대기, 클라이언트 소켓 받아오기
                Socket clientSocket = serverSocket.accept();

                // 새로운 클라이언트를 처리할 다중 ChatServerThread
                new ChatServerThread(clientSocket, clients, userRooms).start();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}